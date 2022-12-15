package co.com.svl.controlador;

import co.com.svl.modelo.*;
import co.com.svl.servicio.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author JHOJAN L
 */
@Slf4j
@Controller
public class ControladorInicio {

    @Autowired
    private AdministradorService administradorService;
    @Autowired
    private EmpleadoService empleadoService;

    /**
     * @author JHOJAN L
     * @param model
     * @param user
     * @return index
     */
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) { //@AuthenticationPrincipal User user){// @AuthenticationPrincipal User user CON ESTO PODEMOS CAPTURAR EL USUSARIO QUE HIZO LOGIN

        if (user.getAuthorities().toString().equals("[ROLE_ADMIN]")) {
            var usuario = (Administrador) obtenerDatosUsuario(user.getAuthorities().toString(), user.getUsername());
            model.addAttribute("usuario", usuario);

        } else {
            var usuario = (Empleado) obtenerDatosUsuario(user.getAuthorities().toString(), user.getUsername());
            model.addAttribute("usuario", usuario);

        }

        return "index";
    }

    /**
     * @author JHOJAN L
     * @param user
     * @param model
     * @return configuracion
     */
    @GetMapping("/configuracion")
    public String configuracion(@AuthenticationPrincipal User user, Model model) {

        var usuario = obtenerDatosUsuario(user.getAuthorities().toString(), user.getUsername());
        model.addAttribute("usuario", usuario);

        return "configuracion";
    }

    /**
     * @author JHOJAN L
     * @param user
     * @param administrador
     * @param empleado
     * @return
     */
    @PostMapping("/modificarDatosPersonales")
    public String modificarDatosPersonales(@AuthenticationPrincipal User user,
            Administrador administrador, Empleado empleado) {

        actualizarDatos(user.getAuthorities().toString(), administrador, empleado);
        return "redirect:/configuracion?exito1=true";
    }

    /**
     * @author JHOJAN L
     * @param user
     * @param administrador
     * @param empleado
     * @param contrasenaActual
     * @param contrasenaNueva
     * @param contrasenaConfirmacion
     * @return
     */
    @PostMapping("/modificarContrasena")
    public String modificarContrasena(@AuthenticationPrincipal User user,
            Administrador administrador, Empleado empleado,
            @Param("contrasenaActual") String contrasenaActual,
            @Param("contrasenaNueva") String contrasenaNueva,
            @Param("contrasenaConfirmacion") String contrasenaConfirmacion) {

        if (user.getAuthorities().toString().equals("[ROLE_ADMIN]")) {

            var validacion = compararContrasenaAdmin(administrador, contrasenaActual,
                    contrasenaNueva, contrasenaConfirmacion);

            if (validacion == 1) {

                return "redirect:/configuracion?error1=true";

            } else if (validacion == 2) {

                return "redirect:/configuracion?error2=true";
            }

        } else {
            var validacion = compararContrasenaEmpleado(empleado, contrasenaActual,
                    contrasenaNueva, contrasenaConfirmacion);

            if (validacion == 1) {

                return "redirect:/configuracion?error1=true";

            } else if (validacion == 2) {

                return "redirect:/configuracion?error2=true";
            }

        }

        return "redirect:/configuracion?exito2=true";
    }

    /**
     * @author JHOJAN L
     * @param rol
     * @param administrador
     * @param empleado
     */
    public void actualizarDatos(String rol, Administrador administrador, Empleado empleado) {

        if (rol.equals("[ROLE_ADMIN]")) {

            administradorService.guardar(administrador);

        } else {
            empleadoService.guardar(empleado);
        }

    }

    /**
     * @author JHOJAN L
     * @param rol
     * @param correo
     * @return empleadoService.encontrarEmpleadoPorCorreo(correo)
     */
    public Object obtenerDatosUsuario(String rol, String correo) {//obtengo todos los datos del usuario logeado

        if (rol.equals("[ROLE_ADMIN]")) {
            return administradorService.encontrarAdministradorPorCorreo(correo);

        } else {
            return empleadoService.encontrarEmpleadoPorCorreo(correo);
        }

    }

    private short compararContrasenaAdmin(Administrador administrador, String contrasenaActual, String contrasenaNueva, String contrasenaConfirmacion) {
        var b = new BCryptPasswordEncoder();

        if (b.matches(contrasenaActual, administrador.getContrasena())) {

            if (contrasenaNueva.equals(contrasenaConfirmacion)) {

                administrador.setContrasena(b.encode(contrasenaNueva));
                administradorService.guardar(administrador);

            } else {

                return 2;
            }

        } else {

            return 1;
        }

        return 0;
    }

    private short compararContrasenaEmpleado(Empleado empleado, String contrasenaActual, String contrasenaNueva, String contrasenaConfirmacion) {
        var b = new BCryptPasswordEncoder();

        if (b.matches(contrasenaActual, empleado.getContrasena())) {

            if (contrasenaNueva.equals(contrasenaConfirmacion)) {

                empleado.setContrasena(b.encode(contrasenaNueva));
                empleadoService.guardar(empleado);

            } else {

                return 2;
            }

        } else {

            return 1;
        }

        return 0;
    }

}
