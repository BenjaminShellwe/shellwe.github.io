package top.shellwe.bip.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.Monitor;

/**
 * The interface Monitor repository.
 */
@Repository(value = "monitorService")
public interface MonitorRepository extends JpaRepository<Monitor,Integer> {
}
