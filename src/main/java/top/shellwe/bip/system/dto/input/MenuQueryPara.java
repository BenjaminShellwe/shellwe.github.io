package top.shellwe.bip.system.dto.input;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import top.shellwe.bip.common.dto.input.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统管理-菜单表 查询参数
 *
 * @author: zhengqing
 * @description:
 * @date: 2019-08-19
 */
@Data
@ApiModel(description = "系统管理-菜单表 查询参数")
public class MenuQueryPara extends BasePageQuery{
    @ApiModelProperty(value = "id")
    private Integer id;
}
