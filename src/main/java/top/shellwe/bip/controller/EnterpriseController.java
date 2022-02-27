package top.shellwe.bip.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shellwe.bip.entity.Enterprise;
import top.shellwe.bip.mapper.EnterpriseMapper;
import top.shellwe.bip.util.Result;

import java.util.List;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    EnterpriseMapper enterpriseMapper;

    @ResponseBody
    @RequestMapping("/query/Info")
    public Result getById(@RequestBody JSONObject data){

        List<Enterprise> list = enterpriseMapper.getById(data.get("userID"));
        if (list.size() == 0){
            return new Result(2001, "未查询到企业数据");
        }
        return new Result(list);
    }
}
