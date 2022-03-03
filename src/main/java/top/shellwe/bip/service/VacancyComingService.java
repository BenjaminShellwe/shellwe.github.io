package top.shellwe.bip.service;

import top.shellwe.bip.entity.VacancyComing;
import top.shellwe.bip.util.Result;

public interface VacancyComingService {
    Result queryAll();
    Result updateAll(VacancyComing vacancyComing);
}
