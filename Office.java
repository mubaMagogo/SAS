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

import static com.mycompany.sab.Shule.shule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;


/**
 *
 * @author MUBA
 */
public class Office {
    private Mtihani mtihani;
    private Darasa darasa;
    private Mkondo mkondo;
    private TreeMap kamusi;
    private CellStyle style;
    private final Systm system;
    
    public Office(){
       mkondo = new Mkondo(); 
       this.system = new Systm();
    }
    
    public Office(String darasa, String mkondo, Mtihani mtihani){
        this.darasa = shule.getDarasa(darasa);
        this.mkondo = shule.getMkondo(darasa+mkondo);
        this.mtihani = mtihani;
        this.system = new Systm();
    }
    
    public Office(String darasa, String mkondo,TreeMap kamusi){
        this.darasa = shule.getDarasa(darasa);
        this.mkondo = shule.getMkondo(darasa+mkondo);
        this.system = new Systm();
        this.kamusi = kamusi;
    }
    
    public Office(Mtihani mtihani){
        this.mtihani = mtihani;
        this.system = new Systm();
    }
    
    void setKamusi(TreeMap kamusi){
        this.kamusi = kamusi;
    }
     
    void setMtihani(Mtihani mtihani){
        this.mtihani = mtihani;
    }
   
    /**
     * @param obj
     * @param file path file lilipo 
     * @param inputObjects objects za kuset taarifa
     * @return objects baada ya kuseti taarifa
     */
    public TreeMap readExcel(File file, Object obj, ArrayList inputObjects){
        TreeMap map = new TreeMap();
         
        /* safisha data
        if((mkondo.getWanafunzi().size() > 0) && (inputObjects.isEmpty())){
            inputObjects = new ArrayList(mkondo.getWanafunzi().values());
        }
        
        LinkedHashMap headers = new LinkedHashMap();
        ArrayList outputObjects = new ArrayList();
        
        // soma sheet ya mwanzo*/
        sheet = getSheet(file.getPath());
       
        for(int i = 9; i <= sheet.getLastRowNum(); i++){
                        
            try{
                String jina = sheet.getRow(i).getCell(1).getStringCellValue();
                double marks = Double.parseDouble(sheet.getRow(i).getCell(4).toString());
                map.put(jina, marks);
            }
            catch(Exception e){
           
            };
        }
        
        /*
        Iterator <Row> rows = sheet.iterator();
        int i = 0; boolean imejaza = false;
        
        while(rows.hasNext()){
            Iterator <Cell> cells = rows.next().iterator();
                  
            obj = getObject(obj,inputObjects,i);
            
            while(cells.hasNext()){
                Cell cell = cells.next();
                String neno = cell.toString().toUpperCase().trim();
                
                // angalia kama neno lipo ktk kamusi
                if(kamusi.containsKey(neno)){
                    String jinaLaMethod = kamusi.get(neno).toString();
                                     
                    // angalia kama neno linahusu mtu au mwanafunzi
                    if(Kama.linahusu(new Mwanafunzi(), neno) || Kama.linahusu(new Mtu(), neno)){
                        headers.put(cell.getColumnIndex(),jinaLaMethod); 
                    }
                    
                    // angalia kama neno linahusu mtihani
                    if(Kama.linahusu(mtihani,neno)){
                        
                        // angalia kama pakusoma ni cell ya mbele                       
                        if(pakusoma("MBELE", cell)){
                            Cell cellYaMbele = cellYaMbele(cell);
                            String str = cellYaMbele.toString();
                            if(!str.isEmpty()){
                                Manuva.invoke(mtihani, cellYaMbele.getAddress().toString(), jinaLaMethod, Manuva.checkInt(str,jinaLaMethod));
                            }
                        }
                        
                        // angalia kama pakusoma ni cell ya chini
                        if(pakusoma("CHINI",cell)){
                            Cell cellYaChini = cellYaChini(cell);
                            String str = cellYaChini.toString();
                            if(!str.isEmpty()){
                                
                                // hakiki kwanza
                                Manuva.invoke(mtihani, cellYaChini.getAddress().toString(), jinaLaMethod, Manuva.checkInt(str, jinaLaMethod));
                            }
                        }
                    }
                    
                    // angalia kama neno linahusu mkondo
                    if(Kama.linahusu(new Darasa(),neno)){
                        
                        // angalia pakusoma ni cell ya mbele                      
                        if(pakusoma("MBELE",cell)){
                            Cell cellYaMbele = cellYaMbele(cell);
                            String str = cellYaMbele.toString();
                            
                            if(!str.isEmpty()){
                                
                                // hakiki kwanza
                                Manuva.invoke(mkondo, cellYaMbele.getAddress().toString(), jinaLaMethod, Manuva.checkInt(str, jinaLaMethod));
                                mkondo = shule.getMkondo(mkondo.streamFullName());
                            }  
                        }                       
                    }
                }
                
                // kama neno halipo kwenye kamusi
                else if(!neno.isEmpty() && headers.containsKey(cell.getColumnIndex())){
                   
                    Object a,b;
                    String tafsiri = headers.get(cell.getColumnIndex()).toString();

                    if(Kama.linahusu(mtihani, tafsiri.toUpperCase())){  
                        
                        if(headers.get(cell.getColumnIndex()).toString().equals("score")){
                            Double alama;
                            try{
                                alama = Double.parseDouble(neno);
                            }
                            catch(Exception e){
                                alama = -1.0;
                            }
                            
                            Manuva.invoke(mtihani,cell.getAddress().toString(), headers.get(cell.getColumnIndex()).toString(),alama);  
                        }
                    }

                    Object[] parameter = getParameter(headers.get(cell.getColumnIndex()).toString());

                    if(parameter == null){
                        parameter = new Object[1];                           
                        parameter[0] = Manuva.checkInt(neno,tafsiri);
                    }

                    a = somaTaarifa(obj, headers.get(cell.getColumnIndex()).toString(), parameter);
                    b = Manuva.invoke(new Hakiki(), cell.getAddress().toString(), tafsiri, parameter);

                    if((a == null)){
                        Manuva.invoke(obj, cell.getAddress().toString(), tafsiri,parameter);
                        imejaza = true;
                    } 

                }
            }
           
            if(imejaza){
                outputObjects.add(obj);
                i++;
            }
        }*/
        
        return map;//outputObjects;
    }
     
