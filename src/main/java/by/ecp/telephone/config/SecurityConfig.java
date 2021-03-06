package by.ecp.telephone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpEncodingProperties;
import org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        CharacterEncodingFilter filter = new CharacterEncodingFilter();
//        filter.setEncoding("UTF-8");
//        filter.setForceEncoding(true);
//        http.addFilterBefore(filter, CsrfFilter.class);
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/webjars/**").permitAll()
                .antMatchers("/resources/**", "/adminEdit/**", "/handbooks/**", "/webjars/**").hasAnyRole("ADMIN")
                .antMatchers("/resources/**", "/login", "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/adminEdit", true)
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
        web.ignoring().antMatchers("/webjars/**");
        web.ignoring().antMatchers("/bootstrap/**");
        web.ignoring().antMatchers("/3.3.7-1/**");
        web.ignoring().antMatchers("/css/**");
        web.ignoring().antMatchers("/js/**");

    }
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password("user").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("qwerty").roles("ADMIN").build());
        manager.createUser(User.withUsername("administrator").password("qwerty").roles("ADMIN").build());
        manager.createUser(User.withUsername("vinty@i.ua").password("1").roles("ADMIN").build());
        manager.createUser(User.withUsername("lkghost").password("1").roles("ADMIN").build());
        return manager;
    }

}
