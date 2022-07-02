package Controller;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

import ImplementazioniDao.*;
import Model.*;

public class Controller {
	private Utente u;
	private UtenteImplementazioneDao ui;
	private TracciaImplementazioneDao ti;
	private AlbumImplementazioneDao ai;
	private AscoltoImplementazioneDao asi;
	private VotoImplementazioneDao vi;
	private PlaylistImplementazioneDao pi;
	private ArtistaImplementazioneDao art;
	
	public Controller() {
		ui = new UtenteImplementazioneDao();
		ti = new TracciaImplementazioneDao();
		ai = new AlbumImplementazioneDao();
		asi = new AscoltoImplementazioneDao();
		vi = new VotoImplementazioneDao();
		pi = new PlaylistImplementazioneDao();
		art = new ArtistaImplementazioneDao();
	}
	
	public Utente login(String email, String password)
	{
		u = ui.login(email, password);
		
		return u;
	}
	
	public int signUp(String nickname, String mail, String password, String nome, String cognome, String nazione,
			String descrizione, String sesso, String datan, String isPremium, String isAdmin)
	{
		int esito;
		
		esito = ui.sign_Up(nickname, mail, password, nome, cognome, nazione, descrizione, sesso, datan, isPremium, isAdmin);
		
		return esito;
	}
	
	public boolean checkEmail(String email)
	{
		boolean esito = ui.checkEmail(email);
		
		return esito;
	}
	
	public boolean checkNickName(String nickName)
	{
		boolean esito = ui.checkNickName(nickName);
		
		return esito;
	}
	
	public ArrayList<Traccia> takeTraccia(String query)
	{
		ArrayList<Traccia> tracce = null;
		
		tracce = ti.takeTraccia(query);
		
		return tracce;
	}
	
	public ArrayList<Album> takeAlbum(String query, boolean flag)
	{
		ArrayList<Album> album = ai.takeAlbum(query, flag);
		
		return album;
	}
	
	public int insertAscolto(Traccia traccia, Utente utente, Calendar tempo)
	{
		int esito = 0;
		int ora = (int) Math.ceil(tempo.getTime().getHours() / 6);
		
		String query = "Insert into ascolta values('" + utente.getNickname() + "', " + traccia.getCodT() + ", "+ ora + ")";
		esito = asi.insertAscolto(query);
		
		return esito;
	}
	
	public int updateUtente(String nickname,String nome, String cognome, String nazione,String sesso,boolean IsPremium, boolean IsAdmin, String descrizione) {
		int esito=0;
		
		esito=ui.updateUtente(nickname, nome, cognome, nazione, sesso, IsPremium, IsAdmin, descrizione);
		
		return esito;
	}
	
	public int insertVoto(Utente utente, Traccia traccia, int voto)
	{
		int esito = vi.insertVoto("insert into vota values('" + utente.getNickname() + "', " + traccia.getCodT() + ", " + voto + ")");
		return esito;
	}
	
	public int deleteUtente(String nickName)
	{
		int esito = ui.deleteUtente("delete from utente where nickname = '"+ nickName +"'");
		
		return esito;
	}
	
	public ArrayList<Utente> takeUtente(String nickName)
	{
		
		ArrayList<Utente> utenti = ui.takeUtente("Select * from utente where nickname = '" + nickName + "'");
		
		return utenti;
	}
	
	public ArrayList<Utente> showUtenti(String query)
	{
		ArrayList<Utente> utenti =ui.takeUtente(query);
		
		return utenti;
	}
	
	public ArrayList<Playlist> takePlaylist( String query)
	{
		ArrayList<Playlist> playlist = pi.takePlaylist(query);
		return playlist;
	}
	
	public ArrayList<Artista> takeArtisti(String query)
	{
		ArrayList<Artista> artisti = art.takeArtista(query);
		return artisti;
	}
	
	public void updatePlaylist(String query)
	{
		int esito = pi.updatePlaylist(query);
	}
	
	public ArrayList<Ascolto> takeAscolto(String query)
	{
		ArrayList<Ascolto> ascolti= asi.takeAscolti(query);
		return ascolti;
	}
	
	public boolean checkVoto(String query)
	{
		boolean flag=false;
		flag=vi.checkVoto(query);
		return flag;
	}
	
	public int updateVoto(String query)
	{
		int esito;
		esito=vi.updateVoto(query);
		return esito;
	}
}
