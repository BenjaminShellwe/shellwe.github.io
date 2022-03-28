package top.shellwe.bip.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.BasicAvatar;

/**
 * The interface Avatar repository.
 */
@Repository(value = "AvatarService")
public interface AvatarRepository extends JpaRepository<BasicAvatar,Integer> {
    /**
     * Find by id avatar.
     *
     * @param id the id
     * @return the avatar
     */
    BasicAvatar findById(int id);
}
