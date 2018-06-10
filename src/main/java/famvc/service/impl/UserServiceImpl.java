/**
 * Author : Anubhav Kaushik
 * Date : Jun 7, 2018
 */
package famvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import famvc.dao.UserDao;
import famvc.hbm.models.User;
import famvc.service.UserService;

/**
 * @author ANUBHAV
 *
 */
@Service("UserService")

public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	@Override
	public boolean validateUser(String email,String password) {
		// TODO Auto-generated method stub
		
		return userDao.validateUser( email,  password);
	}

}
