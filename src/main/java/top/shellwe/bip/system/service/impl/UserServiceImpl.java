package top.shellwe.bip.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022. 
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 1:33:37
 */

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import top.shellwe.bip.common.exception.CustomizeException;
import top.shellwe.bip.config.Constants;
import top.shellwe.bip.system.dto.input.UserQueryPara;
import top.shellwe.bip.system.dto.model.ButtonVO;
import top.shellwe.bip.system.dto.model.MenuVO;
import top.shellwe.bip.system.dto.model.UserInfoVO;
import top.shellwe.bip.system.entity.Menu;
import top.shellwe.bip.system.entity.Role;
import top.shellwe.bip.system.entity.User;
import top.shellwe.bip.system.mapper.RoleMenuMapper;
import top.shellwe.bip.system.mapper.UserMapper;
import top.shellwe.bip.system.mapper.UserRoleMapper;
import top.shellwe.bip.system.service.UserService;
import top.shellwe.bip.util.PasswordUtils;
import top.shellwe.bip.util.TreeBuilder;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    public void listPage(Page<User> page, UserQueryPara filter) {
        page.setRecords(userMapper.selectUsers(page, filter));
    }

    @Override
    public List<User> list(UserQueryPara filter) {
        return userMapper.selectUsers(filter);
    }

    @Override
    public UserInfoVO getCurrentUserInfo(String token) {
        User user = userMapper.getUserInfoByToken(token);
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtil.copyProperties( user,userInfoVO);

        Set<String> roles = new HashSet();
        Set<MenuVO> menuVOS = new HashSet();
        Set<ButtonVO> buttonVOS = new HashSet();

        //查询某个用户的角色
        List<Role> roleList = userRoleMapper.selectRoleByUserId( user.getId() );
        if(roleList != null && !roleList.isEmpty() ){
            roles.add( roleList.get(0).getCode() );

            //查询某个角色的菜单
            List<Menu> menuList = roleMenuMapper.selectMenusByRoleId( roleList.get(0).getId() );
            if(menuList != null && !menuList.isEmpty() ){
                menuList.stream().filter(Objects::nonNull).forEach(menu -> {
                    if ("button".equals(menu.getType().toLowerCase())) {
                        //如果权限是按钮，就添加到按钮里面
                        ButtonVO buttonVO = new ButtonVO();
                        BeanUtil.copyProperties(menu, buttonVO);
                        buttonVOS.add(buttonVO);
                    }
                    if ("menu".equals(menu.getType().toLowerCase())) {
                        //如果权限是菜单，就添加到菜单里面
                        MenuVO menuVO = new MenuVO();
                        BeanUtil.copyProperties(menu, menuVO);
                        menuVOS.add(menuVO);
                    }
                });
            }
        }
        userInfoVO.getRoles().addAll( roles );
        userInfoVO.getButtons().addAll( buttonVOS );
        userInfoVO.getMenus().addAll( TreeBuilder.buildTree(menuVOS) );
        return userInfoVO;
    }

    @Override
    public Integer save(User para) {
        User user = null;
        if (para.getId() != null) {
            user = userMapper.selectById(para.getId());
            para.setUserPassword(PasswordUtils.encodePassword(para.getUserPassword(PasswordUtils.encodePassword(para.getUserPassword(), user.getSalt())), user.getSalt()));
            userMapper.updateById(para);
        } else {
//            para.setSalt( Constants.SALT );
            para.setUserPassword(PasswordUtils.encodePassword(para.getUserPassword(PasswordUtils.encodePassword(para.getUserPassword(), user.getSalt())), Constants.SALT));
            userMapper.insert(para);
        }
        return para.getId();
    }

    @Override
    public Integer updatePersonalInfo(User para) {
        if (para.getId()==null){
            throw new CustomizeException("用户信息异常丢失，请重新登录尝试修改个人信息！");
        }
        if ( StringUtils.isBlank( para.getUserName() ) ){
            throw new CustomizeException("账号不能为空！");
        }
        if ( StringUtils.isBlank( para.getUserRealName() ) ){
            throw new CustomizeException("昵称不能为空！");
        }
        User user = userMapper.selectById( para.getId() );
        if ( StringUtils.isNotBlank( para.getUserPassword(PasswordUtils.encodePassword(para.getUserPassword(), user.getSalt())) ) ){
            if (para.getUserPassword(PasswordUtils.encodePassword(para.getUserPassword(), user.getSalt())).trim().length() < 6){
                throw new CustomizeException("请设置至少6位数密码！");
            }
            // 更新密码
            para.getUserPassword( PasswordUtils.encodePassword(para.getUserPassword(PasswordUtils.encodePassword(para.getUserPassword(), user.getSalt())), user.getSalt()));
        } else {
            para.setUserPassword(null);
        }

        // 验证账号是否重复
        UserQueryPara userQueryPara = new UserQueryPara();
        userQueryPara.setAccount( para.getUserName() );
        List<User> userList = userMapper.selectUsers(userQueryPara);
        if ( !CollectionUtils.isEmpty( userList ) ){
            if ( !para.getUserName().equals( user.getUserName() ) || userList.size() > 1 ){
                throw new CustomizeException( "账号重复，请重新输入！" );
            }
        }
        userMapper.updateById(para);
        return para.getId();
    }
}
