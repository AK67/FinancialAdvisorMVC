/**

 * Author : Anubhav Kaushik
 * Date : Jun 7, 2018
 */
package famvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.Entity;
import org.springframework.beans.factory.annotation.Autowired;

import famvc.hbm.models.User;
import famvc.hibernate.HibernateUtil;

/**
 * @author ANUBHAV
 * @param <T>
 *
 */
public class GenericDao<E> {
	
	@Autowired
	HibernateUtil hibernateUtil;
	Transaction tx ;
	
	Class<E> entity;
	
	public  final  void setEntity(Class<E> object){
		 this.entity =  object;
	}
	
	
	
	public List<E> getAll(){
		Session ses = (Session) hibernateUtil.getMySqlSessionFactory().getCurrentSession();
		tx = ses.beginTransaction();
		System.out.println(entity.getClass());
		List<E> objs = ses.createQuery("from "+ this.entity.getName()).list();
		tx.commit();
		return objs;
	}

}
