package top.shellwe.bip.system.mapper;

/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/3/28 8:56:24
 */

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import top.shellwe.bip.system.dto.input.LogQueryPara;
import top.shellwe.bip.system.entity.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> 系统管理 - 日志表 Mapper 接口 </p>
 *
 * @author : zhengqing
 * @author BenjaminThomas
 * @date : 2022/03/28
 */
@Mapper
public interface LogMapper extends BaseMapper<SysLog> {

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<SysLog> selectLogs(Pagination page, @Param("filter") LogQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<SysLog> selectLogs(@Param("filter") LogQueryPara filter);

}
