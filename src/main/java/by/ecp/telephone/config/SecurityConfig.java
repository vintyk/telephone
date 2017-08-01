package by.ecp.telephone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/login", "/").permitAll()
                .antMatchers("/adminEdit/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
        ;
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        //Web resources
        web.ignoring().antMatchers("/resources/**");
        web.ignoring().antMatchers("/static/css/**");
        web.ignoring().antMatchers("/static/js/**");
        web.ignoring().antMatchers("/static/pic/**");
    }
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("1").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("qwerty").roles("ADMIN").build());
        manager.createUser(User.withUsername("vinty@i.ua").password("1").roles("ADMIN").build());
        return manager;
    }
}
