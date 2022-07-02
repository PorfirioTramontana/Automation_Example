package ImplementazioniDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import ConnessioneDatabase.Connessione;
import DAO.PlaylistDAO;
import Model.Playlist;
import Model.Utente;

public class PlaylistImplementazioneDao implements PlaylistDAO {
	private UtenteImplementazioneDao ui;
	private Connection connection;
	
	public PlaylistImplementazioneDao()
	{
		ui = new UtenteImplementazioneDao();
		try {
			connection = Connessione.getInstance().getConnection();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Playlist> takePlaylist(String query) {
		ArrayList<Playlist> playlist=new ArrayList<Playlist>();
		ArrayList<Utente> utenti=new ArrayList<Utente>();
		Playlist p=null;
		String titolo = "";
		String utente;
		int numTracce = 0;
		int CodP=0;
		boolean visibilita = false;
		Time durata = null;
		Utente u;
				
		try {PreparedStatement queryTakePlaylist=connection.prepareStatement(query);
		ResultSet rs=queryTakePlaylist.executeQuery();
		while(rs.next()) {
			CodP=rs.getInt("CodP");
			titolo=rs.getString("Titolo");
			numTracce=rs.getInt("Ntracce");
			visibilita=rs.getBoolean("Visibilita"); //nel DB sta l'accento
			durata=rs.getTime("Durata");
			utente=rs.getString("NickName");
			utenti=ui.takeUtente("SELECT * FROM UTENTE WHERE NickName= '"+utente+"';");
			u=utenti.get(0);
			p=new Playlist(titolo,numTracce,visibilita,durata,u,CodP);
			playlist.add(p);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return playlist;
	}

	@Override
	public int updatePlaylist(String query) {
		int esito = 0;
		
		try
		{
			PreparedStatement queryUpdatePlaylist= connection.prepareStatement(query);
			esito=queryUpdatePlaylist.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return esito;
	}
}
