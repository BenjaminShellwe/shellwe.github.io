package top.shellwe.bip.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import top.shellwe.bip.system.entity.InformationEnterpriseDepartment;

import top.shellwe.bip.util.Result;

import java.util.List;

/**
 * The interface InformationEnterpriseDepartment service.
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
    List<InformationEnterpriseDepartment> getByEnterpriseID(String eid);

    /**
     * Update informationEnterpriseDepartment field result.
     *
     * @param informationEnterpriseDepartment the informationEnterpriseDepartment
     * @return the result
     */
    Result updateDepartmentField(InformationEnterpriseDepartment informationEnterpriseDepartment);
}
