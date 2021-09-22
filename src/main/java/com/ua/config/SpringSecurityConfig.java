package com.ua.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UserDetailsService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Resource
    private UserDetailsService userDetailsService;
	
//	@Autowired
//    private AuthenticationProvider authenticationProvider;
//
//
//    
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
//        builder.authenticationProvider(authenticationProvider);
//    }
//	@Bean
//	@Override
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}
//	@Bean
//	public UserDetailsService userDetailsServiceBean() throws Exception {
//	    return super.userDetailsServiceBean();
//	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().usernameParameter("email").passwordParameter("password").loginPage("/login").successHandler(new CustomAuthenticationSuccessHandler()).failureUrl("/login?fail=true")
		.and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
		.deleteCookies("JSESSIONSID", "RememberMeCookie").invalidateHttpSession(true)
		.and()
		.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasAnyRole("ADMIN","USER").anyRequest().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/").
		and().sessionManagement().maximumSessions(1)
		.and().and()
		.rememberMe().rememberMeParameter("rememberme").key("secret key").rememberMeCookieName("RememberMeCookie")
		.tokenValiditySeconds(365*24*60*60);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web.ignoring().antMatchers("/resources/**");
	}
	

	
//	@Bean 
//	@Override
//	public UserDetailsService userDetailsService() {
//	    return username -> {
//	        throw new UnsupportedOperationException("unsupported");
//	    };
//	}

}
