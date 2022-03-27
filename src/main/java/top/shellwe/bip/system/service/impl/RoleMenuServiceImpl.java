package top.shellwe.bip.system.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import top.shellwe.bip.system.dto.input.RoleMenuQueryPara;
import top.shellwe.bip.system.entity.RoleMenu;
import top.shellwe.bip.system.mapper.RoleMenuMapper;
import top.shellwe.bip.system.service.RoleMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p> 系统管理 - 角色-菜单关联表  服务实现类 </p>
 */
@Service
@Transactional
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

    @Autowired
    RoleMenuMapper roleMenuMapper;

    @Override
    public void listPage(Page<RoleMenu> page, RoleMenuQueryPara filter) {
        page.setRecords(roleMenuMapper.selectRoleMenus(page, filter));
    }

    @Override
    public List<RoleMenu> list(RoleMenuQueryPara filter) {
        return roleMenuMapper.selectRoleMenus(filter);
    }

    @Override
    public void saveRoleMenu(RoleMenuQueryPara para) {
        Integer roleId = para.getRoleId();
        String menuIds = para.getMenuIds();
        roleMenuMapper.deleteByRoleId( roleId );
        if(StringUtils.isNotBlank( menuIds )){
            String[] menuIdArrays = menuIds.split( "," );
            if(menuIdArrays.length > 0){
                for (String menuId : menuIdArrays) {
                    RoleMenu roleMenu = new RoleMenu();
                    roleMenu.setRoleId( roleId );
                    roleMenu.setMenuId( Integer.parseInt( menuId ) );
                    roleMenuMapper.insert( roleMenu );
                }
            }
        }
    }

    @Override
    public Integer save(RoleMenu para) {
        if (para.getId()!=null) {
            roleMenuMapper.updateById(para);
        } else {
            roleMenuMapper.insert(para);
        }
        return para.getId();
    }
}