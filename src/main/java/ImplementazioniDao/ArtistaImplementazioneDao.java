package ImplementazioniDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnessioneDatabase.Connessione;
import DAO.ArtistaDAO;
import Model.Album;
import Model.Artista;

public class ArtistaImplementazioneDao implements ArtistaDAO{
	private Connection connection;
	
	public ArtistaImplementazioneDao()
	{
		try {
			connection = Connessione.getInstance().getConnection();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Artista> takeArtista(String query) 
	{
		ArrayList<Artista> artisti = new ArrayList<Artista>();
		String nomeArte, descrizione;
		int voto;
		Artista artista;
		
		try {
			PreparedStatement queryTakeArtista = connection.prepareStatement
			(query);
			
			ResultSet rs = queryTakeArtista.executeQuery();
			
			while(rs.next())
			{
				nomeArte = rs.getString(1);
				descrizione = rs.getString(2);
				voto = rs.getInt(3);
				
				artista = new Artista(nomeArte, descrizione, voto, null, null);
				artisti.add(artista);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return artisti;
	}
}