   public void writeExcel(ArrayList inputObjects, File inputFile, File outputFile, String fileName){
        Set masomo = shule.getMasomo();
        int lastCol = 0;
               
        // fungua work book
        sheet = getSheet(inputFile.getPath());      
        marged = sheet.getMergedRegions();
                     
        for(int i = 0; i <= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            
            if(row != null){
                if(row.getLastCellNum() > lastCol){
                    lastCol = row.getLastCellNum();
                }

                for(int j = 0; j < row.getLastCellNum(); j++){

                    Cell cell = row.getCell(j);

                    if(cell != null){

                        String neno = cell.toString().toUpperCase();
                        String address = cell.getAddress().toString();
                        boolean lipoKwenyeKamusi = kamusi.containsKey(neno);
                        
                        // kama halipo kwenye dictionary edit
                        if(!lipoKwenyeKamusi){
                            String[] maneno = neno.split(" ");
                           
                            for (String tempo : maneno) {
                                
                                if (kamusi.containsKey(tempo) && tempo.contains("#")) {
                                    
                                    String tafsiri = kamusi.get(tempo).toString();
                                    
                                    neno = editNeno(shule, tafsiri, neno, tempo);
                                    neno = editNeno(mtihani, tafsiri, neno, tempo);
                                    neno = editNeno(darasa, tafsiri, neno, tempo);
                                    neno = editNeno(mkondo,tafsiri, neno, tempo);
                                    neno = editNeno(system,tafsiri, neno, tempo);
                                }
                            }
                            
                         cell.setCellValue(neno);  
                        }
                        
                        if(lipoKwenyeKamusi){
                            
                            String jinaLaMethod = kamusi.get(neno).toString();
                               
                            // angalia kama linahusu shule
                            if(Kama.linahusu(shule, jinaLaMethod)){
                                Object[] parameter = getParameter(neno);
                                Object ob = Manuva.invoke(shule, address, jinaLaMethod, parameter); 
                                jazaTaarifa(cell,ob);
                            }
                            
                            // kama linahusu somo
                            if(masomo.contains(jinaLaMethod) && mtihani != null){
                                Manuva.invoke(mtihani, address, "subject", jinaLaMethod);
                            }
                            
                            // angalia kama linahusu mtihani
                            if(Kama.linahusu(mtihani, jinaLaMethod) && mtihani != null){
                                Object[] parameter = getParameter(neno);
                                Object ob = Manuva.invoke(mtihani, address, jinaLaMethod, parameter); 
                                jazaTaarifa(cell,ob);
                            }
                            
                            // kama neno linahusu darasa
                            if(Kama.linahusu(darasa,jinaLaMethod) && darasa != null){
                                Object[] parameter = getParameter(neno);
                                Object ob = Manuva.invoke(darasa, address, jinaLaMethod, parameter); 
                                jazaTaarifa(cell, ob);
                            }

                            if(Kama.linahusu(mkondo,jinaLaMethod) && mkondo != null){
                                Object[] parameter = getParameter(neno);
                                Object ob = Manuva.invoke(mkondo, address, jinaLaMethod, parameter); 
                                jazaTaarifa(cell, ob);
                            }

                            // kama linahusu mtu
                            if(Kama.linahusu(new Mtu(), jinaLaMethod) || Kama.linahusu(new Mwanafunzi(), jinaLaMethod) || masomo.contains(jinaLaMethod)){
                               
                                if(masomo.contains(jinaLaMethod)){
                                    jinaLaMethod = "marks";
                                    neno = "score";
                                }
                                                                                                
                                // andaa parameter
                                
                                Object[] parameter = getParameter(jinaLaMethod);
       
                                boolean pakujazaChini = pakujaza("CHINI", cell, jinaLaMethod);
                                boolean pakujazaMbele = pakujaza("MBELE",cell, jinaLaMethod);
                                                              
                                for(int a = 0; a < inputObjects.size(); a++){
                                    Object ob = Manuva.invoke(inputObjects.get(a), address, jinaLaMethod, parameter);
                                    
                                    if(ob != null){ 
                                    
                                        ob = Manuva.checkInt(ob.toString(), jinaLaMethod);
                                        
                                        if(ob != null){
                                            // angalia pakujaza
                                            if(pakujazaChini){

                                                cell = cellYaChini(cell);

                                                //tengeneza style
                                                if(style == null){
                                                   style = cell.getCellStyle(); 
                                                }  

                                                // jaza taarifa
                                                cell.setCellValue(ob.toString());
                                                applyStyle(cell,style,lastCol);

                                                // angalia kama cell ipo ktk range (marged)
                                                if(ipoKwenyeRange(cell)){
                                                    CellRangeAddress range = naombaRange(cell);

                                                    if(range != null){
                                                        int fc = range.getFirstColumn();
                                                        int fr = range.getFirstRow();
                                                        int lc = range.getLastColumn();
                                                        int lr = range.getLastRow();

                                                        range = new CellRangeAddress(fr+1,lr+1,fc,lc);
                                                        marged.add(range);
                                                        sheet.addMergedRegion(range);
                                                    }
                                                }
                                            }
                                            else if(pakujazaMbele){
                                                cell.setCellValue(ob.toString());
                                                cell = cellYaMbele(cell);
                                                applyStyle(cell,style,lastCol);
                                            }
                                            else{
                                                neno = neno.replace(neno, ob.toString());
                                                cell.setCellValue(neno);
                                            } 
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        // ku adjast upana wa columns
        for(int i = 0; i < lastCol; i++){
            sheet.autoSizeColumn(i);
        }

        andikaWorkbook(sheet,outputFile.getPath(), fileName, Msomi.somaExtension(inputFile.getName()));
    }
    
    
    private Object getObject(Object obj, ArrayList inputObjects, int index){
        String jinaLaClass = Msomi.somaExtension(obj.getClass().getName());
        
        if(!inputObjects.isEmpty()){
            obj = inputObjects.get(index);
        }
        else{
            if(jinaLaClass.equals("Mwanafunzi")){
                obj = new Mwanafunzi();
            }
        
            else if(jinaLaClass.equals("Mwalimu")){
                obj = new Mwalimu();
            }
        }
        
        return obj;
    }
    
    private Row getRow(int rowNo){
        Row row = sheet.getRow(rowNo);
        
        if(row == null){
           row = sheet.createRow(rowNo);
        }
      
        return row; 
    } 
    
    private Cell cellYaChini(Cell cell) {

        Cell cellYaChini;
        int gap = 0;
        
        // angalia cell marge
        if(ipoKwenyeRange(cell)){
           CellRangeAddress range = naombaRange(cell);
           
           if(range != null){
              gap = range.getLastRow() - range.getFirstRow();
           }
        }
        
        Row row = getRow(cell.getRowIndex() + gap + 1);
        cellYaChini = row.getCell(cell.getColumnIndex());
        
        if(cellYaChini == null){
            cellYaChini = row.createCell(cell.getColumnIndex());
        }
  
        return cellYaChini;
    }

    private Cell cellYaMbele(Cell cell) {
        
        Cell cellYaMbele;
        
        int gap = 0;
        
        // angalia cell marge
        if(ipoKwenyeRange(cell)){
           CellRangeAddress range = naombaRange(cell);
           
           if(range != null){
              gap = range.getLastColumn() - range.getFirstColumn();
           }
        }
        
        Row row = cell.getRow();
              
        if(row.getLastCellNum() > cell.getColumnIndex() + gap + 1){
            cellYaMbele = row.getCell(cell.getColumnIndex() + gap + 1);
        }
        else{
            cellYaMbele = row.createCell(cell.getColumnIndex() + gap +1);
        }
        
        return cellYaMbele;
    }
   
    private void andikaWorkbook(Sheet sheet, String destination, String fileName, String extension) {
        try {
            FileOutputStream out = new FileOutputStream(destination+"\\"+fileName+"."+extension);
            sheet.getWorkbook().write(out);
            out.close();
        }
        catch (Exception e) {
            
        }
    }
       
    private Object[] getParameter(String neno) {
       
        Object[] parameter = (Object[])null;
        boolean niMtihani = false;
       
 
        if(Manuva.getMajinaYaMethods(new Mwanafunzi()).contains(neno)){
           
            Method[] methods = new Mwanafunzi().getClass().getDeclaredMethods();
            
            for(Method method : methods){
               
                if(neno.equals(method.getName())){
                  
                   Parameter[] parameters = method.getParameters();
                   
                   for(Parameter p : parameters){
                       if(Msomi.somaExtension(p.getType().getName()).equals("Mtihani")){
                           niMtihani = true;
                           break;
                       }
                   }
                }
                if(niMtihani){
                    break;
                }
            }
        }
     
        if(niMtihani){
            parameter = new Object[1];
            parameter [0] = mtihani;
        }
       return parameter;
    }
    
    private Object[] getParameter(Object obj, String jinaLaMethod, String data, boolean write) {
        Object[] parameter = (Object[])null;
        Method method = null;
         
        if(write){
            
            Class<?>[] classParameter = null;
       
            try{
                obj.getClass().getMethod(jinaLaMethod, classParameter);
                return parameter;
            }
            catch(Exception e){}
        }
        
        //tafuta method
        for(Method m : obj.getClass().getSuperclass().getDeclaredMethods()){
            if(m.getName().equals(jinaLaMethod) && m.getParameters().length > 0){
                method = m;
                break;
            }
        }
        
        if(method == null){
            for(Method m : obj.getClass().getDeclaredMethods()){
                if(m.getName().equals(jinaLaMethod) && m.getParameters().length > 0){
                    method = m;
                    break;
                }
            }
        }
            
        if(method != null){
              
            Parameter[] parameters = method.getParameters();

            parameter = new Object[parameters.length];

            for(int i = 0; i < parameters.length; i++){
                String jina = Msomi.somaExtension(parameters[i].getType().getName());

                switch (jina) {
                    case "Mtihani":
                        parameter[i] = mtihani;
                        break;
                    case "Darasa":
                        parameter[i] = darasa;
                        break;
                    case "Mkondo":
                        parameter[i] = mkondo;
                        break;
                    default:
                        parameter[i] = Manuva.checkInt(data, jinaLaMethod);
                        break;
                }
            }  
        }
        
       return parameter;
    }

    public static Sheet getSheet(String jina) {
        Sheet sheet = null;
        try{
            FileInputStream inputFile = new FileInputStream(jina);
            String extension = Msomi.somaExtension(jina);
                       
            if(extension.equals("xls")){
                sheet = new HSSFWorkbook(inputFile).getSheetAt(0);
                
            }
            if(extension.equals("xlsx")){
                sheet = new XSSFWorkbook(inputFile).getSheetAt(0);
               
            }
        }
        catch(Exception e){
            
        }
        return sheet;
    }

    private void applyStyle(Cell cell, CellStyle style, int lastCol) {
        Row r = cell.getRow();
        for(int a = 0; a < lastCol; a++){
           Cell c = r.getCell(a);

            if(c == null){
               c = r.createCell(a);
            }

            c.setCellStyle(style);
        }
                                    
    }
    
    public Object somaTaarifa(Object obj, String jinaLaMethod, Object parameter){
       
        if(parameter == null){
            return Manuva.invoke(obj, "", jinaLaMethod, (Object[]) null);
        }
        else{
            return Manuva.invoke(obj, "", jinaLaMethod, parameter);
        }
    }
    
    private Cell jazaTaarifa(Cell cell, Object ob) {
        
        ob = Manuva.checkInt(ob.toString(), "");

        // jaza taarifa
        if(pakusoma("CHINI", cell)){
            cell = cellYaChini(cell);
            cell.setCellValue(ob.toString());
        }
        else if(pakusoma("MBELE",cell)){
            cell = cellYaMbele(cell);
            cell.setCellValue(ob.toString());
        }
        /*else{
            neno = neno.replace(neno, ob.toString());
            cell.setCellValue(neno);
        }
        */
        return cell;
    }
    
    private boolean pakusoma(String wap, Cell cell){
         boolean jibu = false;
        
        String neno = cell.toString().toUpperCase();
        
        if(Kama.linahusu(new Mwanafunzi(), neno) || Kama.linahusu(new Mtu(), neno)){
            if(wap.equals("CHINI")){
                jibu = true;
            }
        }
        else{
            if(wap.equals("MBELE")){
                jibu = true;
            }
        }
                
        return jibu;
    }
    
    private boolean pakujaza(String wap, Cell cell, String jinaLaMethod){
        
        boolean jibu = false;
        
        String cellMbele = cellYaMbele(cell).toString();
        String cellChini = cellYaChini(cell).toString();
              
        if(Kama.linahusu(new Mwanafunzi(), jinaLaMethod) || Kama.linahusu(new Mtu(), jinaLaMethod) || Manuva.getMajinaYaMethods(new Mwanafunzi()).contains(jinaLaMethod)){            
            if(cellChini.isEmpty() && wap.equals("CHINI")){
                jibu = true;
            }    
        }
        else{
            if(cellMbele.equals("") && wap.equals("CHINI")){
                jibu = true;
            }                
        }
                
        return jibu;
    }
     
    private Sheet sheet;

    private boolean ipoKwenyeRange(Cell cell) {
        boolean b = false;
        
        if(marged != null){
            for(CellRangeAddress adress : marged){
                if(adress.isInRange(cell)){
                   b = true;
                   break;
               }
            }
        }
        
       return b;
    }

    private CellRangeAddress naombaRange(Cell cell) {
        CellRangeAddress address = null;
        
        for(CellRangeAddress adress : marged){
            if(adress.isInRange(cell)){
               address = adress;
               break;
           }
        }
        
        return address;
    }
        
    private String editNeno(Object obj, String tafsiri, String neno, String badili){
        
        if(Kama.linahusu(obj, tafsiri) && obj != null){
            try{
                Object[] parameter = getParameter(obj, tafsiri,neno,true);
                return neno.replace(badili, Manuva.checkInt(Manuva.invoke(obj, "", tafsiri, parameter).toString(),"").toString());
            }
            catch(Exception e){
                Mwanafunzi mwfnz = (Mwanafunzi)obj;
                System.out.println(mwfnz.firstName());
                return neno.replace(badili, "");
            }          
        }
        else if(Kama.linahusuSuper(obj, tafsiri) && obj != null){
            try{
                Object[] parameter = getParameter(obj, tafsiri,neno,true);
                return neno.replace(badili, Manuva.checkInt(Manuva.invoke(obj, "", tafsiri, parameter).toString(),"").toString());
            }
            catch(Exception e){
                return neno.replace(badili, "");
            }       
        }
        else{
            return neno;
        }
    }
    
    
    /**
    * Kujaza word document (MS-WORD)
    * @param inputFile word document yakujaza
    * @param obj aina ya data
    * @param inputObjects data
     * @param dictionaryName dictionary ya report
    * @param outputFile location zitakapo wekwa
    */
    
    public void writeWord(File inputFile, ArrayList inputObjects, File outputFile){
       
        TreeMap mitihani = Settings.loadExaminations();
        
        Iterator objects = inputObjects.iterator();
      
        while(objects.hasNext()){
            Object obj = objects.next();

            // kufungua Word document
            XWPFDocument doc = funguaWord(inputFile); 

            // soma heder kama ipo
            Iterator<XWPFHeader> headers = doc.getHeaderList().iterator();

            // Jaza Heder
            while(headers.hasNext()){
                XWPFHeader header = headers.next();

                Iterator<XWPFParagraph> paragraphs = header.getParagraphs().iterator();

                while(paragraphs.hasNext()){
                   jazaParagraph(paragraphs.next(), obj); 
                }
            }
        
            // jaza jedwali kama lipo 
            Iterator<XWPFTable> majedwali = doc.getTables().iterator(); 

            LinkedHashMap map = new LinkedHashMap();
            
            while(majedwali.hasNext()){

                XWPFTable jedwali = majedwali.next(); 

                // soma vichwa vya habari ktk jedwali
                XWPFTableRow heading = jedwali.getRow(0);

                Iterator<XWPFTableCell> headingCells = heading.getTableCells().iterator();

                int index = 0;
                while(headingCells.hasNext()){

                    XWPFTableCell cell = headingCells.next();

                    String neno = cell.getText().toUpperCase();

                    // angalia kama neno lipo ktk kamusi      
                    if(kamusi.containsKey(neno)){
                        String tafsiri = kamusi.get(neno).toString();
                        map.put(index, tafsiri);
                    }
                    
                    index++;
                } 
                
                // load masomo
                Mwanafunzi mwfnz = (Mwanafunzi)obj;
                Iterator masomo = mwfnz.getMasomo().iterator();
                
                int i = 1;
                while(masomo.hasNext()){
                    String somo = masomo.next().toString();
                    
                    XWPFTableRow row = jedwali.getRow(i);
                    
                    for(Object columnNo : map.keySet()){
                        XWPFTableCell cell = row.getCell((Integer)columnNo);
                        
                        String jinaLaMethod = map.get(columnNo).toString();
                        
                        if(jinaLaMethod.equals("subjectCodes")){
                            cell.setText(somo);
                            mtihani.subject(somo); 
                        }
                        else{
                            if(mitihani.containsKey(jinaLaMethod)){

                                // set jina la mtihani
                                String data = jinaLaMethod;
                                jinaLaMethod = "examName";
                                Object[] parameter = getParameter(mtihani,jinaLaMethod,data,false); 
                                Manuva.invoke(mtihani, "", jinaLaMethod, parameter);

                                jinaLaMethod = "marks";
                                parameter = getParameter(obj,jinaLaMethod,"",false);
                                Object ob = Manuva.invoke(obj, "", jinaLaMethod, parameter);

                                if(ob != null){ 
                                    ob = Manuva.checkInt(ob.toString(), jinaLaMethod);
                                    cell.setText(ob.toString());
                                }
                            }
                            else{
                                Object[] parameter = getParameter(obj,jinaLaMethod,"",false);
                                Object ob = Manuva.invoke(obj, "", jinaLaMethod, parameter);

                                if(ob != null){ 
                                    ob = Manuva.checkInt(ob.toString(), jinaLaMethod);
                                    cell.setText(ob.toString());
                                }
                            }
                        }
                    }
                                    
                    i++;
                }
            }
                         
                
            // soma paragraph
            Iterator<XWPFParagraph> paragraphs = doc.getParagraphs().iterator();
            while(paragraphs.hasNext()){
                jazaParagraph(paragraphs.next(),obj);
            }
              
          
            Mwanafunzi mwfnz = (Mwanafunzi)obj;
            
            tengenezaWord(doc, outputFile.getPath(), mwfnz.fullName());
            
        }
    
    }
    
    private XWPFDocument funguaWord(File inputFile) {
        
        XWPFDocument doc = null;
        try{
            doc = new XWPFDocument(new FileInputStream(inputFile));
        }
        catch(Exception e){}
        return doc;
    }
    
     // Kusoma paragraph na kureplace maneno kama yapo
    private void jazaParagraph(XWPFParagraph paragraph, Object obj){
        
        Iterator<XWPFRun> runs = paragraph.getRuns().iterator();

        while(runs.hasNext()){
            XWPFRun run = runs.next();
            String neno = run.toString().toUpperCase();
            
            // Kupitia key moja moja katika dictionary na kureplace maneno
            
            Iterator<String> keys = kamusi.keySet().iterator();

            while(keys.hasNext()){
                String key = keys.next();

                if(neno.contains(key) && neno.contains("#")){
                   String tafsiri = kamusi.get(key).toString();
                   neno = editNeno(shule, tafsiri, neno, key);
                   neno = editNeno(mtihani, tafsiri, neno, key);
                   neno = editNeno(darasa, tafsiri, neno, key);
                   neno = editNeno(mkondo,tafsiri, neno, key);
                   neno = editNeno(system,tafsiri, neno, key);
                   neno = editNeno(obj, tafsiri, neno, key);
                   run.setText(neno, 0);
                }     
            }
           
            
        }
    }
    
    private void tengenezaWord(XWPFDocument doc, String location, String jinaLaFile) {
       
        try{
            FileOutputStream out = new FileOutputStream(location+"\\"+jinaLaFile+".doc");
            doc.write(out);
            out.close();
            System.out.println("imeandika file "+jinaLaFile);
        }
        catch(Exception e){
           System.out.println("imeshindwa kuandika file "+jinaLaFile);
        }
    }
    
    private void jaza(Cell cell, Object obj, String tafsiri, String neno, boolean b, int lastCol) {
        if(Kama.linahusu(obj, tafsiri) && obj != null){
            //Object[] parameter = getParameter(obj, tafsiri, neno, b);
            //jazaTaarifa(cell, Manuva.invoke(obj, "", tafsiri, parameter), tafsiri, lastCol);
        }
    }
    
    private void jaza(XWPFTableCell cell, Object obj, String tafsiri, String neno){
        
        if(Kama.linahusu(darasa, tafsiri) && darasa != null){
            //Object[] parameter = getParameter(darasa, tafsiri, neno, true);
            //Manuva.invoke(darasa, neno, tafsiri, parameter);
            //darasa = shule.getDarasa(darasa);
        }
        
        if(Kama.linahusu(mkondo, tafsiri) && mkondo != null){
            //Object[] parameter = getParameter(mkondo, tafsiri, neno, true);
            //Manuva.invoke(mkondo, neno, tafsiri, parameter);
            //mkondo = shule.getMkondo(mkondo);
        }
        
        if(Kama.linahusu(mtihani, tafsiri) && mtihani != null){
            //Object[] parameter = getParameter(mtihani, tafsiri, neno, true);
            //Manuva.invoke(mtihani, neno, tafsiri, parameter);
            //mtihani = new Mtihani(mtihani);
        }
        
        if(Kama.linahusu(obj, tafsiri) && obj != null){
            //Object[] parameter = getParameter(obj, tafsiri, neno, true);
            //Object ob = Manuva.invoke(obj, neno, tafsiri, parameter);
            //cell.setText(Manuva.checkInt(ob.toString(), tafsiri).toString());
        }
        
        
    }
            
    
    
    
    
    
    
   

   
    
        
    
    
    
    
    
    
    
    
    
    
    
    
    private List<CellRangeAddress> marged;

    void write(File file, File file0) {
        sheet = getSheet(file.getPath());
        
        for(int i = 6; i < 113; i++){
            Row row = sheet.getRow(i);
            ArrayList alama = new ArrayList(9);
            
            for(int j = 0; j < 9; j++){
                double marks;
                                
                try{
                    marks = row.getCell(2+2*j).getNumericCellValue();
                }
                catch(Exception e){
                    marks = 0;
                } 
                alama.add(marks);
            }
            
            int points = new Tafuta().points(alama);
            String div = new Tafuta().division(points);
            System.out.println(points);
            System.out.println(div);
            row.getCell(22).setCellValue(div);
            row.getCell(23).setCellValue(points);           
        }
        andikaWorkbook(sheet,new File("Sample Files").getPath(),"imesela",Msomi.somaExtension(file.getName()));
        //andikaWorkbook(sheet,file0.getPath(), "", Msomi.somaExtension(file.getName()));
    }

}
