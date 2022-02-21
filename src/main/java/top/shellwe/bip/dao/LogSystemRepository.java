package top.shellwe.bip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.entity.LogSystem;

@Repository(value = "logSystemService")
public interface LogSystemRepository extends JpaRepository<LogSystem,Integer> {

}
