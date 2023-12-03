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
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JMenu;

/**
 *
 * @author Muba
 */
class Settings {
    
    /**
     * ku activate menu
     * @param menu menu unayotaka ku activate
     */
    static void ruhusuMenu(JMenu ... menu){
        for(JMenu m : menu){
            m.setEnabled(true);
        }
    }
    
    /**
     * ku diactivate menu
     * @param menu menu unazotaka ku diactivate
     */
    static void zuiaMenu(JMenu ... menu) {
        for(JMenu m : menu){
            m.setEnabled(false);
        }
    }
    
    public static TreeMap loadDefaultSettings(){
        TreeMap defaultSettings = new TreeMap();
                   
        // Weka data
        defaultSettings.put("EXAMINATIONS", loadExaminations());
        defaultSettings.put("SUBJECTS", loadSubjects());
        defaultSettings.put("GRADES", loadGrades());
        defaultSettings.put("DIVISIONS", loadDivisions());
        defaultSettings.put("POINTS", loadPoints());
        defaultSettings.put("REMARKS", loadRemarks());
        return defaultSettings;
    }
    
    public static ArrayList loadStreams(){
        ArrayList list = new ArrayList(5);
       
        for(int i = 0; i < 8; i++){
            list.add(String.valueOf((char)(65+i)));
        }
        
        return list;
    } // ok
    
    public static ArrayList loadClassess(){
        ArrayList list; int idadi;
       
        if(shule.schoolLevel().startsWith("A")){ 
            idadi = 6;
        }
        
        else if(shule.schoolLevel().startsWith("O")){ 
            idadi = 4;
        }  
        
        else{
            idadi = 7;
        }
        
        list = new ArrayList(idadi);
        for(int i = 1; i <= idadi; i++){
            if(idadi != 7){
                list.add("FORM "+Badili.ktkNambaZaKirumi(i));
            }
            else{
                list.add("STANDARD "+Badili.ktkNambaZaKirumi(i));
            }
        }
        return list; 
    }
        
    public static TreeMap loadGrades(){
       
        TreeMap grades = new TreeMap();
        
        // madaraja kwa A-Level
        if(shule.schoolLevel().startsWith("A")){            
            grades.put("A", 80);
            grades.put("B", 70);
            grades.put("C", 60);
            grades.put("D", 50);
            grades.put("E", 40);
            grades.put("S", 35);
            grades.put("F", 0);
        }
        
        // madaraja kwa O-Level
        if(shule.schoolLevel().startsWith("O")){            
            grades.put("A", 75);
            grades.put("B", 65);
            grades.put("C", 45);
            grades.put("D", 30);
            grades.put("F", 0);
        }
        
        // madaraja kwa msingi
        if(shule.schoolLevel().startsWith("P")){  
            grades.put("A", 41);
            grades.put("B", 31);
            grades.put("C", 21);
            grades.put("D", 11);
            grades.put("E", 0);
        }
        
        return grades;
    } // ok
    
    public static TreeMap loadDivisions(){
        TreeMap divisions = new TreeMap();
        
        // kwa A-Level
        if(shule.schoolLevel().startsWith("A")){ 
            divisions.put("I", 3);
            divisions.put("II", 10);
            divisions.put("III", 13);
            divisions.put("IV", 18);
            divisions.put("O", 20);
        }
        
        // kwa O-Level
        if(shule.schoolLevel().startsWith("O")){ 
            divisions.put("I", 7);
            divisions.put("II", 18);
            divisions.put("III", 22);
            divisions.put("IV", 26);
            divisions.put("O", 34);
        }
        
        // kwa primary
        
        
        return divisions;
    } //OK
    
    public static TreeMap loadPoints(){
       TreeMap points = new TreeMap();
        
        // kwa A-Level
        if(shule.schoolLevel().startsWith("A")){ 
            points.put("A", 1);
            points.put("B", 2);
            points.put("C", 3);
            points.put("D", 4);
            points.put("E", 5);
            points.put("S", 6);
            points.put("F", 7);
        }
        
        // kwa O-Level
        if(shule.schoolLevel().startsWith("O")){ 
            points.put("A", 1);
            points.put("B", 2);
            points.put("C", 3);
            points.put("D", 4);
            points.put("F", 5);
        }
        
        // kwa primary
        
        return points;
    }//OK
    
