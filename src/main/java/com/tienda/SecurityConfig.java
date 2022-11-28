package com.tienda;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    //Metodo para autenticar usuario
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("Juan")
                .password("{noop}123")
                .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("Rebeca")
                .password("{noop}456")
                .roles("VENDEDOR","USER")
                .and()
                .withUser("Pedro")
                .password("{noop}789")
                .roles("USER");
        
    }
    //Metodo para autorizar el acceso o permisos a los usuario
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/articulo/nuevo", "/articulo/guardar", "/articulo/modificar**", "/articulo/eliminar/**",
                            "/categoria/nuevo", "/categoria/guardar", "/categoria/modificar**", "/categoria/eliminar/**",
                            "/cliente/nuevo", "/cliente/guardar", "/cliente/modificar**", "/cliente/eliminar/**",
                            "/usuario/nuevo", "/usuario/guardar", "/usuario/modificar**", "/usuario/eliminar/**")
                .hasAnyRole("ADMIN")
                .antMatchers("/articulo/listado", "/categoria/listado", "/cliente/listado")
                .hasAnyRole("ADMIN", "VENDEDOR")
                .antMatchers("/")
                .hasAnyRole("ADMIN", "VENDEDOR", "USER")
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
                
                
                
    }
    
}
