package top.shellwe.bip.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.Personalinfo;

import java.util.List;

/**
 * The interface Get info pe repository.
 */
@Repository(value = "getInfoPeRepository")
public interface GetInfoPeRepository extends JpaRepository<Personalinfo,Integer> {
    /**
     * Gets by id.
     *
     * @param data the data
     * @return the by id
     */
    List<Personalinfo> getById(int data);
}
