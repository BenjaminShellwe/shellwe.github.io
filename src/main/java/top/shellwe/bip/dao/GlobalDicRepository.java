package top.shellwe.bip.dao;

import org.springframework.stereotype.Repository;
import top.shellwe.bip.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository(value = "globalDicRepository")
public interface GlobalDicRepository extends JpaRepository<Dictionary,Integer> {

    List<Dictionary> getByPrefixAndId(String prefix, int id);
    List<Dictionary> getByTypeNameAndValueStatus(String typeName, String valueStatus);
}
