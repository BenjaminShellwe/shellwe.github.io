package top.shellwe.bip.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GlobalDicMapper {

    @Select("select * from dictionary")
    public String findAllGlobalDic();
}
