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
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Muba
 */
class PremsBot extends Thread {

    private boolean login(String username, String password) {
        
        ujumbe.setText("Login to the prems website");
        
        // jaza username na password
        WebElement userName = driver.findElement(By.name(dictionary.get("nUsername").toString()));
        userName.sendKeys(username);

        WebElement userPassword = driver.findElement(By.name(dictionary.get("nPassword").toString()));
        userPassword.sendKeys(password);

        // tuma login form
        WebElement loginForm = driver.findElement(By.tagName(dictionary.get("tLoginForm").toString()));
        loginForm.submit();
         
        return true;
    }

    enum maelekezo{USAJILI, EDIT, ADMIT};
    private final boolean browserOn;
    private final int delay;
    private static int yearOfAdmission = LocalDate.now().getYear();
    private final JLabel ujumbe;
    private String jinaLaDarasa, jinaLaMkondo, username, password, takwimu;
    private static String driverName, driverPath;
    private maelekezo command;
    private static WebDriver driver;
    private final TreeMap dictionary;
    private LinkedHashMap wanafunzi;
    private ArrayList majinaYaMethods;
    private JProgressBar jProgressBarPrems;
    private String premsUrl;
    
    PremsBot(boolean browserOn, String delay, JLabel ujumbe) {
        this.dictionary = (TreeMap)Settings.loadDictionaries().get("PREMS");
        this.premsUrl = dictionary.get("loginUrl").toString();
        this.browserOn = browserOn;
        this.delay = Integer.valueOf(delay)*1000;
        this.ujumbe = ujumbe;
        
    }
    
    PremsBot(boolean browserOn, String delay, JLabel ujumbe, JProgressBar jProgressBarPrems) {
        this.dictionary = (TreeMap)Settings.loadDictionaries().get("PREMS");
        this.premsUrl = dictionary.get("loginUrl").toString();
        this.browserOn = browserOn;
        this.delay = Integer.valueOf(delay)*1000;
        this.ujumbe = ujumbe;
        this.jProgressBarPrems = jProgressBarPrems;
    }

    static String driverName(){
        return driverName;
    }
    
    static String driverPath(){
        return driverPath;
    }
    
    static void driverName(String driverName){
        PremsBot.driverName = driverName;
    }
    
    static void driverPath(String driverPath){
        PremsBot.driverPath = driverPath;
    }
    
    static void yearOfAdmission(Integer yearOfAdmission){
        PremsBot.yearOfAdmission = yearOfAdmission;
    }
    
    void jinaLaDarasa(String jinaLaDarasa) {
        this.jinaLaDarasa = jinaLaDarasa;
    }

    void jinaLaMkondo(String jinaLaMkondo) {
        this.jinaLaMkondo = jinaLaMkondo;
    }

    void username(String username) {
        this.username = username;
    }

    void password(String password) {
        this.password = password;
    }
    
    void maelekezo(maelekezo maelekezo) {
        this.command = maelekezo;
    }
    
