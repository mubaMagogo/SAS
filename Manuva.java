/*
 * NAPENDA KUMSHUKURU MWENYEZI MUNGU KWA ZAWAIDI YA UHAI
 * HAKIKA HAPANA MOLA APASAE KUABUDIWA NA KUSUJUDIWA ISIPOKUWA MWENYEZI MUNGU MUUMBA WA VYOTE
 * AKILI, MAARIFA NA VIPAWA VYATOKA KWAKE.
 * 
 * KWA NJIA YOYOTE ILIOPATA CODE HIZI, UNARUHUSIWA KUZITUMIA KWA NJIA YA HALALI
 * USIFUTE MISTARI MITATU YA MWANZO YA KUMTUKUZA MWENYEZI MUNGU
 */
package com.mycompany.sab;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JComboBox;

/**
 *
 * @author Muba
 */
public class Manuva {

    /**
     * ku call method katika object
     * @param object object unayotaka ku call method
     * @param cellAdress
     * @param jinaLaMethod jina la method
     * @param args parameta 
     * @return object baada ya ku call; 
     */
    public static Object invoke(Object object, String cellAdress, String jinaLaMethod, Object ... args){
        
        Object obj = null;
        Class<?>[] classParameter = null;
        Method method;
        
        if(args != null){
            classParameter = new Class<?>[args.length];

            for(int i = 0; i < args.length; i++){
                try{
                    classParameter[i] = args[i].getClass();
                }
                catch(Exception e){
                    Mjumbe.oneshaUjumbe("Fail to update data "+cellAdress+"\n"+"Reason: Incompactible data types");
                    break;
                }
            }
        }
        
        try{
            method = object.getClass().getMethod(jinaLaMethod, classParameter);
            obj = method.invoke(object, args);
        }
        catch(Exception e){
            e.printStackTrace();
        }
      
        return obj;
    }

    static Object checkInt(String str, String jinaLaMethod){
        Object obj = "ABS"; 
        
        if(jinaLaMethod.equals("candidateNo") || jinaLaMethod.equals("premNo")){
            return str;
        }
        else{
            try{

                double d = Double.parseDouble(str);
                int i = (int)d;

                if(d >= 0){
                    if(d > i){
                        obj = d;
                    }
                    else{
                        obj = i;
                    }
                }
                else if(d == -1.0){
                    obj = "";
                }
                else if(d == -3.0){
                    obj = "INC";
                }

            }
            catch(Exception e){
                if(jinaLaMethod.equals("score")){
                    obj = "INC";
                }
                else{
                    obj = str;
                }

            }
        }
        return obj;
    }
    
    public static void jazaComboBox(JComboBox<String> box, ArrayList chakujaza, boolean naAll){
        box.removeAllItems();
        
        Iterator vyakujaza = chakujaza.iterator();
        
        if(naAll){
            box.addItem("ALL");  
        }
        
        while(vyakujaza.hasNext()){
            box.addItem(vyakujaza.next().toString());
        }
    }
    
    public static void jazaComboBox(JComboBox<String> box, String chakujaza, boolean naAll){
       
        box.removeAllItems();
        
        switch(chakujaza){
            
            case "MIAKA":
                for(int i = 0; i < 5; i++){
                    box.addItem((LocalDate.now().getYear() - i)+"");
                }
            break;
                
            case "METHODS":
                Iterator methods = Settings.loadMajinaYaMethods().iterator();
                
                while(methods.hasNext()){
                    box.addItem(methods.next().toString());
                }
                
                Iterator mas = Settings.loadSubjects().keySet().iterator();
                while(mas.hasNext()){
                    box.addItem(mas.next().toString());
                }
                
                Iterator exams = Settings.loadExaminations().keySet().iterator();
                while(exams.hasNext()){
                    box.addItem(exams.next().toString());
                }
                
            break;
             
            case "MITIHANI":
                Iterator mitihani = Settings.loadExaminations().keySet().iterator();
           
                while(mitihani.hasNext()){
                    box.addItem(mitihani.next().toString());
                }
            break;
             
            case "MASOMO":
              
                Iterator masomo = Settings.loadSubjects().keySet().iterator();
                
                if(naAll){
                  box.addItem("ALL");  
                }
                
                while(masomo.hasNext()){
                    box.addItem(masomo.next().toString());
                }
            break;
            
            case "MASOMOMENGINE":
                Iterator masomoMengine = Settings.loadOtherSubjects().keySet().iterator();
                
                if(naAll){
                  box.addItem("ALL");  
                }
                
                while(masomoMengine.hasNext()){
                    box.addItem(masomoMengine.next().toString());
                }
            break;
            
            case "MADARASA":
                Iterator madarasa = Settings.loadClassess().iterator();
                
                if(naAll){
                  box.addItem("ALL");  
                }
                
                while(madarasa.hasNext()){
                    box.addItem(madarasa.next().toString());
                }
            break;
            
            case "MIKONDO":
                Iterator mikondo = Settings.loadStreams().iterator();
                
                if(naAll){
                  box.addItem("ALL");  
                }
                
                while(mikondo.hasNext()){
                    box.addItem(mikondo.next().toString());
                }
            break;  
            
            case "CATEGORY":
                Iterator category = Settings.loadCategories().iterator();
                if(naAll){
                  box.addItem("ALL");  
                }
                
                while(category.hasNext()){
                    box.addItem(category.next().toString());
                }
            break;  
        }
    }
    
    /**
     * kupata majina ya method
     * @param obj object 
     * @return majina ya method 
     */
    public static HashSet getMajinaYaMethods(Object obj){
        HashSet set  = new HashSet();
        
        Method[] methods = obj.getClass().getDeclaredMethods();
        
        for (Method method : methods) {
            boolean s = method.getName().startsWith("get");
            boolean g = method.getName().startsWith("get");
            boolean a = method.getName().startsWith("access");
            boolean aa = method.getName().startsWith("add");
            boolean r = method.getName().startsWith("remove");
            
            if(!(s || g || a || aa || r)){
                set.add(method.getName());
            }
        }
        
        return set;
    }
}
