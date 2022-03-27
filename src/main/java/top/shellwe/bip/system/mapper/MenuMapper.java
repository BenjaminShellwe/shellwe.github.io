package top.shellwe.bip.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import top.shellwe.bip.system.dto.input.MenuQueryPara;
import top.shellwe.bip.system.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> 系统管理-菜单表  Mapper 接口 </p>
 *
 * @author : zhengqing
 * @author BenjaminThomas
 * @date : 2022/03/28
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<Menu> selectMenus(Pagination page, @Param("filter") MenuQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<Menu> selectMenus(@Param("filter") MenuQueryPara filter);

    /**
     * 通过菜单编码获取信息
     *
     * @param resources:
     * @return: com.zhengqing.modules.system.entity.Menu
     */
    Menu findByResources(@Param("resources") String resources);

    /**
     * 根据角色查询用户权限
     *
     * @param roleId:
     * @return: java.util.List<com.zhengqing.modules.system.entity.Menu>
     */
    List<Menu> selectMenuByRoleId(@Param("roleId") Integer roleId);

}
