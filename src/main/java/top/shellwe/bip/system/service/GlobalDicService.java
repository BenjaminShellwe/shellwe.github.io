package top.shellwe.bip.system.service;

import top.shellwe.bip.system.entity.Dictionary;
import top.shellwe.bip.util.Result;

/**
 * The interface Global dic service.
 */
public interface GlobalDicService {
    /**
     * Query all result.
     *
     * @return the result
     */
    Result queryAll();

    /**
     * Update global dic.
     *
     * @param dictionary the dictionary
     */
    void updateGlobalDic(Dictionary dictionary);
}
