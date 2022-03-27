package top.shellwe.bip.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.entity.VacancyComing;

/**
 * The interface Vacancy coming repository.
 */
@Repository(value = "vacancyComingService")
public interface VacancyComingRepository extends JpaRepository<VacancyComing,Integer> {
}
