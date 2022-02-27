package top.shellwe.bip.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.dao.GetInfoEnRepository;
import top.shellwe.bip.dao.GetInfoPeRepository;
import top.shellwe.bip.entity.Employeesinfo;
import top.shellwe.bip.entity.Personalinfo;
import top.shellwe.bip.service.GetInfoService;
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
        List<Employeesinfo> list = getInfoEnRepository.getById(data);
        return new Result(list);
    }
    @Override
    public Result getByIdPe(int data) {
        List<Personalinfo> list = getInfoPeRepository.getById(data);
        return new Result(list);
    }
}