    void somaUsajili() {
        
        ujumbe.setVisible(true);
        
        boolean imeLoad = tembeleaWebsite(premsUrl,browserOn);
        
        if(imeLoad){
            boolean imefanikiwaKuLogin = login(username,password);
            
            if(imefanikiwaKuLogin){
                chaguaDarasa(jinaLaDarasa); 
                subiri(delay);
                           
                LinkedHashMap vichwaVyaHabari = somaVichwaVyaHabari();
                Set set = shule.getWanafunzi().keySet();

                takwimu = somaTakwimu();
                int mwfnzNo = 1, wnfnz = idadiYaWanafunzi(), idadiYaPage = idadiYaPage();
                
                jProgressBarPrems.setVisible(true);
                jProgressBarPrems.setStringPainted(true);
                
                do{
                    WebElement table = driver.findElement(By.tagName("tbody"));
                    for(WebElement row : table.findElements(By.tagName("tr"))){
                        
                        for(WebElement link : row.findElements(By.tagName("a"))){
                            String url = link.getAttribute("href");
                            System.out.println(url);
                            
                            if(url.contains("edit")){
                                System.out.println("hii "+url);
                            }
                        }
                        
                        
                        break;
                    }
                    
                            
                    /*Document doc = Jsoup.parse(table.getAttribute("innerHTML"));
                                       
                    for(Element element : doc.getElementsByTag("a")){
                        System.out.println(element.getElementsByAttribute("href").text());
                        if(element.text().contains("edit")){
                            System.out.println(element.getElementsByAttribute("href").text());
                            break;
                        }
                    }
                    */
                    break;
                }
                while(true);
        }
    }
                    /*for(int rowNo = 1; rowNo <= idadiYaRow(); rowNo++){

                    WebElement row = nendaRowYa(rowNo);
                    
                }   
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    Mwanafunzi mwfnz = somaTaarifaZaMwanafunzi(row, vichwaVyaHabari);
                    mwfnz.classAdmitted(jinaLaDarasa);

                    if(!set.contains(mwfnz.premNo())){ // mwanafunzi hayupo ktk kanzidata
                        bonyezaToolTip(row,"Edit");
                        
                        // soma TextField zote
                        getInputFields().forEach(textField -> {
                            somaTextField(textField, mwfnz);
                        });

                        // soma dropdown zote
                        getDropDowns().forEach(dropDown -> {
                            somaDropDown(dropDown, mwfnz);
                        });

                        if(jinaLaMkondo.equals("ALL") || mwfnz.stream().equals(jinaLaMkondo)){
                            msajili(mwfnz);
                            ujumbe.setText(mwfnz.fullName()+" Enrolled sucessfull");
                        }
                            driver.navigate().back();

                        }
                        else{
                            ujumbe.setText(mwfnz.fullName()+" Already in the database");
                        }

                        int asilimia = (int)(((double)mwfnzNo/wnfnz)*100);
                        jProgressBarPrems.setValue(asilimia);
                        jProgressBarPrems.setString(asilimia+"%");
                        mwfnzNo++;
                    }

                    if(pageIliopo() < idadiYaPage){
                        bonyezaNextPage();
                    }
                    else{
                        driver.close();
                        break;
                    }
                }

                while(true);
            }
            else{
                ujumbe.setText("Username or password incorrect");
            }
        }
            
        
       /* if(login(password)){
            chaguaDarasa(jinaLaDarasa);
           
            bonyezaStudents();
            subiri(delay);

            bonyezaQualified();
            ujumbe.setText("Click Qualified students .......");
            subiri(delay); 

            LinkedHashMap vichwaVyaHabari = somaVichwaVyaHabari();
            Set set = shule.getWanafunzi().keySet();
            
            takwimu = somaTakwimu();
            int mwfnzNo = 1, wnfnz = idadiYaWanafunzi(), idadiYaPage = idadiYaPage();
            jProgressBarPrems.setVisible(true);
            jProgressBarPrems.setStringPainted(true);
                        
            do{
                
                for(int rowNo = 1; rowNo <= idadiYaRow(); rowNo++){

                    WebElement row = nendaRowYa(rowNo);
                    Mwanafunzi mwfnz = somaTaarifaZaMwanafunzi(row, vichwaVyaHabari);
                    mwfnz.classAdmitted(jinaLaDarasa);

                    if(!set.contains(mwfnz.premNo())){ // mwanafunzi hayupo ktk kanzidata
                        //PremsWindow.jLabelUjumbe.setText("Click Edit");
                        bonyezaToolTip(row,"Edit");
                        subiri(delay);

                        // soma TextField zote
                        getInputFields().forEach(textField -> {
                            somaTextField(textField, mwfnz);
                        });

                        // soma dropdown zote
                        getDropDowns().forEach(dropDown -> {
                            somaDropDown(dropDown, mwfnz);
                        });

                        if(jinaLaMkondo.equals("ALL") || mwfnz.stream().equals(jinaLaMkondo)){
                            msajili(mwfnz);
                            ujumbe.setText(mwfnz.fullName()+" Enrolled sucessfull");
                        }
                            driver.navigate().back();
                            
                        }
                        else{
                            ujumbe.setText(mwfnz.fullName()+" Already in the database");
                        }

                        // Feedback message
                        //PremsWindow.oneshaLabel(true);
                        //PremsWindow.jLabelNo.setText(mwfnzNo+"");
                        //PremsWindow.jLabelTotal.setText(wanafunzi+"");

                        int asilimia = (int)(((double)mwfnzNo/wnfnz)*100);
                        jProgressBarPrems.setValue(asilimia);
                        jProgressBarPrems.setString(asilimia+"%");
                        mwfnzNo++;
                    }


                //System.out.println(pageIliopo()+"/"+idadiYaPage);
                if(pageIliopo() < idadiYaPage){
                    bonyezaNextPage();
                }
                else{
                    driver.close();
                    break;
                }
                
            
            
            while(true);*/
        
    }
    
