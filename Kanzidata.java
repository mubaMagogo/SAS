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
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 *
 * @author Muba
 */
public class Kanzidata {
    
    // variables
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String URL = "jdbc:derby:kanzidata;create = true";    
    private static Connection con = null;
    private static Statement st = null;

    // constructor
    public Kanzidata(){
        connect();
    }
    
    /**
     * Fanya connection na kanzidata
     */
    private void connect() {
        try{
            Class.forName(DRIVER).getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(URL);
        }
        catch(Exception e){
            e.printStackTrace();
            Mjumbe.log(e,"Kanzidata-connect");
        }
    }
    
    /**
    * ku disconnect kanzidata
    */
    static void disconnect() {
        try {
            con.close();
        }
        catch (SQLException ex) {
            Mjumbe.log(ex, "Kanzidata-disconnect");
        }
    }

    /**
     * Kucheck kama table ipo ktk kanzidata
     * @param jinaLaTable jina la table unayo check
     * @return 
     */
    static boolean tableIpo(String jinaLaTable) {
        boolean jibu = false;
                
        try{
            st = con.createStatement();
            DatabaseMetaData metaData = con.getMetaData();
            
            ResultSet tables = metaData.getTables(null, null, jinaLaTable.toUpperCase(), null);
            jibu = tables.next();
        }
        catch(SQLException e){
            Mjumbe.log(e, "Kanzidata-tableIpo");
        }
        return jibu;
    }

    /**
     * kutengeneza table kwa ajili ya mtumiaji
     */
    void tengenezaTableUsersInfo() {
        try{
            st = con.createStatement();
            st.execute("CREATE TABLE Users ("
                    + "username varchar(100) primary key,"
                    + "password varchar(300),"
                    + "authkey varchar(256) "
                    +")");
            System.out.println("imetengeneza table Users");
        }
        catch(Exception e){
            Mjumbe.log(e, "tengenezaTableUsersInfo");
        }
    }
    
    /**
     * tengeneza table kwaajili ya taarifa za shule
     */
    void tengenezaTableSchoolInfo() {
        try{
            st = con.createStatement();
            st.execute("CREATE TABLE schoolInfo ("
                    + "schoolName varchar(50) primary key,"
                    + "schoolRegion varchar(50),"
                    + "schoolDistrict varchar(50),"
                    + "schoolLevel varchar(15),"
                    + "schoolAddress integer,"
                    + "schoolPhoneNumber varchar(10),"
                    + "centerNo varchar(6),"
                    + "regNo varchar(15)"
                    +")");
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-tengenezaTableSchoolInfo");
        }
    }
    
    void tengenezaTablePrems(){
        try{
            st = con.createStatement();
            st.execute("CREATE TABLE prems ("
                    +"driverName varchar(50) primary key,"
                    +"driverPath varchar(60))"
            );
        }
        catch(Exception e){
            Mjumbe.log(e,"Kanzidata-tengenezaTablePrems");
        }
    }
    
    /**
     * kufuta table ktk database
     * @param jinaLaTable jina la table
     */
    static void deleteTable(String jinaLaTable) {
        if(tableIpo(jinaLaTable)){
            try{
                Statement st = con.createStatement();
                String qry = "DROP TABLE "+jinaLaTable;
                st.execute(qry);
            }
            catch(Exception e){
                Mjumbe.log(e, "Kanzidata-deleteTable");
            }
        }
        else{
            System.out.println("Hakuna table yenye jina "+jinaLaTable);
        }
    }  

    /**
     * Kusoma taarifa za shule ktk kanzidata
     */
    void loadTaarifaZaShule() {
        String query = "SELECT * FROM schoolInfo";
              
        try {
            st = con.createStatement();
            
            ResultSet set = st.executeQuery(query);
            
            while(set.next()){
                shule.schoolName(set.getString("schoolName"));
                shule.schoolRegion(set.getString("schoolRegion"));
                shule.schoolDistrict(set.getString("schoolDistrict"));
                shule.schoolLevel(set.getString("schoolLevel"));
                shule.schoolAddress(set.getInt("schoolAddress"));
                shule.schoolPhoneNo(set.getString("schoolPhoneNumber"));
                shule.centerNo(set.getString("centerNo"));
                shule.regNo(set.getString("regNo"));
            }
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-loadTaarifaZaShule");
        }
    }

