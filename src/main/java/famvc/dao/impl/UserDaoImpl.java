/**
 * Author : Anubhav Kaushik
 * Date : Jun 5, 2018
 */
package famvc.dao.impl;

import java.util.List;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import famvc.dao.GenericDao;
import famvc.dao.UserDao;
import famvc.hbm.models.User;
import famvc.hibernate.HibernateUtil;

/**
 * @author ANUBHAV
 *
 */
@Repository("UserDao")

public class UserDaoImpl  extends GenericDao<User> implements UserDao{
	




	@Autowired
	
	private HibernateUtil hibernateUtil;

	UserDaoImpl(){
		this.setEntity(User.class);
	}
	
	@Override
	public boolean validateUser(String email,String password) {
		
		return false;
		// TODO Auto-generated method stub
		
	}







	

}
