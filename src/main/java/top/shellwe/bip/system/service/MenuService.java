package top.shellwe.bip.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import top.shellwe.bip.system.dto.input.MenuQueryPara;
import top.shellwe.bip.system.entity.SystemUrl;

import java.util.List;

/**
 * <p>  系统管理-菜单表  服务类 </p>
 */
public interface MenuService extends IService<SystemUrl> {

    /**
     * 菜单树
     *
     * @param :
     * @return: java.util.List<top.shellwe.bip.modules.system.entity.SystemUrl>
     */
    List<SystemUrl> listTreeMenu();

    /**
     * 系统管理-菜单表 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<SystemUrl> page, MenuQueryPara filter);

    /**
     * 保存系统管理-菜单表
     *
     * @param input
     */
    Integer save(SystemUrl input);

    /**
     * 系统管理-菜单表 列表
     *
     * @param filter
     * @return
     */
    List<SystemUrl> list(MenuQueryPara filter);
}
