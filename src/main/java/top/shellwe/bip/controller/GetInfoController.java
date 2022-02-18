package top.shellwe.bip.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.dao.GetInfoEnRepository;
import top.shellwe.bip.entity.Employeesinfo;
import top.shellwe.bip.entity.Personalinfo;
import top.shellwe.bip.mapper.GetInfoMapper;
import top.shellwe.bip.util.Result;

import java.util.List;

@RestController
public class GetInfoController {
    @Autowired
    GetInfoEnRepository getInfoEnRepository;

    @Autowired
    GetInfoMapper getInfoMapper;

    @PostMapping("/queryInfo/enterprise")
    public Result getByIdEn(@RequestBody JSONObject data) {
        List<Employeesinfo> list = getInfoMapper.getByIdEn(data.get("id"));
        if (list == null){
            return new Result(200, "查无数据");
        }
        return new Result(list);
    }

    @PostMapping("/queryInfo/personal")
    public Result getByIdPe(@RequestBody JSONObject data) {
        List<Personalinfo> list = getInfoMapper.getByIdPe(data.get("id"));
        if (list == null){
            return new Result(200, "查无数据");
        }
        return new Result(list);
    }
}
