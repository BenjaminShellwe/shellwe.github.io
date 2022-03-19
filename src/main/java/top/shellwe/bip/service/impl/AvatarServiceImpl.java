package top.shellwe.bip.service.impl;

import org.springframework.stereotype.Service;
import top.shellwe.bip.dao.AvatarRepository;
import top.shellwe.bip.entity.Avatar;
import top.shellwe.bip.service.AvatarService;
import top.shellwe.bip.util.Result;

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
    public Result query(int id) {
        Avatar avatar = avatarRepository.getById(id);
        System.out.println("测试输出" + avatarRepository.getById(id));
        return new Result(avatar);
    }
}
