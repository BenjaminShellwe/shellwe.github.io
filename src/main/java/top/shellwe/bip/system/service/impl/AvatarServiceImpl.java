package top.shellwe.bip.system.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.AvatarRepository;
import top.shellwe.bip.system.entity.Avatar;
import top.shellwe.bip.system.service.AvatarService;

import javax.annotation.Resource;


@Service
public class AvatarServiceImpl implements AvatarService {

    @Resource
    AvatarRepository avatarRepository;

    @Override
    public void insert(Avatar avatar){
        avatarRepository.save(avatar);
    }

    @Override
    public Avatar query(int id) {
        Avatar avatar = avatarRepository.getById(id);
        System.out.println("测试输出" + avatarRepository.getById(id));
        return avatar;
    }
}
