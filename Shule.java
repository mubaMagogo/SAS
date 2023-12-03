/*
 * NAPENDA KUMSHUKURU MWENYEZI MUNGU KWA ZAWAIDI YA UHAI
 * HAKIKA HAPANA MOLA APASAE KUABUDIWA NA KUSUJUDIWA ISIPOKUWA MWENYEZI MUNGU MUUMBA WA VYOTE
 * AKILI, MAARIFA NA VIPAWA VYATOKA KWAKE.
 * 
 * KWA NJIA YOYOTE ILIOPATA CODE HIZI, UNARUHUSIWA KUZITUMIA KWA NJIA YA HALALI
 * USIFUTE MISTARI MITATU YA MWANZO YA KUMTUKUZA MWENYEZI MUNGU
 */
package com.mycompany.sab;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Muba
 */
public class Shule {
    
    // instance variables
    private String jinaLaShule;
    private Integer anuaniYaShule;
    private String nambaYaSimuYaShule;
    private String centerNo;
    private String nambaYaUsajiliYaShule;
    private String mkoaIlipo;
    private String wilayaIlipo;
    private String kataIlipo;
    private String levoYaShule;
    private String ainaYaShule;
    private String nemboYaShule;
    private final TreeMap walimu, madarasa, mikondo, majinaYaMikondo,majinaYaCategories,wanafunzi;
    private final TreeSet majinaYaMadarasa, admissionNo,masomo;
    
    public Shule(){
        wanafunzi = new TreeMap();
        walimu = new TreeMap();
        mikondo = new TreeMap();
        madarasa = new TreeMap();
        majinaYaMikondo = new TreeMap();
        majinaYaCategories = new TreeMap();
        majinaYaMadarasa = new TreeSet();
        admissionNo = new TreeSet();
        masomo = new TreeSet();
    }
         
       
    /**
     * jina la shule
     * @return jina la shule
     */
    public String schoolName(){
        return jinaLaShule;
    }
    
    /**
     * jina la kamili la shule mfano ITWANGI SECONDARY SCHOOL
     * @return 
     */
    public String schoolFullName(){
        String str = "";
        
        if(levoYaShule != null){
            if(levoYaShule.startsWith("O")){
                str = "SECONDARY";
            }
            else if(levoYaShule.startsWith("A")){
                str = "HIGH";
            }
            else{
                str = levoYaShule.toUpperCase();
            }
        }
        
        return jinaLaShule +" "+str+" SCHOOL";
    }
    
    /**
     * anuani ya shule mfano 113
     * @return anuani ya shule
     */
    public Integer schoolAddress(){
        return anuaniYaShule;
    }
    
    /**
     * anuani ya shule mfano 113 SHINYANGA
     * @return anuani ya Shule
     */
    public String schooAddressFull(){
        return anuaniYaShule +" "+mkoaIlipo;
    }
    
    /**
     * levo ya shule mfano msingi, sekondari etc
     * @return 
     */
    public String schoolLevel(){
        return levoYaShule;
    }
    
    /**
     * center number mfano S.3023
     * @return center number 
     */
    public String centerNo(){
        return centerNo;
    }
    
    /**
     * namba ya usajili ya shule
     * @return namba ya usajili
     */
    public String regNo(){
        return nambaYaUsajiliYaShule;
    }
    
    /**
     * center number bila nukta mfano S3023
     * @return center number bila nukta
     */
    public String centerNoOnly(){
        return centerNo.replace(".", "");
    }
    
    /**
     * center namba yenye namba pekee mfano 3023
     * @return centre number pekee
     */
    public String centerNoNo(){
        return centerNoOnly().substring(1);
    }
    
    /**
     * namba ya simu ya shule
     * @return namba ya simu
     */
    public String schoolPhoneNo(){
        return nambaYaSimuYaShule;
    }
    
    /**
     * mkoa shule ilipo
     * @return mkoa ilipo
     */
    public String schoolRegion(){
        return mkoaIlipo;
    }
    
    /**
     * wilaya shule ilipo
     * @return wilaya ilipo
     */
    public String schoolDistrict(){
        return wilayaIlipo;
    }
    
