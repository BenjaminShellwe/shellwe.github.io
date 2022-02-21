package top.shellwe.bip.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.dao.MonitorRepository;
import top.shellwe.bip.entity.Monitor;
import top.shellwe.bip.service.MonitorService;
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
