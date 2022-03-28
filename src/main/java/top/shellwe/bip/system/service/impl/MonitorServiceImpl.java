package top.shellwe.bip.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.MonitorRepository;
import top.shellwe.bip.system.entity.SystemLogMonitor;
import top.shellwe.bip.system.service.MonitorService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Resource
    MonitorRepository monitorRepository;

    @Override
    public Result queryAll() {
        List<SystemLogMonitor> list = monitorRepository.findAll();
        return new Result(list);
    }
}
