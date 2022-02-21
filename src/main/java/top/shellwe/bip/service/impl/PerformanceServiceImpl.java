package top.shellwe.bip.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.dao.PerformanceRepository;
import top.shellwe.bip.entity.Monitor;
import top.shellwe.bip.entity.Performance;
import top.shellwe.bip.service.PerformanceService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService {

    @Resource
    PerformanceRepository performanceRepository;

    @Override
    public Result queryAll() {
        List<Performance> list = performanceRepository.findAll();
        return new Result(list);
    }
}
