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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

/**
 *
 * @author Muba
 */
public class Mwanafunzi extends Mtu{
   
    // instance variables
    private int nambaYaUsajili;
    private String darasaAliloSajiliwa;
    private int mwakaAliosajiliwa;
    private String tareheYaKusajiliwa;
    private String ainaYaUsajili;
    private String niMrudiaji;
    private String malazi;
    private int umbaliKutokaNyumbani;
    private String haliYaWazazi;
    private String haliYaMazingiraMagumu;
    private String jinaLaMlezi;
    private String uhusianoNaMlezi;
    private String nambaYaKitambulishoChaMlezi;
    private String emailYaMlezi;
    private String kaziYaMlezi;
    private String anuaniYaMlezi;
    private String anuaniYaMakaziYaMlezi;
    private String jinsiYaMzazi;
    private String elimuYaMzazi;
    private String nambaSimu1;
    private String nambaSimu2;
    private String nambaSimu3;
    private String status;
    private String mkondo;
    private String category;
    private String premNo;
    private String PSLENo;
    private String FTNANo;
    private int PSLEYear ;
    private int FTNAYear ;
    private String examReferenceNo;
    private int examReferenceYear = -1;
    private String mchepuo;
    private TreeSet masomo;
    private final TreeMap mitihani;
    
    // constructors
    public Mwanafunzi(){
        this.category = "ARTS";
        this.status = "ACTIVE";
        this.mwakaAliosajiliwa = LocalDate.now().getYear();
        this.nambaYaUsajili = -1;
        this.mitihani = new TreeMap();
        this.masomo = new TreeSet(Settings.loadArtsSubjects().keySet());
    }
    
    public Mwanafunzi(Mtu mtu){
        super(mtu);
        this.category = "ARTS";
        this.status = "ACTIVE";
        this.mwakaAliosajiliwa = LocalDate.now().getYear();
        this.nambaYaUsajili = -1;
        this.mitihani = new TreeMap();
        this.masomo = new TreeSet(Settings.loadArtsSubjects().keySet());
    }
    
    /***                GETTERS                  ***/
    /**
     * prem namba
     * @return prem namba
     */
    public String premNo(){
        return premNo;
    }
    
    /**
     * namba ya usajili
     * @return namba ya usajili
     */
    public Integer admissionNo(){
        return nambaYaUsajili;
    }
     
    /**
     * darasa alilosajiliwa
     * @return darasa alilosajiliwa
     */
    public String classAdmitted(){
        return darasaAliloSajiliwa;
    }
    
     /**
     * mwaka aliosajiliwa
     * @return mwaka aliosajiliwa
     */
    public Integer yearAdmitted(){
        return mwakaAliosajiliwa;
    }
    
    /**
     * mkondo aliopo
     * @return mkondo aliopo
     */
    public String stream(){
        return mkondo;
    }
    
    /**
     * aina ya usajili
     * @return aina ya usajili
     */
    public String registrationType(){
        return ainaYaUsajili;
    }
    
    /**
     * hali ya utoro (sio mtoro, mtoro, ameacha, amefukuzwa n.k)
     * @return hali ya mwanafunzi
     */
    public String status(){
       return status;  
    }
    
    /**
     * hali ya wazazi (wamefariki mzazi moja au la)
     * @return hali ya wazazi
     */
    public String parentStatus(){
        return haliYaWazazi;
    }
    
    /**
     * Namba ya mtihani darasa la saba
     * @return 
     */
    public String PSLENo(){
        return PSLENo;
    }
    
    /**
     * mwaka aliofanya mtihani darasa la saba
     * @return mwaka aliofanya mtihani
     */
    public Integer PSLEYear(){
        return PSLEYear;
    }
    
    /**
     * namba ya mtihani kidato cha pili
     * @return 
     */
    public String FTNANo(){
        return FTNANo;
    }
     
    /**
     * Mwaka aliofanya mtihani kidato cha pili
     * @return 
     */
    public Integer FTNAYear(){
        return FTNAYear;
    }
    
    /**
     * Ni mrudiaji
     * @return ndio au hapan
     */
    public String isRepeater(){
        return niMrudiaji;
    }
    
    /**
     * mchepuo (Mfono PCM, PCB, CBG, HKL n.k)
     * @return mchepuo
     */
    public String combination(){
        return mchepuo;
    }
    /**
     * mawasiliano namba ya simu yakwanza
     * @return mawasiliano line 1
     */
    public String addressLine1(){
        return nambaSimu1;
    }
    
    /**
     * mawasiliano namba ya 2
     * @return mawasiliano line 2
     */
    public String addressLine2(){
        return nambaSimu2;
    }
    
