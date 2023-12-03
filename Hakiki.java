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
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @since jdk 1.8
 * @author tekTz101
 * @version 1.0.0
 */
public class Hakiki {
    
    public static String firstName(String firstName){
        
        if(firstName.isEmpty()){
            Mjumbe.oneshaUjumbe("First name not valid");
            return null;
        }
        else{
           return firstName; 
        }
       
    }
    
    public static boolean kamaTaarifaZimejazwa(Object ... txt){
        boolean jibu = true;
        
        for(Object str : txt){
            if(str == null || str.toString().isEmpty()){
                return false;
            }
        }        
        return jibu;
    }
    
    public static String middleName(String middleName){
        
        if(middleName.isEmpty()){
           Mjumbe.oneshaUjumbe("Middle name not valid");
            return null;
        }
        else{
           return middleName; 
        }
       
    }
    
    public static String surname(String surname){
        if(surname.isEmpty()){
           Mjumbe.oneshaUjumbe("Surname not valid");
            return null;
        }
        else{
           return surname; 
        }
    }
    
    public static String sex(String sex){
        if(sex.isEmpty()){
           Mjumbe.oneshaUjumbe("sex not valid");
           return null;
        }
        else{
           return sex; 
        }
        
    }
    
    public static String nationality(String nationality){
        if(nationality.isEmpty()){
           Mjumbe.oneshaUjumbe("Nationality not valid");
           return null;
        }
        else{
           return nationality; 
        }
    }
    
    public static String address(String address){
        if(address.isEmpty()){
           Mjumbe.oneshaUjumbe("Address not valid");
           return null;
        }
        else{
           return address; 
        }
    }
    
    public static String email(String email){
        if(email.isEmpty()){
           Mjumbe.oneshaUjumbe("Email not valid");
           return null;
        }
        else{
           return email; 
        }
    }
    /**
     * Kuhakiki tarehe ya kuzaliwa 
     * vigezo kuanzia miaka 4 mpaka 65 (chekechea mpaka ku staafu)
     * @param tareheYaKuzaliwa tarehe ya kuzaliwa
     * @return empty string or error message
     */
    public static String dateOfBirth(String tareheYaKuzaliwa){
        
        if(tareheYaKuzaliwa == null){
            Mjumbe.oneshaUjumbe("Bate of birth not valid null");
            return null;
        }
        else{
            SimpleDateFormat format;
            if(tareheYaKuzaliwa.contains("/")){
                format = new SimpleDateFormat("dd/MM/yyyy"); 
            }
            else if(tareheYaKuzaliwa.contains("-")){
                format = new SimpleDateFormat("dd-MMM-yyyy"); 
            }
            else{
                format = new SimpleDateFormat("dd MMM yyyy"); 
            }

            try {      
                Calendar calenda = Calendar.getInstance();
                calenda.setTime(format.parse(tareheYaKuzaliwa));
                int tareheYaMweziWaKuzaliwa = calenda.get(Calendar.DAY_OF_MONTH);
                int mweziWaKuzaliwa = calenda.get(Calendar.MONTH)+1;
                int mwakaWaKuzaliwa = calenda.get(Calendar.YEAR);

                LocalDate tareheYaLeo = LocalDate.now();
                LocalDate tarehe_Ya_Kuzaliwa = LocalDate.of(mwakaWaKuzaliwa,mweziWaKuzaliwa,tareheYaMweziWaKuzaliwa);
                Period tofauti = Period.between(tarehe_Ya_Kuzaliwa, tareheYaLeo);

                if((tofauti.getYears() < 5) || (tofauti.getYears() > 65)){
                    Mjumbe.oneshaUjumbe("Date of birth not valid");
                    tareheYaKuzaliwa = null;
                }            
            }
            catch(Exception e){
                Mjumbe.oneshaUjumbe("Date of birth not valid");
                tareheYaKuzaliwa = null;
            }
            return tareheYaKuzaliwa;
        }
    }
    
    public static String dateOfMonthOfBirth(Integer tarehe){
        String jibu = "";
        
        if(!(tarehe > 0 && tarehe < 32)){
            jibu = "Date of moth cannot be "+tarehe;
        }
       return jibu;  
    }
    
    public static String monthOfBirth(Integer mwezi){
        String jibu = "";
        
        if(!(mwezi > 0 && mwezi < 13)){
            jibu = "Month cannot be "+ mwezi;
        }
        return jibu;
    }
   
    public static String yearOfBirth(Integer mwaka){
        String jibu = "";
        
        if(mwaka > LocalDate.now().getYear()){
            jibu = "Year of birth cannot be "+mwaka;
        }
      
       return jibu;
    }
    
    public static String phoneNumber(String nambaSimu){
        boolean jibu = true;
        
        for(int i = 0; i < nambaSimu.length(); i++){
            if(!Character.isDigit(nambaSimu.charAt(i)) || nambaSimu.length() != 10){
                Mjumbe.oneshaUjumbe("Phone number not valid");
                jibu = false;
                break;
            }
        }
        
        if(jibu){
            return nambaSimu;
        }
        else{
            return null;
        }
    }
    
    public static String religion(String dini){
        String jibu = "";
        
        if(dini.isEmpty()){
            jibu = "Religion cannot be empty";
        }
        return jibu;
    }
    
