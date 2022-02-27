package top.shellwe.bip.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.*;
import top.shellwe.bip.entity.Dictionary;

import java.util.List;
import java.util.Map;

@Mapper
public interface GlobalDicMapper {

    @Select("select * from dictionary")
    public List<Dictionary> findAllGlobalDic();

    @Select("select * from dictionary where typeName = #{'typeName'}")
    public List<Dictionary> getByTypeName(Object typeName);

    @Select("select * from dictionary where id = #{id}")
    public List<Dictionary> getById(Object id);

    @Insert("insert into dictionary(valueID, valueName, prefix, typeName, description, valueStatus, uniqueID, typeCode)" +
            " values( #{valueID}, #{valueName}, #{prefix}, #{typeName}, #{description}, #{valueStatus}, #{uniqueID}, #{typeCode}, #{type})")
    public void addGlobalDic(int valueID, Object valueName, Object prefix, Object typeName, Object description, Object valueStatus, Object uniqueID, Object typeCode, Object type);

    @Delete("delete from dictionary where id = #{id}")
    public void deleteId(Object id);
}