    public void admitWanafunzi(){
        jProgressBarPrems.setStringPainted(true);
        boolean imefanikiwa = login(password);
        subiri(delay);
    
        if(imefanikiwa){
            chaguaDarasa(jinaLaDarasa);
            subiri(delay);
            
            bonyezaStudents();
            subiri(delay);

            bonyezaQualified();
            subiri(delay);
            
            LinkedHashMap vichwaVyaHabari = somaVichwaVyaHabari();
            takwimu = somaTakwimu();
            int mwfnzNo = 1, wfnz = idadiYaWanafunzi(), idadiYaPage = idadiYaPage(), pageYaSasa = 1;
            Set s = wanafunzi.keySet();
            
            do{   
                for(int rowNo = 1; rowNo <= idadiYaRow(); rowNo++){
                    WebElement row = nendaRowYa(rowNo);
                    
                    Mwanafunzi mwfnz = somaTaarifaZaMwanafunzi(row, vichwaVyaHabari);
                    
                    if(s.contains(mwfnz.fullName())){
                        pageYaSasa = pageIliopo();
                        mwfnz = (Mwanafunzi)wanafunzi.get(mwfnz.fullName());
                        bonyezaToolTip(row,"Admit");
                        jazaAdmissionNo(mwfnz.admissionNo()+"");
                        boolean admitted = bonyezaSave();
                                     
                        int asilimia = (int)(((double)mwfnzNo/wfnz)*100);
                        jProgressBarPrems.setString(asilimia+"%");
                        jProgressBarPrems.setValue(asilimia);
                        
                        mwfnzNo++;
                        
                        if(admitted){
                            subiri(delay);
                            nendaPageYa(pageYaSasa);
                        }
                    }
                }
                
                pageYaSasa++;
                
                if(pageYaSasa > idadiYaPage){
                    break;
                }
                else{
                    nendaPageYa(pageYaSasa);
                }
            }
            while(true);
            driver.close();
        }
    }
    
    void wanafunzi(LinkedHashMap wanafunzi){
        this.wanafunzi = wanafunzi;
    }
    void majinaYaMethods(ArrayList majinaYaMethods){
        this.majinaYaMethods = majinaYaMethods;
    }
    
    private boolean login(String password){
             
        // set aina ya webdriver itakayotumika
        ujumbe.setText("Configure driver ...");
       
        System.setProperty(driverName, driverPath);
                
        try{
            ChromeOptions options = new ChromeOptions(); 
            options.addArguments("--remote-allow-origins=*");
            
            if(browserOn){
                driver = new ChromeDriver(options);
            }
            else{
                options.addArguments("--browserOn", "--window-size=1920,1200");
                options.addArguments("headless");
                driver = new ChromeDriver(options);
            }
            
            ujumbe.setText("Driver configured sucessfully");
            
            // nenda ktk website ya prems
            ujumbe.setText("Establish connection to the Server ...");
            driver.get(dictionary.get("loginUrl").toString());

            driver.manage().window().maximize() ;

            // jaza username na password
            WebElement userName = driver.findElement(By.name(dictionary.get("nUsername").toString()));
            userName.sendKeys(username);

            WebElement userPassword = driver.findElement(By.name(dictionary.get("nPassword").toString()));
            userPassword.sendKeys(password);

            // tuma login form
            WebElement loginForm = driver.findElement(By.tagName(dictionary.get("tLoginForm").toString()));
            loginForm.submit();
            ujumbe.setText("Login to the prems website");   
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            ujumbe.setText("Fail to configure Driver");
            Mjumbe.oneshaUjumbe(ujumbe.getText());
            return false;
        }        
    }
    
