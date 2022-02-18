package top.shellwe.bip.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.shellwe.bip.entity.Employeesinfo;
import top.shellwe.bip.entity.Personalinfo;

import java.util.List;

@Mapper
public interface GetInfoMapper {

    @Select("select * from employeesinfo where id = #{'id'}")
    public List<Employeesinfo> getByIdEn(Object id);

    @Select("select * from personalinfo where id = #{'id'}")
    public List<Personalinfo> getByIdPe(Object id);
}