    void loadMadarasa() {
        String query = "SELECT * FROM CLASSINFO";
              
        try {
            st = con.createStatement();
            
            ResultSet set = st.executeQuery(query);
            
            while(set.next()){
                Mkondo darasa = new Mkondo();
                darasa.className(set.getString("className"));
                darasa.setCategory(set.getString("category"));
                shule.addDarasa(darasa);
                shule.addJinaLaDarasa(darasa.className());
            }
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-loadMadarasa");
        }
    }

    void loadMikondo() {
        String query = "SELECT * FROM streamInfo";
              
        try {
            st = con.createStatement();
            
            ResultSet set = st.executeQuery(query);
            
            while(set.next()){
                Mkondo mkondo = new Mkondo(set.getString("stream"));
                mkondo.className(set.getString("class"));
                mkondo.setCategory(set.getString("category"));
                shule.addMkondo(mkondo);
            }
        }
        catch(Exception e){
            System.out.println("Imeshindwa kusoma table streamInfo \n"+e.getMessage());
        }
    }

    void loadPrems(){
        String query = "SELECT * FROM PREMS";
        
        try{
            st = con.createStatement();
            ResultSet set = st.executeQuery(query);
            
            while(set.next()){
                PremsBot.driverName(set.getString("driverName"));
                PremsBot.driverPath(set.getString("driverPath"));
            }
        }
        catch(Exception e){
            System.out.println("imeshindwa ku load prems \n"+e.getMessage());
        }
    }
    
    void loadWanafunzi() {
        TreeMap dictionary = (TreeMap)Settings.loadDictionaries().get("PREMS_TEMPLETE");
        
        LinkedHashMap map = getColumnNames("STUDENTINFO"); 
       
        String query = "SELECT * FROM studentInfo";
                     
        try {
           
            st = con.createStatement();
            
            ResultSet set = st.executeQuery(query);
            
            while(set.next()){
                Mwanafunzi mwfnz = new Mwanafunzi();
                
                Iterator columnNames = map.keySet().iterator();
                
                while(columnNames.hasNext()){
                    String columnName = columnNames.next().toString();
                    String dataType = map.get(columnName).toString();
                    
                    Object data;
                    if(dataType.equals("INTEGER")){
                        data = set.getInt(columnName);
                    }
                    else{
                        data = set.getString(columnName);
                    }
                  
                    String methodName = dictionary.get(columnName).toString();
                                
                    if(data != null){
                        Manuva.invoke(mwfnz, "", methodName, data);
                        
                    }
                }
                
                Mkondo mkondo = shule.getMkondo(mwfnz.currentClass()+mwfnz.stream());
                if(mkondo != null){
                    mkondo.addMwanafunzi(mwfnz);
                    shule.addMasomo(mwfnz.getMasomo());
                }
            }         
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-loadWanafunzi");
        }
    }

    /**
     * Kuhakiki kama ni kweli mtumiaji ndie mmiliki
     * @param username username
     * @param password namba ya siri
     * @param authkey authentication key
     * @return ndio au sio
     */
    boolean login(String username, String password, String authkey) {
                
        try{
            String qry = "SELECT * FROM Users WHERE username = '"+username+"'" +" AND "
                    + "password = '"+password+"' AND authkey = '"+authkey+"'";
             
            st = con.createStatement();
            return st.executeQuery(qry).next();
            
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-login");
            return false;
        }
    }

    /**
     * update taarifa za mtumiaji
     * @param username username
     * @param password neno la siri
     * @param authkey authentication key
     */
    void updateTaarifaZaUsers(String username, String password, String authkey) {
        String query = "SELECT * FROM Users";
                
        try {
            st = con.createStatement();
            
            ResultSet set = st.executeQuery(query);
            
            if(set.next()){
                
                // update username, password na authkey
                try{
                    PreparedStatement ps = con.prepareStatement("UPDATE Users SET username = ?,"
                            + "password = ?, authkey = ? WHERE username = '"+set.getString("username")+"'");

                    ps.setString(1, username);
                    ps.setString(2, password);
                    ps.setString(3, authkey);

                    ps.executeUpdate();
                }
                catch(Exception e){
                    Mjumbe.log(e, "Kanzidata-updateTaarifaZaUsers");
                }
            }
            
            // insert username, password na authkey
            else{
                ingizaTaarifaZaUsers(username, password, authkey);
            }
            
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-updateTaarifaZaUsers");
        }        
    }
    