    private void subiri(int muda){
        try{
            sleep(muda);
        }
        catch(Exception e){}
    }
    
    private void chaguaDarasa(String jinaLaDarasa){
        ujumbe.setText("Select "+jinaLaDarasa);
        chaguaOption(jinaLaDarasa, "#form_id_chosen", "//*[@id=\"form_id_chosen\"]/div/ul//li");     
    }
    
    private void bonyezaStudents() {
        ujumbe.setText("Click students");
        upandeWaKushotoBonyezaMenu("Students");
    }
    
    private void bonyezaQualified() {
        ujumbe.setText("Click qualified students");
        kwenyeStudentsMenuBonyeza("Qualified");
    }

    /**
     * kubonyeza menu upande wa kushoto
     * @param jinaLaMenu jina la menu 
     */
    private void upandeWaKushotoBonyezaMenu(String jinaLaMenu){
        WebElement elements = driver.findElement(By.className("sidebar-menu"));
        
        List<WebElement> menues = elements.findElements(By.tagName("span"));
        
        for(WebElement menu : menues){
            if(jinaLaMenu.equals(menu.getAttribute("innerHTML"))){
                menu.click();
                break;
            }
        }
    }
        
    /**
     * Kwenye menu ya students bonyeza meu
     * @param jinaLaMenu jina la menu
     */
    private void kwenyeStudentsMenuBonyeza(String jinaLaMenu){
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/aside/div/section/ul/li[3]/ul"));
        List<WebElement> subMenues = element.findElements(By.tagName("a"));
                
        for(WebElement subMenu : subMenues){
            if(jinaLaMenu.equals(subMenu.getText())){
                subMenu.click();
                break;
            }
        }
    }
    
    private LinkedHashMap somaVichwaVyaHabari() {
        LinkedHashMap vichwaVyaHabari = new LinkedHashMap();
        List<WebElement> elements = driver.findElements(By.tagName("th"));

        for(int a = 0; a < elements.size(); a++){

            WebElement element = (WebElement)elements.get(a);

            String key = "";

            try{
                key = element.findElement(By.tagName("a")).getAttribute("innerHTML").toUpperCase().trim();
            }
            catch(Exception e){

            }

            if(dictionary.containsKey(key)){
               vichwaVyaHabari.put(a, dictionary.get(key));
            }
        }
        return vichwaVyaHabari;
    }
    
    private String somaTakwimu() {
        return driver.findElement(By.xpath("/html/body/div/div[1]/div/section[2]/div/div[3]/p")).getText();
    }
    
    private int idadiYaWanafunzi() {
       return Integer.parseInt(takwimu.split(" ")[9]); 
    } 
    
    // kupata idadi ya page
    private int idadiYaPage(){
       return Integer.parseInt(takwimu.split(" ")[3].replace(",", ""));
    }
    
    // kupata idadi ya row
    private int idadiYaRow(){
        return driver.findElements(By.tagName("tr")).size()-1;
    }
    
    private WebElement nendaRowYa(int row) {
        return (WebElement)driver.findElements(By.tagName("tr")).get(row);
    }
    
    private Mwanafunzi somaTaarifaZaMwanafunzi(WebElement row, LinkedHashMap vichwaVyaHabari) {
        List<WebElement> cells = row.findElements(By.tagName("td"));
        Mwanafunzi mwfnz = new Mwanafunzi();
              
        for(int a = 0; a < cells.size(); a++){
            WebElement cell = cells.get(a);

            if(vichwaVyaHabari.containsKey(a)){
                String jinaLaMethod = vichwaVyaHabari.get(a).toString();
                String data = cell.getAttribute("innerHTML").toUpperCase().trim();
                Manuva.invoke(mwfnz, "", jinaLaMethod, Manuva.checkInt(data, jinaLaMethod));
            } 
        }
        return mwfnz;
    }
    
