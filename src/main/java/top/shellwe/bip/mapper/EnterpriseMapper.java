package top.shellwe.bip.mapper;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.shellwe.bip.entity.Enterprise;
import top.shellwe.bip.util.Result;

import java.util.List;
import java.util.Map;

@Mapper
public interface EnterpriseMapper {
    @Select("select * from enterprise where id = #{'id'}")
    public List<Enterprise> getById(Object id);

    @Select("select v.affairID, v.position, v.positionStatus, v.enterpriseID, v.department, v.departmentID, v.description, v.createdTime, v.salary, v.requirement, v.deadline, v.type," +
            " d.name, d.enterprise, d.UIDD, d.director, d.phoneD, d.phoneM, d.UIDM, d.manager, d.departmentStatus" +
            " from vacancy v inner join department d on v.departmentID = d.departmentID")
    public List<Map<String, JSONObject>> uniteTable();
}
