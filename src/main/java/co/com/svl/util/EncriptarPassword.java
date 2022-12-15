package co.com.svl.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Juan Turriago
 */
public class EncriptarPassword {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        var p1 = "123";
        var p2 = "123";
        var pBC = encriptarPassword(p1);
        var p2BC = encriptarPassword(p2);

        System.out.println("password1: " + p1 + "hashCode= "+p1.hashCode());
        System.out.println("password2: " + p2 + "hashCode= "+p2.hashCode());
        System.out.println("password encriptado : "+p2BC);
        
//        System.out.println("password1 encriptado:" + pBC + "hashCode= "+pBC.hashCode());
//        System.out.println("password2 encriptado:" + p2BC + "hashCode= "+p2BC.hashCode());
//        

//        if (pBC.hashCode() == p1.hashCode()) {
//
//            System.out.println("es igual");
////        }
//        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
//        System.out.println(b.matches(p1,pBC));
    }

    /**
     *
     * @param password
     * @return
     */
    public static String encriptarPassword(String password) {//encriptar password mediante spring
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