    private void bonyezaToolTip(WebElement row, String name){
        boolean endelea = true;
        
        for(WebElement elem : row.findElements(By.tagName("td"))){
            
            if(endelea){
                for(WebElement element : elem.findElements(By.tagName("a"))){
              
                    if(name.equalsIgnoreCase(element.getAttribute("title"))){
                        ujumbe.setText("Click "+name);
                        element.click();
                        endelea = false;
                        break;
                    }
                }
            }
            else{
                break;
            }
        } 
    }
    
    public List<WebElement> getInputFields(){
        return driver.findElements(By.tagName("input"));
    }
      
    private void somaTextField(WebElement textField, Mwanafunzi mwfnz) {
        String key = textField.getAttribute("name").toUpperCase().trim();
        String value = textField.getAttribute("value"); 
      
        if(dictionary.containsKey(key) && !value.isEmpty()){
            String jinaLaMethod = dictionary.get(key).toString();
            Manuva.invoke(mwfnz, "", jinaLaMethod, Manuva.checkInt(value, jinaLaMethod));
            ujumbe.setText("Read values from text fields");
        }
    }
    
    private List<WebElement> getDropDowns(){
        return driver.findElements(By.tagName("select"));
    }
    
    private void somaDropDown(WebElement dropDown, Mwanafunzi mwfnz) {
                            
        String value = "";
        String key = dropDown.getAttribute("name").toUpperCase().trim();

        for(WebElement element : dropDown.findElements(By.tagName("option"))){
            if(element.isSelected()){
               value = element.getAttribute("innerHTML").toUpperCase().trim();
               break;
            }
        } 

        if(dictionary.containsKey(key) && !value.isEmpty()){
            String jinaLaMethod = dictionary.get(key).toString();
            Manuva.invoke(mwfnz, " ", jinaLaMethod, Manuva.checkInt(value, jinaLaMethod));
            ujumbe.setText("read drop downs");
        }
    }
    
    // msajili mwanafunzi shuleni
    private void msajili(Mwanafunzi mwfnz) {
        mwfnz.yearAdmitted(PremsBot.yearOfAdmission());
        Mkondo mkondo = shule.getMkondo(jinaLaDarasa+mwfnz.stream());

        if(mkondo != null){
            mkondo.enrollMwanafunzi(mwfnz);
        }
        else{
            mkondo = new Mkondo(mwfnz.stream());
            mkondo.className(jinaLaDarasa);
            mkondo.changeCategory("ARTS");
            mkondo.enrollMwanafunzi(mwfnz);
            shule.enrollMkondo(mkondo);
            shule.addJinaLaDarasa(jinaLaDarasa);
        }
    }
        
    public void editTaarifa(){
        login(password);
        subiri(delay);

        chaguaDarasa(jinaLaDarasa);
        subiri(delay);
        
        bonyezaStudents();
        subiri(delay);
        
        bonyezaQualified();
        subiri(delay); 
               
        LinkedHashMap vichwaVyaHabari = somaVichwaVyaHabari();
        takwimu = somaTakwimu();
        int idadiYaPage = idadiYaPage();
     
        for(int pageNo = 1; pageNo <= idadiYaPage; pageNo++){
            nendaPageYa(pageNo);
            int idadiYaRow = idadiYaRow();
            
            for(int rowNo = 1; rowNo <= idadiYaRow;  rowNo++){
                                
                WebElement row = nendaRowYa(rowNo);
                Mwanafunzi mwfnz = somaTaarifaZaMwanafunzi(row, vichwaVyaHabari);
                subiri(delay);
                
                //angalia kama yupo miongoni mwa wanafunzi
                if(wanafunzi.containsKey(mwfnz.fullName())){
                    mwfnz = (Mwanafunzi)wanafunzi.get(mwfnz.fullName());
                    bonyezaToolTip(row,"Admit");
                    jazaAdmissionNo(mwfnz.admissionNo()+"");
                    bonyezaSave();
                    
                                        
                    // jaza dropdowns
                    //jazaDropDows(majinaYaMethods,mwfnz);
                                        
                                      
                     
                    if(pageNo != 1){
                        nendaPageYa(pageNo);
                    }
                }
            }
            subiri(delay);
        }
    }
    
