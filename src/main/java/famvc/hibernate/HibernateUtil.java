package famvc.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metamodel.Metadata;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import famvc.dao.UserDao;
import famvc.hbm.models.User;
import famvc.service.UserService;
import famvc.service.impl.UserServiceImpl;

@Component
@EnableTransactionManagement
@Scope("singleton")
public class HibernateUtil {

    private SessionFactory mySqlSessionFactory ;
    private SessionFactory noSqlSessionFactory ;
    HibernateUtil(){
    	this.mySqlSessionFactory = buildMySqlSessionFactory();
      	this.noSqlSessionFactory=buildNoSqlSessionFactory();
    }
    /**
	 * @return
	 */
    
	private SessionFactory buildNoSqlSessionFactory() {
		// TODO Auto-generated method stub
		 try {
    		 Configuration configuration = new Configuration()
    				    .setProperty("hibernate.ogm.datastore.provider", "mongodb")
    				    .setProperty("hibernate.ogm.mongodb.database", "FinancialEye")
    				    .setProperty("hibernate.ogm.mongodb.host", "@cluster0-ol72a.mongodb.net/test")
    				    .setProperty("hibernate.order_updates", "true")
    		 			.setProperty("hibernate.ogm..username", "anubhav")
    		 			.setProperty("hibernate.ogm.datastore.password", "Nickdiaz");
    		 
         	ServiceRegistry  ServiceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
         	System.out.println("Hibernate serviceRegistry created");
         	
         	SessionFactory sessionFactory = configuration
         						.buildSessionFactory(ServiceRegistry);
         	

    		   } catch (Throwable th) {
    			System.err.println("Enitial SessionFactory creation failed" + th);
    			throw new ExceptionInInitializerError(th);
    		  }
		return noSqlSessionFactory;
	}
	
	private  SessionFactory buildMySqlSessionFactory() {
    	 try {
    		 Configuration configuration = new Configuration()
    				    .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
    				    .setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
    				    .setProperty("hibernate.connection.url", "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12241316")
    				    .setProperty("hibernate.order_updates", "true")
    		 			.setProperty("hibernate.connection.username", "sql12241316")
    		 			.setProperty("hibernate.connection.password", "bbahee5sb6")
    		 			.setProperty("hibernate.current_session_context_class", "thread")
    		 			.addAnnotatedClass(User.class);
    		 	
    		 ServiceRegistry registry=new StandardServiceRegistryBuilder()
    			        .applySettings(configuration.getProperties())
    			        .build();
    		 
    		 

			
    		 mySqlSessionFactory = configuration.buildSessionFactory(registry);

    		   } catch (Throwable th) {
    			System.err.println("Enitial SessionFactory creation failed" + th);
    			throw new ExceptionInInitializerError(th);
    		  }
		return mySqlSessionFactory;
    }

    public  SessionFactory getMySqlSessionFactory() {
        return mySqlSessionFactory;
    }
    
    public  SessionFactory getNoSqlSessionFactory() {
    	
        return this.noSqlSessionFactory;
    }
    
    public  void shutdownMysql() {
    	// Close caches and connection pools
    	getMySqlSessionFactory().close();
    }

}