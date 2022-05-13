package com.example.security.security_demo_003.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.security.security_demo_003.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MyUserDetailsService userDetailsService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth
                    .userDetailsService(userDetailsService)
                    .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/register_success").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/products").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/very").hasAnyAuthority("USER", "ADMIN")
                //.antMatchers("/addToCart").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/removeFromCart").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/cart").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/checkout").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/checkout/success").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/readuser").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/search").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/details").hasAnyAuthority("USER", "ADMIN")
                .antMatchers("/create").hasAuthority("ADMIN")
                .antMatchers("/update").hasAuthority("ADMIN")
                .antMatchers("/delete").hasAuthority("ADMIN")
                .antMatchers("/edit").hasAuthority("ADMIN")
                .antMatchers("/readadmin").hasAuthority("ADMIN").anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/readuser")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
