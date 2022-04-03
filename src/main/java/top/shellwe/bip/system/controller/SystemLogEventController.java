package top.shellwe.bip.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.system.service.SystemLogEventService;
import top.shellwe.bip.util.Result;

/**
 * The type Log system controller.
 */
@RestController
@RequestMapping("/log")
public class SystemLogEventController {

    /**
     * The Log system service.
     */
    @Autowired
    SystemLogEventService systemLogEventService;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return systemLogEventService.queryAll();
    }
}
