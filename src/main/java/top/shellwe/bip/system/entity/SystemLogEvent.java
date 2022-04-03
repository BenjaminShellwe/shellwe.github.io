package top.shellwe.bip.system.entity;
/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import top.shellwe.bip.common.entity.BaseEntity;

import java.io.Serializable;

@Data
@ApiModel(description = "系统管理 - 日志表")
@TableName("system_log_event")
public class SystemLogEvent extends BaseEntity<SystemLogEvent> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    @TableId(value="id", type= IdType.AUTO)
    private Integer id;
    /**
     * 接口名称
     */
    @ApiModelProperty(value = "接口名称")
    @TableField("name")
    private String name;
    /**
     * 接口地址
     */
    @ApiModelProperty(value = "接口地址")
    @TableField("url")
    private String url;
    /**
     * 访问人IP
     */
    @ApiModelProperty(value = "访问人IP")
    @TableField("ip")
    private String ip;
    /**
     * 访问人ID
     */
    @ApiModelProperty(value = "访问人ID")
    @TableField("user_id")
    private Integer userId;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Integer status;
    /**
     * 接口执行时间
     */
    @ApiModelProperty(value = "接口执行时间")
    @TableField("execute_time")
    private String executeTime;

    @ApiModelProperty(value = "访问人名字")
    @TableField(exist = false)
    private String username;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
