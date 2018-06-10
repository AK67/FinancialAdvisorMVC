/**
 * Author : Anubhav Kaushik
 * Date : Jun 7, 2018
 */
package famvc.service;

import java.util.List;

import famvc.hbm.models.User;

/**
 * @author ANUBHAV
 *
 */

public interface UserService {
	public boolean validateUser(String email, String password);
	public List<User> getAll();
}
