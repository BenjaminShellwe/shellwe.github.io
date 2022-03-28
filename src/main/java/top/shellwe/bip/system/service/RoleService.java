package top.shellwe.bip.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import top.shellwe.bip.system.dto.input.RoleQueryPara;
import top.shellwe.bip.system.entity.BasicRole;

import java.util.List;

public interface RoleService extends IService<BasicRole> {

    /**
     * 系统管理-角色表 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    void listPage(Page<BasicRole> page, RoleQueryPara filter);

    /**
     * 保存系统管理-角色表
     *
     * @param input
     */
    Integer save(BasicRole input);

    /**
     * 系统管理-角色表 列表
     *
     * @param filter
     * @return
     */
    List<BasicRole> list(RoleQueryPara filter);
}
