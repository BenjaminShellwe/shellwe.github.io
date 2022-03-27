package top.shellwe.bip.system.service;

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
