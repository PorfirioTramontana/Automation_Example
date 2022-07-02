package DAO;

import java.sql.Date;
import java.util.ArrayList;

import Model.Utente;

public interface UtenteDAO {
	Utente login(String email, String password);
	int sign_Up(String nickname,String mail,String password,String nome,String cognome,String nazione,String descrizione, String sesso, String datan,String isPremium,String isAdmin);
	boolean checkNickName(String nickName);
	boolean checkEmail(String email);
	int updateUtente(String nickName,String nome, String cognome, String nazione,String sesso,boolean IsPremium, boolean IsAdmin, String descrizione);
	ArrayList<Utente> takeUtente(String query);
	int deleteUtente(String query);
	
}