    /**
     * hifadhi taarifa za mtumiaji katika data base
     * @param username username
     * @param password namba ya siri
     * @param authkey authentic key
     */
    void ingizaTaarifaZaUsers(String username, String password, String authkey) {
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO Users (username, password, authkey)"
                    + " VALUES (?,?,?)");

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, authkey);
            
            ps.execute();
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-ingizaTaarifaZaUsers");
        }
    }
    
    void ingizaTaarifaZaPrems(){
        try{
            PreparedStatement ps = con.prepareStatement("INSERT INTO PREMS (driverName, driverPath)"
                    + " VALUES (?,?)");

            ps.setString(1, PremsBot.driverName());
            ps.setString(2, PremsBot.driverPath());
           
            ps.execute();
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-ingizaTaarifaZaPrems");
            try{
                PreparedStatement ps = con.prepareStatement("UPDATE PREMS SET driverName = ?,"
                        +"driverPath = ? WHERE driverName = '"+PremsBot.driverName()+"'");
                ps.setString(1, PremsBot.driverName());
                ps.setString(1, PremsBot.driverPath());
            }
            catch(Exception f){
                Mjumbe.log(f, "Kanzidata-updatePrems");
            }
        }
    }

    /**
     * update taarifa za shule ktk kanzidata
     * @param schoolName jina la shule
     */
    void updateTaarifaZaShule(String schoolName) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE schoolInfo SET schoolName = ?,"
                    + "schoolRegion = ?, schoolDistrict = ?, schoolLevel = ?, schoolAddress = ?,"
                    + "schoolPhoneNumber = ?, centerNo = ?, regNo = ? WHERE schoolName = '"+schoolName+"'");
                                                                                                         
            ps.setString(1, shule.schoolName());
            ps.setString(2, shule.schoolRegion());
            ps.setString(3, shule.schoolDistrict());
            ps.setString(4, shule.schoolLevel());
            ps.setInt(5, shule.schoolAddress());
            ps.setString(6, shule.schoolPhoneNo());
            ps.setString(7, shule.centerNo());
            ps.setString(8, shule.regNo());

            ps.executeUpdate();
        }
        catch (Exception ex) {
            Mjumbe.log(ex, "Kanzidata-updateTaarifaZaShule");
        }
    }

    /**
     * ingiza taarifa za shule ktk kanzidata
     */
    void ingizaTaarifaZaShule() {
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO SchoolInfo (schoolName, schoolRegion,"
                    + "schoolDistrict,schoolLevel,schoolAddress,schoolPhoneNumber,centerNo,regNo) VALUES (?,?,?,?,?,?,?,?)");

            ps.setString(1, shule.schoolName());
            ps.setString(2, shule.schoolRegion());
            ps.setString(3, shule.schoolDistrict());
            ps.setString(4, shule.schoolLevel());
            ps.setInt(5, shule.schoolAddress());
            ps.setString(6, shule.schoolPhoneNo());
            ps.setString(7, shule.centerNo());
            ps.setString(8, shule.regNo());

            ps.execute();
        }
        catch (Exception ex) {
           Mjumbe.log(ex, "Kanzidata-ingizaTaarifaZaShule");
        }
    }

    /**
     * save taaarifa za mwanafunzi
     * @param mwfnz mwanafunzi
     */
    void addMwanafunzi(Mwanafunzi mwfnz) {
        
        if(tableIpo("studentInfo")){
            ingizaTaarifaZaMwanafunzi(mwfnz);
        }
        else{
           tengenezaTableStudentInfo();
           ingizaTaarifaZaMwanafunzi(mwfnz);
        }
    }

    /**
     * hifadhi taarifa za wanafunzi ktk table ya taarifa
     * @param mwfnz mwanafunzi
     */
    private void ingizaTaarifaZaMwanafunzi(Mwanafunzi mwfnz) {
       
        try {

            PreparedStatement ps = con.prepareStatement("INSERT INTO studentInfo (premNo,admissionNo,firstName,middleName,surname,sex,"
                    + "dateOfBirth,birthCertificateNo,classAdmitted,yearAdmitted,stream,category,registrationType,status,parentStatus,PSLENo,PSLEYear,"
                    + "FTNANo,FTNAYear,idNo,isRepeater,addressLine1,addressLine2,addressLine3,distanceFromHome,physicalAddress,regionalOfDomicile,"
                    + "districtOfDomicile,placeOfDomicile,nationality,healthStatus,difficultiesStatus,disabilitiesStatus,accomodation,guardianName,"
                    + "guardianSex,guardianIdNo,guardianRelation,guardianEmail,phoneNumber,guardianOccupation,guardianAddress,guardianPhysicalAddress,"
                    + "subjectCodes,guardianEducationLevel)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 

            ps.setString(1, mwfnz.premNo());
            ps.setInt(2, mwfnz.admissionNo());
            ps.setString(3, mwfnz.firstName());
            ps.setString(4, mwfnz.middleName());
            ps.setString(5, mwfnz.surname());
            ps.setString(6, mwfnz.sex());
            ps.setString(7, mwfnz.dateOfBirth());
            ps.setString(8, mwfnz.birthCertificateNo());
            ps.setString(9, mwfnz.classAdmitted());
            ps.setInt(10, mwfnz.yearAdmitted());
            ps.setString(11, mwfnz.stream());
            ps.setString(12, mwfnz.category());
            ps.setString(13, mwfnz.registrationType());
            ps.setString(14, mwfnz.status());  
            ps.setString(15, mwfnz.parentStatus());
            ps.setString(16, mwfnz.PSLENo());
            ps.setInt(17, mwfnz.PSLEYear());
            ps.setString(18, mwfnz.FTNANo());
            ps.setInt(19, mwfnz.FTNAYear());
            ps.setString(20, mwfnz.idNo());
            ps.setString(21, mwfnz.isRepeater());
            ps.setString(22, mwfnz.addressLine1());
            ps.setString(23, mwfnz.addressLine2());
            ps.setString(24, mwfnz.addressLine3());
            ps.setInt(25, mwfnz.distanceFromHome());
            ps.setString(26, mwfnz.physicalAddress());
            ps.setString(27, mwfnz.regionalOfDomicile());
            ps.setString(28, mwfnz.districtOfDomicile());
            ps.setString(29, mwfnz.placeOfDomicile());
            ps.setString(30, mwfnz.nationality());
            ps.setString(31, mwfnz.healthStutus());
            ps.setString(32, mwfnz.difficultiesStatus());
            ps.setString(33, mwfnz.disabilitiesStatus());
            ps.setString(34, mwfnz.accomodation());
            ps.setString(35, mwfnz.guardianName());
            ps.setString(36, mwfnz.guardianSex());
            ps.setString(37, mwfnz.guardianIdNo());
            ps.setString(38, mwfnz.guardianRelation());
            ps.setString(39, mwfnz.guardianEmail());
            ps.setString(40, mwfnz.phoneNumber());
            ps.setString(41, mwfnz.guardianOccupation());
            ps.setString(42, mwfnz.guardianAddress());
            ps.setString(43, mwfnz.guardianPhysicalAddress());
            ps.setString(44, mwfnz.subjectCodes());
            ps.setString(45, mwfnz.guardianEducationLevel());
            ps.execute();
        }
        
        catch (SQLException ex) {
            Mjumbe.log(ex, "Kanzidata-ingizaTaarifaZaMwanafunzi");
        }
    }

    /**
     * tengeneza table kwa ajili ya taarifa za wanafunzi
     */
    private void tengenezaTableStudentInfo() {
        try{
            st = con.createStatement();
            st.execute("CREATE TABLE studentInfo ("
            +"premNo varchar(15) primary key,"
            +"admissionNo integer,"
            +"firstName varchar(30),"
            +"middleName varchar(30),"
            +"surname varchar(30),"
            +"sex varchar(6),"
            +"dateOfBirth varchar(25),"
            +"birthCertificateNo varchar(30),"
            +"classAdmitted varchar(20),"
            +"yearAdmitted integer,"
            +"stream varchar(1),"
            + "category varchar(15),"
            +"registrationType varchar(30),"
            +"status varchar(15),"
            +"parentStatus varchar(40),"
            +"PSLENo varchar(30),"
            +"PSLEYear integer,"
            +"FTNANo varchar(15),"
            +"FTNAYear integer,"
            +"idNo varchar(4),"
            +"isRepeater varchar(3),"
            +"addressLine1 varchar(15),"
            +"addressLine2 varchar(15),"
            +"addressLine3 varchar(15),"
            +"distanceFromHome integer,"
            +"physicalAddress varchar(15),"
            +"regionalOfDomicile varchar(30),"
            +"districtOfDomicile varchar(30),"
            +"placeOfDomicile varchar(30),"
            +"nationality varchar(25),"
            +"healthStatus varchar(30),"
            +"difficultiesStatus varchar(15),"
            +"disabilitiesStatus varchar(15),"
            +"accomodation varchar(18),"
            +"guardianName varchar(18),"
            +"guardianSex varchar(6),"
            +"guardianIdNo varchar(20),"
            +"guardianRelation varchar(15),"
            +"guardianEmail varchar(20),"
            +"phoneNumber varchar(10),"
            +"guardianOccupation varchar(20),"
            +"guardianAddress varchar(20),"
            +"guardianPhysicalAddress varchar(20),"
            +"subjectCodes varchar(60),"
            +"guardianEducationLevel varchar(15))");
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-tengenezaTableStudentInfo");
        }
    }

    /**
     * Ku update taarifa za mwanafunzi kwenye kanzidata ya wanafunzi
     * precondition jina la method ktk object mwfnz ilio athiriwa ni sawa na title ya column kwenye kanzidata
     * @param mwfnz
     * @param jinaLaMethod 
     */
    void updateTaarifaZaMwanafunzi(Mwanafunzi mwfnz, String jinaLaMethod) {
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE studentInfo SET "+jinaLaMethod+" = ?" +"WHERE premNo = '"+mwfnz.premNo()+"'"); 
            Object taarifa = Manuva.invoke(mwfnz, "", jinaLaMethod, (Object[]) null);
            
            String type = Msomi.somaExtension(taarifa.getClass().getName());
            if(type.equals("String")){
                ps.setString(1,taarifa.toString());
            }
            else{
                ps.setInt(1, Integer.valueOf(taarifa.toString()));
            }
            
            ps.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Imeshindwa ku update "+jinaLaMethod+" kwa mwanafunzi "+mwfnz.fullName());
        }
    }
    
    /**
     * kusave taarifa za mkondo ktk kanzidata
     * @param mkondo mkondo
     */
    void addMkondo(Mkondo mkondo) {
        if(tableIpo("StreamInfo")){
            ingizaTaarifaZaMkondo(mkondo);
        }
        else{
            tengenezaTableStreamInfo();
            ingizaTaarifaZaMkondo(mkondo);
        }
    }

    /**
     * ku save taarifa za darasa ktk kanzidata
     * @param darasa darasa
     */
    void addDarasa(Darasa darasa) {
        if(tableIpo("ClassInfo")){
            ingizaTaarifaZaDarasa(darasa);
        }
        else{
            tengenezaTableClassInfo();
            ingizaTaarifaZaDarasa(darasa);
        }
    }

    /**
     * kuingiza taarifa za darasa ktk table
     * @param darasa darasa
     */
    private void ingizaTaarifaZaDarasa(Darasa darasa) {
        
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO CLASSINFO (classFullName, className, category) VALUES (?,?,?)");

            ps.setString(1, darasa.getClassFullName());
            ps.setString(2, darasa.className());
            ps.setString(3, darasa.getCategory());
            
            ps.execute();
        }
        catch (Exception ex) {
            Mjumbe.log(ex, "Kanzidata-ingizaTaarifaZaDarasa");
        }  
    }

    /**
     * kutengeneza table kwa ajili ya taarifa za darasa
     */
    private void tengenezaTableClassInfo() {
        try{
            st = con.createStatement();
            st.execute("CREATE TABLE classInfo ("
                    + "classFullName varchar(20) primary key ,"
                    + "className varchar(15),"
                    + "category varchar (20)"
                    + ")");
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-tengenezaTableClassInfo");
        }
    }

    /**
     * ku update taarifa za darasa
     * @param darasa darasa
     */
    public void updateTaarifaZaDarasa(Darasa darasa) {
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE classInfo SET classFullName = ?,"
                    + "className = ?, category = ?"
                    + " WHERE classFullName = '"+darasa.getClassFullName()+"'");
            
            ps.setString(1, darasa.getClassFullName());
            ps.setString(2, darasa.className());
            ps.setString(3, darasa.getCategory());                                                                        
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            Mjumbe.log(ex, "Kanzidata-updateTaarifaZaDarasa");
        }
    }

    /**
     * ingiza taarifa za mkondo ktk table mkondo
     * @param mkondo mkondo
     */
    private void ingizaTaarifaZaMkondo(Mkondo mkondo) {
         
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO STREAMINFO (streamFullName,class,stream,category) VALUES (?,?,?,?)");
            ps.setString(1, mkondo.streamFullName());
            ps.setString(2, mkondo.className());
            ps.setString(3, mkondo.streamName()); 
            ps.setString(4, mkondo.getCategory());
            ps.execute();
        }
        catch (Exception ex) {
            Mjumbe.log(ex, "Kanzidata-ingizaTaarifaZaMkondo");
        } 
    }

    /**
     * tengeneza table ya kuhifadhia taarifa za mkondo
     */
    private void tengenezaTableStreamInfo() {
        try{
            st = con.createStatement();
            st.execute("CREATE TABLE streamInfo ("
                    + "streamFullName varchar(15) primary key,"
                    + "class varchar(15),"
                    + "stream varchar(1),"
                    + "category varchar (15))");           
        }
        catch(Exception e){
            Mjumbe.log(e, "Kanzidata-tengenezaTableStreamInfo");
        }
    }
        
    /**
     * Kupata column headers ktk table
     * @param tableName jina la table
     * @return 
     */
    private LinkedHashMap getColumnNames(String tableName) {
       LinkedHashMap columnNames = new LinkedHashMap();
               
        try{
            DatabaseMetaData metadata = con.getMetaData();
            
            ResultSet set = metadata.getColumns(null, null, tableName, null);
            while(set.next()){
                columnNames.put(set.getString("COLUMN_NAME"), set.getString("TYPE_NAME"));
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return columnNames;
    }
    
    void deleteMwanafunzi(Mwanafunzi mwfnz) {
        delete("premNo",mwfnz.premNo(),"studentInfo");
    }
    
    void deleteMkondo(String jinaKamiliLaMkondo) {
        delete("streamFullName", jinaKamiliLaMkondo, "streamInfo");
    }
    
    void deleteDarasa(String jinaKamiliLaDarasa) {
        delete("classFullName", jinaKamiliLaDarasa, "classInfo");
    }
    
    
    /**
     * Kudelete data katika table
     * @param jinaLaColumn column yenye primary key
     * @param data data unayotaka ku delete
     * @param jinaLaTable jina la table ktk kanzidata
     */
    void delete(String jinaLaColumn, String data, String jinaLaTable){
        String query = "DELETE FROM "+jinaLaTable+" WHERE "+jinaLaColumn+" = ?";
       
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, data);
            ps.executeUpdate();
        }
        catch(Exception e){
            System.out.println("Imeshindwa kudelete "+data+" ktk table "+jinaLaTable);
        }
    } 
    
    
    void loadMtihani(Mtihani mtihani){
        String somo = mtihani.subject();
        
        if(tableIpo(mtihani.getExamTitle())){
                    
            Iterator tableHeaders = getColumnNames(mtihani.getExamTitle()).keySet().iterator();
            
            if(tableHeaders.hasNext()){
                tableHeaders.next(); // Ruka premNo
            
                while(tableHeaders.hasNext()){
                    
                    String tableHeader = tableHeaders.next().toString();
                   
                    mtihani.setSubjectTitle(tableHeader);

                    try {
                        String query = "SELECT PREMNO, "+tableHeader+" FROM "+mtihani.getExamTitle();
                        st = con.createStatement();

                        ResultSet set = st.executeQuery(query);

                        while(set.next()){
                            Mwanafunzi mwfnz = shule.getMwanafunzi(set.getString("PREMNO"));
                            if(mwfnz != null){
                                mwfnz.score(mtihani, set.getDouble(mtihani.getSubjectTitle()));
                            }
                            else{
                                delete("premNo",set.getString("PREMNO"),mtihani.getExamTitle());
                                System.out.println(set.getString("PREMNO"));
                            }
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                        System.out.println("Imeshindwa kuload mitihani \n"+e.getMessage());
                    }
                }
            }
            
        }
        
        mtihani.subject(somo);
    }
    
    void ingizaAlama(TreeMap alamaZaWote, Mtihani mtihani) {
        
        if(tableIpo(mtihani.getExamTitle())){
            if(columnIpo(mtihani.getSubjectTitle(),mtihani.getExamTitle())){
                saveAlama(alamaZaWote,mtihani);
            }
            else{
                addColumn(mtihani.getSubjectTitle(),mtihani.getExamTitle());
                saveAlama(alamaZaWote,mtihani);
            }
        }
        else{
            tengenezaTableMtihani(mtihani.getExamTitle());
            addColumn(mtihani.getSubjectTitle(),mtihani.getExamTitle());
            saveAlama(alamaZaWote,mtihani);
        }
    }

    private void saveAlama(TreeMap alamaZaWote, Mtihani mtihani) {
        Iterator it = alamaZaWote.keySet().iterator();
        TreeMap updateMarks = new TreeMap();
        
        while(it.hasNext()){
            
            String premNo = it.next().toString();
            double alama = (double)alamaZaWote.get(premNo);
            
            try {
                PreparedStatement ps = con.prepareStatement("INSERT INTO " +mtihani.getExamTitle()+"(premNo, "+mtihani.getSubjectTitle()
                        + ") VALUES (?,?)");
                ps.setString(1, premNo);
                ps.setDouble(2, alama);
                ps.execute();
            }
            catch(Exception e){
                updateMarks.put(premNo, alama);
            }
        }
        
        if(!updateMarks.isEmpty()){
            it = updateMarks.keySet().iterator();
        
            while(it.hasNext()){

                String premNo = it.next().toString();
                double alama = (double)alamaZaWote.get(premNo);
                try{
                    PreparedStatement ps = con.prepareStatement("UPDATE "+mtihani.getExamTitle()+" SET "+mtihani.getSubjectTitle()+" = ? WHERE "
                     + "premNo = '"+premNo+"'");

                    ps.setDouble(1, alama);

                    ps.executeUpdate();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    
    /**
     * Tengeneza table ya mitihani
     * @param examTitle jina la mtihani 
     */
    private void tengenezaTableMtihani(String examTitle) {
       
        try{
            st = con.createStatement();
            st.execute("CREATE TABLE "+examTitle+"("
                    + "premNo varchar(15) primary key"+")");
            System.out.println("imetengeneza table "+examTitle);
        }
        catch(Exception e){
            System.out.println("imeshindwa kutengeneza table "+examTitle+"\n"+e.getMessage());
        }
    
    }
    
    /**
     * kucheck kama column ipo ktk table
     * @param columnName column header
     * @param tableName jina la table
     * @return 
     */
    private boolean columnIpo(String columnName,String tableName){
        return getColumnNames(tableName).containsKey(columnName);
    }
    
    /**
     * Add column ktk table
     * @param columnName column header
     * @param tableName jina la table
     */
    private void addColumn(String columnName, String tableName) {
        try {
            Statement stmt = con.createStatement();
            String qry = "ALTER TABLE "+tableName+" ADD "+columnName+" VARCHAR(60)";
            stmt.executeUpdate(qry);
            System.out.println("imetengeneza column "+columnName);
        }
        catch (Exception ex) {
           System.out.println("Imeshindwa ku add Column "+columnName+" katika table "+tableName+"\n"+ ex.getMessage());
        }  
    }

    void updateTaarifaZaPrems() {
        if(tableIpo("PREMS")){
            ingizaTaarifaZaPrems();
        }
        else{
            tengenezaTablePrems();
            ingizaTaarifaZaPrems();
        }
    }
}
