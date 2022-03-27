package top.shellwe.bip.system.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.VacancyComingRepository;
import top.shellwe.bip.system.entity.VacancyComing;
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
        List<VacancyComing> list = vacancyComingRepository.findAll();
        return new Result(list);
    }

    @Override
    public Result updateAll(VacancyComing vacancyComing) {
        vacancyComingRepository.save(vacancyComing);
        return new Result(200, "Success");
    }
}
