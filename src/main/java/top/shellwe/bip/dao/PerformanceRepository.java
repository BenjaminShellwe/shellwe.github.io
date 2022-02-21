package top.shellwe.bip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.entity.Performance;

@Repository(value = "performanceService")
public interface PerformanceRepository extends JpaRepository<Performance,Integer> {
}