    /**
    * mawasiliano namba ya 3
    * @return mawasiliano line 3
    */
    public String addressLine3(){
        return nambaSimu3;
    }    
    
    /**
     * umbali kutokea nyumbani mpaka shule
     * @return umbali kutokea nyumbani
     */
    public Integer distanceFromHome(){
        return umbaliKutokaNyumbani;
    }
    
    /**
     * hali ya ugumu wa maisha
     * @return hali ya ugumu wa maisha
     */
    public String difficultiesStatus(){
        return haliYaMazingiraMagumu;
    }
    
    /**
     * malazi (bweni au kutwa)
     * @return malazi
     */
    public String accomodation(){
        return malazi;
    }
    
    /**
     * jina la mlezi
     * @return jina la mlezi
     */
    public String guardianName(){
        return jinaLaMlezi;
    }
    
    /**
     * jinsia ya mlezi
     * @return jinsia ya mlezi
     */
    public String guardianSex(){
        return jinsiYaMzazi;
    }
    
    /**
     * Namba ya kitambulisho cha mzazi/mlezi
     * @return Namba ya kitambulisho cha mzazi/mlezi
     */
    public String guardianIdNo(){
        return nambaYaKitambulishoChaMlezi;
    }
    
    /**
     * Mahusiano ya mlezi na mwanafunzi (mfano Mjomba Babu n.k)
     * @return Mahusiano ya mwanafunzi na mlezi
     */
    public String guardianRelation(){
        return uhusianoNaMlezi;
    }
    
    /**
     * Email ya mzazi/mlezi
     * @return email ya mzazi/mlezi
     */
    public String guardianEmail(){
        return emailYaMlezi;
    }
    
    /**
     * Kazi ya mzazi/mlezi
     * @return kazi ya mzazi/mlezi
     */
    public String guardianOccupation(){
        return kaziYaMlezi;
    }
    
    /**
     * Anuani ya mzazi/mlezi
     * @return anuani ya mzazi/mlezi
     */
    public String guardianAddress(){
        return anuaniYaMlezi;
    }
    
    /**
    * Anuani ya kudumu (makazi) ya mzazi/mlezi
    * @return Anuani ya kudumu (makazi) ya mzazi/mlezi
    */
    public String guardianPhysicalAddress(){
        return anuaniYaMakaziYaMlezi;
    }
       
    /**
     * Kiwango cha elimu cha mlezi
     * @return 
     */
    public String guardianEducationLevel(){
        return elimuYaMzazi;
    }
    
    /**
     * namba ya mtihani wa mwisho wa taifa aliofanya
     * @return namba ya mtihani PSLE au FTNA
     */
    public String examReferenceNo(){
        return examReferenceNo;
    }
    
    /**
     * Mwaka aliofanya mtihani
     * @return mwaka aliofanyia PSLE or FTNA
     */
    public Integer examReferenceYear(){
        if(examReferenceYear == 0){
           return LocalDate.now().getYear();
        }
        else{
            return examReferenceYear;
        }
    }
       
    /**
     * tarehe ya usajili
     * @return tarehe ya usajili
     */
    public String registrationDate(){
        return tareheYaKusajiliwa;
    }
    
    /**
     * masomo anayosoma mwanafunzi
     * @return masomo
     */
    public TreeSet getMasomo(){
        return masomo;
    }
    
    /**
     * darasa alilopo (mfano FORM I, FORM II etc)
     * @return darasa alilopo sasa
     */
    public String currentClass(){
        int darasa = Badili.ktkNambaZaKawaida(darasaAliloSajiliwa.split(" ")[1]); // darasa alilo sajiliwa ktk namba ya kawaida
        return Badili.kuwaDarasa(darasa + LocalDate.now().getYear() - mwakaAliosajiliwa);
    }
    
    /**
     * darasa alilopo kwa kifupi (mfano I, II, III)
     * @return darasa alilopo kwa kifupi
     */
    
    public String currentClassPrefix(){
        return currentClass().split(" ")[1];
    }
        
    /**
     * aina ya masomo anayosoma (science, arts, business, agriculture etc)
     * @return aina ya masomo anayosoma
     */
    public String category(){
        return category;
    }
         
    /**
     * namba ya mtihani (mfano S.3023/0001)
     * @return 
     */
    public String examNo(){
        return shule.centerNo()+"/"+candidateNo();
    }
    
