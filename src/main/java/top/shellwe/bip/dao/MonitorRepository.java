package top.shellwe.bip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.entity.Monitor;

@Repository(value = "monitorService")
public interface MonitorRepository extends JpaRepository<Monitor,Integer> {
}
