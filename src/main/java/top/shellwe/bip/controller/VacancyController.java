package top.shellwe.bip.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.entity.Vacancy;
import top.shellwe.bip.service.VacancyService;
import top.shellwe.bip.util.Result;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    @Autowired
    VacancyService vacancyService;

    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return vacancyService.queryAll();
    }

    @ResponseBody
    @RequestMapping("/addNewVacancy")
    public Result publish(@RequestBody JSONObject object){
        Long timeStamp = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmss");
        Vacancy vacancy =new Vacancy();
        vacancy.setCreatedTime(object.getDate("createdTime"));
        vacancy.setDeadline(object.getDate("deadline"));
        vacancy.setPositionStatus(object.getString("positionStatus"));
        vacancy.setType(object.getString("type"));
        vacancy.setRequirement(object.getString("requirement"));
        vacancy.setSalary(object.getString("salary"));
        vacancy.setDepartment(object.getString("department"));
        vacancy.setDepartmentStatus(object.getString("departmentStatus"));
        vacancy.setPosition(object.getString("position"));
        vacancy.setDescription(object.getString("description"));
        String s = simpleDateFormat.format(timeStamp);
        vacancy.setAffairID(s);
        Result r = vacancyService.publish(vacancy);
        if (r.getCode() == 200){
            return r;
        }
        return new Result(400, "Error!");
    }
}