    /**
     * namba ya mtahiniwa (mfano 0001)
     * @return namba ya mtahiniwa
     */
    public String candidateNo(){
       Mkondo darasa = shule.getDarasa(this.currentClass());
       int nambaYaMtahiniwa = new Vector(darasa.getWanafunzi().keySet()).indexOf(this.fullName());
       return Badili.ktkTarakimuNne(nambaYaMtahiniwa+1);
    } 
       
    /**
     * set namba ya usajili
     * @param nambaYaUsajili namba ya usajili
     */
    public void admissionNo(Integer nambaYaUsajili){
        this.nambaYaUsajili = nambaYaUsajili;
    }
    
    /**
     * set darasa alilo sajiliwa
     * @param darasaAliloSajiliwa darasa alilo sajiliwa
     */
    public void classAdmitted(String darasaAliloSajiliwa){
        this.darasaAliloSajiliwa = darasaAliloSajiliwa;
    }
           
    /**
     * set mwaka aliosajiliwa
     * @param mwakaAliosajiliwa mwaka aliosajiliwa
     */
    public void yearAdmitted(Integer mwakaAliosajiliwa){
        this.mwakaAliosajiliwa = mwakaAliosajiliwa;
    }
    
    /**
     * aina ya usajili
     * @param ainaYaUsajili
     */
    public void registrationType(String ainaYaUsajili){
        this.ainaYaUsajili = ainaYaUsajili;
    }
    
    /**
     * set mkondo 
     * @param mkondo mkondo
     */
    public void stream(String mkondo){
        this.mkondo = mkondo;
    }
    
    /**
     * amerudia darasa
     * @param niMrudiaji
     */
    public void isRepeater(String niMrudiaji){
        this.niMrudiaji = niMrudiaji;
    }
        
    /**
     * set combination 
     * @param mchepuo combination
     */
    public void combination(String mchepuo){
        this.mchepuo = mchepuo;
    }
    
    /**
     * set necha ya masomo (Science, Arts etc)
     * @param category 
     */
    public void category(String category){
        this.category = category;
    }
    
    /**
     * hali ya mwanafunzi (mtoro, ameacha, amefukuzwa n.k)
     * @param status
     */
    public void status(String status){
       this.status = status;  
    }
      
    /**
     * prem namba
     * @param premNo prem#
     */
    public void premNo(String premNo){
        this.premNo = premNo;
    }
    
    /**
     * namba ya mtihani darasa la saba
     * @param PSLENo namba ya mtihani darasa la saba
     */
    public void PSLENo(String PSLENo){
        this.PSLENo = PSLENo;
    }
    
    /**
     * kuset mwaka aliofanya mtihani darasa la saba
     * @param PSLEYear mwaka aliofanya mtihani darasa VII
     */
    public void PSLEYear(Integer PSLEYear){
        this.PSLEYear = PSLEYear;
    }
    
    /**
     * kuset namba ya mtihani kidato cha pili
     * @param FTNANo namba ya mtihani kidato cha pili
     */
    public void FTNANo(String FTNANo){
        this.FTNANo = FTNANo;
    }
    
    /**
     * kuset mwaka aliofanya mtihani kidato cha pili
     * @param FTNAYear mwaka aliofanyia mtihani
     */
    public void FTNAYear(Integer FTNAYear){
        this.FTNAYear = FTNAYear;
    }
    
    /**
     * kuset reference number
     * @param examReferenceNo reference number 
     */
    public void examReferenceNo(String examReferenceNo){
        this.examReferenceNo = examReferenceNo;
    }
    
    /**
     * kuset reference year
     * @param examReferenceYear reference year
     */
    public void examReferenceYear(Integer examReferenceYear){
        this.examReferenceYear = examReferenceYear;
    }
    
    /**
     * umbali kutokea nyumbani mpaka shule
     * @param umbaliKutokaNyumbani
     */
    public void distanceFromHome(Integer umbaliKutokaNyumbani){
        this.umbaliKutokaNyumbani = umbaliKutokaNyumbani;
    }
    
     /**
     * malazi (anapatiwa malazi shuleni)
     * @param malazi
     */
    public void accomodation(String malazi){
        this.malazi = malazi;
    }
     /**
     * mawasiliano line 1
     * @param nambaSimu1
     * @this.mawasiliano line 1
     */
    public void addressLine1(String nambaSimu1){
        this.nambaSimu1 = nambaSimu1;
    }
    
     /**
     * mawasiliano line 2
     * @param nambaSimu2
     * @this.mawasiliano line 2
     */
    public void addressLine2(String nambaSimu2){
        this.nambaSimu2 = nambaSimu2;
    }
    
     /**
     * mawasiliano line 3
     * @param nambaSimu3
     * @this.mawasiliano line 3
     */
    public void addressLine3(String nambaSimu3){
        this.nambaSimu3 = nambaSimu3;
    }  
    
