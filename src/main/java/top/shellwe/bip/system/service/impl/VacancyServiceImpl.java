package top.shellwe.bip.system.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.VacancyRepository;
import top.shellwe.bip.system.entity.Vacancy;
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
        List<Vacancy> list = vacancyRepository.findAll();
        return new Result(list);
    }

    @Override
    public Result publish(Vacancy data) {
        vacancyRepository.save(data);
        return new Result(200, "Success");
    }

    @Override
    public void update(Vacancy data) {
        vacancyRepository.save(data);
    }
}
