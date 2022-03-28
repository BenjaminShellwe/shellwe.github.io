package top.shellwe.bip.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.AvatarRepository;
import top.shellwe.bip.system.entity.BasicAvatar;
import top.shellwe.bip.system.service.AvatarService;

import javax.annotation.Resource;


@Service
public class AvatarServiceImpl implements AvatarService {

    @Resource
    AvatarRepository avatarRepository;

    @Override
    public void insert(BasicAvatar basicAvatar){
        avatarRepository.save(basicAvatar);
    }

    @Override
    public BasicAvatar query(int id) {
        BasicAvatar basicAvatar = avatarRepository.getById(id);
        System.out.println("测试输出" + avatarRepository.getById(id));
        return basicAvatar;
    }
}
