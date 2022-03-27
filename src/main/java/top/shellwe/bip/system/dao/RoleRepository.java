package top.shellwe.bip.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.Role;

/**
 * The interface Role repository.
 */
@Repository(value = "RoleService")
public interface RoleRepository extends JpaRepository<Role,Integer> {

}
