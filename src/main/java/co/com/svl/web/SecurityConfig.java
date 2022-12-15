package co.com.svl.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Juan Turriago
 */
@Slf4j
@Configuration
@EnableWebSecurity //habilitamos la seguridad 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//extiende de WebSecurityConfigurerAdapter para poder personalizar los usuarios 
//que pueden acceder a la aplicacion

    //inyectamos la interface UserDetailsService, que la implementamos en usuarioservice
    @Autowired
    private UserDetailsService userDetailsService; 

    /**
     * @author Juan Turriago
     * @return BCryptPasswordEncoder
     */
    public BCryptPasswordEncoder passwordEncoder() { //definimos este metodo
        //para que spring pueda usar esta encriptacion. por lo tanto estara en 
        //el contenedor de spring al implementarlo como un bean
        return new BCryptPasswordEncoder();
    }

    /**
     * @author Juan Turriago
     * @param build
     * @throws Exception
     */
    @Autowired //inyectamos este metodo lo que realizara de manera automatica del obj build de la clase AuthenticationManagerBuilder(ya esta definido en la fabrica de spring)
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        //buscara una implementacion de userDetailsService
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());  //establecemos el usuario al poner build.usuario.tipodeencriptacion        
    }

    /**
     * @author Juan Turriago
     * @param http
     * @throws Exception
     */
    @Override//este concepto se le conoce como autorizacion: aqui se le restringe dependidendo de la configuracion accesos a funcionalidades del sistema o paginas de la misma
    protected void configure(HttpSecurity http) throws Exception { //este metodo permite restringir algunas funcionalidades del sistema
        http.authorizeRequests()
                .antMatchers("/consultas", "/reportes")
                .hasRole("ADMIN")
                .antMatchers("/", "/configuracion", "/ventas", "/inventario")
                .hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin() //con esto indicamos que login vamos a usar e indicamos la vista con su path la cual sera el login que haremos
                .loginPage("/login").failureUrl("/login?error=true")//si al hacer login surge un error con failurl redirige a una pag de error en este caso pasaremos un parametro para mostrar una alerta
                .and()
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
