package top.shellwe.bip.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.SystemLogOrder;

/**
 * The interface Log system repository.
 */
@Repository(value = "logSystemService")
public interface LogSystemRepository extends JpaRepository<SystemLogOrder,Integer> {

}
