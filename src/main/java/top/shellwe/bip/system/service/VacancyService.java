package top.shellwe.bip.system.service;

import top.shellwe.bip.system.entity.Vacancy;
import top.shellwe.bip.util.Result;

/**
 * The interface Vacancy service.
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
    Result publish(Vacancy data);

    /**
     * Update.
     *
     * @param data the data
     */
    void update(Vacancy data);
}
