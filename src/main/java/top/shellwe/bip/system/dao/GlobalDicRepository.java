package top.shellwe.bip.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.DictionaryGlobal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The interface Global dic repository.
 */
@Repository(value = "globalDicRepository")
public interface GlobalDicRepository extends JpaRepository<DictionaryGlobal,Integer> {
    /**
     * Gets by prefix and id.
     *
     * @param prefix the prefix
     * @param id     the id
     * @return the by prefix and id
     */
    List<DictionaryGlobal> getByPrefixAndId(String prefix, int id);

    /**
     * Gets by type name.
     *
     * @param data the data
     * @return the by type name
     */
    List<DictionaryGlobal> getByTypeName(String data);
}
