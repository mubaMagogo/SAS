/*
 * NAPENDA KUMSHUKURU MWENYEZI MUNGU KWA ZAWAIDI YA UHAI
 * HAKIKA HAPANA MOLA APASAE KUABUDIWA NA KUSUJUDIWA ISIPOKUWA MWENYEZI MUNGU MUUMBA WA VYOTE
 * AKILI, MAARIFA NA VIPAWA VYATOKA KWAKE.
 * 
 * KWA NJIA YOYOTE ILIOPATA CODE HIZI, UNARUHUSIWA KUZITUMIA KWA NJIA YA HALALI
 * USIFUTE MISTARI MITATU YA MWANZO YA KUMTUKUZA MWENYEZI MUNGU
 */
package com.mycompany.sab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Muba
 */
public class Mtu {
    
    // instance variables
    private String jinaLaMwanzo;
    private String jinaLaKati;
    private String jinaLaMwisho;
    private String jinsia;
    private String anuaniYaMakazi;
    private String uraia;
    private String haliYaKiafya;
    private String haliYaUlemavu;
    private String mkoaMakaziYaKudumu;
    private String wilayaMakaziYaKudumu;
    private String makaziYaKudumu;
    private String tareheYaKuzaliwa;
    private String nambaYaChetiChaKuzaliwa;
    private int tareheYaMweziWaKuzaliwa;
    private int mweziWaKuzaliwa;
    private int mwakaWaKuzaliwa;
    private String picha;
    private String nambaYaSimu;
    private String dini;
    private Date tareheKuzaliwa;
    private String nambaYaKitambulisho;
    private String baruaPepe;
        
    
    // constructors  
    public Mtu(){
        
    }
    
    public Mtu(Mtu mtu){
       this.jinaLaMwanzo = mtu.firstName();
       this.jinaLaKati = mtu.middleName();
       this.jinaLaMwisho = mtu.surname();
       this.jinsia = mtu.sex();
       this.anuaniYaMakazi = mtu.physicalAddress();
       this.uraia = mtu.nationality();
       this.makaziYaKudumu = mtu.placeOfDomicile();
       this.tareheYaKuzaliwa = mtu.dateOfBirth();
       this.nambaYaChetiChaKuzaliwa = mtu.birthCertificateNo();
       this.dini = mtu.religion();
       this.nambaYaSimu = mtu.phoneNumber();
       this.picha = mtu.photo();
       setTareheYaKuzaliwa(tareheYaKuzaliwa);
    }
    
    public Mtu(String jinaLaMwanzo, String jinaLaKati, String jinaLaMwisho,
               String jinsia, String uraia, String tareheYaKuzaliwa){
        this.jinaLaMwanzo = jinaLaMwanzo;
        this.jinaLaKati = jinaLaKati;
        this.jinaLaMwisho = jinaLaMwisho;
        this.jinsia = jinsia;
        this.uraia = uraia;
        this.tareheYaKuzaliwa = tareheYaKuzaliwa;
        setTareheYaKuzaliwa(tareheYaKuzaliwa);
        
    }
    
    /***                GETTERS                  ***/
    /**
     * jina la mwanzo
     * @return jina la Mwanzo
     */
    public String firstName(){
        return jinaLaMwanzo;
    }
    
    /**
     * jina la kati
     * @return jina la kati
     */
    public String middleName(){
        return jinaLaKati;
    }
    
    /**
     * jina la mwisho/ukoo
     * @return jina la mwisho/ukoo
     */
    public String surname(){
        return jinaLaMwisho;
    }
    
    /**
     * jinsia
     * @return jinsia 
     */
    public String sex(){
        return jinsia;
    }
    
    /**
     * tarehe mwezi na mwaka wa kuzaliwa
     * @return tarehe mwezi na mwaka wa kuzaliwa
     */
    public String dateOfBirth(){
        return tareheYaKuzaliwa;
    }
    
