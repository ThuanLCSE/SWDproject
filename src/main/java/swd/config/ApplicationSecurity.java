package swd.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity 
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable();
        http
            .authorizeRequests()
            .antMatchers("/api/**").permitAll()   
            .antMatchers("/login").permitAll()
            .antMatchers("/signup").permitAll()   
//            .antMatchers("/**").hasRole("author")
            .antMatchers("/admin/**").hasRole("admin")
            .anyRequest().authenticated()    
                .and()
            .formLogin().loginPage("/login").failureUrl("/login?error")
            .defaultSuccessUrl("/home").successForwardUrl("/home")
            .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
            .logout().logoutUrl("/logout")
            .logoutSuccessUrl("/login?logout")
                .permitAll();
    }

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

      auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery(
            "select username,password, active from user where username=? AND active = 1")
        .authoritiesByUsernameQuery(
            "select username, role from user  where username=?");
    }
}