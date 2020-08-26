import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class PierwszeTesty {

    private WebDriver driver;
    
    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Ignore
    @Test
    public void testCase1() {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("test");
    }

    @Ignore
    @Test
    public void logowanieDoFacebooka() throws InterruptedException {
        // krok 1 - otwieramy stronę
        driver.get("http://facebook.com");

        // krok 2 - w okienko adres e-mail wpisujemy e-mail
        // 1. znajdź okienko
        // 2. wpisz text
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("test");
        Thread.sleep(5000);

        // krok 3 - w okienko hasło wpisujemy hasło
        // 1. znajdujemy element
        // 2. wpisujemy text
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("test");
        Thread.sleep(5000);

        // krok 4 - klikamy "zaloguj się"
        // 1. znajdź element
        // 2. kliknij w niego
        WebElement zaloguj = driver.findElement(By.id("u_0_b"));
        zaloguj.click();
        Thread.sleep(5000);
    }

    @Ignore
    @Test
    public void logowanie() {
        // krok 1 - otwieramy stronę
        driver.get("http://zadaniadlatestera.pl/textBox.html");

        // krok 2 - wpisujemy login
        WebElement login = driver.findElement(By.id("login"));
        login.sendKeys("testLogin");

        // krok 3 - wpisujemy hasło
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("testLogin");

        // krok 4 - klikamy przysick "prześlij"
        WebElement przeslij = driver.findElement(By.id("sendLogin"));
        przeslij.click();

    }

    @Ignore
    @Test
    public void rejestracja() throws InterruptedException {

        driver.get("http://zadaniadlatestera.pl/textBox.html");

        WebElement imie = driver.findElement(By.id("name"));
        imie.sendKeys("Magda");
        Thread.sleep(5000);

        WebElement nazwisko = driver.findElement(By.id("surname"));
        nazwisko.sendKeys("Kornas");
        Thread.sleep(5000);

        WebElement pesel = driver.findElement(By.id("personalId"));
        pesel.sendKeys("921205");
        Thread.sleep(5000);

        WebElement telefon = driver.findElement(By.name("phoneNumber"));
        telefon.sendKeys("555111888");
        Thread.sleep(5000);

        WebElement przeslij = driver.findElement(By.id("sendLogin"));
        przeslij.click();
    }

    @Ignore
    @Test
    public void ankieta() throws InterruptedException {

        driver.get("http://zadaniadlatestera.pl/radioButton.html");

        WebElement plec = driver.findElement(By.id("woman"));
        plec.click();
        Thread.sleep(5000);

        WebElement wiek = driver.findElement(By.id("age2"));
        wiek.click();
        Thread.sleep(5000);

        WebElement wyksztalcenie = driver.findElement(By.id("level2"));
        wyksztalcenie.click();
        Thread.sleep(5000);

        WebElement miejsce = driver.findElement(By.id("city"));
        miejsce.click();
        Thread.sleep(5000);

        WebElement praca = driver.findElement(By.id("yes"));
        praca.click();
        Thread.sleep(5000);

        WebElement przeslij = driver.findElement(By.name("send"));
        przeslij.click();
    }

    @Ignore
    @Test
    public void checkboxy() throws InterruptedException {

        driver.get("http://zadaniadlatestera.pl/checkbox.html");

        WebElement games = driver.findElement(By.id("games"));
        games.click();
        Thread.sleep(5000);

        WebElement reading = driver.findElement(By.id("reading"));
        reading.click();
        Thread.sleep(5000);

        WebElement instrument = driver.findElement(By.name("instrument"));
        instrument.click();
        Thread.sleep(5000);
    }

    @Ignore
    @Test
    public void select() throws InterruptedException {

        driver.get("http://zadaniadlatestera.pl/select.html");

        Select gatunek = new Select(driver.findElement(By.name("sort")));
        // wybierz z listy "Hymn"
        gatunek.selectByValue("Hymn");
        Thread.sleep(3000);

        Select wiek = new Select(driver.findElement(By.name("age")));
        wiek.selectByIndex(1);
        Thread.sleep(3000);

        Select regal = new Select(driver.findElement(By.name("place")));
        regal.selectByValue("vi"); // albo jako regal.selectByVisibleText("VI"); bo jest to widoczne na stronie
        Thread.sleep(3000);

        WebElement numer = driver.findElement(By.id("index"));
        numer.sendKeys("12");
        Thread.sleep(3000);

        Select osoba = new Select(driver.findElement(By.name("personName")));
        osoba.selectByValue("osoba4");
        Thread.sleep(3000);

        WebElement przeslij = driver.findElement(By.id("send"));
        przeslij.click();

    }

    @Ignore
    @Test
    public void alert()throws InterruptedException {

        driver.get("http://zadaniadlatestera.pl/alert1.html");

        WebElement decyzja = driver.findElement(By.id("dec"));
        decyzja.click();
        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();
        alert.dismiss(); // alert.accept();
        Thread.sleep(3000);
    }

    @Ignore
    @Test
    public void alert2() throws InterruptedException {

        driver.get("http://zadaniadlatestera.pl/alert2.html");

        WebElement biblioteka = driver.findElement(By.id("index"));
        biblioteka.sendKeys("E12G22");
        Thread.sleep(3000);

        WebElement skasuj = driver.findElement(By.id("delete"));
        skasuj.click();
        Thread.sleep(3000);

        Alert alert2 = driver.switchTo().alert();
        alert2.accept();
        Thread.sleep(3000);
    }

    @Test
    public void zadanie() throws InterruptedException {

        driver.get("http://zadaniadlatestera.pl/zadanie.html");

        WebElement imie = driver.findElement(By.id("name"));
        imie.sendKeys("Magda");
        Thread.sleep(3000);

        WebElement nazwisko = driver.findElement(By.id("lastName"));
        nazwisko.sendKeys("Kornas");
        Thread.sleep(3000);

        WebElement telefon = driver.findElement(By.name("phoneNumber"));
        telefon.sendKeys("555111888");
        Thread.sleep(3000);

        WebElement mail = driver.findElement(By.id("email"));
        mail.sendKeys("magda@gmail.com");
        Thread.sleep(3000);

        WebElement plec = driver.findElement(By.id("woman"));
        plec.click();
        Thread.sleep(3000);

        WebElement ulica = driver.findElement(By.id("street"));
        ulica.sendKeys("Pawia 8");
        Thread.sleep(3000);

        WebElement miasto = driver.findElement(By.id("city"));
        miasto.sendKeys("Kraków");
        Thread.sleep(3000);

        Select kontynent = new Select(driver.findElement(By.name("sort")));
        kontynent.selectByValue("Australia");
        Thread.sleep(3000);

        WebElement login = driver.findElement(By.id("login"));
        login.sendKeys("Magdaaa");
        Thread.sleep(3000);

        WebElement haslo = driver.findElement(By.id("password"));
        haslo.sendKeys("test01");
        Thread.sleep(3000);

        WebElement haslo2 = driver.findElement(By.id("repeatPassword"));
        haslo2.sendKeys("test01");
        Thread.sleep(3000);

        WebElement przeslij = driver.findElement(By.id("send"));

    }

}