    /**
    * Namba ya cheti cha kuzaliwa
    * @return 
    */
    public String birthCertificateNo(){
        return nambaYaChetiChaKuzaliwa;
    }
    
    /**
     * namba ya kitambulisho
     * @return namba ya kitambulisho
     */
    public String idNo(){
        return nambaYaKitambulisho;
    }
    
    /**
     * anuani ya makazi
     * @return anuani ya makazi
     */
    public String physicalAddress(){
        return anuaniYaMakazi;
    }
    
    /**
     * mkoa makazi yake ya kudumu yalipo
     * @return Mkoa atokapo
     */
    public String regionalOfDomicile(){
        return mkoaMakaziYaKudumu;
    }
    
    /**
     * wilaya makazi yake ya kudumu yalipo
     * @return wilaya atokapo
     */
    public String districtOfDomicile(){
        return wilayaMakaziYaKudumu;
    }
    
    /**
     * Eneo la makazi ya kudumu atokapo
     * @return makazi atokapo 
     */
    public String placeOfDomicile(){
        return makaziYaKudumu;
    }
    
    /**
     * uraia
     * @return uraia
     */
    public String nationality(){
        return uraia;
    }
    
    /**
     * hali yake kiafya 
     * @return hali ya kiafya
     */
    public String healthStutus(){
        return haliYaKiafya;
    }
    
    /**
     * Hali ya ulemavu
     * @return hali ya ulemavu
     */
    public String disabilitiesStatus(){
        return haliYaUlemavu;
    }
    
    /**
     * namba ya simu
     * @return namba ya simu
     */
    public String phoneNumber(){
        return nambaYaSimu;
    }
    
    /**
     * jina (initial yenye dot)
     * @return jina
     */
    public String name(){
       return jinaLaMwanzo+" "+jinaLaKati.charAt(0)+". "+jinaLaMwisho;
    }
    
    /**
     * jina (initial isio na dot)
     * @return jina
     */
    public String initial(){
        return jinaLaMwanzo+" "+jinaLaKati.charAt(0)+" "+jinaLaMwisho;
    }
    
    /**
     * jina kamili
     * @return jina kamili
     */
    public String fullName(){
        return jinaLaMwanzo+" "+jinaLaKati+" "+jinaLaMwisho;
    }
    
    /**
     * jinsia kwa kifupi (M or F)
     * @return 
     */
    public String sexInitial(){
        return jinsia.charAt(0)+"";
    }
    
    /**
     * tarehe aliozaliwa
     * @return tarehe ya kuzaliwa
     */
    public int dateOfMonthOfBirth(){
        return tareheYaMweziWaKuzaliwa;
    }
    
    /**
     * mwezi aliozaliwa
     * @return mwezi wa kuzaliwa
     */
    public int monthOfBirth(){
        return mweziWaKuzaliwa;
    }
    
    /**
     * mwaka aliozaliwa
     * @return mwaka wa kuzaliwa
     */
    public int yearOfBirth(){
        return mwakaWaKuzaliwa;
    }
    
    /**
     * path/location ya picha
     * @return anuani picha ilipo
     */
    public String photo(){
        return picha;
    }
    
    /**
     * dini (mkristo, mwislam n.k)
     * @return dini
     */
    public String religion(){
        return dini;
    }
      
    /**
     * email
     * @return email
     */
    public String email(){
        return baruaPepe;
    }
    
    /**
     * umri wake
     * @return umri
     */
    public String age(){
        
        String age = "";
        try{
            LocalDate tareheYaLeo = LocalDate.now();
            LocalDate tarehe_Ya_Kuzaliwa = LocalDate.of(mwakaWaKuzaliwa,mweziWaKuzaliwa,tareheYaMweziWaKuzaliwa);
            Period tofauti = Period.between(tarehe_Ya_Kuzaliwa, tareheYaLeo);
            age = tofauti.getYears()+"";
        }
        catch(Exception e){
            
        }       
       return age;
    }
        
