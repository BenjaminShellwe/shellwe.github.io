package top.shellwe.bip.system.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shellwe.bip.system.entity.Department;
import top.shellwe.bip.system.entity.Enterprise;
import top.shellwe.bip.system.mapper.EnterpriseMapper;
import top.shellwe.bip.system.service.DepartmentService;
import top.shellwe.bip.util.Result;

import java.util.List;
import java.util.Map;

/**
 * The type Enterprise controller.
 */
@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

    /**
     * The Enterprise mapper.
     */
    @Autowired
    EnterpriseMapper enterpriseMapper;
    /**
     * The Department service.
     */
    @Autowired
    DepartmentService departmentService;

    /**
     * Get by id result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/query/Info")
    public Result getById(@RequestBody JSONObject data){

        List<Enterprise> list = enterpriseMapper.getById(data.get("userID"));
        if (list.size() == 0){
            return new Result(2001, "????????");
        }
        return new Result(list);
    }

    /**
     * Query department result.
     *
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/query/departmentAll")
    public Result queryDepartment(){
        return departmentService.queryAll();
    }

    /**
     * Query department by eid result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/query/department")
    public Result queryDepartmentByEID(@RequestBody JSONObject data){
        List<Department> list = departmentService.getByEnterpriseID(data.getString("enterpriseID"));
        if (list.size() == 0) {
            return new Result(400, "Error!");
        }
        return new Result(list);
    }

    /**
     * Unite table list.
     *
     * @return the list
     */
    @ResponseBody
    @RequestMapping("/query/uniteTable")
    public List<Map<String, JSONObject>> uniteTable(){
//        System.out.println("????" + enterpriseMapper.uniteTable());
        return enterpriseMapper.uniteTable();
    }

    /**
     * Update department field result.
     *
     * @param data the data
     * @return the result
     */
    @ResponseBody
    @RequestMapping("/update/department/field")
    public Result updateDepartmentField(@RequestBody JSONObject data){
       Department department = new Department();
       System.out.println("????" + data);
        JSONObject o = data.getJSONObject("data");
        department.setId(o.getInteger("id"));
        department.setName(o.getString("name"));
        department.setDepartmentID(o.getString("departmentID"));
        department.setEnterpriseID(o.getString("enterpriseID"));
        department.setUIDD(o.getString("uidd"));
        department.setDirector(o.getString("director"));
        department.setPhoneD(o.getString("phoneD"));
        department.setUIDM(o.getString("uidm"));
        department.setManager(o.getString("manager"));
        department.setPhoneM(o.getString("phoneM"));
        department.setDepartmentStatus(o.getString("departmentStatus"));
        departmentService.updateDepartmentField(department);
        return new Result(200, "Success");
    }
}

