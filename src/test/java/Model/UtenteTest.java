package Model;

import org.junit.Before;
import org.junit.Test;
import Model.Utente;
import java.sql.Date;

import static org.junit.Assert.*;

public class UtenteTest {

    private Utente utenteTest;

    @Before
    public void setUtenteTest(){
        utenteTest = new Utente("TestUtente", "@unina.it", "12345", "Test", "Utente", "IT",
                " ", "M", new Date(1998,5,1), false, false);
    }

    @Test
    public void getNicknameTest() {
        assertEquals("TestUtente",utenteTest.getNickname());
    }

    @Test
    public void getMailTest() {
        assertEquals("@unina.it",utenteTest.getMail());
    }

    @Test
    public void getPasswordTest() {
        assertEquals("12345",utenteTest.getPassword());
    }

    @Test
    public void getNomeTest() {
        assertEquals("Test",utenteTest.getNome());
    }

    @Test
    public void getCognomeTest() {
        assertEquals("Utente",utenteTest.getCognome());
    }

    @Test
    public void getNazioneTest() {
        assertEquals("IT",utenteTest.getNazione());
    }

    @Test
    public void getDescrizioneTest() {
        assertEquals(" ",utenteTest.getDescrizione());
    }

    @Test
    public void getDatanTest() {
        assertEquals(new Date(1998,5,1),utenteTest.getDatan());
    }

    @Test
    public void getIsIspremiumTest() {
        assertFalse(utenteTest.getIsIspremium());
    }

    @Test
    public void getIsIsadminTest() {
        assertFalse(utenteTest.getIsIsadmin());
    }

    @Test
    public void getSessoTest() {
        assertEquals("M",utenteTest.getSesso());
    }
}