package top.shellwe.bip.system.mapper;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.shellwe.bip.system.entity.InformationEnterpriseEmployees;
import top.shellwe.bip.system.entity.informationPersonal;

import java.util.List;

/**
 * The interface Get info mapper.
 */
@Mapper
public interface InformationMapper {

    /**
     * Gets by id en.
     *
     * @param userID the user id
     * @return the by id en
     */
    @Select("select * from information_enterprise_employees where userID = #{'userID'}")
    public List<InformationEnterpriseEmployees> getByIdEn(Object userID);

    /**
     * Gets by eid.
     *
     * @param enterpriseID the enterprise id
     * @return the by eid
     */
    @Select("select * from information_enterprise_employees where enterpriseID = #{enterpriseID}")
    public List<InformationEnterpriseEmployees> getByEID(Object enterpriseID);

    /**
     * Gets by id pe.
     *
     * @param userID the user id
     * @return the by id pe
     */
    @Select("select * from information_enterprise_personal where userID = #{'userID'}")
    public List<informationPersonal> getByIdPe(Object userID);

}
