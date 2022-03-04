package top.shellwe.bip.service;

import top.shellwe.bip.entity.Dictionary;
import top.shellwe.bip.util.Result;

public interface GlobalDicService {
    Result queryAll();
    void updateGlobalDic(Dictionary dictionary);
}
