package top.shellwe.bip.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.DepartmentRepository;
import top.shellwe.bip.system.entity.InformationEnterpriseDepartment;
import top.shellwe.bip.system.service.DepartmentService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    DepartmentRepository departmentRepository;

    @Override
    public Result queryAll() {
        List<InformationEnterpriseDepartment> list = departmentRepository.findAll();
        return new Result(list);
    }

    @Override
    public List<InformationEnterpriseDepartment> getByEnterpriseID(String eid) {
//        List<InformationEnterpriseDepartment> list = departmentRepository.getByEnterpriseID(eid);
        return departmentRepository.getByEnterpriseID(eid);
    }

    @Override
    public Result updateDepartmentField(InformationEnterpriseDepartment informationEnterpriseDepartment){
        departmentRepository.save(informationEnterpriseDepartment);
        return new Result(200, "Success");
    }
}