    /***                SETTERS                  ***/
    /**
     * set jina la mwanzo
     * @param jinaLaMwanzo jina la mwanzo
     */
    public void firstName(String jinaLaMwanzo){
        this.jinaLaMwanzo = jinaLaMwanzo;
    }
    
    /**
     * set jina la kati
     * @param jinaLaKati jina la kati
     */
    public void middleName(String jinaLaKati){
        this.jinaLaKati = jinaLaKati;
    }
    
    /**
     * set jina la mwisho
     * @param jinaLaMwisho jina la mwisho
     */
    public void surname(String jinaLaMwisho){
        this.jinaLaMwisho = jinaLaMwisho;
    }
    
    /**
     * set majina kupitia jina kamili
     * @param jinaKamili jina kamili
     */
    public void fullName(String jinaKamili){
        String[] majina = jinaKamili.split(" ");
        
        if(majina.length == 3){ // kuhakiki majina
            this.jinaLaMwanzo = majina[0];
            this.jinaLaKati = majina[1];
            this.jinaLaMwisho = majina[2];
        }
    }
    
    /**
     * jinsia
     * @param jinsia jinsia
     */
    public void sex(String jinsia){
        
        if(jinsia.startsWith("M")){
            jinsia = "MALE";
        }
        else{
            jinsia = "FEMALE";
        }
        this.jinsia = jinsia;
    }
    
    /**
     * set anuani ya makazi anakoishi
     * @param anuani anuani ya makazi
     */
    public void physicalAddress(String anuani){
        this.anuaniYaMakazi = anuani;
    }
    
    /**
     * makazi ya kudumu
     * @param makaziYaKudumu 
     */
    public void placeOfDomicile(String makaziYaKudumu){
        this.makaziYaKudumu = makaziYaKudumu;
    }
    
    public void regionalOfDomicile(String mkoaMakaziYaKudumu){
        this.mkoaMakaziYaKudumu = mkoaMakaziYaKudumu;
    }
    
    public void districtOfDomicile(String wilayaMakaziYaKudumu){
        this.wilayaMakaziYaKudumu = wilayaMakaziYaKudumu;
    }
    
    /**
     * uraia
     * @param uraia uraia
     */
    public void nationality(String uraia){
        this.uraia = uraia;
    }
    
    /**
     * set tarehe ya kuzaliwa ktk mfumo wa maneno
     * @param tareheYaKuzaliwa tareheYaKuzaliwa;
     */
    public void dateOfBirth(String tareheYaKuzaliwa){
        setTareheYaKuzaliwa(tareheYaKuzaliwa);
    }

    /**
     * set tarehe ya kuzaliwa 
     * @param tareheYaKuzaliwa tareheYaKuzaliwa;
     */
    public void dateOfBirth(Date tareheYaKuzaliwa){
        setTareheYaKuzaliwa(tareheYaKuzaliwa);
    }
    
    /**
     * Namba ya cheti cha kuzaliwa 
     * @param nambaYaChetiChaKuzaliwa namba ya cheti cha kuzaliwa
     */
    public void birthCertificateNo(String nambaYaChetiChaKuzaliwa){
        this.nambaYaChetiChaKuzaliwa = nambaYaChetiChaKuzaliwa;
    }
    
    /**
     * set tareheYaKuzaliwa kwa kutumia date object
     * @param tareheKuzaliwa tarehe Ya Kuzaliwa
     */
    public void setTareheYaKuzaliwa(Date tareheKuzaliwa){
       this.tareheKuzaliwa = tareheKuzaliwa;
       
       Calendar calenda = Calendar.getInstance();
       calenda.setTime(tareheKuzaliwa);
       
       this.tareheYaMweziWaKuzaliwa = calenda.get(Calendar.DAY_OF_MONTH);
       this.mweziWaKuzaliwa = calenda.get(Calendar.MONTH)+1;
       this.mwakaWaKuzaliwa = calenda.get(Calendar.YEAR);
       this.tareheYaKuzaliwa = tareheYaMweziWaKuzaliwa+"/"+mweziWaKuzaliwa+"/"+mwakaWaKuzaliwa;
    }
    
