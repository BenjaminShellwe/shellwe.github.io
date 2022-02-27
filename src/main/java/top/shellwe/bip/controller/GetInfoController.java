package top.shellwe.bip.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.dao.GetInfoEnRepository;
import top.shellwe.bip.entity.Employeesinfo;
import top.shellwe.bip.entity.Personalinfo;
import top.shellwe.bip.mapper.GetInfoMapper;
import top.shellwe.bip.util.Result;

import java.util.List;

@RestController
@RequestMapping("/queryInfo")
public class GetInfoController {
    @Autowired
    GetInfoEnRepository getInfoEnRepository;

    @Autowired
    GetInfoMapper getInfoMapper;

    @PostMapping("/enterprise")
    public Result getByEID(@RequestBody JSONObject data) {
        List<Employeesinfo> list = getInfoMapper.getByEID(data.get("enterpriseID"));
        if (list.size() == 0){
            return new Result(2001, "未查询到企业员工数据");
        }
        return new Result(list);
    }

    @PostMapping("/employee")
    public Result getByIdEn(@RequestBody JSONObject data) {
        List<Employeesinfo> list = getInfoMapper.getByIdEn(data.get("userID"));
        if (list.size() == 0){
            return new Result(2001, "未查询到该企业职员数据");
        }
        return new Result(list);
    }

    @PostMapping("/personal")
    public Result getByIdPe(@RequestBody JSONObject data) {
        List<Personalinfo> list = getInfoMapper.getByIdPe(data.get("userID"));
        if (list.size() == 0){
            return new Result(2001, "未查询到用户数据");
        }
        return new Result(list);
    }
}
