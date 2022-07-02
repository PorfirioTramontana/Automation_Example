package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Album;
import Model.Traccia;
import Model.Utente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DettagliTraccia extends JFrame {

	private JPanel contentPane;
	private JFrame dettagliTraccia;
	private JTextField titoloField;
	private JTextField durataField;
	private JTextField etichettaField;
	private JTextField annoUscitaField;
	private JTextField tipoField;
	private JTextField genereField;
	private JTextField formatoField;
	private JTextField qualitaField;
	private JTextField votoField;
	private Utente utente;
	private JButton btnTornaIndietro_2 = new JButton("Torna indietro");
	
	public DettagliTraccia(JFrame home, Traccia traccia, Controller controller, JFrame indietro, Utente utente) 
	{
		this.utente = utente;
		if(indietro != null)
		{
			indietro.setVisible(false);
		}
		else
		{
			btnTornaIndietro_2.setVisible(false);
		}
		
		home.setVisible(false);
		dettagliTraccia = this;
		dettagliTraccia.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(224, 255, 255));
		setContentPane(contentPane);
		
		JLabel lblHome = new JLabel(traccia.getTitolo());
		lblHome.setHorizontalAlignment(SwingConstants.LEFT);
		lblHome.setForeground(new Color(34, 139, 34));
		lblHome.setFont(new Font("Arial", Font.PLAIN, 50));
		lblHome.setBounds(10, 11, 742, 54);
		contentPane.add(lblHome);
		
		JLabel lblTitolo = new JLabel("Titolo:");
		lblTitolo.setForeground(new Color(0, 0, 205));
		lblTitolo.setFont(new Font("Arial", Font.PLAIN, 28));
		lblTitolo.setBounds(10, 84, 99, 37);
		contentPane.add(lblTitolo);
		
		JLabel lblDurata = new JLabel("Durata:");
		lblDurata.setForeground(new Color(0, 0, 205));
		lblDurata.setFont(new Font("Arial", Font.PLAIN, 28));
		lblDurata.setBounds(10, 168, 99, 37);
		contentPane.add(lblDurata);
		
		JLabel lblEtichetta = new JLabel("Etichetta:");
		lblEtichetta.setForeground(new Color(0, 0, 205));
		lblEtichetta.setFont(new Font("Arial", Font.PLAIN, 28));
		lblEtichetta.setBounds(10, 262, 151, 37);
		contentPane.add(lblEtichetta);
		
		JLabel lblAnnoDiUscita = new JLabel("Anno di uscita:");
		lblAnnoDiUscita.setForeground(new Color(0, 0, 205));
		lblAnnoDiUscita.setFont(new Font("Arial", Font.PLAIN, 28));
		lblAnnoDiUscita.setBounds(10, 346, 185, 37);
		contentPane.add(lblAnnoDiUscita);
		
		JLabel lblTipoDiTraccia = new JLabel("Tipo di traccia:");
		lblTipoDiTraccia.setForeground(new Color(0, 0, 205));
		lblTipoDiTraccia.setFont(new Font("Arial", Font.PLAIN, 28));
		lblTipoDiTraccia.setBounds(10, 427, 185, 37);
		contentPane.add(lblTipoDiTraccia);
		
		JLabel lblGenere = new JLabel("Genere:");
		lblGenere.setForeground(new Color(0, 0, 205));
		lblGenere.setFont(new Font("Arial", Font.PLAIN, 28));
		lblGenere.setBounds(10, 509, 185, 37);
		contentPane.add(lblGenere);
		
		titoloField = new JTextField();
		titoloField.setEditable(false);
		titoloField.setFont(new Font("Arial", Font.PLAIN, 22));
		titoloField.setColumns(10);
		titoloField.setBounds(10, 119, 307, 45);
		contentPane.add(titoloField);
		
		durataField = new JTextField();
		durataField.setEditable(false);
		durataField.setFont(new Font("Arial", Font.PLAIN, 22));
		durataField.setColumns(10);
		durataField.setBounds(10, 216, 307, 45);
		contentPane.add(durataField);
		
		etichettaField = new JTextField();
		etichettaField.setEditable(false);
		etichettaField.setFont(new Font("Arial", Font.PLAIN, 22));
		etichettaField.setColumns(10);
		etichettaField.setBounds(10, 298, 307, 45);
		contentPane.add(etichettaField);
		
		annoUscitaField = new JTextField();
		annoUscitaField.setEditable(false);
		annoUscitaField.setFont(new Font("Arial", Font.PLAIN, 22));
		annoUscitaField.setColumns(10);
		annoUscitaField.setBounds(10, 381, 307, 45);
		contentPane.add(annoUscitaField);
		
		tipoField = new JTextField();
		tipoField.setEditable(false);
		tipoField.setFont(new Font("Arial", Font.PLAIN, 22));
		tipoField.setColumns(10);
		tipoField.setBounds(10, 461, 307, 45);
		contentPane.add(tipoField);
		
		genereField = new JTextField();
		genereField.setEditable(false);
		genereField.setFont(new Font("Arial", Font.PLAIN, 22));
		genereField.setColumns(10);
		genereField.setBounds(10, 544, 307, 45);
		contentPane.add(genereField);
		
		JLabel lblFormato = new JLabel("Formato:");
		lblFormato.setForeground(new Color(0, 0, 205));
		lblFormato.setFont(new Font("Arial", Font.PLAIN, 28));
		lblFormato.setBounds(391, 84, 131, 37);
		contentPane.add(lblFormato);
		
		formatoField = new JTextField();
		formatoField.setFont(new Font("Arial", Font.PLAIN, 22));
		formatoField.setEditable(false);
		formatoField.setColumns(10);
		formatoField.setBounds(391, 119, 307, 45);
		contentPane.add(formatoField);
		
		JLabel lblTitolo_1_1 = new JLabel("Qualit\u00E0:");
		lblTitolo_1_1.setForeground(new Color(0, 0, 205));
		lblTitolo_1_1.setFont(new Font("Arial", Font.PLAIN, 28));
		lblTitolo_1_1.setBounds(391, 168, 99, 37);
		contentPane.add(lblTitolo_1_1);
		
		JLabel lblTitolo_1_2 = new JLabel("Voto:");
		lblTitolo_1_2.setForeground(new Color(0, 0, 205));
		lblTitolo_1_2.setFont(new Font("Arial", Font.PLAIN, 28));
		lblTitolo_1_2.setBounds(391, 262, 99, 37);
		contentPane.add(lblTitolo_1_2);
		
		qualitaField = new JTextField();
		qualitaField.setFont(new Font("Arial", Font.PLAIN, 22));
		qualitaField.setEditable(false);
		qualitaField.setColumns(10);
		qualitaField.setBounds(391, 206, 56, 45);
		contentPane.add(qualitaField);
		
		votoField = new JTextField();
		votoField.setFont(new Font("Arial", Font.PLAIN, 22));
		votoField.setEditable(false);
		votoField.setColumns(10);
		votoField.setBounds(391, 298, 56, 45);
		contentPane.add(votoField);
		
		JLabel lblTitolo_1_2_1 = new JLabel("Artista/i:");
		lblTitolo_1_2_1.setForeground(new Color(0, 0, 205));
		lblTitolo_1_2_1.setFont(new Font("Arial", Font.PLAIN, 28));
		lblTitolo_1_2_1.setBounds(391, 369, 131, 37);
		contentPane.add(lblTitolo_1_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(391, 417, 307, 81);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 26));
		scrollPane.setViewportView(list);
		
		JButton btnTornaIndietro = new JButton("Torna ad home");
		btnTornaIndietro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home.setVisible(true);
				System.out.println("Ti trovi in home");
				dettagliTraccia.dispose();
			}
		});
		btnTornaIndietro.setForeground(Color.BLACK);
		btnTornaIndietro.setFont(new Font("Arial", Font.BOLD, 26));
		btnTornaIndietro.setBackground(Color.RED);
		btnTornaIndietro.setBounds(762, 11, 279, 37);
		contentPane.add(btnTornaIndietro);
		
		JButton btnVisualizzaOriginale = new JButton("Visualizza originale");
		btnVisualizzaOriginale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DettagliTraccia dettagliTraccia2;
				if(traccia.getIsIsCover())
				{
					dettagliTraccia2 = new DettagliTraccia(home, traccia.getTc(), controller, dettagliTraccia, utente);
				}
				else
				{
					dettagliTraccia2 = new DettagliTraccia(home, traccia.getTr(), controller, dettagliTraccia, utente);
				}
				
				System.out.println("Traccia originale");
			}
		});
		btnVisualizzaOriginale.setForeground(Color.BLACK);
		btnVisualizzaOriginale.setFont(new Font("Arial", Font.BOLD, 26));
		btnVisualizzaOriginale.setBackground(new Color(244, 164, 96));
		btnVisualizzaOriginale.setBounds(391, 566, 314, 37);
		contentPane.add(btnVisualizzaOriginale);
		
		JButton btnVisualizzaAlbum = new JButton("Visualizza album");
		btnVisualizzaAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ArrayList<Album> album = controller.takeAlbum("Select * from album, traccia where traccia.coda = album.coda and traccia.codt = " + traccia.getCodT(), true);
				DettagliAlbum dettagliAlbum = new DettagliAlbum(home, controller, album.get(0), dettagliTraccia, utente);
				System.out.println("Ti trovi in dettagli album");
			}
		});
		btnVisualizzaAlbum.setForeground(Color.BLACK);
		btnVisualizzaAlbum.setFont(new Font("Arial", Font.BOLD, 26));
		btnVisualizzaAlbum.setBackground(new Color(244, 164, 96));
		btnVisualizzaAlbum.setBounds(715, 518, 314, 37);
		contentPane.add(btnVisualizzaAlbum);
		
		if(traccia.getAlbum() == null)
		{
			btnVisualizzaAlbum.setVisible(false);
		}
		
		if(!traccia.getIsIsCover() && !traccia.getIsIsRemastered())
		{
			btnVisualizzaOriginale.setVisible(false);
		}
		
		titoloField.setText(traccia.getTitolo());
		durataField.setText(traccia.getDurata().toString());
		if(traccia.getEtichetta() == null)
		{
			etichettaField.setText("Nessuna");
		}
		else
		{
			etichettaField.setText(traccia.getEtichetta());
		}
		
		if(traccia.getIsIsCover())
		{
			tipoField.setText("Cover");
		}
		else if(traccia.getIsIsRemastered())
		{
			tipoField.setText("Remastered");
		}
		else
		{
			tipoField.setText("Originale");
		}
		
		formatoField.setText(traccia.getFormato());
		qualitaField.setText("" +traccia.getQualita());
		annoUscitaField.setText("" + traccia.getAnnoU());
		votoField.setText("" + traccia.getVoto());
		genereField.setText(traccia.getGenere());
		DefaultListModel mdl = new DefaultListModel();
		int i;
		for(i = 0; i < traccia.getArtisti().size(); i++)
		{
			mdl.addElement(traccia.getArtisti().get(i).getNomearte());
		}
		list.setModel(mdl);
		
		JButton btnVisualizzaArtista = new JButton("Visualizza artista");
		btnVisualizzaArtista.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(list.getSelectedIndex() != -1)
				{
					DettagliArtista da = new DettagliArtista(home, controller, traccia.getArtisti().get(list.getSelectedIndex()), dettagliTraccia, utente);
				}
				else
				{
					JOptionPane.showMessageDialog(btnVisualizzaArtista, "Scegliere un artista");
				}
			}
		});
		btnVisualizzaArtista.setForeground(Color.BLACK);
		btnVisualizzaArtista.setFont(new Font("Arial", Font.BOLD, 26));
		btnVisualizzaArtista.setBackground(new Color(244, 164, 96));
		btnVisualizzaArtista.setBounds(391, 518, 314, 37);
		contentPane.add(btnVisualizzaArtista);
		
		btnTornaIndietro_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				indietro.setVisible(true);
				System.out.println("Stai tornando indietro");
				dettagliTraccia.dispose();
			}
		});
		btnTornaIndietro_2.setForeground(Color.BLACK);
		btnTornaIndietro_2.setFont(new Font("Arial", Font.BOLD, 26));
		btnTornaIndietro_2.setBackground(Color.RED);
		btnTornaIndietro_2.setBounds(762, 107, 279, 37);
		contentPane.add(btnTornaIndietro_2);
		
		JButton btnAscolta = new JButton("Ascolta");
		btnAscolta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					try 
					{
				        java.awt.Desktop.getDesktop().browse(java.net.URI.create(traccia.getLink()));
				    } catch (java.io.IOException e1) {
				        System.out.println(e1.getMessage());
				    }
					
					int esito = controller.insertAscolto(traccia, utente, Calendar.getInstance());
					System.out.println(esito);
			}
		});
		
		btnAscolta.setForeground(Color.BLACK);
		btnAscolta.setFont(new Font("Arial", Font.BOLD, 26));
		btnAscolta.setBackground(new Color(244, 164, 96));
		btnAscolta.setBounds(762, 59, 279, 37);
		contentPane.add(btnAscolta);
	}
}
