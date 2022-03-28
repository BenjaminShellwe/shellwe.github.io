package top.shellwe.bip.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import top.shellwe.bip.util.Result;

/**
 * The interface Get info service.
 */
public interface GetInfoService {
    /**
     * Gets by id en.
     *
     * @param data the data
     * @return the by id en
     */
    Result getByIdEn(int data);

    /**
     * Gets by id pe.
     *
     * @param data the data
     * @return the by id pe
     */
    Result getByIdPe(int data);
}
