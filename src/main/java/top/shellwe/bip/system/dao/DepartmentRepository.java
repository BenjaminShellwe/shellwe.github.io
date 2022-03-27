package top.shellwe.bip.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.Department;

import java.util.List;

/**
 * The interface Department repository.
 */
@Repository(value = "departmentService")
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    /**
     * Gets by enterprise id.
     *
     * @param eid the eid
     * @return the by enterprise id
     */
    List<Department> getByEnterpriseID(String eid);
}
