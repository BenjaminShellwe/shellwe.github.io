package top.shellwe.bip.system.service;

import top.shellwe.bip.system.entity.Department;

import top.shellwe.bip.util.Result;

import java.util.List;

/**
 * The interface Department service.
 */
public interface DepartmentService {
    /**
     * Query all result.
     *
     * @return the result
     */
    Result queryAll();

    /**
     * Gets by enterprise id.
     *
     * @param eid the eid
     * @return the by enterprise id
     */
    List<Department> getByEnterpriseID(String eid);

    /**
     * Update department field result.
     *
     * @param department the department
     * @return the result
     */
    Result updateDepartmentField(Department department);
}
