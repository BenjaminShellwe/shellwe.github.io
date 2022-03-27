package top.shellwe.bip.system.mapper;

import org.apache.ibatis.annotations.*;
import top.shellwe.bip.system.entity.Dictionary;

import java.util.List;


/**
 * The interface Global dic mapper.
 */
@Mapper
public interface GlobalDicMapper {

    /**
     * Find all global dic list.
     *
     * @return the list
     */
    @Select("select * from dictionary")
    public List<Dictionary> findAllGlobalDic();

    /**
     * Gets by type name.
     *
     * @param typeName the type name
     * @return the by type name
     */
    @Select("select * from dictionary where typeName = #{'typeName'}")
    public List<Dictionary> getByTypeName(Object typeName);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Select("select * from dictionary where id = #{id}")
    public List<Dictionary> getById(Object id);

    /**
     * Add global dic.
     *
     * @param valueID     the value id
     * @param valueName   the value name
     * @param prefix      the prefix
     * @param typeName    the type name
     * @param description the description
     * @param valueStatus the value status
     * @param uniqueID    the unique id
     * @param typeCode    the type code
     * @param type        the type
     */
    @Insert("insert into dictionary(valueID, valueName, prefix, typeName, description, valueStatus, uniqueID, typeCode)" +
            " values( #{valueID}, #{valueName}, #{prefix}, #{typeName}, #{description}, #{valueStatus}, #{uniqueID}, #{typeCode}, #{type})")
    public void addGlobalDic(int valueID, Object valueName, Object prefix, Object typeName, Object description, Object valueStatus, Object uniqueID, Object typeCode, Object type);

    /**
     * Delete id.
     *
     * @param id the id
     */
    @Delete("delete from dictionary where id = #{id}")
    public void deleteId(Object id);
}
