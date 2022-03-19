package top.shellwe.bip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.entity.Avatar;

import java.util.List;

@Repository(value = "AvatarService")
public interface AvatarRepository extends JpaRepository<Avatar,Integer> {
}