    public static TreeMap loadRemarks(){
        TreeMap remarks = new TreeMap();
        
        // kwa A-Level
        if(shule.schoolLevel().startsWith("A")){ 
            remarks.put("A", "EXELLENT");
            remarks.put("B", "VERY GOOD");
            remarks.put("C", "GOOD");
            remarks.put("D", "AVERAGE");
            remarks.put("E", "SATISFACTORY");
            remarks.put("S", "SUBSIDIARY");
            remarks.put("F", "FAIL");
        }
        
        // kwa O-Level
        if(shule.schoolLevel().startsWith("O")){ 
            remarks.put("A", "VIZURI SANA");
            remarks.put("B", "VIZURI");
            remarks.put("C", "WASTANI");
            remarks.put("D", "DHAIFU");
            remarks.put("F", "DHAIFU SANA");
        }
        
        // kwa O-Level
        if(shule.schoolLevel().startsWith("P")){ 
            remarks.put("A", "BORA SANA");
            remarks.put("B", "VIZURI SANA");
            remarks.put("C", "VIZURI");
            remarks.put("D", "INARIDHISHA");
        }
        
        // kwa primary
        return remarks;
    } //OK
    
    public static TreeMap loadExaminations(){
        TreeMap examinations = new TreeMap();
         
        if(shule.schoolLevel().startsWith("P")){
            examinations.put("MTIHANI WA ROBO MHULA", 50);
            examinations.put("MTIHANI WA NUSU MHULA", 50);
            examinations.put("MTIHANI WA KUMALIZA MHULA", 50);
        }
        
        else{
            examinations.put("MIDTERM", 50);
            examinations.put("TERMINAL", 50);
            examinations.put("ANNUAL", 50);
        }
        return examinations;
    } //OK
    
    public static TreeMap loadArtsSubjects(){
        TreeMap subjects = loadSubjects();
        if(subjects.containsKey("PHYSICS")){
            subjects.remove("PHYSICS");
        }
        
        if(subjects.containsKey("CHEMISTRY")){
            subjects.remove("CHEMISTRY");
        }
        
        return subjects;
    }
    
    public static TreeMap loadBusinessSubjects(){
        TreeMap subjects = loadArtsSubjects();
        subjects.put("BOOK KEEPING", "062");
        subjects.put("COMMERCE", "062");
        return subjects;
    }
    
    public static TreeMap loadAgricultureSubjects(){
        TreeMap subjects = loadArtsSubjects();
        subjects.put("AGRICULTURAL SCIENCE", "034");
        return subjects;
    }
    
    static TreeMap loadAllSubjects(){
        TreeMap subjects = new TreeMap();
        subjects.putAll(loadSubjects());
        subjects.putAll(loadBusinessSubjects());
        subjects.putAll(loadAgricultureSubjects());
        subjects.putAll(loadOtherSubjects());
        return subjects;
    }
    
