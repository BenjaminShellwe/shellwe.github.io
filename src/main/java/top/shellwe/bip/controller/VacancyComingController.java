package top.shellwe.bip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.service.VacancyComingService;
import top.shellwe.bip.util.Result;

@RestController
@RequestMapping("/vacancyComing")
public class VacancyComingController {

    @Autowired
    VacancyComingService vacancyComingService;

    @ResponseBody
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return vacancyComingService.queryAll();
    }
}
