package top.shellwe.bip.system.controller;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shellwe.bip.system.dao.DepartmentRepository;
import top.shellwe.bip.system.dao.GetInfoEnRepository;
import top.shellwe.bip.system.dao.GetInfoPeRepository;
import top.shellwe.bip.system.entity.InformationEnterpriseDepartment;
import top.shellwe.bip.system.entity.InformationEnterpriseEmployees;
import top.shellwe.bip.system.entity.informationPersonal;
import top.shellwe.bip.system.mapper.InformationMapper;
import top.shellwe.bip.util.Result;

import java.util.*;

/**
 * The type Get info controller.
 */
@RestController
@RequestMapping("/queryInfo")
public class GetInfoController {
    /**
     * The Get info en repository.
     */
    @Autowired
    GetInfoEnRepository getInfoEnRepository;

    /**
     * The Get info pe repository.
     */
    @Autowired
    GetInfoPeRepository getInfoPeRepository;

    /**
     * The InformationEnterpriseDepartment repository.
     */
    @Autowired
    DepartmentRepository departmentRepository;

    /**
     * The Get info mapper.
     */
    @Autowired
    InformationMapper informationMapper;

    /**
     * Gets by eid.
     *
     * @param data the data
     * @return the by eid
     */
    @PostMapping("/enterprise")
    public Result getByEID(@RequestBody JSONObject data) {
        List<InformationEnterpriseEmployees> list = informationMapper.getByEID(data.get("enterpriseID"));
        if (list.size() == 0){
            return new Result(2001, "未查询到企业员工数据");
        }
        return new Result(list);
    }

    /**
     * Gets by id en.
     *
     * @param data the data
     * @return the by id en
     */
    @PostMapping("/employee")
    public Result getByIdEn(@RequestBody JSONObject data) {
        List<InformationEnterpriseEmployees> list = informationMapper.getByIdEn(data.get("userID"));
        if (list.size() == 0){
            return new Result(2001, "未查询到该企业职员数据");
        }
        return new Result(list);
    }

    /**
     * Gets by id pe.
     *
     * @param data the data
     * @return the by id pe
     */
    @PostMapping("/personal")
    public Result getByIdPe(@RequestBody JSONObject data) {
        List<informationPersonal> list = informationMapper.getByIdPe(data.get("userID"));
        if (list.size() == 0){
            return new Result(202, "未查询到用户数据,请确认UID正确性", "warning");
        }
        return new Result(list);
    }

    /**
     * Update personal result.
     *
     * @param informationPersonal the informationPersonal
     * @return the result
     */
    @PostMapping("/update/personal")
    public Result updatePersonal(@RequestBody informationPersonal informationPersonal) {
        getInfoPeRepository.save(informationPersonal);
        return new Result(200, "更新信息操作已提交到数据库", "success");
    }

    /**
     * Insert personal result.
     *
     * @param informationEnterpriseEmployees the informationEnterpriseEmployees
     * @return the result
     */
    @PostMapping("/insert/personal")
    public Result insertPersonal(@RequestBody InformationEnterpriseEmployees informationEnterpriseEmployees) {
        getInfoEnRepository.save(informationEnterpriseEmployees);
        return new Result(200, "员工信息操作已提交到数据库", "success");
    }

    /**
     * InformationEnterpriseDepartment info result.
     *
     * @param data the data
     * @return the result
     */
    @PostMapping("/enterprise/department")
    public Result departmentInfo(@RequestBody JSONObject data) {
        List<InformationEnterpriseDepartment> list = departmentRepository.getByEnterpriseID(data.getString("enterpriseID"));
        return new Result(200, "部门信息操作已从数据库取出", list);
    }

    /**
     * Role result.
     *
     * @param data the data
     * @return the result
     */
    @PostMapping("/role")
    public Result role(@RequestBody JSONObject data) {


        return new Result(200, "数据库已返回数据");
    }
}