    /**
     * kata shule ilipo
     * @return 
     */
    public String schoolWard(){
        return kataIlipo;
    }
    
    /**
     * aina ya shule mfano mchanganyiko, wasichana pekee n.k
     * @return aina ya shule;
     */
    public String schoolCategory(){
        return ainaYaShule;
    }
    
    /**
     * nembo ya shule
     * @return nembo ya shule
     */
    public String schoolBadge(){
        return nemboYaShule;
    }
      
    /**
     * kupata mikondo yote
     * @return mikondo
     */
    TreeMap getMikondo(){
        return mikondo;
    }
    
    /**
     * kupata madarasa
     * @return madarasa
     */
    TreeMap getMadarasa(){
       return madarasa;        
    }
      
    /**
     * kupata majina ya madarasa
     * @return majina ya madarasa (mfaono FORM II, FORM III etc)
     */
    TreeSet getMajinaYaMadarasa(){
        return majinaYaMadarasa;
    }
    
    TreeSet getAdmissionNo(){
        return admissionNo;
    }
    
    TreeSet getMajinaYaMikondo(String jinaLaDarasa){
        return (TreeSet)majinaYaMikondo.get(jinaLaDarasa);
    }
    
    TreeSet getMajinaYaCategories(String jinaLaDarasa){
        return (TreeSet)majinaYaCategories.get(jinaLaDarasa);
    }
    
     /**
     * orodha ya masomo yanayo somwa shuleni
     * @return masomo
     */
    TreeSet getMasomo(){
        return masomo;
    }
    
        
    // Setters
    /**
     * set jina la shule
     * @param jinaLaShule jina la shule
     */
    public void schoolName(String jinaLaShule){
        this.jinaLaShule = jinaLaShule;
    }
    
    /**
     * set anuani ya shule
     * @param anuaniYaShule anuani ya shule
     */
    public void schoolAddress(Integer anuaniYaShule){
        this.anuaniYaShule = anuaniYaShule;
    }
    
    /**
     * set namba ya simu ya shule
     * @param nambaYaSimuYaShule namba ya simu ya shule
     */
    public void schoolPhoneNo(String nambaYaSimuYaShule){
        this.nambaYaSimuYaShule = nambaYaSimuYaShule;
    }
        
    /**
     * set center namba ya shule
     * @param centerNo center namba 
     */
    void centerNo(String centerNo){
        this.centerNo = centerNo;
    }
    
    /**
     * set namba ya usajili ya shule
     * @param nambaYaUsajiliYaShule
     */
    public void regNo(String nambaYaUsajiliYaShule){
        this.nambaYaUsajiliYaShule = nambaYaUsajiliYaShule;
    }
    
    /**
     * set mkoa shule ilipo
     * @param mkoaIlipo shule ilipo
     */
    public void schoolRegion(String mkoaIlipo){
        this.mkoaIlipo = mkoaIlipo;
    }
    
    /**
     * set wilaya shule ilipo
     * @param wilayaIlipo wilaya ilipo
     */
    public void schoolDistrict(String wilayaIlipo){
        this.wilayaIlipo = wilayaIlipo;
    }
    
    /**
     * set kata shule ilipo
     * @param kataIlipo kata shule ilipo
     */
    public void schoolWard(String kataIlipo){
        this.kataIlipo = kataIlipo;
    }
    
    /**
     * set levo ya shule mfano msingi sekondari
     * @param levoYaShule levo ya shule 
     */
    public void schoolLevel(String levoYaShule){
        this.levoYaShule = levoYaShule;
    }
    
    /**
     * set aina ya shule mfano mchanganyiko au jinsia moja
     * @param ainaYaShule aina ya shule
     */
    public void schoolCategory(String ainaYaShule){
        this.ainaYaShule = ainaYaShule;
    }
    
    /**
     * kupata walimu 
     * @return walimu
     */
    TreeMap getWalimu(){
        return walimu;
    }
    
    /**
     * kupata wanafunzi
     * @return wanafunzi
     */
    TreeMap getWanafunzi(){
        return wanafunzi;
    }
    
