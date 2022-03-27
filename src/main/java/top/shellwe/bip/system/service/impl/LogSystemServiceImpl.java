package top.shellwe.bip.system.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.shellwe.bip.system.dao.LogSystemRepository;
import top.shellwe.bip.system.dto.input.LogQueryPara;
import top.shellwe.bip.system.entity.LogSystem;
import top.shellwe.bip.system.entity.SysLog;
import top.shellwe.bip.system.mapper.LogMapper;
import top.shellwe.bip.system.service.LogSystemService;
import top.shellwe.bip.util.Result;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogSystemServiceImpl extends ServiceImpl<LogMapper, SysLog> implements LogSystemService {

    @Autowired
    LogMapper logMapper;

    @Resource
    LogSystemRepository logSystemRepository;

    @Override
    public Result queryAll() {
        List<LogSystem> list = logSystemRepository.findAll();
        return new Result(list);
    }

    @Override
    public void listPage(Page<SysLog> page, LogQueryPara para) {
        List<SysLog> result = logMapper.selectLogs(page, para);
        result.forEach( e->{
            if (e.getUserId()==0){
                e.setUsername("非法人员");
            }
        });
        page.setRecords(result);
    }

    @Override
    public List<SysLog> list(LogQueryPara para) {
        return logMapper.selectLogs(para);
    }

    @Override
    public Integer save(SysLog para) {
        if (para.getId()!=null) {
            logMapper.updateById(para);
        } else {
            logMapper.insert(para);
        }
        return para.getId();
    }
}
