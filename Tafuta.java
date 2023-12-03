/*
 * NAPENDA KUMSHUKURU MWENYEZI MUNGU KWA ZAWAIDI YA UHAI
 * HAKIKA HAPANA MOLA APASAE KUABUDIWA NA KUSUJUDIWA ISIPOKUWA MWENYEZI MUNGU MUUMBA WA VYOTE
 * AKILI, MAARIFA NA VIPAWA VYATOKA KWAKE.
 * 
 * KWA NJIA YOYOTE ILIOPATA CODE HIZI, UNARUHUSIWA KUZITUMIA KWA NJIA YA HALALI
 * USIFUTE MISTARI MITATU YA MWANZO YA KUMTUKUZA MWENYEZI MUNGU
 */
package com.mycompany.sab;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;


/**
 *
 * @author Muba
 */
class Tafuta {
    private final TreeMap points, maoni, daraja, division;//, totalZaWote; 
   
    public Tafuta(){
        this.maoni = Settings.loadRemarks();
        this.daraja = Settings.loadGrades();
        this.division = Settings.loadDivisions();
        this.points = Settings.loadPoints();
        //this.totalZaWote = new TreeMap();
    }
    
    /**
     * kupata hash key kwa kupitia sha256 algorithm
     * @param neno neno unalotaka kupata hash key yake
     * @return 
     */
    static String hashKey(String neno) {
        return Hashing.sha256().hashString(neno, StandardCharsets.UTF_8).toString();
    }
    
    public String grade(double alama){
        String Daraja = " ";

            Iterator it = daraja.keySet().iterator();

            while(it.hasNext()){
                String s = it.next().toString();
                double d = Double.parseDouble(daraja.get(s).toString());
                
                if(d >= 0 && alama >= d){
                    Daraja = s;
                    break;
                }    
            }
            
            return Daraja;
    }
    
    public int points(ArrayList marks){
        int alama = 0;
        Collections.sort(marks, Collections.reverseOrder());

        if(marks.size() < 7){
            return -3;
        }
        else{
            for(int i = 0; i < 7; i++){
                alama += point(grade((double)marks.get(i)));
            }
            return alama;
        }
    }
    
    /**
    * kutafuta point 
    * @param daraja daraja la ufaulu
    * @return point
    */
    private int point(String daraja){

        if(points.containsKey(daraja)){
           return (int)points.get(daraja);
        }
        else{
            return 0;
        }
    }
    
    public String division(int points){
       
        String d = "INC";
        if(points > 0){
            ArrayList list = new ArrayList(division.keySet());
            Collections.sort(list,Collections.reverseOrder());

            Iterator divisions = list.iterator();

            while(divisions.hasNext()){
                d = divisions.next().toString();

                if(points >= Integer.parseInt(division.get(d).toString())){
                    break;
                }    
            }
        }
        return d;
    }
    
    public double nafasi(double alama, ArrayList alamaZote){
            double nafasi = alamaZote.size();
            Collections.sort(alamaZote, Comparator.reverseOrder());

            int indexYaAlama = alamaZote.indexOf(alama);
            
            if(indexYaAlama+1 < alamaZote.size()){
                double alamaIfuatayo = (Double)alamaZote.get(indexYaAlama+1);
                
                if(alama == alamaIfuatayo){
                    nafasi = indexYaAlama + 1.5;
                }
                else{
                    nafasi = indexYaAlama + 1;
                }                
            }
            
            return nafasi;
        }
    
    public String remarks(String grade){
        if(maoni.containsKey(grade)){
            return maoni.get(grade).toString();
        }
        else{
            return "";
        }
    }
}
