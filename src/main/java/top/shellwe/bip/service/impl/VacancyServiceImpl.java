package top.shellwe.bip.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.dao.VacancyRepository;
import top.shellwe.bip.entity.Vacancy;
import top.shellwe.bip.service.VacancyService;
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
}
