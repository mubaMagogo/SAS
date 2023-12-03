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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 *
 * @author Muba
 */
public class Mkondo extends Darasa{
    private final TreeMap wavulana, wasichana, nonActiveWavulana, nonActiveWasichana;
    public static final TreeMap average = new TreeMap();
    public static final TreeMap<String, Double> totalReport = new TreeMap();
    public static final TreeMap reportSat = new TreeMap();
    private String jinaLaMkondo;
                        
    public Mkondo() {
        this.wavulana = new TreeMap();
        this.wasichana = new TreeMap();
        this.nonActiveWavulana = new TreeMap();
        this.nonActiveWasichana = new TreeMap();
        this.jinaLaMkondo = "ALL";
    }

    public Mkondo(String jinaLaMkondo){
        this.jinaLaMkondo = jinaLaMkondo;
        this.wavulana = new TreeMap();
        this.wasichana = new TreeMap();
        this.nonActiveWavulana = new TreeMap();
        this.nonActiveWasichana = new TreeMap();
    }

    /**
     * kupata jina la mkondo (mfano A,B,C n.k)
     * @return 
     */
    public String streamName(){
        return jinaLaMkondo;
    }

    @Override
    public String className(){
        return super.className();
    }
    
    /**
     * Kupata wavulana
     * @return wavulana
     */
    TreeMap getWavulana(){
        return wavulana;
    }

    /**
     * kupata wasichana
     * @return wasichana
     */
    TreeMap getWasichana(){
        return wasichana;
    }
            
    public void calculateAverage(Mtihani mtihani){
        
        average.clear();
        Iterator wanafunz = getWanafunzi().values().iterator();
        ArrayList list;
        
        if(average.containsKey(mtihani.getExamTitle())){
            list = (ArrayList)average.get(mtihani.getExamTitle());
        }
        else{
            list  = new ArrayList();
        }
        
        while(wanafunz.hasNext()){
            Mwanafunzi mwfnz = (Mwanafunzi)wanafunz.next();
            list.add(mwfnz.average(mtihani));
        }
        
        average.put(mtihani.getExamTitle(), list);
    }
    
    public void calculateTotalReport(Mtihani mtihani){
        
        totalReport.clear();
        
        Iterator wanafunz = getWanafunzi().values().iterator();
        while(wanafunz.hasNext()){
            Mwanafunzi mwfnz = (Mwanafunzi)wanafunz.next();
            double total = 0;
            
            Iterator masomo = mwfnz.getMasomo().iterator();
        
            while(masomo.hasNext()){
                mtihani.subject(masomo.next().toString());
                double marks = mwfnz.reportAverage(mtihani);

                if(marks > 0){
                    total += marks;
                }
            }
            
            if(total > 0){
                totalReport.put(mwfnz.premNo(), total); 
            }
                     
        }
    }
    
    /**
     * kupata wavulana ambao sio active
     * @return wavulana wasio active
     */
    TreeMap getNonActiveWavulana(){
        return nonActiveWavulana;
    }

    /**
     * kupata wasichana wasio active
     * @return wasichana wasio active
     */
    TreeMap getNonActiveWasichana(){
        return nonActiveWasichana;
    }

    /**
     * kupata wanafunzi active
     * @return wanafunzi active
     */
    LinkedHashMap getWanafunzi(){
        LinkedHashMap tempo = new LinkedHashMap();
        tempo.putAll(wasichana);
        tempo.putAll(wavulana);
        return tempo;
    }

    LinkedHashMap getWanafunzi(String somo){
        LinkedHashMap map = new LinkedHashMap();
        
        Iterator wanafunzi = getWanafunzi().values().iterator();
        while(wanafunzi.hasNext()){
            Mwanafunzi mwfnz = (Mwanafunzi)wanafunzi.next();
            if(mwfnz.getMasomo().contains(somo)){
                map.put(mwfnz.fullName(), mwfnz);
            }
        }
        return map;
    }
    
    /**
     * kupata wanafunzi non active
     * @return wanafuzi non active
     */
    LinkedHashMap getNonActive(){
        LinkedHashMap tempo = new LinkedHashMap();
        tempo.putAll(nonActiveWasichana); 
        tempo.putAll(nonActiveWavulana);
        return tempo;
    }
    
    LinkedHashMap getWanafunziWote(){
        LinkedHashMap tempo = new LinkedHashMap();
        TreeMap ke = getWasichana();
        ke.putAll(nonActiveWasichana);
        
        TreeMap me = getWavulana();
        me.putAll(nonActiveWavulana);
        
        tempo.putAll(ke);
        tempo.putAll(me);
        return tempo;
    }
    
