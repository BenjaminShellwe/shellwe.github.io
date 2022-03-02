package top.shellwe.bip.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.dao.VacancyComingRepository;
import top.shellwe.bip.entity.VacancyComing;
import top.shellwe.bip.service.VacancyComingService;
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
}