    /**
     * kupata wanafunzi wote wa darasa
     * @param jinaLaDarasa jina la darasa
     * @return mkondo
     */
    Mkondo getDarasa(String jinaLaDarasa) {
        
        Mkondo darasa = new Mkondo();
        darasa.className(jinaLaDarasa);
        
        Iterator<Mkondo> it = mikondo.values().iterator();
        
        while(it.hasNext()){
            Mkondo mkondo = it.next();
            
            if(mkondo.className().equals(jinaLaDarasa)){
                darasa.addWasichana(mkondo.getWasichana());
                darasa.addWavulana(mkondo.getWavulana());
                darasa.addNonActiveWasichana(mkondo.getNonActiveWasichana());
                darasa.addNonActiveWavulana(mkondo.getNonActiveWavulana());
            }
        }
        return darasa;
    }
    
    /**
     * kupata wanafunzi wa darasa wanaosoma category flan
     * @param jinaLaDarasa jina la darasa
     * @param category category
     * @return mkondo
     */
    
    Mkondo getDarasa(String jinaLaDarasa, String category){
        
        if(madarasa.containsKey(jinaLaDarasa + category)){
            Mkondo darasa = (Mkondo)madarasa.get(jinaLaDarasa + category);
            
            Iterator<Mwanafunzi> it = getDarasa(jinaLaDarasa).getWanafunzi().values().iterator();
            
            while(it.hasNext()){
                Mwanafunzi mwfnz = it.next();

                if(mwfnz.category().equals(category)){
                    darasa.addMwanafunzi(mwfnz);
                }
            }
            return darasa;
        }
        else{
            Mkondo darasa = getDarasa(jinaLaDarasa);
            darasa.setCategory(category);
            return darasa;
        }        
    }
      
    boolean categoryIpo(String jinaLaDarasa ,String category){
        return madarasa.containsKey(jinaLaDarasa+category);
    }
    
    
    /**
     * kupata mkondo
     * @param jinaKamiliLaMkondo jina kamili la mkondo
     * @return mkondo
     */
    Mkondo getMkondo(String jinaKamiliLaMkondo) {
        
        if(mikondo.containsKey(jinaKamiliLaMkondo)){
            return (Mkondo)mikondo.get(jinaKamiliLaMkondo);
        }
        else if(jinaKamiliLaMkondo.contains("ALL")){
            jinaKamiliLaMkondo = jinaKamiliLaMkondo.replace("ALL", "");
            return getDarasa(jinaKamiliLaMkondo);
        }
        else{
            return null;
        }
    }
        
    Mwanafunzi getMwanafunzi(String premNo) {
        return (Mwanafunzi)wanafunzi.get(premNo);
    }

    /**
     * ku save mkondo ktk kanzidata
     * @param mkondo mkondo
     */
    void enrollMkondo(Mkondo mkondo) {
            
        // chek kwanza kama darasa lipo
        boolean darasaLipo = false;
        Iterator<Darasa> it = madarasa.values().iterator();
        
        while(it.hasNext()){
            Darasa darasa = it.next();
            
            if(darasa.className().equals(mkondo.className())){
                darasaLipo = true;
                break;
            }
        }
        
        // kama halipo save darasa
        if(!darasaLipo){
           enrollDarasa(mkondo); 
        }
        
        // save mkondo ktk kanzi data
        addMkondo(mkondo);
        new Kanzidata().addMkondo(mkondo);
    }

    /**
     * kumweka mwanafunzi shuleni
     * @param mwfnz mwanafunzi
     */
    void addMwanafunzi(Mwanafunzi mwfnz) {
        wanafunzi.put(mwfnz.premNo(), mwfnz);
        
        if(mwfnz.admissionNo() != -1){
            admissionNo.add(mwfnz.admissionNo());
        }
    }

    private void enrollDarasa(Mkondo darasa) {
        addDarasa(darasa);
        new Kanzidata().addDarasa(darasa);
    }

    void addDarasa(Mkondo darasa) {
        madarasa.put(darasa.getClassFullName(), darasa);
        addJinaLaCateogory(darasa.getCategory(), darasa.className());
    }

    void addJinaLaDarasa(String jinaLaDarasa){
        majinaYaMadarasa.add(jinaLaDarasa);
    }
    
