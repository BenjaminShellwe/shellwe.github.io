package top.shellwe.bip.system.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.shellwe.bip.system.entity.VacancyComing;
import top.shellwe.bip.system.mapper.VacancyComingMapper;
import top.shellwe.bip.system.service.VacancyComingService;
import top.shellwe.bip.util.Result;

/**
 * The type Vacancy coming controller.
 */
@RestController
@RequestMapping("/vacancyComing")
public class VacancyComingController {

    /**
     * The Vacancy coming service.
     */
    @Autowired
    VacancyComingService vacancyComingService;

    /**
     * The Vacancy coming mapper.
     */
    @Autowired
    VacancyComingMapper vacancyComingMapper;
    private JSONObject data;

    /**
     * Query all result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return vacancyComingService.queryAll();
    }

    /**
     * Update by aid result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/updateByAid")
    public Result updateByAid(@RequestBody JSONObject data){
        String aid = data.getString("affairID");
        int i = data.getInteger("verify");
        vacancyComingMapper.updateByAid(aid, i);
        return new Result(200, "Success");
    }

    /**
     * Delete by aid result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/deleteByAid")
    public Result deleteByAid(@RequestBody JSONObject data){
        vacancyComingMapper.deleteByAid(data.getString("affairID"));
        return new Result(200, "Success");
    }

    /**
     * Update vacancy coming result.
     *
     * @param data the data
     * @return the result
     */
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
