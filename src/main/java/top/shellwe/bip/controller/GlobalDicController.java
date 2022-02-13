package top.shellwe.bip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.shellwe.bip.mapper.GlobalDicMapper;
import top.shellwe.bip.service.GlobalDicService;
import top.shellwe.bip.util.Result;

import java.util.Map;

@RestController
public class GlobalDicController {
    @Autowired
    GlobalDicService globalDicService;

    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return globalDicService.queryAll();
    }
    @PostMapping("/queryNameAndStatus")
    public Result getByTypeName(@RequestBody String typeName, String valueStatus) {
        return globalDicService.getByTypeNameAndValueStatus(typeName, valueStatus);
    }
}
