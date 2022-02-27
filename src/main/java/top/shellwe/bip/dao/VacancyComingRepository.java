package top.shellwe.bip.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.entity.VacancyComing;

@Repository(value = "vacancyComingService")
public interface VacancyComingRepository extends JpaRepository<VacancyComing,Integer> {
}
