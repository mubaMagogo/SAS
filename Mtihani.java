/*
 * NAPENDA KUMSHUKURU MWENYEZI MUNGU KWA ZAWAIDI YA UHAI
 * HAKIKA HAPANA MOLA APASAE KUABUDIWA NA KUSUJUDIWA ISIPOKUWA MWENYEZI MUNGU MUUMBA WA VYOTE
 * AKILI, MAARIFA NA VIPAWA VYATOKA KWAKE.
 * 
 * KWA NJIA YOYOTE ILIOPATA CODE HIZI, UNARUHUSIWA KUZITUMIA KWA NJIA YA HALALI
 * USIFUTE MISTARI MITATU YA MWANZO YA KUMTUKUZA MWENYEZI MUNGU
 */
package com.mycompany.sab;

import java.util.TreeMap;

/**
 *
 * @author Muba
 */
public class Mtihani {

    private String examName;
    private String subject;
    private Integer examYear;
    private String term;
    public Mtihani(){
        
    }

    public String examFullName() {
        return getExamTitle()+"_"+getSubjectTitle();
    }
    
    public void examName(String examName){
        this.examName = examName;
    }

    public String subject() {
        return subject;
    }
    
    public void subject(String subject) {
        this.subject = subject;
    }

    public Integer examYear(){
        return examYear;
    }
    
    public void examYear(Integer examYear) {
        this.examYear = examYear;
    }
    
    public String term(){
        return term;
    }
    
    public void term(String term){
        this.term = term;
    }
    
    String getExamTitle() {
        return examName+"_"+term+"_"+examYear;
    }
     
    String getSubjectTitle(){
        return subject.replace(" ","_");
    }
    
    public String examName(){
        return examName;
    }

    void insertAlama(TreeMap alamaZaWote) {
        alamaZaWote.putAll(alamaZaWote);
        new Kanzidata().ingizaAlama(alamaZaWote, this);
    }

    void setSubjectTitle(String subjectTitle) {
        this.subject = subjectTitle.replace("_", " ");
    }

    
}
