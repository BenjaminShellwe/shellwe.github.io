package top.shellwe.bip.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.LogSystem;

/**
 * The interface Log system repository.
 */
@Repository(value = "logSystemService")
public interface LogSystemRepository extends JpaRepository<LogSystem,Integer> {

}
