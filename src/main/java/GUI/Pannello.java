package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Model.Ascolto;
import Model.Traccia;
import Model.Utente;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Pannello extends JFrame {

	private JPanel contentPane;
	private JTextField traccia;
	private ArrayList<Ascolto> ascoltio=new ArrayList<Ascolto>();
	private ArrayList<Ascolto> ascoltir=new ArrayList<Ascolto>();
	private ArrayList<Ascolto> ascoltic=new ArrayList<Ascolto>();
	private JFrame pannello;
	private JButton btnCerca = new JButton("Cerca");
	private JList list_original = new JList();
	private JList list_remastered = new JList();
	private JList list_cover = new JList();
	private JButton btnTornaHome = new JButton("Torna Home");
	private JButton btnTornaProfilo = new JButton("Torna al mio Profilo");
	private DefaultListModel dlmo=new DefaultListModel();
	private DefaultListModel dlmr=new DefaultListModel();
	private DefaultListModel dlmc=new DefaultListModel();

	
	public Pannello(JFrame myUtente,Controller controller,JFrame home) {
		
		System.out.println("Sei in Pannello Admin");
		myUtente.setVisible(false);
		home.setVisible(false);
		pannello=this;
		pannello.setVisible(true);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1067, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(224, 255, 255));
		setContentPane(contentPane);
		
		JLabel lblTitle = new JLabel("Zona Ricerca");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(new Color(34, 139, 34));
		lblTitle.setFont(new Font("Arial", Font.PLAIN, 50));
		lblTitle.setBounds(0, 10, 325, 54);
		contentPane.add(lblTitle);
		
		traccia = new JTextField();
		traccia.setFont(new Font("Tahoma", Font.ITALIC, 21));
		traccia.setText("");
		traccia.setColumns(10);
		traccia.setBounds(0, 186, 315, 54);
		contentPane.add(traccia);
		
		JLabel lblTraccialbl = new JLabel("Inserisci una Traccia");
		lblTraccialbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTraccialbl.setBounds(10, 93, 284, 44);
		contentPane.add(lblTraccialbl);
		btnCerca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!traccia.getText().equals(""))
				{
					ascoltio=controller.takeAscolto("SELECT A.NICKNAME,A.FASCIAORARIA,A.CodT FROM ASCOLTA AS A,TRACCIA AS T WHERE T.TITOLO= '"+traccia.getText()+"' AND A.CODT=T.CODT AND T.Iscover=false and T.IsRemastered=False ;");
					ascoltir=controller.takeAscolto("SELECT A.NICKNAME,A.FASCIAORARIA,A.CodT FROM ASCOLTA AS A,TRACCIA AS T WHERE T.TITOLO = '"+traccia.getText()+"' AND A.CODT=T.CODT AND T.IsRemastered=TRUE ;");
					ascoltic=controller.takeAscolto("SELECT A.NICKNAME,A.FASCIAORARIA,A.CodT FROM ASCOLTA AS A,TRACCIA AS T WHERE T.TITOLO = '"+traccia.getText()+"' AND A.CODT=T.CODT AND T.IsCover=TRUE ;");
					
					int i;
					for(i=0;i<ascoltio.size();i++) 
					{
						dlmo.addElement(""+ascoltio.get(i).getUtente().getNickname()+", in questa fascia:"+ascoltio.get(i).getFascia());
						
						
					}
					list_original.setModel(dlmo);
					for(i=0;i<ascoltir.size();i++)
					{
						dlmr.addElement(""+ascoltir.get(i).getUtente().getNickname()+", in questa fascia:"+ascoltir.get(i).getFascia());
					}
					list_remastered.setModel(dlmr);
					
					for(i=0;i<ascoltic.size();i++)
					{
						dlmc.addElement(""+ascoltic.get(i).getUtente()+", inquesta fascia oraria :" +ascoltic.get(i).getFascia());
					}
					list_cover.setModel(dlmc);
					
				}
				else {
					JOptionPane.showMessageDialog(btnCerca, "Inserire una traccia");
				}
			}
		});
		
		btnCerca.setForeground(Color.BLACK);
		btnCerca.setFont(new Font("Arial", Font.BOLD, 26));
		btnCerca.setBounds(53, 297, 154, 37);
		btnCerca.setBackground(new Color(244, 164, 96));
		contentPane.add(btnCerca);
		
		JLabel lblUtentiCheHanno = new JLabel("versione originale,ascoltata da:");
		lblUtentiCheHanno.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblUtentiCheHanno.setBounds(407, 44, 543, 44);
		contentPane.add(lblUtentiCheHanno);
		
		JLabel lblUtentiCheHanno_1 = new JLabel("versione remastered,ascoltata da:");
		lblUtentiCheHanno_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblUtentiCheHanno_1.setBounds(407, 261, 588, 44);
		contentPane.add(lblUtentiCheHanno_1);
		
		JLabel lblUtentiCheHanno_1_1 = new JLabel("versione cover,ascoltata da:");
		lblUtentiCheHanno_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblUtentiCheHanno_1_1.setBounds(407, 482, 588, 44);
		contentPane.add(lblUtentiCheHanno_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(417, 93, 532, 149);
		contentPane.add(scrollPane);
		list_original.setFont(new Font("Arial", Font.PLAIN, 22));
		
		
		scrollPane.setViewportView(list_original);
		list_remastered.setFont(new Font("Arial", Font.PLAIN, 22));
		
		
		list_remastered.setBounds(417, 313, 539, 159);
		contentPane.add(list_remastered);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(417, 525, 543, 125);
		contentPane.add(scrollPane_1);
		list_cover.setFont(new Font("Arial", Font.PLAIN, 22));
		
		
		scrollPane_1.setViewportView(list_cover);
		btnTornaHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				home.setVisible(true);
				System.out.println("Stai andando in Home");
				pannello.dispose();
			}
		});
		
		
		btnTornaHome.setFont(new Font("Arial", Font.PLAIN, 22));
		btnTornaHome.setBounds(10, 453, 249, 37);
		btnTornaHome.setForeground(Color.BLACK);
		btnTornaHome.setBackground(Color.RED);
		contentPane.add(btnTornaHome);
		btnTornaProfilo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myUtente.setVisible(true);
				System.out.println("Stai tornandno in MyUtente");
				pannello.dispose();
			}
		});
		
		
		btnTornaProfilo.setFont(new Font("Arial", Font.PLAIN, 22));
		btnTornaProfilo.setBounds(10, 500, 249, 37);
		btnTornaProfilo.setForeground(Color.BLACK);
		btnTornaProfilo.setBackground(new Color(255, 69, 0));
		contentPane.add(btnTornaProfilo);
		

	}
}
