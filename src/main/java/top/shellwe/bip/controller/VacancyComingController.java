package top.shellwe.bip.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.mapper.VacancyComingMapper;
import top.shellwe.bip.service.VacancyComingService;
import top.shellwe.bip.util.Result;

@RestController
@RequestMapping("/vacancyComing")
public class VacancyComingController {

    @Autowired
    VacancyComingService vacancyComingService;
    @Autowired
    VacancyComingMapper vacancyComingMapper;

    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return vacancyComingService.queryAll();
    }

    @ResponseBody
    @RequestMapping("/updateById")
    public Result updateByAid(@RequestBody JSONObject data){
        String aid = data.getString("affairID");
        int i = data.getInteger("verify");
        vacancyComingMapper.updateByAid(aid, i);
        return new Result(200, "Success");
    }

}
