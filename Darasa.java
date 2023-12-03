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
public class Darasa {

    private String jinaLaDarasa, category = "ALL";
        
    public Darasa(){
        
    }
    
    public Darasa(String jinaLaDarasa){
        this.jinaLaDarasa = jinaLaDarasa;
    }
    
    /**
     * kupata jina la darasa
     * @return jina la darasa
     */
    public String className(){
        return jinaLaDarasa;
    }

    /**
     * set jina la darasa
     * @param jinaLaDarasa jina la darasa 
     */
    public void className(String jinaLaDarasa){
        this.jinaLaDarasa = jinaLaDarasa;
    }
       
    String getClassFullName() {
        return jinaLaDarasa + category;
    }

    /**
     * kupata category mfano (SCIENCE, ARTS, BUSINESS AGRICULTURE etc)
     * @return category
     */
    String getCategory() {
        return category;
    }

    void setCategory(String category) {
        this.category = category;
    }
}
