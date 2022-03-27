package top.shellwe.bip.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.Performance;

/**
 * The interface Performance repository.
 */
@Repository(value = "performanceService")
public interface PerformanceRepository extends JpaRepository<Performance,Integer> {
}
