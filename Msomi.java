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
public class Msomi {

    static String somaExtension(String jinaLaFile) {
        String extension = "";
        if(jinaLaFile != null){
            extension = jinaLaFile.substring(jinaLaFile.lastIndexOf(".")+1);
        }
        if(extension.contains("$")){
            extension = extension.substring(extension.lastIndexOf("$")+1);
        }
        return extension;
    }
    
}
