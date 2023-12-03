/*
 * NAPENDA KUMSHUKURU MWENYEZI MUNGU KWA ZAWAIDI YA UHAI
 * HAKIKA HAPANA MOLA APASAE KUABUDIWA NA KUSUJUDIWA ISIPOKUWA MWENYEZI MUNGU MUUMBA WA VYOTE
 * AKILI, MAARIFA NA VIPAWA VYATOKA KWAKE.
 * 
 * KWA NJIA YOYOTE ILIOPATA CODE HIZI, UNARUHUSIWA KUZITUMIA KWA NJIA YA HALALI
 * USIFUTE MISTARI MITATU YA MWANZO YA KUMTUKUZA MWENYEZI MUNGU
 */
package com.mycompany.sab;

import static com.mycompany.sab.Shule.shule;

/**
 *
 * @author Muba
 */
public class Badili {

    /**
     * kubadili namba ya kirumi kuwa ktk namba za kawaida
     * pre-condition namba ya kirumi iwe kuanzia I mpaka VII
     * @param nambaYaKirumi namba ya kirumi
     * @return namba ya kawaida
     */
    static int ktkNambaZaKawaida(String nambaYaKirumi) {
        int nambaYaKawaida = 0;

        for(int i = 1; i <= 7; i++){
             if(ktkNambaZaKirumi(i).equals(nambaYaKirumi)){
                nambaYaKawaida = i;
             }
        }
       
       return nambaYaKawaida;   
    }
    
    /**
     * kubadili namba ya kawaida kuwa ya kirumi
     * @param nambaYaKawaida namba ya kawaida
     * @return namba ya kirumi
     */
    static String ktkNambaZaKirumi(int nambaYaKawaida) {
        
        String[] nambaZaKirumi = {"I","II","III","IV","V","VI","VII"};
        
        if(nambaYaKawaida > 0 && nambaYaKawaida <= nambaZaKirumi.length){
            return nambaZaKirumi[nambaYaKawaida -1];
        }
        else{
            return "I";
        }
    }
    
    /**
     * kubadili namba ya kawaida kuwa jina la darasa (mfano 2 kuwa form II, au standard II)
     * @param namba namba ya kawaida
     * @return jina la darasa
     */
    static String kuwaDarasa(int namba){
        if(shule.schoolLevel().startsWith("P")){ 
            return "STANDARD "+Badili.ktkNambaZaKirumi(namba);
        }
        else{
            return "FORM "+Badili.ktkNambaZaKirumi(namba);
        }
    }    

    /**
     * kubadili jina la darasa kuwa namba ya kawaida(mfano form II kuwa 2, au standard II kuwa 7)
     * @param jinaLaDarasa Jina la darasa
     * @return namba inayowakilisha darasa
     */
    static int kuwaNamba(String jinaLaDarasa){
        if(shule.schoolLevel().startsWith("P")){ 
            jinaLaDarasa = jinaLaDarasa.replace("STANDARD ", "");
        }
        else{
            jinaLaDarasa = jinaLaDarasa.replace("FORM ", "");
        }
        
        return Badili.ktkNambaZaKawaida(jinaLaDarasa);
    }
    
    /**
     * kubadili namba kuwa ktk tarakimu nne
     * @param namba namba ktk tarakimu chini ya nne
     * @return namba ktk tarakimu nne
     */
    static String ktkTarakimuNne(int namba) {
        if(namba < 10){
            return "000"+namba;
        }
        else if(namba > 9 && namba < 100){
            return "00"+namba;
        }
        else if(namba < 1000 && namba > 99){
            return "0"+namba;
        }
        else{
            return namba+"";
        }
    }
}