    public static TreeMap loadSubjects(){
        TreeMap subjects = new TreeMap();
        
        // kwa A-Level
        if(shule.schoolLevel().startsWith("A")){ 
            subjects.put("GENERAL STUDIES", "111");
            subjects.put("ENGLISH LANGUAGE 1", "122/1");
            subjects.put("ENGLISH LANGUAGE 2", "122/2");
            subjects.put("GEOGRAPHY 1", "113/1");
            subjects.put("GEOGRAPHY 2", "113/2");
            subjects.put("KISWAHILI 1", "121/1");
            subjects.put("KISWAHILI 2", "121/2");
            subjects.put("PHYSICS 1", "131/1");
            subjects.put("PHYSICS 2", "131/2");
            subjects.put("CHEMISTRY 1", "132/1");
            subjects.put("CHEMISTRY 2", "132/2");
            subjects.put("BIOLOGY 1", "133/1");
            subjects.put("BIOLOGY 2", "133/2");
            subjects.put("HISTORY 1", "112/1");
            subjects.put("HISTORY 2", "112/2");
            subjects.put("ECONOMICS 1", "151/1");
            subjects.put("ECONOMICS 2", "151/2");
            subjects.put("COMMERSE 1", "152/1");
            subjects.put("COMMERSE 2", "152/2");
            subjects.put("ACCOUNTANCE 1", "153/1");
            subjects.put("ACCOUNTANCE 2", "153/2");
            subjects.put("BASIC APPLIED MATHEMATICS", "141");
            subjects.put("ADVANCE MATHEMATICS 1", "142/1");
            subjects.put("ADVANCE MATHEMATICS 2", "142/2");
        }
        
        // kwa O-Level
        if(shule.schoolLevel().startsWith("O")){ 
            subjects.put("CIVICS", "011");
            subjects.put("HISTORY", "012");
            subjects.put("GEOGRAPHY", "013");
            subjects.put("KISWAHILI", "021");
            subjects.put("ENGLISH LANGUAGE", "022");
            subjects.put("PHYSICS", "031/1");
            subjects.put("CHEMISTRY", "032/1");
            subjects.put("BIOLOGY", "033");
            subjects.put("BASIC MATHEMATICS", "041");
        }
        
        // kwa msingi
        if(shule.schoolLevel().startsWith("P")){ 
            subjects.put("SCIENCE", "05E");
            subjects.put("MATHEMATICS", "04E");
            subjects.put("KISWAHILI", "01");
            subjects.put("ENGLISH LANGUAGE", "02");
            subjects.put("HISABATI", "04");
            subjects.put("SAYANSI", "05");
            subjects.put("SOCIAL STUDIES", "03E");
            subjects.put("MAARIFA YA JAMII", "01");
        }
        
        return subjects;
    } 
    
    public static TreeMap loadOtherSubjects(){
        TreeMap subjects = new TreeMap();
        subjects.put("BUILDING CONSTRUCTION", "071");
        subjects.put("RADIO AND TV SERVICING", "083");
        subjects.put("MECHANICAL DRAUGHTING", "097");
        subjects.put("ENGINEERING SCIENCE", "035");
        subjects.put("BIBLE KNOWLEDGE", "014");
        subjects.put("ELIMU YA DINI YA KIISLAMU", "015");
        subjects.put("BIOLOGY 2A", "033/2A");
        subjects.put("BIOLOGY 2B", "033/2B");
        subjects.put("BIOLOGY 2C", "033/2C");
        subjects.put("CHEMISTRY 2A", "032/2A");
        subjects.put("CHEMISTRY 2B", "032/2B");
        subjects.put("CHEMISTRY 2C", "032/2C");
        subjects.put("PHYSICS 2A", "031/2A");
        subjects.put("PHYSICS 2B", "031/2B");
        subjects.put("PHYSICS 2C", "031/2C");
        subjects.put("PAINTING AND SIGNWRITING", "076");
        subjects.put("WORKSHOP TECHNOLOGY", "092");
        subjects.put("ARCHITECTURAL DRAUGHTING ELECTRICAL", "072");
        subjects.put("PLANT AND EQUIPMENT MAINTANANCE", "086");
        subjects.put("QUALIFYING TEST", "010");
        subjects.put("SURVEYING", "073");
        subjects.put("ELECTRICAL INSTALLATION", "081");
        subjects.put("FOUNDRY AND BLACKSMITH", "098");
        subjects.put("CARPENTRY AND JOINERY", "074");
        subjects.put("REFRIGERATION AND AIR CONDITIONING", "085");
        subjects.put("LITERATURE IN ENGLISH", "024");
        subjects.put("ADDITIONAL MATHEMATICS", "042");
        subjects.put("MUSIC", "017/1");
        subjects.put("FOOD AND NUTRITION", "051/1");
        subjects.put("PLUMBING", "077");
        subjects.put("AUTO ELECTRICS", "096");
        subjects.put("CHINESE LANGUAGE", "026");
        subjects.put("FINE ART 2", "016/2");
        subjects.put("TEXTILES AND DRESSMAKING 2", "052/2");
        subjects.put("INFORMATION AND COMPUTER STUDIES", "036/1");
        subjects.put("MUSIC 2", "017/2");
        subjects.put("FITTING AND TURNING", "095");
        subjects.put("FINE ART", "016/1");
        subjects.put("PHYSICAL EDUCATION", "018");
        subjects.put("TEXTILES AND DRESSMAKING", "052/1");
        subjects.put("BRICKWORK AND MASONRY", "075");
        subjects.put("ELECTRICAL DRAUGHTING", "084");
        subjects.put("MOTOR VEHICLE MECHANICS", "093");
        subjects.put("INFORMATION AND COMPUTER STUDIES 2", "036/2");
        subjects.put("WELDING AND METAL FABRICATION", "094");
        subjects.put("INFORMATION AND COMPUTER STUDIES", "036");
        subjects.put("AGRICULTURAL SCIENCE 2", "034/2");
        subjects.put("WELDING AND METAL FABRICATION", "094");
        subjects.put("FRENCH LANGUAGE", "023");
        subjects.put("THEATRE ARTS", "019");
        subjects.put("ARABIC LANGUAGE", "025");
        return subjects;
    }
    