    LinkedHashMap getNonAdmitted(){
        Iterator<Mwanafunzi> wfnz = getWanafunziWote().values().iterator();
        LinkedHashMap map = new LinkedHashMap();
        
        while(wfnz.hasNext()){
            Mwanafunzi mwfnz = wfnz.next();
            
            if(mwfnz.admissionNo() == -1){
                map.put(mwfnz.fullName(), mwfnz);
            }
        }
        
        return map;
    }
    
    /**
     * kuset jina la mkondo
     * @param jinaLaMkondo jina la mkondo
     */
    public void streamName(String jinaLaMkondo){
        this.jinaLaMkondo = jinaLaMkondo;
    }

    @Override
    void setCategory(String category){
        super.setCategory(category);
    }
    
    void changeCategory(String category){
        setCategory(category);
        
        Iterator<Mwanafunzi> wanafunzi = getWanafunzi().values().iterator();
        while(wanafunzi.hasNext()){
            Mwanafunzi mwfnz = wanafunzi.next();
            mwfnz.category(category);
            new Kanzidata().updateTaarifaZaMwanafunzi(mwfnz, "category");
        }
    }
    
    void enrollMwanafunzi(Mwanafunzi mwfnz) {
        addMwanafunzi(mwfnz);                        
        new Kanzidata().addMwanafunzi(mwfnz);
    }

    void addMwanafunzi(Mwanafunzi mwfnz) {
        if(mwfnz.sex().startsWith("M")){
            if(mwfnz.status().equalsIgnoreCase("ACTIVE")){
                wavulana.put(mwfnz.fullName(), mwfnz);
            }
            else{
                nonActiveWavulana.put(mwfnz.fullName(), mwfnz);
            }
        }
        else{
            if(mwfnz.status().equalsIgnoreCase("ACTIVE")){
                wasichana.put(mwfnz.fullName(), mwfnz);
            }
            else{
                nonActiveWasichana.put(mwfnz.fullName(), mwfnz);
            }
        }
        shule.addMwanafunzi(mwfnz);
    }
    
    /**
     * kuweka wasichana darasani kwa mkupuo
     * @param wasichana wasichana
     */
    void addWasichana(TreeMap wasichana) {
        this.wasichana.putAll(wasichana);
    }
    
    void addNonActiveWasichana(TreeMap nonActiveWasichana){
        this.nonActiveWasichana.putAll(nonActiveWasichana);
    }

    /**
     * kuweka wavulana darasani kwa mkupuo
     * @param wavulana wavulana
     */
    void addWavulana(TreeMap wavulana) {
        this.wavulana.putAll(wavulana);
    }

    void addNonActiveWavulana(TreeMap nonActiveWavulana){
        this.nonActiveWavulana.putAll(nonActiveWavulana);
    }
    /**
     * jina kamili la mkondo
     * @return jina kamili la mkondo (mfano FORM IIA)
     */
    public String streamFullName() {
        return super.className()+jinaLaMkondo;
    }

    void removeMwanafunzi(Mwanafunzi mwfnz) {
        if(mwfnz.sex().startsWith("M")){
            wavulana.remove(mwfnz.fullName());
        }
        else{
            wasichana.remove(mwfnz.fullName());
        }
    }

    void deleteMwanafunzi(Mwanafunzi mwfnz) {
        removeMwanafunzi(mwfnz);
        shule.deleteMwanafunzi(mwfnz);
    }

    ArrayList getAverage(Mtihani mtihani) {
        if(average.containsKey(mtihani.getExamTitle())){
            return (ArrayList)average.get(mtihani.getExamTitle());
        }
        else{
            return new ArrayList();
        }
    }
    
    ArrayList getAverageReport(Mtihani mtihani) {
       
        Iterator wanafunz = getWanafunzi().values().iterator();
        ArrayList list = new ArrayList();
                
        while(wanafunz.hasNext()){
            Mwanafunzi mwfnz = (Mwanafunzi)wanafunz.next();
            list.add(mwfnz.reportAverage(mtihani));
        }
        return list;
    }
    
    Double getTotalReport(Mwanafunzi mwfnz){
        return totalReport.get(mwfnz.premNo());
    }
    
    ArrayList getTotalReport(){
        return new ArrayList(totalReport.values());
    }
    
    Integer getReportSat(Mtihani mtihani){
        if(reportSat.containsKey(mtihani.subject())){
            return (Integer)reportSat.get(mtihani.subject());
        }
        else{
            Iterator wanafunz = getWanafunzi().values().iterator();
            int sat = 0;

            while(wanafunz.hasNext()){
                Mwanafunzi mwfnz = (Mwanafunzi)wanafunz.next();

                if(mwfnz.getMasomo().contains(mtihani.subject()) && mwfnz.reportAverage(mtihani) > -1){
                    sat++;
                }
            }
            return sat;
        }
    }
}
