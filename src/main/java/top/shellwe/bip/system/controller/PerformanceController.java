package top.shellwe.bip.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.system.service.PerformanceService;
import top.shellwe.bip.util.Result;

/**
 * The type Performance controller.
 */
@RestController
@RequestMapping("/performance")
public class PerformanceController {

    /**
     * The Performance service.
     */
    @Autowired
    PerformanceService performanceService;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return performanceService.queryAll();
    }
}
