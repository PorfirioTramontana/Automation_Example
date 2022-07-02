package ImplementazioniDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnessioneDatabase.Connessione;
import DAO.AscoltoDAO;
import Model.Ascolto;
import Model.Traccia;
import Model.Utente;

public class AscoltoImplementazioneDao implements AscoltoDAO {

	private Connection connection;
	private TracciaImplementazioneDao ti;
	private UtenteImplementazioneDao ui;
	
	public AscoltoImplementazioneDao()
	{
		try {
			connection = Connessione.getInstance().getConnection();
			ti = new TracciaImplementazioneDao();
			ui = new UtenteImplementazioneDao();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	@Override
	public int insertAscolto(String query) {
		int esito = 0;
		
		try{
			PreparedStatement queryInsertAscolto = connection.prepareStatement(query);
			esito = queryInsertAscolto.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return esito;
	}
	
	
	public ArrayList<Ascolto> takeAscolti(String query) 
	{ 
		ArrayList<Ascolto> ascolti= new ArrayList<Ascolto>();
		ArrayList<Utente> utenti ;
		ArrayList<Traccia> tracce ; 
		Ascolto a=null;
		
		String nickname;
		int codT;
		int fascia;
		
		try{
			PreparedStatement queryAscolto = connection.prepareStatement(query);
			ResultSet rs = queryAscolto.executeQuery();
			
			while(rs.next())
			{
				nickname=rs.getString("NickName");
				codT=rs.getInt("CodT");
				fascia=rs.getInt("fasciaoraria");
				utenti=ui.takeUtente("SELECT * FROM UTENTE WHERE NICKNAME='"+nickname+"' ;");
				tracce=ti.takeTraccia("SELECT * FROM TRACCIA WHERE CODT="+codT+";");
				a= new Ascolto(utenti.get(0),tracce.get(0),fascia);
				ascolti.add(a);
				System.out.println(a.getFascia());
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return ascolti ;
	}


}
