package top.shellwe.bip.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.InformationEnterpriseDepartment;

import java.util.List;

/**
 * The interface InformationEnterpriseDepartment repository.
 */
@Repository(value = "departmentService")
public interface DepartmentRepository extends JpaRepository<InformationEnterpriseDepartment,Integer> {
    /**
     * Gets by enterprise id.
     *
     * @param eid the eid
     * @return the by enterprise id
     */
    List<InformationEnterpriseDepartment> getByEnterpriseID(String eid);
}
