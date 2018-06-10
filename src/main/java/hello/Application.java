package hello;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import famvc.hibernate.HibernateUtil;
import famvc.service.UserService;

@SpringBootApplication
@EnableWebMvc
@ComponentScan({"famvc.hibernate","famvc.hbm.models","famvc.service.impl","famvc.dao.impl","famvc.mvc.controller"})
public class Application {	

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Autowired
    HibernateUtil hibernateUtil;
    
    @Autowired
	UserService usrService;
    
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
             //System.out.println(ctx.getBeanDefinitionNames().toString());
            // long i = 1; 
    		//ses.createCriteria(User.class).list().stream().forEach(u->System.out.println(((User)(u)).getName()));
        	 
    		//usrService.getAll().stream().forEach(u->System.out.println(u.getName()));
        	//SessionFactory ses = hibernateUtil.getNoSqlSessionFactory();
        	//ses.getCurrentSession();
        	//ses.close();
    		System.out.println("*#*");
        };
    }
  
  /*  @Bean
    public DispatcherServlet dispatcherServlet(){
    	return new DispatcherServlet();
    }
    
    @Bean
    public ServletRegistrationBean dispatcherServletRegistration(){
    	ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet(),"/advice/");
    	registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
    	return registration;
    }*/
  
}