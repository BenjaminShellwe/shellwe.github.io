package top.shellwe.bip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.shellwe.bip.entity.Employeesinfo;

import java.util.List;

@Repository(value = "getInfoEnRepository")
public interface GetInfoEnRepository extends JpaRepository<Employeesinfo,Integer> {
    List<Employeesinfo> getById(int data);
}
