package top.shellwe.bip.system.mapper;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import top.shellwe.bip.system.dto.input.RoleQueryPara;
import top.shellwe.bip.system.entity.BasicRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<BasicRole> {

    /**
     * 列表分页
     * @param page
     * @param filter
     * @return
     */
    List<BasicRole> selectRoles(Pagination page, @Param("filter") RoleQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<BasicRole> selectRoles(@Param("filter") RoleQueryPara filter);

    /**
     * 通过用户ID查询角色集合
     *
     * @param userId:
     * @return: java.util.List<Role>
     */
    List<BasicRole> selectRoleByUserId(@Param("userId") Integer userId);

    /**
     * 通过菜单ID查询角色集合
     *
     * @param menuId:
     * @return: java.util.List<Role>
     */
    List<BasicRole> selectRoleByMenuId(@Param("menuId") Integer menuId);

}
