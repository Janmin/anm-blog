package cc.anmink.config;

import cc.anmink.security.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by xiezijian on 2017/3/10.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //注册CustomUserService的Bean
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //添加自定义的user detail service认证
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/img/**","/api/**", "/font-awesome/**","/home/**","/admin/**").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()//其余请求需认证才可访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/home", true)
                .permitAll()//登录页面可任意访问
                .and()
                .logout()
                .permitAll();
    }

}
