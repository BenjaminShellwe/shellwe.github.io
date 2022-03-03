package top.shellwe.bip.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.shellwe.bip.entity.VacancyComing;
import top.shellwe.bip.mapper.VacancyComingMapper;
import top.shellwe.bip.service.VacancyComingService;
import top.shellwe.bip.util.Result;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/vacancyComing")
public class VacancyComingController {

    @Autowired
    VacancyComingService vacancyComingService;

    @Autowired
    VacancyComingMapper vacancyComingMapper;
    private JSONObject data;

    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return vacancyComingService.queryAll();
    }

    @ResponseBody
    @RequestMapping("/updateByAid")
    public Result updateByAid(@RequestBody JSONObject data){
        String aid = data.getString("affairID");
        int i = data.getInteger("verify");
        vacancyComingMapper.updateByAid(aid, i);
        return new Result(200, "Success");
    }

    @ResponseBody
    @RequestMapping("/deleteByAid")
    public Result deleteByAid(@RequestBody JSONObject data){
        vacancyComingMapper.deleteByAid(data.getString("affairID"));
        return new Result(200, "Success");
    }

    @ResponseBody
    @RequestMapping("/updateAll")
    public Result updateVacancyComing(@RequestBody JSONObject data){
//        System.out.println("测试输出data" + data);
        VacancyComing vacancyComing = new VacancyComing();
        JSONObject o = data.getJSONObject("data");
        vacancyComing.setId(o.getInteger("id"));
        vacancyComing.setAffairID(o.getString("affairID"));
        vacancyComing.setResult(o.getString("result"));
        vacancyComing.setEnterpriseID(o.getString("enterpriseID"));
        vacancyComing.setDepartmentID(o.getString("departmentID"));
        vacancyComing.setPosition(o.getString("position"));
        vacancyComing.setDepartment(o.getString("department"));
        vacancyComing.setEstimatedTime(o.getString("estimatedTime"));
        vacancyComing.setName(o.getString("name"));
        vacancyComing.setSex(o.getString("sex"));
        vacancyComing.setDescription(o.getString("description"));
        vacancyComing.setCreatedTime(o.getString("createdTime"));
        vacancyComing.setAddress(o.getString("address"));
        vacancyComing.setPhone(o.getString("phone"));

        vacancyComingService.updateAll(vacancyComing);
        return new Result(200, "Success");
    }
}
