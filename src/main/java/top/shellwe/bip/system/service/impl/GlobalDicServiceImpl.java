package top.shellwe.bip.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.GlobalDicRepository;
import top.shellwe.bip.system.entity.DictionaryGlobal;
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
        List<DictionaryGlobal> list = globalDicRepository.findAll();
        return new Result(list);
    }

    @Override
    public void updateGlobalDic(DictionaryGlobal dictionaryGlobal) {
        globalDicRepository.save(dictionaryGlobal);
        new Result(200, "Success");
    }
}
