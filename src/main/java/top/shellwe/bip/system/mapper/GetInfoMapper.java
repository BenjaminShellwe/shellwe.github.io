package top.shellwe.bip.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.shellwe.bip.system.entity.Employeesinfo;
import top.shellwe.bip.system.entity.Personalinfo;

import java.util.List;

/**
 * The interface Get info mapper.
 */
@Mapper
public interface GetInfoMapper {

    /**
     * Gets by id en.
     *
     * @param userID the user id
     * @return the by id en
     */
    @Select("select * from employeesinfo where userID = #{'userID'}")
    public List<Employeesinfo> getByIdEn(Object userID);

    /**
     * Gets by eid.
     *
     * @param enterpriseID the enterprise id
     * @return the by eid
     */
    @Select("select * from employeesinfo where enterpriseID = #{enterpriseID}")
    public List<Employeesinfo> getByEID(Object enterpriseID);

    /**
     * Gets by id pe.
     *
     * @param userID the user id
     * @return the by id pe
     */
    @Select("select * from personalinfo where userID = #{'userID'}")
    public List<Personalinfo> getByIdPe(Object userID);

}
