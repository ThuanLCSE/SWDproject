package swd.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import swd.DAO.BlogDAO;
import swd.DAO.BlogLikeDAO;
import swd.DAO.UserDAO;
import swd.service.BlogService;
import swd.service.BlogServiceImpl;
import swd.service.LikeService;
import swd.service.LikeServiceImpl;
import swd.service.UserService;
import swd.service.UserServiceImpl;
//
@Configuration
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan(basePackages="swd.controller")
public class ApplicationConfig extends WebMvcConfigurerAdapter  {
    
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // TODO Auto-generated method stub
        return  application.sources(ApplicationStart.class);
    }

    @Bean(name="blogService")
    public BlogService blogService(){
        return new BlogServiceImpl();
    }

    @Bean(name="likeService")
    public LikeService likeService(){
        return new LikeServiceImpl();
    }
    @Bean(name="userService")
    public UserService userService(){
        return new UserServiceImpl();
    }
    @Bean(name="blogDAO")
    public BlogDAO blogDAO(){
        return new BlogDAO();
    }

    @Bean(name="blogLikeDAO")
    public BlogLikeDAO blogLikeDAO(){
        return new BlogLikeDAO();
    }
    
    @Bean(name="userDAO")
    public UserDAO userDAO(){
        return new UserDAO();
    }
    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123456");
        
        return driverManagerDataSource;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
       LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
       em.setDataSource(dataSource());
       em.setPackagesToScan(new String[] { "swd.entity.model" });
  
       JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
       em.setJpaVendorAdapter(vendorAdapter);
       em.setJpaProperties(additionalProperties());
  
       return em;
    }
  
  
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(emf);
  
       return transactionManager;
    }
  
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
       return new PersistenceExceptionTranslationPostProcessor();
    }
  
    Properties additionalProperties() {
       Properties properties = new Properties();
       properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
       return properties;
    }
    
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

  
}
