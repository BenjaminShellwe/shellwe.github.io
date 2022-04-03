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
import top.shellwe.bip.system.dao.LogSystemRepository;
import top.shellwe.bip.system.dto.input.LogQueryPara;
import top.shellwe.bip.system.entity.SystemLogOrder;
import top.shellwe.bip.system.entity.SystemLogEvent;
import top.shellwe.bip.system.mapper.SystemLogEventMapper;
import top.shellwe.bip.system.service.SystemLogEventService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SystemEventLogEventServiceImpl extends ServiceImpl<SystemLogEventMapper, SystemLogEvent> implements SystemLogEventService {

    @Autowired
    SystemLogEventMapper systemLogEventMapper;

    @Resource
    LogSystemRepository logSystemRepository;

    @Override
    public Result queryAll() {
        List<SystemLogOrder> list = logSystemRepository.findAll();
        return new Result(list);
    }

    @Override
    public void listPage(Page<SystemLogEvent> page, LogQueryPara para) {
        List<SystemLogEvent> result = systemLogEventMapper.selectSystemLogs(page, para);
        result.forEach( e->{
//            if (e.getUserId()==0){
//                e.setUsername("非法人员");
//            }
        });
        page.setRecords(result);
    }

    @Override
    public List<SystemLogEvent> list(LogQueryPara para) {
        return systemLogEventMapper.selectSystemLogs(para);
    }

    @Override
    public Integer save(SystemLogEvent para) {
        if (para.getId()!=null) {
            systemLogEventMapper.updateById(para);
        } else {
            systemLogEventMapper.insert(para);
        }
        return para.getId();
    }
}
