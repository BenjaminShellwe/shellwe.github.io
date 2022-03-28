package top.shellwe.bip.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.SystemLogMonitor;

/**
 * The interface SystemLogMonitor repository.
 */
@Repository(value = "monitorService")
public interface MonitorRepository extends JpaRepository<SystemLogMonitor,Integer> {
}
