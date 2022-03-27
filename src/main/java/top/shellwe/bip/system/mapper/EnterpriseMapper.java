package top.shellwe.bip.system.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.shellwe.bip.system.entity.Enterprise;

import java.util.List;
import java.util.Map;

/**
 * The interface Enterprise mapper.
 */
@Mapper
public interface EnterpriseMapper {
    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @Select("select * from enterprise where id = #{'id'}")
    public List<Enterprise> getById(Object id);

    /**
     * Unite table list.
     *
     * @return the list
     */
    @Select("select v.affairID, v.position, v.positionStatus, v.enterpriseID, v.department, v.departmentID, v.description, v.createdTime, v.salary, v.requirement, v.deadline, v.type," +
            " d.name, d.enterprise, d.UIDD, d.director, d.phoneD, d.phoneM, d.UIDM, d.manager, d.departmentStatus" +
            " from vacancy v inner join department d on v.departmentID = d.departmentID")
    public List<Map<String, JSONObject>> uniteTable();
}
