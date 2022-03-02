package top.shellwe.bip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.entity.Department;

import java.util.List;

@Repository(value = "departmentService")
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    List<Department> getByEnterpriseID(String eid);
}
