package top.shellwe.bip.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.Vacancy;

/**
 * The interface Vacancy repository.
 */
@Repository(value = "vacancyService")
public interface VacancyRepository extends JpaRepository<Vacancy,Integer> {
}
