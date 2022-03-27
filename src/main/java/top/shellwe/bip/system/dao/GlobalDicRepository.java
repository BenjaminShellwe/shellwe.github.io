package top.shellwe.bip.system.dao;

import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Global dic repository.
 */
@Repository(value = "globalDicRepository")
public interface GlobalDicRepository extends JpaRepository<Dictionary,Integer> {
    /**
     * Gets by prefix and id.
     *
     * @param prefix the prefix
     * @param id     the id
     * @return the by prefix and id
     */
    List<Dictionary> getByPrefixAndId(String prefix, int id);

    /**
     * Gets by type name.
     *
     * @param data the data
     * @return the by type name
     */
    List<Dictionary> getByTypeName(String data);
}
