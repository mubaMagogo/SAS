/*
 * NAPENDA KUMSHUKURU MWENYEZI MUNGU KWA ZAWAIDI YA UHAI
 * HAKIKA HAPANA MOLA APASAE KUABUDIWA NA KUSUJUDIWA ISIPOKUWA MWENYEZI MUNGU MUUMBA WA VYOTE
 * AKILI, MAARIFA NA VIPAWA VYATOKA KWAKE.
 * 
 * KWA NJIA YOYOTE ILIOPATA CODE HIZI, UNARUHUSIWA KUZITUMIA KWA NJIA YA HALALI
 * USIFUTE MISTARI MITATU YA MWANZO YA KUMTUKUZA MWENYEZI MUNGU
 */
package com.mycompany.sab;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Muba
 */
public class Systm {
    private final String date; 
    
    public Systm(){
       this.date = LocalDate.now().format(DateTimeFormatter.ofPattern("d MMM, uuuu"));
    }
    
    /**
     * mwaka kama inavyosomeka ktk kalenda ya computer yako
     * @return mwaka
     */
    public String systemYear(){
        return date.split(" ")[2];
    }
    
    /**
     * mwezi kama unavyosomeka ktk computer yako (1 - 12)
     * @return mwezi
     */
    public int systemMonth(){
        return LocalDate.now().getMonthValue();
    }
    
    /**
     * kupata tarehe kama inavyosomeka ktk computer yako (1 - 31)
     * @return 
     */
    public int systemDay(){
        return Integer.valueOf(date.split(" ")[0]);
    }
    
    /**
     * kupata mwezi kama unavyosomeka ktk computer yako (Jan, Mar etc)
     * @return 
     */
    public String systemMonthText(){
       return date.split(" ")[1].toUpperCase();
    }
    
    public String systemDate(){
        return date;
    }
}
