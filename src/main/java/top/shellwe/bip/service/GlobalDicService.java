package top.shellwe.bip.service;

import top.shellwe.bip.util.Result;

public interface GlobalDicService {
    Result queryAll();
    Result getByTypeName(String data);
}