    /**
     * kuseti hali ya ugumu wa mazingira
     * @param haliYaMazingiraMagumu hali ya ugumu wa mazingira 
     */
    public void difficultiesStatus(String haliYaMazingiraMagumu){
        this.haliYaMazingiraMagumu = haliYaMazingiraMagumu;
    }
    
    /**
     * jina la mzazi/mlezi
     * @param jinaLaMlezi jina la mzazi/mlezi
     */
    public void guardianName(String jinaLaMlezi){
        this.jinaLaMlezi = jinaLaMlezi;
    }
    
    /**
     * jinsi ya mzazi
     * @param jinsiYaMzazi 
     */
    public void guardianSex(String jinsiYaMzazi){
        this.jinsiYaMzazi = jinsiYaMzazi;
    }
    
    /**
     * elimu ya mzazi
     * @param elimuYaMzazi elimu ya mzazi
     */
    public void guardianEducationLevel(String elimuYaMzazi){
        this.elimuYaMzazi = elimuYaMzazi;
    }
    
    /**
     * Uhusiano kati ya mwanafunzi na mlezi (Mfano Mjomba, shangazi n.k)
     * @param uhusianoNaMlezi 
     */
    public void guardianRelation(String uhusianoNaMlezi){
        this.uhusianoNaMlezi = uhusianoNaMlezi;
    }
    
    /**
     * Barua pepe ya mzazi/mlezi
     * @param emailYaMlezi barua pepe ya mzazi/mlezi
     */
    public void guardianEmail(String emailYaMlezi){
        this.emailYaMlezi = emailYaMlezi;
    }
        
    /**
     * Namba ya kitambulisho cha mzazi/mlezi
     * @param nambaYaKitambulishoChaMlezi 
     */
    public void guardianIdNo(String nambaYaKitambulishoChaMlezi){
        this.nambaYaKitambulishoChaMlezi = nambaYaKitambulishoChaMlezi;
    }
    
    /**
     * Kazi ya mzazi/mlezi
     * @param kaziYaMlezi kazi ya mzazi/mlezi
     */
    public void guardianOccupation(String kaziYaMlezi){
        this.kaziYaMlezi = kaziYaMlezi;
    }
    
    /**
     * Anuani ya mzazi/mlezi
     * @param anuaniYaMlezi anuani ya mzazi/mlezi
     */
    public void guardianAddress(String anuaniYaMlezi){
        this.anuaniYaMlezi = anuaniYaMlezi;
    }

    /**
     * Anuani ya makazi ya mzazi/mlezi
     * @param anuaniYaMakaziYaMlezi anuani ya makazi ya mzazi/mlezi
     */
    public void guardianPhysicalAddress(String anuaniYaMakaziYaMlezi){
        this.anuaniYaMakaziYaMlezi = anuaniYaMakaziYaMlezi;
    }
    
    /**
     * hali ya wazazi (wamefariki mzazi moja au la)
     * @param haliYaWazazi
     */
    public void parentStatus(String haliYaWazazi){
        this.haliYaWazazi = haliYaWazazi;
    }

    /**
     * kupata alama 
     * @param mtihani alama
     * @return 
     */
    public Double marks(Mtihani mtihani){
        if(masomo.contains(mtihani.subject())){
            if(mitihani.containsKey(mtihani.examFullName())){
                return (Double)mitihani.get(mtihani.examFullName());
            }
            else{// load mitihani
                new Kanzidata().loadMtihani(mtihani);              
                
                if(mitihani.containsKey(mtihani.examFullName())){
                    return (Double)mitihani.get(mtihani.examFullName());
                }
                else{
                    return -1.0;
                }
            }
        }
        else{
            return -1.0;
        }
    }

    public String grade(Mtihani mtihani){
        return new Tafuta().grade(marks(mtihani));
    }
    
    public Double average(Mtihani mtihani){
        double average = total(mtihani)/getMasomo().size();
        return Double.parseDouble(String.format("%.2f", average));
    }
       
    public Double reportGrandAverage(){
        return Double.parseDouble(String.format("%.2f", totalReport()/getMasomo().size()));
    }
    
    public Double reportAverage(Mtihani mtihani){
        mtihani.examName("MIDTERM");
        double midterm = marks(mtihani);
        
        mtihani.examName("TERMINAL");
        double terminal = marks(mtihani);
        
        
        if(midterm > -1){
            if(terminal > -1){
                return (midterm + terminal)/2;
            }
            else{
                return midterm;
            }
        }
        else{
            return terminal;
        }
    }
    