    public static TreeSet loadMajinaYaMethods(){
        /*TreeSet methods = new TreeSet(); 
        methods.addAll(Manuva.getMajinaYaMethods(new Mwanafunzi()));
        methods.addAll(Manuva.getMajinaYaMethods(new Mwalimu()));
        methods.addAll(Manuva.getMajinaYaMethods(new Shule())); 
        methods.addAll(Manuva.getMajinaYaMethods(new Mtu()));
        methods.addAll(Manuva.getMajinaYaMethods(new Mtihani()));
        methods.addAll(Manuva.getMajinaYaMethods(new Darasa()));
        methods.addAll(Manuva.getMajinaYaMethods(new Darasa().new Mkondo()));
        return methods;*/
        return null;
    }
    
    /**
     * status kwa ajili ya mifumo ya prem na prems
     * @return default status za mifumo ya prem na prems;
     */
    public static ArrayList loadStatus(){
         
        ArrayList status = new ArrayList();
        
        if(shule.schoolLevel().startsWith("P")){
            
        }
        else{
            status.add("active");
            status.add("truancy");
            status.add("pregnancy");
            status.add("death");
            status.add("indiscipline");
            status.add("not-reported");
            status.add("dropout");
            status.add("transfered out of country");
        }
      
        return status;
    }
    
