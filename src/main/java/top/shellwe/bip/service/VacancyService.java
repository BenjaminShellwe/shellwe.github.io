package top.shellwe.bip.service;

import top.shellwe.bip.entity.Vacancy;
import top.shellwe.bip.util.Result;

public interface VacancyService {
    Result queryAll();
    Result publish(Vacancy data);
}
