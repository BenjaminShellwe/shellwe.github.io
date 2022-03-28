package top.shellwe.bip.system.service.impl;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.shellwe.bip.system.dto.input.RoleQueryPara;
import top.shellwe.bip.system.entity.BasicRole;
import top.shellwe.bip.system.mapper.RoleMapper;
import top.shellwe.bip.system.service.RoleService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, BasicRole> implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public void listPage(Page<BasicRole> page, RoleQueryPara filter) {
        page.setRecords(roleMapper.selectRoles(page, filter));
    }

    @Override
    public List<BasicRole> list(RoleQueryPara filter) {
        return roleMapper.selectRoles(filter);
    }

    @Override
    public Integer save(BasicRole para) {
        String s = String.valueOf(para.getId());
        if (s != null) {
            roleMapper.updateById(para);
        } else {
            roleMapper.insert(para);
        }
        return para.getId();
    }
}
