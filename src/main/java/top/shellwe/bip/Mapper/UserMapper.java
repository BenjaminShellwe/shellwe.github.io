package top.shellwe.bip.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select userName from user where userName = #{'userName'}")
    public String selectUserName(String userName);

    @Select("select userPassword from user where userName = #{'userName'}")
    public String selectUserPassword(String userName);

    @Select("select userPassword, userPassword from user where userName = #{'userName'} AND userPassword = #{'userPassword'}")
    public String check(String userName,String userPassword);

    @Insert("insert into user(userName, userPassword) values(#{'userName'}, #{'userPassword'})")
    public void addUser(String userName, String userPassword);
}
