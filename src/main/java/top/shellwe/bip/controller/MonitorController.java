package top.shellwe.bip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.service.MonitorService;
import top.shellwe.bip.util.Result;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    MonitorService monitorService;

    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return monitorService.queryAll();
    }
}
