package top.shellwe.bip.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.shellwe.bip.entity.Employeesinfo;
import top.shellwe.bip.entity.Personalinfo;

import java.util.List;

@Mapper
public interface GetInfoMapper {

    @Select("select * from employeesinfo where userID = #{'userID'}")
    public List<Employeesinfo> getByIdEn(Object userID);

    @Select("select * from employeesinfo where enterpriseID = #{enterpriseID}")
    public List<Employeesinfo> getByEID(Object enterpriseID);

    @Select("select * from personalinfo where userID = #{'userID'}")
    public List<Personalinfo> getByIdPe(Object userID);

}
