package top.shellwe.bip.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.PerformanceRepository;
import top.shellwe.bip.system.entity.InformationEnterprisePerformance;
import top.shellwe.bip.system.service.PerformanceService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Resource
    PerformanceRepository performanceRepository;

    @Override
    public Result queryAll() {
        List<InformationEnterprisePerformance> list = performanceRepository.findAll();
        return new Result(list);
    }
}
