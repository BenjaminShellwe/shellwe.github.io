package top.shellwe.bip.system.service;

import top.shellwe.bip.system.entity.VacancyComing;
import top.shellwe.bip.util.Result;

/**
 * The interface Vacancy coming service.
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
     * @param vacancyComing the vacancy coming
     * @return the result
     */
    Result updateAll(VacancyComing vacancyComing);
}
