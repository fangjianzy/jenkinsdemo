package hk.com.datainsights.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import hk.com.datainsights.entry.UserEntry;

@Mapper
public interface UserDao {
	@Insert("insert into user(name, age) values(#{name}, #{age})")
	public long addUser(UserEntry user);
	
	@Select("select id, name as name, age as age from user where id = #{pkid}")
	public UserEntry findById(long pkid);
}
