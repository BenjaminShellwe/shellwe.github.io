package top.shellwe.bip.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.shellwe.bip.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select userName from user where userName = #{'userName'}")
    public String selectUserName(String userName);

    @Select("select userPassword from user where userName = #{'userName'}")
    public String selectUserPassword(String userName);

    @Select("select id from user where userName = #{'userName'}")
    public int check(String userName);

    @Insert("insert into user(userName, userPassword) values(#{'userName'}, #{'userPassword'})")
    public void addUser(String userName, String userPassword);

    @Update("update user set userPassword = #{psw} where id = #{id} and userName = #{userName}")
    public void updatePsw(Object id, Object psw, Object userName);

    @Select("select id from user where enterpriseID = #{'enterpriseID'}")
    public List<User> queryEID(String enterpriseID);

    @Select("select enterpriseID from user where id = #{'id'}")
    public List<User> getEID(String id);
}
