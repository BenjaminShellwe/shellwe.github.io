package top.shellwe.bip.system.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.GlobalDicRepository;
import top.shellwe.bip.system.entity.Dictionary;
import top.shellwe.bip.system.service.GlobalDicService;
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
    public void updateGlobalDic(Dictionary dictionary) {
        globalDicRepository.save(dictionary);
        new Result(200, "Success");
    }
}
