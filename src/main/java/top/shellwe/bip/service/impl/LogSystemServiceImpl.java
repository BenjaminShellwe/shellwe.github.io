package top.shellwe.bip.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.dao.LogSystemRepository;
import top.shellwe.bip.entity.LogSystem;
import top.shellwe.bip.service.LogSystemService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogSystemServiceImpl implements LogSystemService {

    @Resource
    LogSystemRepository logSystemRepository;

    @Override
    public Result queryAll() {
        List<LogSystem> list = logSystemRepository.findAll();
        return new Result(list);
    }
}
