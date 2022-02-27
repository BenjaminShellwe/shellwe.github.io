package top.shellwe.bip.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.shellwe.bip.entity.Enterprise;

import java.util.List;

@Mapper
public interface EnterpriseMapper {
    @Select("select * from enterprise where id = #{'id'}")
    public List<Enterprise> getById(Object id);
}
