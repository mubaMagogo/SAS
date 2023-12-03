/*
 * NAPENDA KUMSHUKURU MWENYEZI MUNGU KWA ZAWAIDI YA UHAI
 * HAKIKA HAPANA MOLA APASAE KUABUDIWA NA KUSUJUDIWA ISIPOKUWA MWENYEZI MUNGU MUUMBA WA VYOTE
 * AKILI, MAARIFA NA VIPAWA VYATOKA KWAKE.
 * 
 * KWA NJIA YOYOTE ILIOPATA CODE HIZI, UNARUHUSIWA KUZITUMIA KWA NJIA YA HALALI
 * USIFUTE MISTARI MITATU YA MWANZO YA KUMTUKUZA MWENYEZI MUNGU
 */
package com.mycompany.sab;

/**
 *
 * @author Muba
 */
public class Kama {
    
    /**
     * kuthibitisha kama class ina jina la method tajwa
     * @param obj
     * @param jinaLaMethod jina la method
     * @param neno neno litupalo jina la method
     * @return true au false
     */
    public static boolean linahusu(Object obj, String jinaLaMethod){                     
        try{
            return Manuva.getMajinaYaMethods(obj).contains(jinaLaMethod);
        }
        catch(Exception e){
             return false;
        }               
    }
    
    public static boolean linahusuSuper(Object obj, String jinaLaMethod){
        try{
            return Manuva.getMajinaYaMethods(obj.getClass().getSuperclass().newInstance()).contains(jinaLaMethod);
        }
        catch(Exception e){
             return false;
        }     
    }
    
}
