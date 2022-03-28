package top.shellwe.bip.util;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * The type Message display.
 */
@Data
@ApiModel(description = "websocket消息内容")
public class MessageDisplay {

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

    @ApiModelProperty(value = "消息")
    private String msg;

    @ApiModelProperty(value = "在线人数")
    private int count;
}
