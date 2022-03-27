package top.shellwe.bip.system.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import top.shellwe.bip.system.dto.input.UserQueryPara;
import top.shellwe.bip.system.dto.model.UserInfoVO;
import top.shellwe.bip.system.entity.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface UserService extends IService<User> {

    /**
     * 系统管理-用户基础信息表列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<User> page, UserQueryPara filter);

    /**
     * 保存系统管理-用户基础信息表
     *
     * @param input:
     * @return: java.lang.Integer
     */
    Integer save(User input);

    /**
     * 修改用户个人信息
     *
     * @param para:
     * @return: java.lang.Integer
     */
    Integer updatePersonalInfo(User para);

    /**
     * 系统管理-用户基础信息表列表
     *
     * @param filter
     * @return
     */
    List<User> list(UserQueryPara filter);

    /**
     * 通过token获取用户信息
     *
     * @param token:
     * @return: top.shellwe.bip.system.dto.model.UserInfoVO
     */
    UserInfoVO getCurrentUserInfo(String token);

}
