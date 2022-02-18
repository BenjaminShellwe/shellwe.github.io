package top.shellwe.bip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.entity.Personalinfo;

import java.util.List;

@Repository(value = "getInfoPeRepository")
public interface GetInfoPeRepository extends JpaRepository<Personalinfo,Integer> {
        List<Personalinfo> getById(int data);
}
