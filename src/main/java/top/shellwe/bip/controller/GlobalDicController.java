package top.shellwe.bip.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.shellwe.bip.entity.Dictionary;
import top.shellwe.bip.mapper.GlobalDicMapper;
import top.shellwe.bip.service.GlobalDicService;
import top.shellwe.bip.util.Result;

import java.util.*;


@RestController
@RequestMapping("/dictionary")
public class GlobalDicController {
    @Autowired
    GlobalDicService globalDicService;

    @Autowired
    GlobalDicMapper globalDicMapper;

    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return globalDicService.queryAll();
    }

    @PostMapping("/queryTypeName")
    public Result getByTypeName(@RequestBody JSONObject data) {
        List<Dictionary> list = globalDicMapper.getByTypeName(data.get("typeName"));
        if (list.size() == 0){
            return new Result(200, "查无数据");
        }
        return new Result(list);
    }

    @PostMapping("/queryId")
    public Result getById(@RequestBody JSONObject data) {
        List<Dictionary> list = globalDicMapper.getById(data.get("id"));
        if (list.size() == 0){
            return new Result(200, "查无数据");
        }
//        System.out.println(list.get(0).getEditable());
        if(Objects.equals(list.get(0).getEditable(), "0")){
            return new Result(4033, "禁止写访问");
        }
        return new Result(200, "数据已获取");
    }
    @PostMapping("/deleteId")
    public Result DeleteById(@RequestBody JSONObject data) {
        List<Dictionary> list = globalDicMapper.getById(data.get("id"));
//        System.out.println(list);
        if(Objects.equals(list.get(0).getEditable(), "0")){
            return new Result(4033, "删除动作被拒绝");
        }
        globalDicMapper.deleteId(data.get("id"));
        return new Result(200, "删除已执行");
    }

    @PostMapping("/addGlobalDic")
    public Result addGlobalDic(@RequestBody Dictionary dictionary) {
        cherkType(dictionary);
        if(dictionary.getType().equals("single")){
            List<Dictionary> list = globalDicMapper.getByTypeName(dictionary.getTypeName());
            if(list.size() > 0) {
                return new Result(415, "Same rule found!");
            }
        }
        dictionary.setEditable("0");
        globalDicService.updateGlobalDic(dictionary);
        return new Result(200, "添加规则成功!");
    }

    @ResponseBody
    @RequestMapping("/update/field")
    public Result updateGlobalDicField(@RequestBody Dictionary dictionary) {
        cherkType(dictionary);
        globalDicService.updateGlobalDic(dictionary);
        return new Result(200, "Success");
    }
    public void cherkType(@RequestBody Dictionary dictionary) {
        if(dictionary.getType().equals("single")) {
            dictionary.setValueID(0);
            if(dictionary.getTypeCode().contains("_")){
                dictionary.setTypeCode((dictionary.getTypeCode().split("_Type")[0]));
            }
        }
        if(dictionary.getType().equals("group")) {
            if(!dictionary.getTypeCode().contains("_")){
                dictionary.setTypeCode(dictionary.getTypeCode() + "_Type");
            }
            List<Dictionary> list = globalDicMapper.getByTypeName(dictionary.getTypeName());
            if(list.size() > 0) {
                dictionary.setValueID(list.size() + 1);
            }
        }
    }
}
