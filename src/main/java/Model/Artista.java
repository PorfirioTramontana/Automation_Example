package Model;

import java.util.ArrayList;

public class Artista {
	private String nomearte;
	private String descrizione;
	private ArrayList<Traccia> tracce;
	private ArrayList<Album> album;
	private int voto;
	
	public Artista(String nomearte,String descrizione ,int voto, ArrayList<Traccia> tracce, ArrayList<Album> album) {
		this.nomearte=nomearte;
		this.descrizione=descrizione;
		this.voto=voto;
		this.tracce = tracce;
		this.album = album;
	}

	public String getNomearte() {return nomearte;}

	public String getDescrizione() {return descrizione;}

	public int getVoto() {return voto;}

	public ArrayList<Traccia> getTracce() {return tracce;}

	public ArrayList<Album> getAlbum() {return album;}

	public void setTracce(ArrayList<Traccia> tracce) {this.tracce = tracce;}

	public void setAlbum(ArrayList<Album> album) {this.album = album;}
	
	
}
