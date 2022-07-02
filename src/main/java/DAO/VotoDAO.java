package DAO;

public interface VotoDAO {
	int insertVoto(String query);
	boolean checkVoto(String query);
	int updateVoto(String query);
}
