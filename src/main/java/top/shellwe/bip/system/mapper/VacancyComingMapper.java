package top.shellwe.bip.system.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * The interface Vacancy coming mapper.
 */
@Mapper
public interface VacancyComingMapper {

    /**
     * Update by aid.
     *
     * @param aid the aid
     * @param i   the
     */
    @Update("update vacancycoming set verify = #{i} where affairID = #{aid}")
    public void updateByAid(String aid, int i);

    /**
     * Delete by aid.
     *
     * @param aid the aid
     */
    @Delete("delete from vacancycoming where affairID = #{aid}")
    public void deleteByAid(String aid);
}
