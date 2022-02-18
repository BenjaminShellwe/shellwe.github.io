package top.shellwe.bip.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.shellwe.bip.entity.Dictionary;
import top.shellwe.bip.mapper.GlobalDicMapper;
import top.shellwe.bip.service.GlobalDicService;
import top.shellwe.bip.util.Result;

import java.util.*;


@RestController
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

//    @PostMapping("/queryNameAndStatus")
//    public Result getByTypeName(@RequestBody JSONObject data) {
//        System.out.println("data = " + data.get("typeName"));
//        return globalDicService.getByTypeName((String) data.get("typeName"));
//        return globalDicService.getByTypeName((String) data.get("typeName"));
//    }
    @PostMapping("/queryTypeName")
    public Result getByTypeName(@RequestBody JSONObject data) {
        List<Dictionary> list = globalDicMapper.getByTypeName(data.get("typeName"));
        if (list == null){
            return new Result(200, "查无数据");
        }
        return new Result(list);
    }

    @PostMapping("/queryId")
    public Result getById(@RequestBody JSONObject data) {
        List<Dictionary> list = globalDicMapper.getById(data.get("id"));
        if (list == null){
            return new Result(200, "查无数据");
        }
        System.out.println(list.get(0).getEditable());
        if(Objects.equals(list.get(0).getEditable(), "0")){
            return new Result(4033, "禁止写访问");
        }
        return new Result(200, "数据已获取");
    }
    @PostMapping("/deleteId")
    public Result DeleteById(@RequestBody JSONObject data) {
        List<Dictionary> list = globalDicMapper.getById(data.get("id"));
        System.out.println(list.get(0).getEditable());
        if(Objects.equals(list.get(0).getEditable(), "0")){
            return new Result(4033, "删除动作被拒绝");
        }
        globalDicMapper.deleteId(data.get("id"));
        return new Result(200, "删除已执行");
    }

    @PostMapping("/addGlobalDic")
    public Result addGlobalDic(@RequestBody JSONObject data) {
        List<Dictionary> list = globalDicMapper.getByTypeName(data.get("typeName"));
        if (list.size() > 0){
//            查询到相同typeName,valueID长度值+1即新valueID
//            System.out.println("if");
            String s = String.valueOf(list.get(0).getUniqueID());
            data.put("uniqueID",s);
//            特殊情况getValueID=0时,说明是全局唯一不可添加新模板
            if(list.get(0).getValueID() == 0) {
                return new Result(500, "不允许此模板添加新规则");
            }else {
                int i = list.size() + 1;
                data.put("valueID",i);
//                写入数据库
            }

        } else {
//            查询到无相同typeName,需要重新赋值uniqueID和valueID
//            System.out.println("else");
            List<Dictionary> allList = globalDicMapper.findAllGlobalDic();
            allList.sort(new Comparator<Dictionary>() {
                @Override
                public int compare(Dictionary o1, Dictionary o2) {
                    int d = o1.getUniqueID() - o2.getUniqueID();
                    if (d > 0) {
                        return 1;
                    } else if (d < 0) {
                        return -1;
                    }
                    return 0;
                }
            });
            String uid = String.valueOf(data.get("uniqueID"));
            if (uid.equals("")){
                //            遍历获取最大UID 再增加1
                List<Integer> allUID = new ArrayList<Integer>();
                for(int i = 0; i < allList.size(); i++){
                    allUID.add(allList.get(i).getUniqueID());
                }
//            赋值
                data.put("uniqueID",Collections.max(allUID)+1);

            }
//            判断valueID
            String type = String.valueOf(data.get("type"));
            Map<String, Object> map = new HashMap<>();
            if (type.equals("single")) {
                data.put("valueID", 0);
//              循环转换
                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    map.put(entry.getKey(), entry.getValue());
                }
            } else if (type.equals("group")) {
//              遍历获取最大VID 再增加1
                List<Integer> allVID = new ArrayList<Integer>();
                for(int i = 0; i < allList.size(); i++){
                    allVID.add(allList.get(i).getUniqueID());
                }
                data.put("valueID",Collections.max(allVID)+1);
//              循环转换
                for (Map.Entry<String, Object> entry : data.entrySet()) {
                    map.put(entry.getKey(), entry.getValue());
                }
            } else {
                System.out.println("验证数据错误");
            }
//            检查数据
//            System.out.println(data);
            System.out.println(map);

            int i = (int) map.get("valueID");
            Object o = map.get("valueName");
            Object o1 = map.get("prefix");
            Object o2 = map.get("typeName");
            Object o3 = map.get("description");
            Object o4 = map.get("valueStatus");
            Object o5 = map.get("uniqueID");
            Object o6 = map.get("typeCode");
            Object o7 = map.get("type");

//          写入数据库
            globalDicMapper.addGlobalDic(i, o, o1 ,o2, o3, o4, o5, o6, o7);
            System.out.println("Success");
        }
        return new Result(200, "添加规则成功!");
    }
}