    private int pageIliopo() {
        return Integer.parseInt(somaTakwimu().split(" ")[1]);
    }
    
    private void bonyezaNextPage(){
        try{
            driver.findElement(By.cssSelector("body > div > div.content-wrapper > div > section.content > div > div.box-footer > ul > li.next > a")).click();
        }
        catch(Exception e){
            //driver.close();
        }
    }
    
     /**
     * kuchagua option ktk dropdown
     * assumption ni drop down inaonekana ktk windows
     * @param option option unayotaka kuchagua;
     * @param cssClickPath css slector adress ya dropdown
     * @param xDropDownPath xpath address ya dropdown
     */
    private void chaguaOption(String option, String cssClickPath, String xDropDownPath){
        
        driver.findElement(By.cssSelector(cssClickPath)).click();
        
        // pitia darasa moja moja kujua lipi limechaguliwa
        List<WebElement> dropDowns = driver.findElements(By.xpath(xDropDownPath));
        
        for(WebElement dropDown : dropDowns){
            if(dropDown.getAttribute("innerHTML").equalsIgnoreCase(option)){
                dropDown.click();
                break;
            }
        }
    }
    private boolean bonyezaSave(){
        try{
            driver.findElement(By.xpath("/html/body/div/div[1]/div/section[2]/div/div[3]/button")).click();
            return true;
        }
        catch(Exception r){
            return false;
        }
        
    }
    
        
    private void nendaPageYa(int pageNo){
        
        if(pageNo <= idadiYaPage()){
            boolean clicked = clickPage(pageNo);
            
            int i = 0;
            while(!clicked){
                clickPage(9 + 4*i);
                clicked = clickPage(pageNo);
                i++;
            }
        }
    }
    
    private boolean clickPage(int pageNo){
        try{
           driver.findElement(By.linkText(pageNo+"")).click();
           return true;
        }
        catch(Exception e){
           return false;
        }        
    }
    
    private void jazaAdmissionNo(String admissionNo) {
        try{
            driver.findElement(By.xpath("//*[@id=\"admission-number\"]")).sendKeys(admissionNo);
        }
        catch(Exception e){}
        
    }
    
    private void jazaTextField(ArrayList majinaYaMethods, WebElement textField, Mwanafunzi mwfnz){
        String key = textField.getAttribute("name").toUpperCase().trim();
        
        if(dictionary.containsKey(key)){
            String jinaLaMethod = dictionary.get(key).toString();
            
            if(textField.isEnabled() && majinaYaMethods.contains(jinaLaMethod)){
                Object ob = Manuva.invoke(mwfnz, "", jinaLaMethod, (Object[])null);
                
                if(ob != null){
                    textField.clear();
                    textField.sendKeys(ob.toString());
                }
            }
        }
    }
    static Integer yearOfAdmission(){
        return yearOfAdmission;
    }
    
    static void closeBrowser() {
        if(driver != null){
            driver.close();
        }
        
    }
    
    private boolean tembeleaWebsite(String url, boolean oneshaBrowser) {
        ujumbe.setText("Configure driver ...");      
        System.setProperty(driverName, driverPath);
        
        try{
            ChromeOptions options = new ChromeOptions(); 
            options.addArguments("--remote-allow-origins=*");
            
            if(oneshaBrowser){
                driver = new ChromeDriver(options);
            }
            else{
                options.addArguments("--browserOn", "--window-size=1920,1200");
                options.addArguments("headless");
                driver = new ChromeDriver(options);
            }
            
            ujumbe.setText("Driver configured sucessfully");
            
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            ujumbe.setText("Visit "+url);
            driver.get(url);
            driver.manage().window().maximize() ;
            return true;
        }
        catch(Exception e){
            Mjumbe.oneshaUjumbe("Check your driver version or internet connections");
            return false;
        }
    }
    
    @Override
    public void run(){
        if(command.equals(maelekezo.USAJILI)){
            //editTaarifa();
            somaUsajili();
        }
        else if(command.equals(maelekezo.ADMIT)){
            admitWanafunzi();
        }
        
    }    
}
