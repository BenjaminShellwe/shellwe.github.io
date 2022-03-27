package top.shellwe.bip.system.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.MonitorRepository;
import top.shellwe.bip.system.entity.Monitor;
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
        List<Monitor> list = monitorRepository.findAll();
        return new Result(list);
    }
}
