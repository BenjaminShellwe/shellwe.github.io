package top.shellwe.bip.service;

import top.shellwe.bip.entity.Department;

import top.shellwe.bip.util.Result;

import java.util.List;

public interface DepartmentService {
    Result queryAll();
    List<Department> getByEnterpriseID(String eid);
    Result updateDepartmentField(Department department);
}
