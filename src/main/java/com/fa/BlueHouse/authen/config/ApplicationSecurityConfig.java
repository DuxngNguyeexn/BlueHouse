package com.fa.BlueHouse.authen.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.fa.BlueHouse.authen.control.ApplicationUserService;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity()
public class ApplicationSecurityConfig {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ApplicationUserService applicationUserService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((auth) -> auth
						.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
						.requestMatchers("/login", "/forgot/**", "/common/**", "/lib/**").permitAll()
						.requestMatchers("/employee/**").hasAnyRole(UserRole.EMPLOYEE.name(), UserRole.MANAGE.name(), UserRole.ADMIN.name())
						.requestMatchers("/event/**").hasRole(UserRole.ADMIN.name())
				        .requestMatchers("/Apartment/**").hasAnyRole(UserRole.ADMIN.name(), UserRole.RESIDENT.name(), UserRole.EMPLOYEE.name())
						.anyRequest().authenticated())

				.formLogin(form -> form
						.loginPage("/login")
						.usernameParameter("username")
						.passwordParameter("password")
						.defaultSuccessUrl("/")
						.permitAll())

				.rememberMe(rember -> rember
						.rememberMeParameter("remember-me")
						.tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(10))
						.key("@BlueH0use"))

				.logout(logout -> logout
						.logoutUrl("/logout")
						.clearAuthentication(true)
						.invalidateHttpSession(true)
						.deleteCookies("JSESSIONID", "remember-me")
						.logoutSuccessUrl("/login"));
		return http.build();
	}

	@Bean
	public ProviderManager authManagerBean(AuthenticationProvider provider) {
		return new ProviderManager(provider);
	}

	@Bean
	public AuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(applicationUserService);

		return provider;
	}
}
