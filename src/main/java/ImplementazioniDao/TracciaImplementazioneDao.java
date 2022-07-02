package ImplementazioniDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import ConnessioneDatabase.Connessione;
import DAO.TracciaDAO;
import Model.Album;
import Model.Artista;
import Model.Traccia;

public class TracciaImplementazioneDao implements TracciaDAO {
	
private Connection connection;
	
	public TracciaImplementazioneDao()
	{
		try {
			connection = Connessione.getInstance().getConnection();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Traccia> takeTraccia(String query) {
		ArrayList<Traccia> traccia = new ArrayList<Traccia>();
		Traccia t = null;
		
		String titolo, etichetta, genere, link, formato, queryArtisti;
		Time durata;
		int annoU, qualita, voto, codA, codTC, codTR, codT;
		boolean isCover, isRemastered;
		
		AlbumImplementazioneDao albumDao = null;
		TracciaImplementazioneDao tr = null;
		TracciaImplementazioneDao tc = null;
		
		Traccia tracciaR = null;
		Traccia tracciaC = null;
		Album a = null;
		
		ArrayList<Album> album = new ArrayList<Album>();
		ArrayList<Traccia> trr= new ArrayList<Traccia>();
		ArrayList<Traccia> tcc= new ArrayList<Traccia>();
		ArrayList<Artista> artisti = new ArrayList<Artista>();
		ArtistaImplementazioneDao ai = new ArtistaImplementazioneDao();
		
		try {
			PreparedStatement queryTakeTraccia = connection.prepareStatement
			(query);
			
			ResultSet rs = queryTakeTraccia.executeQuery();
			
			while(rs.next())
			{
				titolo = rs.getString("Titolo");
				etichetta = rs.getString("Etichetta");
				genere = rs.getString("Genere");
				link = rs.getString("Link");
				formato = rs.getString("Formato");
				durata = rs.getTime("Durata");
				annoU = rs.getInt("AnnoU");
				qualita = rs.getInt("Qualita");
				voto = rs.getInt("Voto");
				isCover = rs.getBoolean("IsCover");
				isRemastered = rs.getBoolean("IsRemastered");
				codA = rs.getInt("CodA");
				codTC = rs.getInt("CodTC");
				codTR= rs.getInt("CodTR");
				codT = rs.getInt("CodT");
				albumDao = new AlbumImplementazioneDao();
				tr = new TracciaImplementazioneDao();
				tc = new TracciaImplementazioneDao();
				
				if(codA != 0)
				{
					album = albumDao.takeAlbum("SELECT * FROM ALBUM WHERE CodA="+codA, false);
					a = album.get(0);
				}
				
				
				if(codTR != 0)
				{ 
					trr = tr.takeTraccia("SELECT * FROM TRACCIA WHERE CodT="+codTR);
					tracciaR=trr.get(0);
				}
				if(codTC != 0)
				{ 
					tcc = tc.takeTraccia("SELECT * FROM TRACCIA WHERE CodT="+codTC);
					tracciaC=tcc.get(0);
				}
				
				queryArtisti = "SELECT * FROM ARTISTA, PRODUCE WHERE ARTISTA.NOMEARTE = PRODUCE.NOMEARTE AND PRODUCE.CODT = " + codT;
				artisti = ai.takeArtista(queryArtisti);
				t = new Traccia(titolo, durata, etichetta, annoU, genere, link, formato, qualita, voto, isCover, isRemastered, a, tracciaR, tracciaC, artisti, codT);
				traccia.add(t);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return traccia;
	}
}
