package top.shellwe.bip.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.dao.GlobalDicRepository;
import top.shellwe.bip.entity.Dictionary;
import top.shellwe.bip.service.GlobalDicService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GlobalDicServiceImpl implements GlobalDicService {
    @Resource
    GlobalDicRepository globalDicRepository;

    @Override
    public Result queryAll() {
        List<Dictionary> list = globalDicRepository.findAll();
        return new Result(list);
    }

    @Override
    public Result getByTypeNameAndValueStatus(String typeName, String valueStatus) {
        List<Dictionary> list = globalDicRepository.getByTypeNameAndValueStatus(typeName, valueStatus);
        return new Result(list);
    }
}
