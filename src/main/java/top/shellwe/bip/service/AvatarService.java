package top.shellwe.bip.service;

import top.shellwe.bip.entity.Avatar;
import top.shellwe.bip.util.Result;

public interface AvatarService {
    Result query(int id);
    void insert(Avatar avatar);
}
