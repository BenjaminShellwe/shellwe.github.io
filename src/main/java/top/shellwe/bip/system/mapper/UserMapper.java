package top.shellwe.bip.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.shellwe.bip.system.dto.input.UserQueryPara;
import top.shellwe.bip.system.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select userName from user where userName = #{'userName'}")
    String selectUserName(String userName);

    @Select("select userPassword from user where userName = #{'userName'}")
    String selectUserPassword(String userName);

    @Select("select id from user where userName = #{'userName'}")
    int check(String userName);

    @Insert("insert into user(userName, userPassword) values(#{'userName'}, #{'userPassword'})")
    void addUser(String userName, String userPassword);

    @Update("update user set userPassword = #{psw} where id = #{id} and userName = #{userName}")
    void updatePsw(Object id, Object psw, Object userName);

    @Select("select id, userRealName from user where enterpriseID = #{'enterpriseID'}")
    List<User> queryEID(String enterpriseID);

    @Select("select enterpriseID from user where id = #{'id'}")
    public List<User> getEID(String id);

    /**
     * 列表分页
     *
     * @param page
     * @param filter
     * @return
     */
    List<User> selectUsers(Pagination page, @Param("filter") UserQueryPara filter);

    /**
     * 列表
     *
     * @param filter
     * @return
     */
    List<User> selectUsers(@Param("filter") UserQueryPara filter);


    /**
     * 通过token查找用户信息
     *
     * @param token:
     * @return: top.shellwe.bip.system.entity.User
     */
    User getUserInfoByToken(@Param("token") String token);


    /**
     * 通过角色ID查询用户集合
     *
     * @param roleId:
     * @return: java.util.List<Role>
     */
    List<User> selectUserByRoleId(@Param("roleId") Integer roleId);

    /**
     * 通过账号查找用户信息
     *
     * @param username:
     * @return: top.shellwe.bip.system.entity.User
     */
    User selectUserByUsername(@Param("username") String username);
}
