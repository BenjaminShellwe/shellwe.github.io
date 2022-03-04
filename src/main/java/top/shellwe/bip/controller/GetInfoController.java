package top.shellwe.bip.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.dao.DepartmentRepository;
import top.shellwe.bip.dao.GetInfoEnRepository;
import top.shellwe.bip.dao.GetInfoPeRepository;
import top.shellwe.bip.entity.Department;
import top.shellwe.bip.entity.Employeesinfo;
import top.shellwe.bip.entity.Personalinfo;
import top.shellwe.bip.mapper.GetInfoMapper;
import top.shellwe.bip.util.Result;

import java.util.*;

@RestController
@RequestMapping("/queryInfo")
public class GetInfoController {
    @Autowired
    GetInfoEnRepository getInfoEnRepository;

    @Autowired
    GetInfoPeRepository getInfoPeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    GetInfoMapper getInfoMapper;

    @PostMapping("/enterprise")
    public Result getByEID(@RequestBody JSONObject data) {
        List<Employeesinfo> list = getInfoMapper.getByEID(data.get("enterpriseID"));
        if (list.size() == 0){
            return new Result(2001, "未查询到企业员工数据");
        }
        return new Result(list);
    }

    @PostMapping("/employee")
    public Result getByIdEn(@RequestBody JSONObject data) {
        List<Employeesinfo> list = getInfoMapper.getByIdEn(data.get("userID"));
        if (list.size() == 0){
            return new Result(2001, "未查询到该企业职员数据");
        }
        return new Result(list);
    }

    @PostMapping("/personal")
    public Result getByIdPe(@RequestBody JSONObject data) {
        List<Personalinfo> list = getInfoMapper.getByIdPe(data.get("userID"));
        if (list.size() == 0){
            return new Result(202, "未查询到用户数据,请确认UID正确性", "warning");
        }
        return new Result(list);
    }

    @PostMapping("/update/personal")
    public Result updatePersonal(@RequestBody Personalinfo personalinfo) {
        getInfoPeRepository.save(personalinfo);
        return new Result(200, "更新信息操作已提交到数据库", "success");
    }

    @PostMapping("/insert/personal")
    public Result insertPersonal(@RequestBody Employeesinfo employeesinfo) {
        getInfoEnRepository.save(employeesinfo);
        return new Result(200, "员工信息操作已提交到数据库", "success");
    }

    @PostMapping("/enterprise/department")
    public Result departmentInfo(@RequestBody JSONObject data) {
        List<Department> list = departmentRepository.getByEnterpriseID(data.getString("enterpriseID"));
        return new Result(200, "部门信息操作已从数据库取出", list);
    }
}