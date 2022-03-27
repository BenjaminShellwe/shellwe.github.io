package top.shellwe.bip.system.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.system.entity.Vacancy;
import top.shellwe.bip.system.service.VacancyService;
import top.shellwe.bip.util.Result;

import java.text.SimpleDateFormat;

/**
 * The type Vacancy controller.
 */
@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    /**
     * The Vacancy service.
     */
    @Autowired
    VacancyService vacancyService;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return vacancyService.queryAll();
    }

    /**
     * Update result.
     *
     * @param object the object
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/update")
    public Result update(@RequestBody JSONObject object) {
        Vacancy vacancy = new Vacancy();
        vacancy.setAffairID(object.getString("affairID"));
        vacancy.setPosition(object.getString("position"));
        vacancy.setDescription(object.getString("description"));
        vacancy.setSalary(object.getString("salary"));
        vacancy.setType(object.getString("type"));
        vacancy.setRequirement(object.getString("requirement"));
        vacancy.setDepartment(object.getString("department"));
        vacancy.setDeadline(object.getDate("deadline"));
        vacancy.setCreatedTime(object.getDate("createdTime"));
        vacancy.setDepartmentID(object.getString("departmentID"));
        vacancy.setEnterpriseID(object.getString("enterpriseID"));
        vacancy.setPositionStatus(object.getString("positionStatus"));
        vacancyService.update(vacancy);
        return new Result(200, "提交数据已修改");
    }

    /**
     * Publish result.
     *
     * @param object the object
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/addNewVacancy")
    public Result publish(@RequestBody JSONObject object){
        Long timeStamp = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyyMMddHHmmss");
        Vacancy vacancy =new Vacancy();
        vacancy.setCreatedTime(object.getDate("createdTime"));
        vacancy.setDeadline(object.getDate("estimatedTime"));
        vacancy.setPositionStatus(object.getString("positionStatus"));
        vacancy.setType(object.getString("type"));
        vacancy.setRequirement(object.getString("requirement"));
        vacancy.setSalary(object.getString("salary"));
        vacancy.setDepartment(object.getString("department"));
        vacancy.setPosition(object.getString("position"));
        vacancy.setDescription(object.getString("description"));
        vacancy.setDepartmentID(object.getString("departmentID"));
        vacancy.setEnterpriseID(object.getString("enterpriseID"));
        String s = simpleDateFormat.format(timeStamp);
        System.out.println("测试输出" + object.getString("AffairID"));
        if(object.getString("AffairID") == null ){
            vacancy.setAffairID(s);
        } else {
            vacancy.setAffairID(object.getString("AffairID"));
        }
        Result r = vacancyService.publish(vacancy);
        if (r.getCode() != 200){
            return new Result(401, "Error!", "error");
        }
        return new Result(200, "success", "success");
    }
}