    public String reportGrade(Mtihani mtihani){
        return new Tafuta().grade(reportAverage(mtihani));
    }
    
    public String reportRemarks(Mtihani mtihani){
        return new Tafuta().remarks(reportGrade(mtihani));
    }
    
    public String averageGrade(Mtihani mtihani){
        return new Tafuta().grade(average(mtihani));
    }
    
    public Integer points(Mtihani mtihani){
        ArrayList marks = new ArrayList();
        
        Iterator masomo = getMasomo().iterator();
        while(masomo.hasNext()){
            String somo = masomo.next().toString();
            
            mtihani.subject(somo);
            double mark = marks(mtihani);
            
            if(mark >= 0){
                marks.add(mark);
            }
        }
        
       return new Tafuta().points(marks);
    }
     
    public Integer pointsReport(Mtihani mtihani){
        ArrayList marks = new ArrayList();
        
        Iterator masomo = getMasomo().iterator();
        while(masomo.hasNext()){
            String somo = masomo.next().toString();
            
            mtihani.subject(somo);
            double mark = reportAverage(mtihani);
            
            if(mark >= 0){
                marks.add(mark);
            }
        }
        
       return new Tafuta().points(marks);
    }
    
    public String division(Mtihani mtihani){
        return new Tafuta().division(points(mtihani));
    }
    
    public String divisionReport(Mtihani mtihani){
        return new Tafuta().division(pointsReport(mtihani));
    }
    
    public Double total(Mtihani mtihani){
        double total = 0;
        Iterator masomo = getMasomo().iterator();
        
        while(masomo.hasNext()){
            mtihani.subject(masomo.next().toString());
            
            double marks = marks(mtihani);
            
            if(marks > 0){
                total += marks;
            }
        }
        
        
        return total;
    }
    
    public Double totalReport(){
        return shule.getMkondo(this.currentClass()+"ALL").getTotalReport(this);
    }
    
    public Double overRallPosition(Mtihani mtihani){
        if(average(mtihani) > 0){
            return new Tafuta().nafasi(average(mtihani), shule.getMkondo(this.currentClass()+"ALL").getAverage(mtihani));
        }
        else{
            return -1.0;
        }
    }
    
    public Double positionReport(Mtihani mtihani){
        return new Tafuta().nafasi(reportAverage(mtihani), shule.getMkondo(this.currentClass()+"ALL").getAverageReport(mtihani));
    }
    
    public Double grandPositionReport(){
        return new Tafuta().nafasi(totalReport(), shule.getMkondo(this.currentClass()+"ALL").getTotalReport());
    }
    
    public Integer satReport(Mtihani mtihani){
        return shule.getMkondo(this.currentClass()+"ALL").getReportSat(mtihani);
    }
    
    public Integer totalSat(){
        return shule.getMkondo(this.currentClass()+"ALL").getTotalReport().size();
    }
    public Integer outOfMarks(){
        return getMasomo().size()*100;
    }
    
    /**
     * kuset alama za mwanafunzi
     * @param mtihani mtihani husika
     * @param alama alama ktk mtihani husika
     */
    public void score(Mtihani mtihani, Double alama){
        mitihani.put(mtihani.examFullName(), alama);
    }
    
    /**
     * kuongeza masomo anayosoma mwanafunzi
     * @param masomo masomo
     */
    public void addSomo(TreeSet masomo){
        this.masomo.clear();
        this.masomo.addAll(masomo);
        new Kanzidata().updateTaarifaZaMwanafunzi(this, "subjectCodes");
    }
    
    public void clearMasomo(){
        masomo.clear();
    }
    
    public String subjectCodes() {
        String subjectCodes = "";
        
        TreeMap masomoYote = Settings.loadAllSubjects();
        
        for(Object somo : masomo){
            if(masomoYote.containsKey(somo)){
                subjectCodes = subjectCodes+masomoYote.get(somo)+",";
            }
        }
        
        return subjectCodes;
    }
    
    public void subjectCodes(String codes){
        masomo.clear();
        masomo.addAll(getMasomoFromCodes(codes));
    }
    
    private TreeSet getMasomoFromCodes(String codes) {
        TreeSet masomoFromCodes = new TreeSet();
        String[] subjectCodes = codes.split(",");
        TreeMap allSubjects = Settings.loadAllSubjects();
        
        for(String subjectCode : subjectCodes){
            for(Object subject: allSubjects.keySet()){
                if(subjectCode.equals(allSubjects.get(subject))){
                    masomoFromCodes.add(subject);
                    break;
                }
            }
        }
        
        return masomoFromCodes;
    }
}
