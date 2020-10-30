package org.daxue.config;

import org.daxue.service.core.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public WebSecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    private CustomUserDetailsService userDetailsService;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/test/**")
                .antMatchers("/views/**", "/images/**", "/css/**", "/js/**")
                .antMatchers("/open/**");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()    // 如果有允许匿名的url，填在下面
            .anyRequest().authenticated()   // .antMatchers().permitAll()
            .and()
            .formLogin()
            .loginPage("/login")  // 设置登陆页
            .defaultSuccessUrl("/").permitAll()   // 设置登陆成功页
            .and()                     // 自定义登陆用户名和密码参数，默认为username和password
                                       // .usernameParameter("username")
                                      // .passwordParameter("password")
            .logout().permitAll();

        // 关闭CSRF跨域
        http.csrf().disable();
    }
//
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();

            }

            @Override
            public boolean matches(final CharSequence charSequence, final String s) {
                return s.equals(charSequence.toString());
            }

        });


//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
    }
//

}
