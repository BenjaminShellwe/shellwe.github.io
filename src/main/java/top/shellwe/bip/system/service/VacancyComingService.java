package top.shellwe.bip.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import top.shellwe.bip.system.entity.SeniorVacancyCreate;
import top.shellwe.bip.util.Result;

/**
 * The interface SeniorVacancy coming service.
 */
public interface VacancyComingService {
    /**
     * Query all result.
     *
     * @return the result
     */
    Result queryAll();

    /**
     * Update all result.
     *
     * @param seniorVacancyCreate the vacancy coming
     * @return the result
     */
    Result updateAll(SeniorVacancyCreate seniorVacancyCreate);
}
