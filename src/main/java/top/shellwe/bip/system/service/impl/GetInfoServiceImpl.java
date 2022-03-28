package top.shellwe.bip.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.GetInfoEnRepository;
import top.shellwe.bip.system.dao.GetInfoPeRepository;
import top.shellwe.bip.system.entity.InformationEnterpriseEmployees;
import top.shellwe.bip.system.entity.informationPersonal;
import top.shellwe.bip.system.service.GetInfoService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GetInfoServiceImpl implements GetInfoService {
    @Resource
    GetInfoEnRepository getInfoEnRepository;

    @Resource
    GetInfoPeRepository getInfoPeRepository;

    @Override
    public Result getByIdEn(int data) {
        List<InformationEnterpriseEmployees> list = getInfoEnRepository.getById(data);
        return new Result(list);
    }
    @Override
    public Result getByIdPe(int data) {
        List<informationPersonal> list = getInfoPeRepository.getById(data);
        return new Result(list);
    }
}
