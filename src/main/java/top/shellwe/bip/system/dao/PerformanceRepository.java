package top.shellwe.bip.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.InformationEnterprisePerformance;

/**
 * The interface InformationEnterprisePerformance repository.
 */
@Repository(value = "performanceService")
public interface PerformanceRepository extends JpaRepository<InformationEnterprisePerformance,Integer> {
}
