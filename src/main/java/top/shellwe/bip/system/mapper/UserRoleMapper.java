package top.shellwe.bip.system.mapper;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import top.shellwe.bip.system.dto.input.UserRoleQueryPara;
import top.shellwe.bip.system.entity.BasicRole;
import top.shellwe.bip.system.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> 系统管理 - 用户角色关联表  Mapper 接口 </p>
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<UserRole> selectUserRoles(Pagination page, @Param("filter") UserRoleQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<UserRole> selectUserRoles(@Param("filter") UserRoleQueryPara filter);

    /**
     * 根据角色Id删除用户与角色相关联数据
     *
     * @param roleId:
     * @return: void
     */
    void deleteByRoleId(@Param("roleId") Integer roleId);

    /**
     * 根据用户Id查询关联角色
     *
     * @param userId:
     * @return: java.util.List<top.shellwe.bip.system.entity.Role>
     */
    List<BasicRole> selectRoleByUserId(@Param("userId") Integer userId);

}
