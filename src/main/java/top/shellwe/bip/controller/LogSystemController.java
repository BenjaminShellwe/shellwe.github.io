package top.shellwe.bip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.service.LogSystemService;
import top.shellwe.bip.util.Result;

@RestController
@RequestMapping("/log")
public class LogSystemController {

    @Autowired
    LogSystemService logSystemService;

    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return logSystemService.queryAll();
    }
}
