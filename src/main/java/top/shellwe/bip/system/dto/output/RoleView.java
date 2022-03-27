package top.shellwe.bip.system.dto.output;

import top.shellwe.bip.system.entity.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.shellwe.bip.system.entity.Role;


/**
 * <p> 系统管理-角色表 输出内容</p>
 *
 */
@Data
@ApiModel(description = "系统管理 - 角色表 输出内容")
public class RoleView extends Role {

    @ApiModelProperty(value = "是否已关联系统用户")
    private String isRelatedSysUser;

    @ApiModelProperty(value = "是否已关联系统菜单")
    private String isRelatedSysMenu;

    @ApiModelProperty(value = "是否已关联微信账号")
    private String isRelatedWxAccount;

}
