/**
 * Author : Anubhav Kaushik
 * Date : Jun 5, 2018
 */
package famvc.dao;

import java.util.List;

import famvc.hbm.models.User;

/**
 * @author ANUBHAV
 *
 */
public interface UserDao {
	
	public boolean validateUser(String email,String password);
	public List<User> getAll();

}
