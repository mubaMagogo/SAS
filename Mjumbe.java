/*
 * NAPENDA KUMSHUKURU MWENYEZI MUNGU KWA ZAWAIDI YA UHAI
 * HAKIKA HAPANA MOLA APASAE KUABUDIWA NA KUSUJUDIWA ISIPOKUWA MWENYEZI MUNGU MUUMBA WA VYOTE
 * AKILI, MAARIFA NA VIPAWA VYATOKA KWAKE.
 * 
 * KWA NJIA YOYOTE ILIOPATA CODE HIZI, UNARUHUSIWA KUZITUMIA KWA NJIA YA HALALI
 * USIFUTE MISTARI MITATU YA MWANZO YA KUMTUKUZA MWENYEZI MUNGU
 */
package com.mycompany.sab;

import javax.swing.JOptionPane;
import org.apache.logging.log4j.*;


/**
 *
 * @author Muba
 */
class Mjumbe {
    private static Logger logger;
    
    public Mjumbe(){
        logger = LogManager.getLogger("Login");
    }
    /**
     * kuonesha ujumbe
     * @param ujumbe maelezo ya kuuonesha 
     */
    static void oneshaUjumbe(String ujumbe) {
        JOptionPane.showMessageDialog(null,ujumbe);
    }

    /**
     * kuuliza swali
     * @param swali swali
     * @return namba ya jibu lilio jibiwa
     */
    static int ulizaSwali(String swali) {
        return JOptionPane.showConfirmDialog(null,swali);
    }
    
    /**
     * ku log ujumbe ktk file
     * @param ujumbe ujumbe husika
     */
    static void log(Exception e, String ujumbe){
        e.printStackTrace();
    }
}
