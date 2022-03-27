package top.shellwe.bip.system.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.shellwe.bip.system.entity.Dictionary;
import top.shellwe.bip.system.mapper.GlobalDicMapper;
import top.shellwe.bip.system.service.GlobalDicService;
import top.shellwe.bip.util.Result;

import java.util.*;


/**
 * The type Global dic controller.
 */
@RestController
@RequestMapping("/dictionary")
public class GlobalDicController {
    /**
     * The Global dic service.
     */
    @Autowired
    GlobalDicService globalDicService;

    /**
     * The Global dic mapper.
     */
    @Autowired
    GlobalDicMapper globalDicMapper;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return globalDicService.queryAll();
    }

    /**
     * Gets by type name.
     *
     * @param data the data
     * @return the by type name
     */
    @PostMapping("/queryTypeName")
    public Result getByTypeName(@RequestBody JSONObject data) {
        List<top.shellwe.bip.system.entity.Dictionary> list = globalDicMapper.getByTypeName(data.get("typeName"));
        if (list.size() == 0){
            return new Result(200, "查无数据");
        }
        return new Result(list);
    }

    /**
     * Gets by id.
     *
     * @param data the data
     * @return the by id
     */
    @PostMapping("/queryId")
    public Result getById(@RequestBody JSONObject data) {
        List<top.shellwe.bip.system.entity.Dictionary> list = globalDicMapper.getById(data.get("id"));
        if (list.size() == 0){
            return new Result(200, "查无数据");
        }
//        System.out.println(list.get(0).getEditable());
        if(Objects.equals(list.get(0).getEditable(), "0")){
            return new Result(4033, "禁止写访问");
        }
        return new Result(200, "数据已获取");
    }

    /**
     * Delete by id result.
     *
     * @param data the data
     * @return the result
     */
    @PostMapping("/deleteId")
    public Result DeleteById(@RequestBody JSONObject data) {
        List<top.shellwe.bip.system.entity.Dictionary> list = globalDicMapper.getById(data.get("id"));
//        System.out.println(list);
        if(Objects.equals(list.get(0).getEditable(), "0")){
            return new Result(4033, "删除动作被拒绝");
        }
        globalDicMapper.deleteId(data.get("id"));
        return new Result(200, "删除已执行");
    }

    /**
     * Add global dic result.
     *
     * @param dictionary the dictionary
     * @return the result
     */
    @PostMapping("/addGlobalDic")
    public Result addGlobalDic(@RequestBody top.shellwe.bip.system.entity.Dictionary dictionary) {
        cherkType(dictionary);
        if(dictionary.getType().equals("single")){
            List<top.shellwe.bip.system.entity.Dictionary> list = globalDicMapper.getByTypeName(dictionary.getTypeName());
            if(list.size() > 0) {
                return new Result(415, "Same rule found!");
            }
        }
        dictionary.setEditable("0");
        globalDicService.updateGlobalDic(dictionary);
        return new Result(200, "添加规则成功!");
    }

    /**
     * Update global dic field result.
     *
     * @param dictionary the dictionary
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/update/field")
    public Result updateGlobalDicField(@RequestBody top.shellwe.bip.system.entity.Dictionary dictionary) {
        cherkType(dictionary);
        globalDicService.updateGlobalDic(dictionary);
        return new Result(200, "Success");
    }

    /**
     * Cherk type.
     *
     * @param dictionary the dictionary
     */
    public void cherkType(@RequestBody top.shellwe.bip.system.entity.Dictionary dictionary) {
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
