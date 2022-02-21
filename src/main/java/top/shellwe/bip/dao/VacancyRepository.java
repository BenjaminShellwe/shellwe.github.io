package top.shellwe.bip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.entity.Vacancy;

@Repository(value = "vacancyService")
public interface VacancyRepository extends JpaRepository<Vacancy,Integer> {
}
