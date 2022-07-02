package DAO;
import java.util.ArrayList;

import Model.Playlist;

public interface PlaylistDAO {
	ArrayList<Playlist> takePlaylist(String query);
	int updatePlaylist(String query);
}
