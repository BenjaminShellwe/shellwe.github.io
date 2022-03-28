package top.shellwe.bip.system.service;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import top.shellwe.bip.system.entity.SeniorVacancy;
import top.shellwe.bip.util.Result;

/**
 * The interface SeniorVacancy service.
 */
public interface VacancyService {
    /**
     * Query all result.
     *
     * @return the result
     */
    Result queryAll();

    /**
     * Publish result.
     *
     * @param data the data
     * @return the result
     */
    Result publish(SeniorVacancy data);

    /**
     * Update.
     *
     * @param data the data
     */
    void update(SeniorVacancy data);
}
