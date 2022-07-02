package ImplementazioniDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnessioneDatabase.Connessione;
import DAO.VotoDAO;
import Model.Album;

public class VotoImplementazioneDao implements VotoDAO {
	private Connection connection;
	
	public VotoImplementazioneDao()
	{
		try {
			connection = Connessione.getInstance().getConnection();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	@Override
	public int insertVoto(String query) {
		int esito = 0;
		
		try {
			PreparedStatement queryInsertVoto = connection.prepareStatement
			(query);
			
			esito = queryInsertVoto.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return esito;
	}
	public boolean checkVoto(String query)
	{
		boolean	flag=false;
		try 
		{
			PreparedStatement queryCheckVoto = connection.prepareStatement(query);
					
			ResultSet rs = queryCheckVoto.executeQuery();
			
			while(rs.next())
			{
				flag=true;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public int updateVoto(String query)
	{
		int esito=0;
		
		try
		{
			PreparedStatement queryUpdateVoto = connection.prepareStatement
					(query);
					
					esito = queryUpdateVoto.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return esito;
	}

}
