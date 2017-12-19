package hk.com.datainsights.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hk.com.datainsights.dao.UserDao;
import hk.com.datainsights.entry.UserEntry;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public long addUser(UserEntry user){
		return userDao.addUser(user);
	}
	public UserEntry findById(long pkid){
		return userDao.findById(pkid);
	}
}
