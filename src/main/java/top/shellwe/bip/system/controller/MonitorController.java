package top.shellwe.bip.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.system.service.MonitorService;
import top.shellwe.bip.util.Result;

/**
 * The type Monitor controller.
 */
@RestController
@RequestMapping("/monitor")
public class MonitorController {

    /**
     * The Monitor service.
     */
    @Autowired
    MonitorService monitorService;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return monitorService.queryAll();
    }
}
