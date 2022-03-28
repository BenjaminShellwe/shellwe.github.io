package top.shellwe.bip.system.controller.api;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.google.common.collect.Lists;
import top.shellwe.bip.common.api.BaseController;
import top.shellwe.bip.common.dto.output.ApiResult;
import top.shellwe.bip.system.dto.input.MenuQueryPara;
import top.shellwe.bip.system.dto.output.SystemUrlTreeNode;
import top.shellwe.bip.system.entity.SystemUrl;
import top.shellwe.bip.system.service.MenuService;
import top.shellwe.bip.util.TreeBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p> 系统管理-菜单表  接口 </p>
 */
@RestController
@RequestMapping("/api/system/menu")
@Api(description = "系统管理 - 菜单表 接口")
public class SysMenuController extends BaseController {

    @Autowired
    MenuService menuService;

    @PostMapping(value = "/treeMenu", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取菜单树", httpMethod = "POST", response = ApiResult.class)
    public ApiResult treeMenu() {
        List<SystemUrl> list = menuService.listTreeMenu();
        List<SystemUrlTreeNode> menuTreeNodeList = Lists.newArrayList();
        if( list != null && !list.isEmpty() ){
            list.forEach( temp->{
                SystemUrlTreeNode menuTreeNode = new SystemUrlTreeNode();
                BeanUtil.copyProperties( temp, menuTreeNode);
                menuTreeNodeList.add( menuTreeNode );
            } );
        }
        List<SystemUrlTreeNode> menuTreeNodeList2 = TreeBuilder.buildMenuTree( menuTreeNodeList );

//        menuTreeNodeList2.stream().sorted( Comparator.comparing( SystemUrlTreeNode::getSortNo ) ).collect( Collectors.toList());
        JSONObject json = new JSONObject();
        json.put( "menuList", list);
        json.put( "menuTree", menuTreeNodeList2);
        return ApiResult.ok("获取菜单树成功", json);
    }

    @PostMapping(value = "/save", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "保存菜单 ", httpMethod = "POST", response = ApiResult.class)
    public ApiResult save(@RequestBody @Validated SystemUrl input) {
        Integer id = menuService.save(input);
        return ApiResult.ok("保存菜单成功", id);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "删除菜单", httpMethod = "POST", response = ApiResult.class)
    public ApiResult delete(@RequestBody MenuQueryPara input) {
        // 如果该菜单下存在子菜单，提示先删除子菜单
        List<SystemUrl> systemUrlList = menuService.selectList(new EntityWrapper<SystemUrl>().eq("parent_id", input.getId()));
        if (!CollectionUtils.isEmpty(systemUrlList)){
//            systemUrlList.forEach(e -> menuService.deleteById(e.getId()));
            return ApiResult.fail("该菜单下存在子菜单，请先删除子菜单！");
        }
        menuService.deleteById(input.getId());
        return ApiResult.ok("删除菜单成功");
    }

    // 下面暂时不用 ================================================

    @PostMapping(value = "/listPage", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取系统管理-菜单表 列表分页", httpMethod = "POST", response = ApiResult.class)
    public ApiResult listPage(@RequestBody MenuQueryPara filter) {
        Page<SystemUrl> page = new Page<>(filter.getPage(),filter.getLimit());
        menuService.listPage(page, filter);
        return ApiResult.ok("获取系统管理-菜单表 列表分页成功", page);
    }

    @PostMapping(value = "/list", produces = "application/json;charset=utf-8")
    @ApiOperation(value = "获取系统管理-菜单表 列表", httpMethod = "POST", response = ApiResult.class)
    public ApiResult list(@RequestBody MenuQueryPara filter) {
        List<SystemUrl> result = menuService.list(filter);
        return ApiResult.ok("获取系统管理-菜单表 列表成功",result);
    }

//    @PostMapping(value = "/getById", produces = "application/json;charset=utf-8")
//    @ApiOperation(value = "获取系统管理-菜单表 信息", httpMethod = "POST", response = ApiResult.class)
//    public ApiResult getById(@RequestBody MenuQueryPara input) {
//        SystemUrl entity = menuService.selectById(input.getId());
//        return ApiResult.ok("获取系统管理-菜单表 信息成功", entity);
//    }

}
