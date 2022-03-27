package top.shellwe.bip.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.system.service.LogSystemService;
import top.shellwe.bip.util.Result;

/**
 * The type Log system controller.
 */
@RestController
@RequestMapping("/log")
public class LogSystemController {

    /**
     * The Log system service.
     */
    @Autowired
    LogSystemService logSystemService;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return logSystemService.queryAll();
    }
}
