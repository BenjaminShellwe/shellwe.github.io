package top.shellwe.bip.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.VacancyRepository;
import top.shellwe.bip.system.entity.SeniorVacancy;
import top.shellwe.bip.system.service.VacancyService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {

    @Resource
    VacancyRepository vacancyRepository;

    @Override
    public Result queryAll() {
        List<SeniorVacancy> list = vacancyRepository.findAll();
        return new Result(list);
    }

    @Override
    public Result publish(SeniorVacancy data) {
        vacancyRepository.save(data);
        return new Result(200, "Success");
    }

    @Override
    public void update(SeniorVacancy data) {
        vacancyRepository.save(data);
    }
}
