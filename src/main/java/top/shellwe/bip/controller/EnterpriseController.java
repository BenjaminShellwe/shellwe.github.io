package top.shellwe.bip.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shellwe.bip.dao.DepartmentRepository;
import top.shellwe.bip.entity.Department;
import top.shellwe.bip.entity.Enterprise;
import top.shellwe.bip.mapper.EnterpriseMapper;
import top.shellwe.bip.service.DepartmentService;
import top.shellwe.bip.util.Result;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    EnterpriseMapper enterpriseMapper;
    @Autowired
    DepartmentService departmentService;

    @ResponseBody
    @RequestMapping("/query/Info")
    public Result getById(@RequestBody JSONObject data){

        List<Enterprise> list = enterpriseMapper.getById(data.get("userID"));
        if (list.size() == 0){
            return new Result(2001, "未查询到企业数据");
        }
        return new Result(list);
    }

    @ResponseBody
    @RequestMapping("/query/departmentAll")
    public Result queryDepartment(){
        return departmentService.queryAll();
    }

    @ResponseBody
    @RequestMapping("/query/department")
    public Result queryDepartmentByEID(@RequestBody JSONObject data){
        List<Department> list = departmentService.getByEnterpriseID(data.getString("enterpriseID"));
        if (list.size() == 0) {
            return new Result(400, "Error!");
        }
        return new Result(list);
    }

    @ResponseBody
    @RequestMapping("/query/uniteTable")
    public List<Map<String, JSONObject>> uniteTable(){
//        System.out.println("测试输出" + enterpriseMapper.uniteTable());
        return enterpriseMapper.uniteTable();
    }
}

