package DAO;

import java.util.ArrayList;

import Model.Artista;

public interface ArtistaDAO {
	ArrayList<Artista> takeArtista(String query);
}