    void addJinaLaCateogory(String jinaLaCateogory, String jinaLaDarasa){
        if(majinaYaCategories.containsKey(jinaLaDarasa)){
            TreeSet set = (TreeSet)majinaYaCategories.get(jinaLaDarasa);
            set.add(jinaLaCateogory);
            majinaYaCategories.put(jinaLaDarasa, set);
        }
        else{
            TreeSet set = new TreeSet();
            set.add(jinaLaCateogory);
            majinaYaCategories.put(jinaLaDarasa, set);
        }
    }
    
    void addJinaLaMkondo(String jinaLaMkondo, String jinaLaDarasa){
        if(jinaLaMkondo != null && jinaLaDarasa != null){
            if(majinaYaMikondo.containsKey(jinaLaDarasa)){
                TreeSet set = (TreeSet)majinaYaMikondo.get(jinaLaDarasa);
                set.add(jinaLaMkondo);
                majinaYaMikondo.put(jinaLaDarasa, set);
            }
            else{
                TreeSet set = new TreeSet();
                set.add(jinaLaMkondo);
                majinaYaMikondo.put(jinaLaDarasa, set);
            }
        }
    }
        
    void addMkondo(Mkondo mkondo) {
        addJinaLaMkondo(mkondo.streamName(), mkondo.className());
        mikondo.put(mkondo.streamFullName(), mkondo);
    }

    ArrayList getCategories(String jinaLaDarasa) {
        ArrayList categories = new ArrayList();
        Iterator<Darasa> it = madarasa.values().iterator();
        
        while(it.hasNext()){
            Darasa darasa = it.next();
            
            if(darasa.className().equals(jinaLaDarasa)){
                categories.add(getDarasa(jinaLaDarasa,darasa.getCategory()));
            }
        }
        
        return categories;
    }

    void deleteDarasa(String jinaLaDarasa) {
        Iterator<String> categories = getMajinaYaCategories(jinaLaDarasa).iterator();
        
        while(categories.hasNext()){
            deleteCategory(jinaLaDarasa, categories.next());
        }
    }

    void deleteCategory(String jinaLaDarasa, String category){
        Iterator<Mwanafunzi> wnfnz = getDarasa(jinaLaDarasa,category).getWanafunzi().values().iterator();
        
        while(wnfnz.hasNext()){
            Mwanafunzi mwfnz = wnfnz.next();
            new Kanzidata().deleteMwanafunzi(mwfnz);
        }
        
        removeCategory(jinaLaDarasa, category);
        new Kanzidata().deleteDarasa(jinaLaDarasa+category);
    }
    
    
    void removeMwanafunzi(Mwanafunzi mwfnz) {
        wanafunzi.remove(mwfnz.premNo());
    }

    void deleteMwanafunzi(Mwanafunzi mwfnz) {
        removeMwanafunzi(mwfnz);
        new Kanzidata().deleteMwanafunzi(mwfnz);
    }

    /**
     * kuongeza somo
     * @param somo jina la somo
     */
    void addSomo(String somo) {
        this.masomo.add(somo);
    }
     
    void addMasomo(TreeSet masomo){
        this.masomo.addAll(masomo);
    }
    
    private void removeCategory(String jinaLaDarasa, String category) {
        madarasa.remove(jinaLaDarasa+category);
        
        if(majinaYaCategories.containsKey(jinaLaDarasa)){
            TreeSet set = (TreeSet)majinaYaCategories.get(jinaLaDarasa);
            set.remove(category);
            majinaYaCategories.put(jinaLaDarasa, set);
        }
    }
    
    public static Shule shule = new Shule();

    void deleteMkondo(String jinaKamiliLaMkondo) {
        Mkondo mkondo = getMkondo(jinaKamiliLaMkondo);
        mikondo.remove(jinaKamiliLaMkondo);
        TreeSet set = (TreeSet)majinaYaMikondo.get(mkondo.className());
        set.remove(mkondo.streamName());
        majinaYaMikondo.put(mkondo.className(), set);
        new Kanzidata().deleteMkondo(jinaKamiliLaMkondo);
    }
}
