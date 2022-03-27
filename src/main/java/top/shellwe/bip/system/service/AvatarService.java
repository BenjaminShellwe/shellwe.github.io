package top.shellwe.bip.system.service;

import top.shellwe.bip.system.entity.Avatar;

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
    Avatar query(int id);

    /**
     * Insert.
     *
     * @param avatar the avatar
     */
    void insert(Avatar avatar);
}