    /**
     * hakiki kama admission number teari inatumiwa na mwfnz mwengine
     * @param admNo admission number
     * @return ndio au hapana
     */
    public static String admissionNo(String admNo){
        if(!admNo.isEmpty()){
            
            if(shule.getWanafunzi().keySet().contains(admNo)){
                Mjumbe.oneshaUjumbe("Admission number already exist");
                return null;
            }
            else{
                return admNo;
            }
        }
        
        else{
            Mjumbe.oneshaUjumbe("Admission number cannot be empty");
            return null;
        }        
    }
    
    public static String stream(String stream){
        String jibu = "";
        
        if(stream.toCharArray().length > 0){
            int x = stream.toCharArray()[0];
            if(!(x >= 65 && x <= 85)){
               jibu = "Stream "+"("+stream +")"+" is not valid";
            }
        }
                
        return jibu;
    }
    
    public static String yearAdmitted(Integer year){
        String jibu = "";
        
        if(year > LocalDate.now().getYear()){
            jibu = "Year admitted ahead of System clock";
        }
        else if(year < LocalDate.now().getYear() - 7){
            jibu = "Year admitted("+year+")"+" not valid";
        }
        
        return jibu;
    }
    
    public static String premNo(String premNo){
        if(premNo.isEmpty()){
            Mjumbe.oneshaUjumbe("Prem number not valid");
            return null;
        }
        else if(shule.getWanafunzi().keySet().contains(premNo)){
            Mjumbe.oneshaUjumbe("Prem number already exist");
            return null;
        }
        else{
            return premNo;
        }
    }
    
    public static String classAdmitted(String darasa){
        String jibu = "";
        
        try{
            String jina = darasa.split(" ")[0];
            int x = Badili.ktkNambaZaKawaida(darasa.split(" ")[1]);
            
            if(!((jina.equals("STANDARD")||jina.equals("FORM")) && (x > 0 && x <= 7))){
                jibu = "Class admitted "+"("+darasa+")"+" not valid";
            }
        }
        catch(Exception e){
            jibu = "Class admitted "+"("+darasa+")"+" not valid";
        }
        return jibu;
    }
    
   
    /**
     * kuhakiki kama file ni picha
     * @param file file unalotaka kuhakiki
     * @return ndio au hapana
     */
    public static String picha(File file){
        String jibu = "";
        
        if(file != null){
            String extension = Msomi.somaExtension(file.getName());
        
            if((extension.equalsIgnoreCase("jpg"))){
                jibu = "Sorry Select jpg file";
            }
        }
        else{
            jibu = "There is no image to set";
        }
        return jibu;
    }
    
    /**
     * hakiki kama tarehe ipo sawa
     * @param tarehe tarehe (mfano 22/11/2020)
     * @return ipo sau au la
     */
    public static boolean tarehe(String tarehe){
        SimpleDateFormat format; 
        boolean jibu = false;
        
        if(tarehe.contains("/")){
            format = new SimpleDateFormat("dd/MM/yyyy"); 
        }
        else if(tarehe.contains("-")){
            format = new SimpleDateFormat("dd-MMM-yyyy"); 
        }
        else{
            format = new SimpleDateFormat("dd MMM yyyy"); 
        }
        
        try{
            Date date = format.parse(tarehe);
            
            jibu = true;
        }
        catch(Exception e){
            jibu = false;
        }
        
        return jibu;
    }
    
       
    /**
     * hakiki kama center namba ipo sawa
     * @param centreNo center namba
     * @return ndio au hapana
     */
    public static String centerNo(String centerNo){
        
        // kwa sekondoari
        if(centerNo.length() == 6){
            boolean f = centerNo.startsWith("S.");
            boolean s = centerNo.startsWith("P.");

            if(!(f && s )){
                return centerNo;
            }
            else{
                Mjumbe.oneshaUjumbe("Center number not valid");
                return null;
            }
        }
        else{
            Mjumbe.oneshaUjumbe("Center number not valid");
            return null;
        }
    }
    
    /**
     * kuhakiki kama text field zimejazwa 
     * @param filds text field
     * @return ndio au hapana
     */
    public static boolean fieldZimejazwa(JTextField ... filds) {
        boolean jibu = true;
        for(JTextField fild : filds){
           if(fild.getText().equals("")||fild.getText().equals("INVALID")){
               jibu = false;
               fild.setText("INVALID");
               break;
           } 
        }
        return jibu;
    }
    
    public static String score(Double alama){
        String jibu = "";
        
        if(alama > 100){
            jibu = "Invalid mark "+alama;
        }
        
        return jibu;
    }
    
    public static String PSLENo(String psleNo){
       
        if(psleNo.length() == 13){
            return "";
        }
        else{
            return "PSLENo not be correct";
        }
    }
    
    /**
     * hakiki psleNo na ftnaNo
     * @param q qualificationNo
     * @return ndio au hapana
     */
    public static boolean qualificationNo(String q){
       
        return true;
    }

    public static String referenceNo(String text) {
        if(text.isEmpty()){
            Mjumbe.oneshaUjumbe("Reference number not valid");
            return null;
        }
        else{
            return text;
        }
    }

    static boolean textFieldZimejazwa(JTextField ... fields) {
        boolean zimejazwa = true;
        for(JTextField field : fields){
            if(field.getText().length() == 0){
                return false;
            }
        }
        return zimejazwa;
    }
}