    /**
     * set tarehe aliozaliwa
     * @param tareheYaMweziWaKuzaliwa tarehe alio zaliwa
     */
    public void dateOfMonthOfBirth(int tareheYaMweziWaKuzaliwa){
        this.tareheYaMweziWaKuzaliwa = tareheYaMweziWaKuzaliwa;
    }
    
    /**
     * set mwezi aliozaliwa
     * @param mweziWaKuzaliwa mwezi alio zaliwa
     */
    public void monthOfBirth(int mweziWaKuzaliwa){
        this.mweziWaKuzaliwa = mweziWaKuzaliwa;
    }
    
    /**
     * set mwaka aliozaliwa
     * @param mwakaWaKuzaliwa mwaka aliozaliwa
     */
    public void yearOfBirth(int mwakaWaKuzaliwa){
        this.mwakaWaKuzaliwa = mwakaWaKuzaliwa;
    }
    
    /**
     * set path/location ya picha yake
     * @param picha location picha ilipo
     */
    public void photo(String picha){
        this.picha = picha;
    }
    
    /**
     * set namba ya simu
     * @param nambaYaSimu namba ya simu
     */
    public void phoneNumber(String nambaYaSimu){
        this.nambaYaSimu = nambaYaSimu;
    }
    
    /**
     * set dini yake
     * @param dini dini
     */
    public void religion(String dini){
        this.dini = dini;
    }
    
    /**
     * hali ya kiafya (mlemavu wa akili, ngozi, viungo n.k)
     * @param haliYaKiafya hali ya afya
     */
    public void healthStutus(String haliYaKiafya){
        this.haliYaKiafya = haliYaKiafya;
    }
    
    public void disabilityStatus(String haliYaUlemavu){
        this.haliYaUlemavu = haliYaUlemavu;
    }
    
    /**
     * namba ya kitambulisho
     * @param idNo namba ya kitambulisho
     */
    public void idNo(String idNo){
        this.nambaYaKitambulisho = idNo;
    }
    
    /**
     * email
     * @param email email
     */
    public void email(String email){
        this.baruaPepe = email;
    }
    
    /**
     * Set tarehe ya kuzaliwa kutoka ktk tarehe yenye mfumo wa maneno
     * @param tareheYaKuzaliwa tarehe ya mfumo wa maneno
     */
    private void setTareheYaKuzaliwa(String tareheYaKuzaliwa){
        SimpleDateFormat format;
        
        if(tareheYaKuzaliwa.contains("/")){
            format = new SimpleDateFormat("dd/MM/yyyy"); 
        }
        else if(tareheYaKuzaliwa.contains("-")){
            format = new SimpleDateFormat("dd-MMM-yyyy"); 
        }
        else if(tareheYaKuzaliwa.contains(",")){
            format = new SimpleDateFormat("MMM dd, yyyy"); 
        }
        else{
            format = new SimpleDateFormat("dd MMM yyyy"); 
        }
        
        try {            
            this.tareheKuzaliwa = format.parse(tareheYaKuzaliwa);
            
            Calendar kalenda = Calendar.getInstance();
            kalenda.setTime(tareheKuzaliwa);
            
            this.tareheYaKuzaliwa = tareheYaKuzaliwa;
            this.mwakaWaKuzaliwa = kalenda.get(Calendar.YEAR);
            this.mweziWaKuzaliwa = 1+kalenda.get(Calendar.MONTH);
            this.tareheYaMweziWaKuzaliwa = kalenda.get(Calendar.DAY_OF_MONTH); 
        }
        catch(ParseException ex) {
                
        }
    }
}
