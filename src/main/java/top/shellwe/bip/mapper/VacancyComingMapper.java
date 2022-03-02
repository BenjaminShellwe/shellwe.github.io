package top.shellwe.bip.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface VacancyComingMapper {

    @Update("update vacancycoming set verify = #{i} where affairID = #{aid}")
    public void updateByAid(String aid, int i);
}
