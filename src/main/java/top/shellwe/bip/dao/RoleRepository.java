package top.shellwe.bip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.entity.Role;

@Repository(value = "RoleService")
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
