package swd.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
   
    @Autowired
    DataSource dataSource;
    @Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
        auth.jdbcAuthentication()  
                .usersByUsernameQuery("select username,password,enabled from user where username=?")  
                .authoritiesByUsernameQuery("select u.username,r.role from user u inner join user_roles ur on(u.id=ur.user_id) inner join role r on(ur.role_id=r.id)  where u.username=?")  
                .dataSource(dataSource);  
        auth.userDetailsService(userDetailsService());  
    }  
  
  
    @Override  
    protected void configure(HttpSecurity http) throws Exception {  
        http  
            .authorizeRequests()  
                .antMatchers("/admin/**").hasAuthority("ADMIN")  
                .antMatchers("/user/**").hasAuthority("USER")  
                .anyRequest().fullyAuthenticated()  
                .and()  
            .formLogin()  
            .and()  
            .logout()  
        ;  
    }  
}
