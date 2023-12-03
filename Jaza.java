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
import java.util.Iterator;
import javax.swing.JComboBox;

/**
 *
 * @author Muba
 */
public class Jaza {
    
    enum chakujaza {MADARASA,MIKONDO,MIAKA,MITIHANI,MASOMO,MASOMOMENGINE,CATEGORY}
      
    static void comboBox(JComboBox box, chakujaza jaza, boolean addAll){
        box.removeAllItems();
        
        switch(jaza){
            
            case MIAKA:
                for(int i = 0; i < 5; i++){
                    box.addItem((LocalDate.now().getYear() - i)+"");
                }
            break;
                          
            case MITIHANI:
                Iterator mitihani = Settings.loadExaminations().keySet().iterator();
           
                while(mitihani.hasNext()){
                    box.addItem(mitihani.next().toString());
                }
            break;
             
            case MASOMO:
                Iterator masomo = Settings.loadSubjects().keySet().iterator();
                
                if(addAll){
                  box.addItem("ALL");  
                }
                
                while(masomo.hasNext()){
                    box.addItem(masomo.next().toString());
                }
            break;
            
            case MASOMOMENGINE:
                Iterator masomoMengine = Settings.loadOtherSubjects().keySet().iterator();
                
                if(addAll){
                  box.addItem("ALL");  
                }
                
                while(masomoMengine.hasNext()){
                    box.addItem(masomoMengine.next().toString());
                }
            break;
            
            case MADARASA:
                Iterator madarasa = Settings.loadClassess().iterator();
                
                if(addAll){
                  box.addItem("ALL");  
                }
                
                while(madarasa.hasNext()){
                    box.addItem(madarasa.next().toString());
                }
            break;
            
            case MIKONDO:
                Iterator mikondo = Settings.loadStreams().iterator();
                
                if(addAll){
                  box.addItem("ALL");  
                }
                
                while(mikondo.hasNext()){
                    box.addItem(mikondo.next().toString());
                }
            break;  
            
            case CATEGORY:
                Iterator category = Settings.loadCategories().iterator();
                if(addAll){
                  box.addItem("ALL");  
                }
                
                while(category.hasNext()){
                    box.addItem(category.next().toString());
                }
            break;  
        }
      
    }
}
