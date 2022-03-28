package top.shellwe.bip.system.dao;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import top.shellwe.bip.system.entity.InformationEnterpriseEmployees;

import java.util.List;

/**
 * The interface Get info en repository.
 */
@Repository(value = "getInfoEnRepository")
public interface GetInfoEnRepository extends JpaRepository<InformationEnterpriseEmployees,Integer> {
    /**
     * Gets by id.
     *
     * @param data the data
     * @return the by id
     */
    List<InformationEnterpriseEmployees> getById(int data);
}
