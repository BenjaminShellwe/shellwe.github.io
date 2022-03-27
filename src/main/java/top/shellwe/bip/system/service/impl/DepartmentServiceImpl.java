package top.shellwe.bip.system.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.DepartmentRepository;
import top.shellwe.bip.system.entity.Department;
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
        List<Department> list = departmentRepository.findAll();
        return new Result(list);
    }

    @Override
    public List<Department> getByEnterpriseID(String eid) {
//        List<Department> list = departmentRepository.getByEnterpriseID(eid);
        return departmentRepository.getByEnterpriseID(eid);
    }

    @Override
    public Result updateDepartmentField(Department department){
        departmentRepository.save(department);
        return new Result(200, "Success");
    }
}
