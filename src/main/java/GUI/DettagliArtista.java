package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Album;
import Model.Artista;
import Model.Traccia;
import Model.Utente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DettagliArtista extends JFrame {

	private JPanel contentPane;
	private DettagliArtista dettagliArtista;
	private JButton btnTornaIndietro = new JButton("Torna Indietro");
	private ArrayList<Traccia> tracce = new ArrayList<Traccia>();
	private DefaultListModel dlm_traccia = new DefaultListModel();
	private DefaultListModel dlm_album = new DefaultListModel();
	private ArrayList<Album> album = new ArrayList<Album>();
	private JList list_Tracce = new JList();
	private JList list_Album = new JList();
	private JTextField voto;
	private JEditorPane descrizione = new JEditorPane();
	private JButton btnDettagliTraccia = new JButton("Dettagli");
	
	public DettagliArtista(JFrame home, Controller controller, Artista artista,JFrame indietro, Utente utente) {
		
		dettagliArtista = this;
		dettagliArtista.setVisible(true);
		home.setVisible(false);
		System.out.println("Sei in DettagliArtista");
		
		if(indietro == null)
		{
			btnTornaIndietro.setVisible(false);
		}
		else
		{
			indietro.setVisible(false);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(224, 255, 255));
		setContentPane(contentPane);
		
		JLabel lblArtista = new JLabel("Informazoni su "+artista.getNomearte());
		lblArtista.setHorizontalAlignment(SwingConstants.LEFT);
		lblArtista.setForeground(new Color(34, 139, 34));
		lblArtista.setFont(new Font("Arial", Font.PLAIN, 50));
		lblArtista.setBounds(10, 10, 688, 54);
		contentPane.add(lblArtista);
		
		JButton btnHome = new JButton("Torna in home");
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home.setVisible(true);
				System.out.println("Ti trovi in home");
				dettagliArtista.dispose();
			}
		});
		btnHome.setForeground(Color.BLACK);
		btnHome.setFont(new Font("Arial", Font.BOLD, 26));
		btnHome.setBackground(Color.RED);
		btnHome.setBounds(794, 64, 249, 37);
		contentPane.add(btnHome);
		btnTornaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indietro.setVisible(true);
				System.out.println("Stai tornando Indietro");
				dettagliArtista.dispose();
			}
		});
		
		
		btnTornaIndietro.setForeground(Color.BLACK);
		btnTornaIndietro.setFont(new Font("Arial", Font.BOLD, 26));
		btnTornaIndietro.setBackground(new Color(255, 69, 0));
		btnTornaIndietro.setBounds(794, 131, 249, 37);
		contentPane.add(btnTornaIndietro);
		
		JLabel lblNewLabel = new JLabel("Tracce Prodotte:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 97, 177, 54);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 147, 197, 385);
		contentPane.add(scrollPane_1);
		list_Tracce.setFont(new Font("Arial", Font.PLAIN, 22));
		scrollPane_1.setViewportView(list_Tracce);
		
		JLabel lblNewLabel_1 = new JLabel("Album prodotti:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(227, 97, 177, 54);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(227, 146, 197, 385);
		contentPane.add(scrollPane_2);
		list_Album.setFont(new Font("Arial", Font.PLAIN, 22));
		scrollPane_2.setViewportView(list_Album);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descrizione:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(434, 159, 177, 54);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Voto:");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1_1_1.setBounds(434, 320, 177, 54);
		contentPane.add(lblNewLabel_1_1_1);
		
		voto = new JTextField();
		voto.setFont(new Font("Arial", Font.PLAIN, 22));
		voto.setEditable(false);
		voto.setBounds(434, 369, 72, 45);
		contentPane.add(voto);
		voto.setColumns(10);
		
		if(artista.getDescrizione() == null)
		{
			descrizione.setText("Nessuna descrizione");
			descrizione.setFont(new Font("Arial", Font.ITALIC, 22));
		}
		else
		{
			descrizione.setText(artista.getDescrizione());
		}
		
		voto.setText("" + artista.getVoto());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(434, 198, 249, 135);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(descrizione);
		descrizione.setFont(new Font("Arial", Font.PLAIN, 22));
		descrizione.setEditable(false);
		
		setTracce(controller, artista);
		setAlbum(controller, artista);
		btnDettagliTraccia.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list_Tracce.getSelectedIndex() != -1)
				{
					DettagliTraccia dt = new DettagliTraccia(home, tracce.get(list_Tracce.getSelectedIndex()), controller, dettagliArtista, utente);
				}
				else
				{
					JOptionPane.showMessageDialog(btnDettagliTraccia, "Scegliere la traccia");
				}
			}
		});
		
		btnDettagliTraccia.setForeground(Color.BLACK);
		btnDettagliTraccia.setFont(new Font("Arial", Font.BOLD, 26));
		btnDettagliTraccia.setBackground(new Color(244, 164, 96));
		btnDettagliTraccia.setBounds(10, 540, 154, 37);
		contentPane.add(btnDettagliTraccia);
		
		JButton btnDettagliAlbum = new JButton("Dettagli");
		btnDettagliAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list_Album.getSelectedIndex() != -1)
				{
					DettagliAlbum da = new DettagliAlbum(home, controller, album.get(list_Album.getSelectedIndex()), dettagliArtista, utente);
				}
				else
				{
					JOptionPane.showMessageDialog(btnDettagliTraccia, "Scegliere la traccia");
				}
			}
		});
		btnDettagliAlbum.setForeground(Color.BLACK);
		btnDettagliAlbum.setFont(new Font("Arial", Font.BOLD, 26));
		btnDettagliAlbum.setBackground(new Color(244, 164, 96));
		btnDettagliAlbum.setBounds(227, 540, 154, 37);
		contentPane.add(btnDettagliAlbum);
	}
	
	private void setTracce(Controller controller,Artista artista)
	{
		tracce=controller.takeTraccia("SELECT T.CodT,Titolo,Durata,Etichetta,AnnoU,IsCover,IsRemastered,Genere,Link,Formato,Voto,Qualita,CodA,CodTR,CodTC FROM PRODUCE AS P,TRACCIA AS T WHERE P.NomeArte= '"+artista.getNomearte()+"' AND T.CodT=P.CodT;");
		int i;
		
		for(i=0;i<tracce.size();i++)
		{
			dlm_traccia.addElement(""+tracce.get(i).getTitolo());
		}
		list_Tracce.setModel(dlm_traccia);
	}
	
	private void setAlbum(Controller controller,Artista artista)
	{
		album=controller.takeAlbum("SELECT A.CodA,Titolo,AnnoU,Durata,Ntracce,Etichetta,Voto FROM INCIDE AS I,ALBUM AS A WHERE I.NomeArte= '"+artista.getNomearte()+"' AND I.CodA=A.CodA",true);
		
		int i;
		
		for(i=0;i<album.size();i++)
		{
			dlm_album.addElement(""+album.get(i).getTitolo());
		}
		list_Album.setModel(dlm_album);
	}
}
