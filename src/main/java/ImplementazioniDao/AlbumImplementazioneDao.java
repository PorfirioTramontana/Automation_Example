package ImplementazioniDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import ConnessioneDatabase.Connessione;
import DAO.AlbumDAO;
import Model.Album;
import Model.Artista;
import Model.Traccia;

public class AlbumImplementazioneDao implements AlbumDAO {
	private Connection connection;
	
	public AlbumImplementazioneDao()
	{
		try {
			connection = Connessione.getInstance().getConnection();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Album> takeAlbum(String query, boolean flag) {
		ArrayList<Album> album= new ArrayList<Album>();
		ArrayList<Artista> artisti = new ArrayList<Artista>();
		ArtistaImplementazioneDao ai = new ArtistaImplementazioneDao();
		TracciaImplementazioneDao ti = new TracciaImplementazioneDao();
		Album a = null;
		ArrayList <Traccia> tracce = new ArrayList<Traccia>();
		
		String titolo, etichetta, queryArtisti;
		int annou, ntracce, voto, codA;
		Time durata;
		
		try {
			PreparedStatement queryTakeAlbum = connection.prepareStatement
			(query);
			
			ResultSet rs = queryTakeAlbum.executeQuery();
			
			while(rs.next())
			{
				titolo = rs.getString("Titolo");
				etichetta = rs.getString("Etichetta");
				annou = rs.getInt("AnnoU");
				ntracce = rs.getInt("Ntracce");
				voto = rs.getInt("Voto");
				durata = rs.getTime("Durata");
				codA = rs.getInt("CodA");
				
				queryArtisti = "SELECT * FROM ARTISTA, INCIDE WHERE INCIDE.NOMEARTE = ARTISTA.NOMEARTE AND INCIDE.CODA = " + codA;
				artisti = ai.takeArtista(queryArtisti);
				if(flag)
				{
					tracce = ti.takeTraccia("Select * from traccia where coda = " + codA);
				}
				else
				{
					tracce = null;
				}
				
				a = new Album(titolo, annou, durata, ntracce, etichetta, voto, artisti, tracce);
				album.add(a);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return album;
	}
	
}