    public static TreeMap loadDictionaries(){
        TreeMap dictionary = new TreeMap();
       
        //kwajili ya kuandika score sheet
        TreeMap wScoreSheet = new TreeMap();
        wScoreSheet.put("#SCHOOL_NAME","schoolName");
        wScoreSheet.put("SUBJECT:", "subject");
        wScoreSheet.put("EXAM:","examName");
        wScoreSheet.put("TERM:","term");
        wScoreSheet.put("CLASS:","className");
        wScoreSheet.put("STREAM:","streamName");
        wScoreSheet.put("YEAR:","examYear");
        wScoreSheet.put("FULL NAME","fullName");
        wScoreSheet.put("EXAM NO.", "examNo");
        wScoreSheet.put("SEX","sex");
                
        // kwajili ya kusoma score sheet
        TreeMap rScoreSheet = new TreeMap();
        rScoreSheet.put("SUBJECT:", "subject");
        rScoreSheet.put("EXAM:","examName");
        rScoreSheet.put("TERM:","term");
        rScoreSheet.put("CLASS:","className");
        rScoreSheet.put("STREAM:","streamName");
        rScoreSheet.put("YEAR:","examYear");
        rScoreSheet.put("SCORE","score");
        
        // kwa ajili ya kusoma na kujaza templete
        TreeMap templete = new TreeMap();
        templete.put("ADMISSION NO", "admissionNo");
        templete.put("FIRST NAME", "firstName");
        templete.put("MIDDLE NAME", "middleName");
        templete.put("SURNAME", "surname");
        templete.put("SEX", "sex");
        templete.put("DATE OF BIRTH", "dateOfBirth");
        templete.put("CLASS ADMITTED", "classAdmitted");
        templete.put("STREAM", "stream");
        templete.put("YEAR ADMITTED", "yearAdmitted");
        templete.put("PREM NO.", "premNo");
        templete.put("PSLE NO.", "PSLENo");
        templete.put("STATUS", "status");
        templete.put("PSLE YEAR", "PSLEYear");
        
        // Kwaajili ya prems
        TreeMap prems = new TreeMap();

        // data za mfumo
        prems.put("driverName", "webdriver.chrome.driver");
        prems.put("driverLocation", "D:\\SAP\\lib\\chromedriver.exe");
        prems.put("loginUrl", "https://prems.necta.go.tz/prems/");
        prems.put("nUsername", "username");
        prems.put("nPassword", "password");
        prems.put("tLoginForm", "form");
        prems.put("csStatusChooser", "#status_chosen > a > div > b");
        prems.put("csClassChooser", "#form_id_chosen");
        prems.put("xClasses", "//*[@id=\"form_id_chosen\"]/div/ul//li");
        prems.put("xPagination", "/html/body/div/div[1]/div/section[2]/div/div[3]/ul/li");
      
        // data za mwanafunzi
        prems.put("PREM NUMBER", "premNo");
        prems.put("PREM_NUMBER", "premNo");
        prems.put("ADMISSION_NUMBER", "admissionNo");
        prems.put("PSLE_NUMBER", "PSLENo");
        prems.put("FIRST_NAME", "firstName");
        prems.put("FULL NAME", "fullName");
        prems.put("OTHER_NAMES", "middleName");
        prems.put("MIDDLE_NAME", "middleName");
        prems.put("SURNAME", "surname");
        prems.put("DATE_OF_BIRTH", "dateOfBirth");
        prems.put("ID_NUMBER", "idNo");
        prems.put("BIRTH_CERTIFICATE_NO", "birthCertificateNo");
        prems.put("GUARDIAN_NIN", "guardianIdNo");
        prems.put("GUARDIAN_NAME", "guardianName");
        prems.put("GUARDIAN_RELATION", "guardianRelation");
        prems.put("GUARDIAN_EMAIL", "guardinEmail");
        prems.put("GUARDIAN_PHONE", "phoneNumber");
        prems.put("GUARDIAN_OCCUPATION", "guardianOccupation");
        prems.put("GUARDIAN_ADDRESS", "guardianAddress");
        prems.put("GUARDIAN_PHYSICAL_ADDRESS", "guardianPhysicalAddress");
        prems.put("ADDRESS_LINE_1", "addressLine1");
        prems.put("ADDRESS_LINE_2", "addressLine2");
        prems.put("ADDRESS_LINE_3", "addressLine3");
        prems.put("DISTANCE_FROM_HOME", "distanceFromHome");
        prems.put("PHYSICAL_ADDRESS", "physicalAddress");
        prems.put("FORM_ID", "classAdmitted");
        prems.put("FORM_ADMITTED", "classAdmitted");
        prems.put("YEAR_ADMITTED", "yearAdmitted");
        prems.put("REGISTRATION_TYPE", "registrationType");
        prems.put("PSLE_YEAR", "PSLEYear");
        prems.put("SEX", "sex");
        prems.put("STATUS", "status");
        prems.put("PARENTING_STATUS_ID", "parentStatus");
        prems.put("PARENTING_STATUS", "parentStatus");
        prems.put("STREAM", "stream");
        prems.put("IS_REPEATER", "isRepeater");
        prems.put("GUARDIAN_SEX", "guardianSex");
        prems.put("EDUCATION_LEVEL_ID", "guardianEducationLevel");
        prems.put("EDUCATION_LEVEL", "guardianEducationLevel");
        prems.put("REGION_ID", "regionalOfDomicile");
        prems.put("REGION", "regionalOfDomicile");
        prems.put("DISTRICT_ID", "districtOfDomicile");
        prems.put("DISTRICT", "districtOfDomicile");
        prems.put("DOMICILE", "placeOfDomicile");
        prems.put("COUNTRY_ID", "nationality");
        prems.put("COUNTRY", "nationality");
        prems.put("HEALTH_STATUS_CATEGORY_ID", "helthStutus");
        prems.put("HEALTH_STATUS_CATEGORY", "helthStutus");
        prems.put("DIFFICULTIES[_IDS]", "dificultiesStatus");
        prems.put("DISABILITIES[_IDS]", "disabilityStatus");
        prems.put("ACCOMMODATION_ID","accomodation");
        prems.put("DIFFICULTIES", "dificultiesStatus");
        prems.put("DISABILITIES", "disabilityStatus");
        prems.put("ACCOMMODATION","accomodation");
        
        // Kwa ajili ya kusoma na kujaza prems templete
        TreeMap premsTemplete = new TreeMap();
        premsTemplete.put("#SCHOOL_NAME", "schoolFullName");
        premsTemplete.put("ADMISSIONNO", "admissionNo");
        premsTemplete.put("FIRSTNAME", "firstName");
        premsTemplete.put("MIDDLENAME", "middleName");
        premsTemplete.put("SURNAME", "surname");
        premsTemplete.put("SEX", "sex");
        premsTemplete.put("DATEOFBIRTH", "dateOfBirth");
        premsTemplete.put("BIRTHCERTIFICATENO","birthCertificateNo");
        premsTemplete.put("CLASSADMITTED","classAdmitted");
        premsTemplete.put("YEARADMITTED", "yearAdmitted");
        premsTemplete.put("STREAM","stream");
        premsTemplete.put("PREMNO","premNo");
        premsTemplete.put("REGISTRATIONTYPE","registrationType");
        premsTemplete.put("STATUS","status");
        premsTemplete.put("PARENTSTATUS","parentStatus");
        premsTemplete.put("PSLENO", "PSLENo");
        premsTemplete.put("PSLEYEAR", "PSLEYear");
        premsTemplete.put("FTNANO", "FTNANo");
        premsTemplete.put("FTNAYEAR", "FTNAYear");
        premsTemplete.put("IDNO","idNo");
        premsTemplete.put("ISREPEATER","isRepeater");
        premsTemplete.put("ADDRESSLINE1","addressLine1");
        premsTemplete.put("ADDRESSLINE2","addressLine2");
        premsTemplete.put("ADDRESSLINE3","addressLine3");
        premsTemplete.put("DISTANCEFROMHOME","distanceFromHome");
        premsTemplete.put("PHYSICALADDRESS","physicalAddress");
        premsTemplete.put("REGIONALOFDOMICILE","regionalOfDomicile");
        premsTemplete.put("DISTRICTOFDOMICILE","districtOfDomicile");
        premsTemplete.put("PLACEOFDOMICILE","placeOfDomicile");
        premsTemplete.put("NATIONALITY","nationality");
        premsTemplete.put("HEALTHSTATUS","healthStutus");
        premsTemplete.put("DIFFICULTIESSTATUS","difficultiesStatus");
        premsTemplete.put("DISABILITIESSTATUS","disabilitiesStatus");
        premsTemplete.put("ACCOMODATION","accomodation");
        premsTemplete.put("GUARDIANNAME","guardianName");
        premsTemplete.put("GUARDIANSEX","guardianSex");
        premsTemplete.put("GUARDIANIDNO","guardianIdNo");
        premsTemplete.put("GUARDIANRELATION","guardianRelation");
        premsTemplete.put("GUARDIANEMAIL","guardianEmail");
        premsTemplete.put("PHONENUMBER","phoneNumber");
        premsTemplete.put("GUARDIANOCCUPATION","guardianOccupation");
        premsTemplete.put("GUARDIANADDRESS","guardianAddress");
        premsTemplete.put("GUARDIANPHYSICALADDRESS","guardianPhysicalAddress");
        premsTemplete.put("GUARDIANEDUCATIONLEVEL","guardianEducationLevel");
        premsTemplete.put("CATEGORY", "category");
        premsTemplete.put("SUBJECTCODES", "subjectCodes");
        
        // kwa ajili ya kusoma na kuandika Matokeo
        TreeMap results = new TreeMap();
        results.put("#SCHOOL_NAME","schoolName");
        results.put("#CLASS_NAME", "className");
        results.put("#EXAM_NAME", "examName");
        results.put("#EXAM_MONTH", "systemMonthText");
        results.put("#EXAM_YEAR", "systemYear");
        results.put("CAND NO.", "candidateNo");
        results.put("CANDIDATE'S NAME", "fullName");
        results.put("SEX", "sexInitial");
        results.put("STREAM","stream");
        results.put("GRADE", "grade");
        results.put("AVERAGE", "average");
        results.put("AV GRADE", "averageGrade");
        results.put("DIVISION", "division");
        results.put("POINTS", "points");
        results.put("ENGLISH", "ENGLISH LANGUAGE");
        results.put("B/MATH", "BASIC MATHEMATICS");
        results.put("ICS", "INFORMATION AND COMPUTER STUDIES");
        results.put("CIVICS", "CIVICS");
        results.put("POSITION", "overRallPosition");
        
        // kwa ajili ya kujaza tables
        TreeMap table = new TreeMap();
        table.put("Prem #", "premNo");
        table.put("First Name", "firstName");
        table.put("Middle Name", "middleName");
        table.put("Surname", "surname");
        table.put("Sex", "sex");
        table.put("Admission #", "admissionNo");
        table.put("Status", "status");
        table.put("Class", "currentClass");
        table.put("Stream", "stream");
        table.put("Age", "age");
                
        // masomo
        Iterator subjects = loadSubjects().keySet().iterator();
        while(subjects.hasNext()){
            String key = subjects.next().toString();
            results.put(key, key);
        }
                    
        // kwa ajili ya kuandika report
        TreeMap reports = new TreeMap();
        reports.put("#SN","schoolName");
        reports.put("#PN", "schoolPhoneNo");
        reports.put("#SA", "schoolAddress");
        reports.put("#SR", "schoolRegion");
        reports.put("#SD", "systemDate");
        reports.put("#FN", "fullName");
        reports.put("#CC", "currentClass");
        reports.put("#TM","term");
        reports.put("SOMO", "subjectCodes");
        reports.put("MAJARIBIO", "MIDTERM");
        reports.put("MITIHANI", "TERMINAL");
        reports.put("WASTANI", "reportAverage");
        reports.put("DARAJA", "reportGrade");
        reports.put("MAONI", "reportRemarks");
        reports.put("NAFASI YA", "positionReport");
        reports.put("KATI YA", "satReport");
        reports.put("#JA", "totalReport");
        reports.put("#KA", "outOfMarks");
        reports.put("#WS", "reportGrandAverage");
        reports.put("#NMH", "grandPositionReport");
        reports.put("#KY", "totalSat");
        reports.put("#DIV", "divisionReport");
        reports.put("#PTS", "pointsReport");
        
        // masomo
        Iterator subject = loadSubjects().keySet().iterator();
        while(subject.hasNext()){
            String key = subject.next().toString();
            reports.put(key, key);
        }
                  
        // weka kwenye dictionary
        dictionary.put("WSCORE_SHEET", wScoreSheet);
        dictionary.put("RSCORE_SHEET", rScoreSheet);
        dictionary.put("TEMPLETES", templete);
        dictionary.put("RESULTS", results);
        dictionary.put("REPORTS", reports);
        dictionary.put("PREMS", prems);
        dictionary.put("PREMS_TEMPLETE", premsTemplete);
        dictionary.put("TABLE", table);
        
        return dictionary;
    }
    
    static TreeSet loadCategories() {
        TreeSet categories = new TreeSet();
        categories.add("SCIENCE");
        categories.add("ARTS");
        categories.add("BUSINESS");
        categories.add("AGRICULTURE");
        return categories;
    }
}
