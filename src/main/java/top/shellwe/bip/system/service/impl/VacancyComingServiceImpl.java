package top.shellwe.bip.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.VacancyComingRepository;
import top.shellwe.bip.system.entity.SeniorVacancyCreate;
import top.shellwe.bip.system.service.VacancyComingService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VacancyComingServiceImpl implements VacancyComingService {

    @Resource
    VacancyComingRepository vacancyComingRepository;

    @Override
    public Result queryAll() {
        List<SeniorVacancyCreate> list = vacancyComingRepository.findAll();
        return new Result(list);
    }

    @Override
    public Result updateAll(SeniorVacancyCreate seniorVacancyCreate) {
        vacancyComingRepository.save(seniorVacancyCreate);
        return new Result(200, "Success");
    }
}
