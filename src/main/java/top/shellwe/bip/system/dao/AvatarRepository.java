package top.shellwe.bip.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.Avatar;

/**
 * The interface Avatar repository.
 */
@Repository(value = "AvatarService")
public interface AvatarRepository extends JpaRepository<Avatar,Integer> {
    /**
     * Find by id avatar.
     *
     * @param id the id
     * @return the avatar
     */
    Avatar findById(int id);
}
