package top.shellwe.bip.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import top.shellwe.bip.system.entity.DictionaryGlobal;
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
     * @param dictionaryGlobal the dictionary
     */
    void updateGlobalDic(DictionaryGlobal dictionaryGlobal);
}
