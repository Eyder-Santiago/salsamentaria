package co.com.svl.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Juan Turriago
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

    /**
     * @author Juan Turriago
     * @param registro
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registro){//indicamos la vista por default
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login"); //mapeamos la vista login para que se pueda acceder sin pasar por ningun controlador
        registro.addViewController("/errores/403").setViewName("/errores/403");
    }
}
