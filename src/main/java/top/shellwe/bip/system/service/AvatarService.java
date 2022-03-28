package top.shellwe.bip.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import top.shellwe.bip.system.entity.BasicAvatar;

/**
 * The interface Avatar service.
 */
public interface AvatarService {
    /**
     * Query avatar.
     *
     * @param id the id
     * @return the avatar
     */
    BasicAvatar query(int id);

    /**
     * Insert.
     *
     * @param basicAvatar the avatar
     */
    void insert(BasicAvatar basicAvatar);
}
