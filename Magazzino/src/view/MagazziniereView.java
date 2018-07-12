package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.FlowLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class MagazziniereView extends JFrame {

	private JPanel contentPane;
	
	private JButton btnRegistraIngresso;
	private JButton btnRegistraUscita;
	private JButton btnSpostaArticolo;
	
	private JPanel dadPanel;
	private JPanel _registraIngressoPanel;
	private JPanel _registraUscitaPanel;
	private JPanel _spostaArticoloPanel;
	private JPanel panel_name;
	private JLabel lblRegistraIngresso;
	//private JPanel panel_date;
	private JSpinner hour;
	private SpinnerNumberModel h_model;
	private SpinnerNumberModel m_model;
	private JSpinner minute;
	private int hours;
	private int minutes;
	private Date date;
	private Calendar cal;
	private JPanel panel_2;
	private JPanel panel_add;
	private JPanel separ1;
	private JLabel label;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnAggiungi;
	private JLabel lblTipoDiArticolo;
	private JLabel lblPrezzo;
	private JLabel lblDataDiProduzione;
	private JComboBox type_field;
	private JSpinner price_field;
	private JFormattedTextField date_field;
	private JPanel separ2;
	private JPanel panel_6;
	private JPanel panel_riepilogo;
	private JLabel lblRiepilogoArticoliAggiunti;
	private JPanel panel_date;
	private JLabel lblInserisciLoraDellingresso;
	private JPanel panel_7;
	private JPanel panel_8;
	private JButton btnConfermaOrario;
	private JButton btnCambiaOrario;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JButton btnConfermaIngresso;
	private JPanel panel_12;
	private JPanel panel_13;
	private TableAddTest nlt;
	private JPanel panel_14;
	

	public MagazziniereView() {
		/*addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				System.out.println(e.getComponent().getSize());
			}
		});*/
		
		setTitle("Magazziniere");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#373737"));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{250, 0};
		gbl_panel.rowHeights = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblMenu = new JLabel("          MENU");
		lblMenu.setHorizontalAlignment(SwingConstants.LEFT);
		lblMenu.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblMenu.setForeground(Color.decode("#676767"));
		lblMenu.setBorder(null);
		GridBagConstraints gbc_lblMenu = new GridBagConstraints();
		gbc_lblMenu.anchor = GridBagConstraints.WEST;
		gbc_lblMenu.insets = new Insets(0, 0, 0, 0);
		gbc_lblMenu.gridx = 0;
		gbc_lblMenu.gridy = 3;
		panel.add(lblMenu, gbc_lblMenu);
		
		btnRegistraIngresso = new MyGUI.MyButton("Registra ingresso");
		btnRegistraIngresso.setText("          Registra ingresso");
		btnRegistraIngresso.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistraIngresso.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnRegistraIngresso.setBackground(Color.decode("#474747"));
		btnRegistraIngresso.setForeground(Color.decode("#F4F4F4"));
		btnRegistraIngresso.setBorder(null);
		GridBagConstraints gbc_btnRegistraIngresso = new GridBagConstraints();
		gbc_btnRegistraIngresso.fill = GridBagConstraints.BOTH;
		gbc_btnRegistraIngresso.insets = new Insets(0, 0, 0, 0);
		gbc_btnRegistraIngresso.gridx = 0;
		gbc_btnRegistraIngresso.gridy = 4;
		panel.add(btnRegistraIngresso, gbc_btnRegistraIngresso);
		
		btnRegistraUscita = new MyGUI.MyButton("Registra uscita");
		btnRegistraUscita.setText("          Registra uscita");
		btnRegistraUscita.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistraUscita.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnRegistraUscita.setBackground(Color.decode("#474747"));
		btnRegistraUscita.setForeground(Color.decode("#F4F4F4"));
		btnRegistraUscita.setBorder(null);
		GridBagConstraints gbc_btnRegistraUscita = new GridBagConstraints();
		gbc_btnRegistraUscita.insets = new Insets(0, 0, 0, 0);
		gbc_btnRegistraUscita.fill = GridBagConstraints.BOTH;
		gbc_btnRegistraUscita.gridx = 0;
		gbc_btnRegistraUscita.gridy = 5;
		panel.add(btnRegistraUscita, gbc_btnRegistraUscita);
		
		btnSpostaArticolo = new MyGUI.MyButton("Sposta articolo");
		btnSpostaArticolo.setText("          Sposta articolo");
		btnSpostaArticolo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSpostaArticolo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnSpostaArticolo.setBackground(Color.decode("#474747"));
		btnSpostaArticolo.setForeground(Color.decode("#F4F4F4"));
		btnSpostaArticolo.setBorder(null);
		GridBagConstraints gbc_btnSpostaArticolo = new GridBagConstraints();
		gbc_btnSpostaArticolo.insets = new Insets(0, 0, 0, 0);
		gbc_btnSpostaArticolo.fill = GridBagConstraints.BOTH;
		gbc_btnSpostaArticolo.gridx = 0;
		gbc_btnSpostaArticolo.gridy = 6;
		panel.add(btnSpostaArticolo, gbc_btnSpostaArticolo);
		
		
		JLabel lblImpostazioni = new JLabel("          IMPOSTAZIONI");
		lblImpostazioni.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblImpostazioni.setForeground(Color.decode("#676767"));
		lblImpostazioni.setBorder(null);
		GridBagConstraints gbc_lblImpostazioni = new GridBagConstraints();
		gbc_lblImpostazioni.insets = new Insets(0, 0, 0, 0);
		gbc_lblImpostazioni.anchor = GridBagConstraints.WEST;
		gbc_lblImpostazioni.gridx = 0;
		gbc_lblImpostazioni.gridy = 7;
		panel.add(lblImpostazioni, gbc_lblImpostazioni);
		
		JButton btnLogout = new MyGUI.MyButton("          Logout");
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnLogout.setBackground(Color.decode("#474747"));
		btnLogout.setForeground(Color.decode("#F4F4F4"));
		btnLogout.setBorder(null);
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.fill = GridBagConstraints.BOTH;
		gbc_btnLogout.gridx = 0;
		gbc_btnLogout.gridy = 8;
		panel.add(btnLogout, gbc_btnLogout);
		
		dadPanel = new JPanel();
		contentPane.add(dadPanel, BorderLayout.CENTER);
		dadPanel.setLayout(new CardLayout(0, 0));
		
		_registraIngressoPanel = new JPanel();
		JScrollPane scroller = new JScrollPane(dadPanel);
		this.getContentPane().add(scroller, BorderLayout.CENTER);
		_registraIngressoPanel.setBackground(Color.decode("#F4F4F4"));
		dadPanel.add(_registraIngressoPanel, "name_38889414123501");
		GridBagLayout gbl__registraIngressoPanel = new GridBagLayout();
	
		gbl__registraIngressoPanel.columnWidths = new int[]{0, 0};
		gbl__registraIngressoPanel.rowHeights = new int[]{70, 100, 2, 200, 2, 50, 0};
		gbl__registraIngressoPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl__registraIngressoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		_registraIngressoPanel.setLayout(gbl__registraIngressoPanel);
		
		panel_name = new JPanel();
		panel_name.setBorder(MyGUI.margin);
		panel_name.setBackground(Color.decode("#1BBC9B"));
		GridBagConstraints gbc_panel_name = new GridBagConstraints();
		gbc_panel_name.insets = new Insets(0, 0, 5, 0);
		gbc_panel_name.fill = GridBagConstraints.BOTH;
		gbc_panel_name.gridx = 0;
		gbc_panel_name.gridy = 0;
		_registraIngressoPanel.add(panel_name, gbc_panel_name);
		panel_name.setLayout(new BoxLayout(panel_name, BoxLayout.X_AXIS));
		
		lblRegistraIngresso = new JLabel("Registra ingresso");
		lblRegistraIngresso.setForeground(Color.decode("#F4F4F4"));
		lblRegistraIngresso.setFont(new Font("SansSerif", Font.BOLD, 26));
		panel_name.add(lblRegistraIngresso);
		
		panel_date = new JPanel();
		panel_date.setBackground(Color.decode("#F4F4F4"));
		panel_date.setBorder(MyGUI.margin);
		GridBagConstraints gbc_panel_date = new GridBagConstraints();
		gbc_panel_date.anchor = GridBagConstraints.NORTH;
		gbc_panel_date.insets = new Insets(0, 0, 5, 0);
		gbc_panel_date.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_date.gridx = 0;
		gbc_panel_date.gridy = 1;
		_registraIngressoPanel.add(panel_date, gbc_panel_date);
		panel_date.setLayout(new BorderLayout(0, 0));
		
		lblInserisciLoraDellingresso = new JLabel("Inserisci l'orario dell'ingresso:");
		lblInserisciLoraDellingresso.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblInserisciLoraDellingresso.setForeground(Color.decode("#373737"));
		lblInserisciLoraDellingresso.setBorder(new EmptyBorder(10, 0, 0, 0));
		panel_date.add(lblInserisciLoraDellingresso, BorderLayout.NORTH);
		
		panel_7 = new JPanel();
		panel_7.setBackground(Color.decode("#F4F4F4"));
		panel_date.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		panel_10 = new JPanel();
		panel_7.setBackground(Color.decode("#F4F4F4"));
		panel_7.add(panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{120, 120, 0};
		gbl_panel_10.rowHeights = new int[]{33, 0};
		gbl_panel_10.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_10.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_10.setLayout(gbl_panel_10);
		
		btnConfermaOrario = new MyGUI.MyButton("Conferma");
		GridBagConstraints gbc_btnConferma = new GridBagConstraints();
		gbc_btnConferma.fill = GridBagConstraints.BOTH;
		gbc_btnConferma.insets = new Insets(0, 0, 0, 5);
		gbc_btnConferma.gridx = 0;
		gbc_btnConferma.gridy = 0;
		panel_10.add(btnConfermaOrario, gbc_btnConferma);
		btnConfermaOrario.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnConfermaOrario.setBackground(Color.decode("#1BBC9B"));
		btnConfermaOrario.setForeground(Color.decode("#F4F4F4"));
		btnConfermaOrario.setBorder(null);
		
		btnCambiaOrario = new MyGUI.MyButton("Cambia");
		btnCambiaOrario.setEnabled(false);
		btnCambiaOrario.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCambiaOrario.setBackground(Color.decode("#373737"));
		btnCambiaOrario.setForeground(Color.decode("#F4F4F4"));
		btnCambiaOrario.setBorder(null);
		GridBagConstraints gbc_btnCambia = new GridBagConstraints();
		gbc_btnCambia.fill = GridBagConstraints.BOTH;
		gbc_btnCambia.gridx = 1;
		gbc_btnCambia.gridy = 0;
		panel_10.add(btnCambiaOrario, gbc_btnCambia);
		
		/*btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minute.setEnabled(false);
				hour.setEnabled(false);
				btnConferma.setEnabled(false);
				btnCambia.setEnabled(true);
				btnConferma.setBackground(Color.decode("#373737"));
				btnCambia.setBackground(Color.decode("#1BBC9B"));
			}
		});
		
		btnCambia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minute.setEnabled(true);
				hour.setEnabled(true);
				btnConferma.setEnabled(true);
				btnCambia.setEnabled(false);
				btnConferma.setBackground(Color.decode("#1BBC9B"));
				btnCambia.setBackground(Color.decode("#373737"));
			}
		});*/
		
		panel_8 = new JPanel();
		panel_8.setBorder(new EmptyBorder(10, 0, 0, 0));
		panel_8.setBackground(Color.decode("#F4F4F4"));
		panel_date.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		
		panel_9 = new JPanel();
		panel_8.add(panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{50, 50, 0};
		gbl_panel_9.rowHeights = new int[] {30, 0};
		gbl_panel_9.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		date = new Date();
		cal = Calendar.getInstance();
		cal.setTime(date);  
		hours = cal.get(Calendar.HOUR_OF_DAY);
		minutes = cal.get(Calendar.MINUTE);
		
		hour = new JSpinner();
		hour.setModel(new SpinnerNumberModel(hours, 0, 23, 1));
		hour.setFont(new Font("SansSerif", Font.PLAIN, 14));
		hour.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#373737")));
		GridBagConstraints gbc_hour = new GridBagConstraints();
		gbc_hour.fill = GridBagConstraints.BOTH;
		gbc_hour.anchor = GridBagConstraints.NORTHWEST;
		gbc_hour.insets = new Insets(0, 0, 0, 5);
		gbc_hour.gridx = 0;
		gbc_hour.gridy = 0;
		panel_9.add(hour, gbc_hour);
		
		minute = new JSpinner();
		minute.setFont(new Font("SansSerif", Font.PLAIN, 14));
		minute.setModel(new SpinnerNumberModel(minutes, 0, 59, 1));
		minute.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#373737")));
		GridBagConstraints gbc_minute = new GridBagConstraints();
		gbc_minute.fill = GridBagConstraints.BOTH;
		gbc_minute.anchor = GridBagConstraints.NORTHWEST;
		gbc_minute.insets = new Insets(0, 5, 0, 0);
		gbc_minute.gridx = 1;
		gbc_minute.gridy = 0;
		panel_9.add(minute, gbc_minute);
		
		separ1 = new JPanel();
		separ1.setBackground(Color.decode("#F4F4F4"));
		separ1.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.decode("#373737")));
		GridBagConstraints gbc_separ1 = new GridBagConstraints();
		gbc_separ1.insets = new Insets(0, 0, 5, 0);
		gbc_separ1.fill = GridBagConstraints.BOTH;
		gbc_separ1.gridx = 0;
		gbc_separ1.gridy = 2;
		_registraIngressoPanel.add(separ1, gbc_separ1);
		
		panel_add = new JPanel();
		panel_add.setBackground(Color.decode("#F4F4F4"));
		panel_add.setBorder(MyGUI.margin);
		GridBagConstraints gbc_panel_add = new GridBagConstraints();
		gbc_panel_add.insets = new Insets(0, 0, 5, 0);
		gbc_panel_add.fill = GridBagConstraints.BOTH;
		gbc_panel_add.gridx = 0;
		gbc_panel_add.gridy = 3;
		_registraIngressoPanel.add(panel_add, gbc_panel_add);
		panel_add.setLayout(new BorderLayout(0, 0));
		
		label = new JLabel("Aggiungi un articolo:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.decode("#373737"));
		label.setFont(new Font("SansSerif", Font.BOLD, 14));
		label.setBorder(null);
		panel_add.add(label, BorderLayout.NORTH);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.decode("#F4F4F4"));
		panel_add.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.decode("#F4F4F4"));
		panel_add.add(panel_4, BorderLayout.WEST);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{240, 240, 0};
		gbl_panel_4.rowHeights = new int[] {33, 33, 33};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0};
		panel_4.setLayout(gbl_panel_4);
		
		lblTipoDiArticolo = new JLabel("Tipo di articolo");
		lblTipoDiArticolo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_lblTipoDiArticolo = new GridBagConstraints();
		gbc_lblTipoDiArticolo.anchor = GridBagConstraints.WEST;
		gbc_lblTipoDiArticolo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoDiArticolo.gridx = 0;
		gbc_lblTipoDiArticolo.gridy = 0;
		panel_4.add(lblTipoDiArticolo, gbc_lblTipoDiArticolo);
		
		type_field = new JComboBox();
		type_field.setFont(new Font("SansSerif", Font.PLAIN, 14));
		type_field.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#373737")));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_4.add(type_field, gbc_textField);
		
		lblPrezzo = new JLabel("Prezzo");
		lblPrezzo.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPrezzo = new GridBagConstraints();
		gbc_lblPrezzo.anchor = GridBagConstraints.WEST;
		gbc_lblPrezzo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrezzo.gridx = 0;
		gbc_lblPrezzo.gridy = 1;
		panel_4.add(lblPrezzo, gbc_lblPrezzo);
		
		panel_14 = new JPanel();
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.anchor = GridBagConstraints.WEST;
		gbc_panel_14.fill = GridBagConstraints.VERTICAL;
		gbc_panel_14.insets = new Insets(0, 0, 5, 0);
		gbc_panel_14.gridx = 1;
		gbc_panel_14.gridy = 1;
		panel_4.add(panel_14, gbc_panel_14);
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[]{20, 0};
		gbl_panel_14.rowHeights = new int[]{30, 0};
		gbl_panel_14.columnWeights = new double[]{0.1, Double.MIN_VALUE};
		gbl_panel_14.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_14.setLayout(gbl_panel_14);
		
		price_field = new JSpinner();
		price_field.setModel(new SpinnerNumberModel(0.00, 0.00, 100000, 0.01));
		price_field.setFont(new Font("SansSerif", Font.PLAIN, 14));
		price_field.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#373737")));
		GridBagConstraints gbc_price_field = new GridBagConstraints();
		gbc_price_field.anchor = GridBagConstraints.WEST;
		gbc_price_field.fill = GridBagConstraints.VERTICAL;
		gbc_price_field.gridx = 0;
		gbc_price_field.gridy = 0;
		panel_14.add(price_field, gbc_price_field);
		
		lblDataDiProduzione = new JLabel("Data di produzione");
		lblDataDiProduzione.setFont(new Font("SansSerif", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDataDiProduzione = new GridBagConstraints();
		gbc_lblDataDiProduzione.anchor = GridBagConstraints.WEST;
		gbc_lblDataDiProduzione.insets = new Insets(0, 0, 0, 5);
		gbc_lblDataDiProduzione.gridx = 0;
		gbc_lblDataDiProduzione.gridy = 2;
		panel_4.add(lblDataDiProduzione, gbc_lblDataDiProduzione);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		date_field = new JFormattedTextField(df);
		date_field.setColumns(10);
		date_field.setFont(new Font("SansSerif", Font.PLAIN, 14));
		date_field.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.decode("#373737")));
		        
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		panel_4.add(date_field, gbc_textField_2);
		date_field.setColumns(10);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.decode("#F4F4F4"));
		panel_add.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		panel_6 = new JPanel();
		panel_6.setBackground(Color.decode("#F4F4F4"));
		panel_5.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{120, 0};
		gbl_panel_6.rowHeights = new int[]{33, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		btnAggiungi = new MyGUI.MyButton("Aggiungi");
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String type = String.valueOf(type_field.getSelectedItem());
				
				try {
				    price_field.commitEdit();
				} catch ( java.text.ParseException e ) {}
				Object price = price_field.getValue();
				
				String date = date_field.getText();
				
				nlt.addRow(type, price, date);
				
				type_field.setSelectedItem(null);
				price_field.setValue(0.00);
				date_field.setText(null);
			}
		});
		btnAggiungi.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnAggiungi.setBackground(Color.decode("#1BBC9B"));
		btnAggiungi.setForeground(Color.decode("#F4F4F4"));
		btnAggiungi.setBorder(null);
		GridBagConstraints gbc_btnAggiungi = new GridBagConstraints();
		gbc_btnAggiungi.fill = GridBagConstraints.BOTH;
		gbc_btnAggiungi.gridx = 0;
		gbc_btnAggiungi.gridy = 0;
		panel_6.add(btnAggiungi, gbc_btnAggiungi);
		
		separ2 = new JPanel();
		separ2.setBackground(Color.decode("#F4F4F4"));
		separ2.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.decode("#373737")));
		GridBagConstraints gbc_separ2 = new GridBagConstraints();
		gbc_separ2.insets = new Insets(0, 0, 5, 0);
		gbc_separ2.fill = GridBagConstraints.BOTH;
		gbc_separ2.gridx = 0;
		gbc_separ2.gridy = 4;
		_registraIngressoPanel.add(separ2, gbc_separ2);
		
		panel_riepilogo = new JPanel();
		panel_riepilogo.setBackground(Color.decode("#F4F4F4"));
		panel_riepilogo.setBorder(MyGUI.margin);
		GridBagConstraints gbc_panel_riepilogo = new GridBagConstraints();
		gbc_panel_riepilogo.fill = GridBagConstraints.BOTH;
		gbc_panel_riepilogo.gridx = 0;
		gbc_panel_riepilogo.gridy = 5;
		_registraIngressoPanel.add(panel_riepilogo, gbc_panel_riepilogo);
		panel_riepilogo.setLayout(new BorderLayout(0, 0));
		
		lblRiepilogoArticoliAggiunti = new JLabel("Riepilogo articoli aggiunti:");
		lblRiepilogoArticoliAggiunti.setForeground(Color.decode("#373737"));
		lblRiepilogoArticoliAggiunti.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRiepilogoArticoliAggiunti.setBorder(null);
		panel_riepilogo.add(lblRiepilogoArticoliAggiunti, BorderLayout.NORTH);
		
		panel_11 = new JPanel();
		panel_11.setBackground(Color.decode("#F4F4F4"));
		panel_11.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		panel_riepilogo.add(panel_11, BorderLayout.SOUTH);
		
		panel_12 = new JPanel();
		panel_12.setBackground(Color.decode("#F4F4F4"));
		panel_12.setBorder(new EmptyBorder(0, 0, 5, 0));
		panel_11.add(panel_12);
		GridBagLayout gbl_panel_12 = new GridBagLayout();
		gbl_panel_12.columnWidths = new int[]{150, 0};
		gbl_panel_12.rowHeights = new int[]{33, 0};
		gbl_panel_12.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_12.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_12.setLayout(gbl_panel_12);
		
		btnConfermaIngresso = new JButton("Conferma ingresso");
		btnConfermaIngresso.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnConfermaIngresso.setBackground(Color.decode("#1BBC9B"));
		btnConfermaIngresso.setForeground(Color.decode("#F4F4F4"));
		btnConfermaIngresso.setBorder(null);
		GridBagConstraints gbc_btnConfermaIngresso = new GridBagConstraints();
		gbc_btnConfermaIngresso.fill = GridBagConstraints.BOTH;
		gbc_btnConfermaIngresso.gridx = 0;
		gbc_btnConfermaIngresso.gridy = 0;
		panel_12.add(btnConfermaIngresso, gbc_btnConfermaIngresso);
		
		panel_13 = new JPanel();
		panel_13.setBackground(Color.decode("#F4F4F4"));
		FlowLayout flowLayout = (FlowLayout) panel_13.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_riepilogo.add(panel_13, BorderLayout.CENTER);
	
		nlt = new TableAddTest();
		nlt.setBackground(Color.BLACK);
		panel_13.add(nlt);
		
		_registraUscitaPanel = new JPanel();
		dadPanel.add(_registraUscitaPanel, "name_39071320350817");
		_registraUscitaPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnUscita = new JButton("uscita");
		_registraUscitaPanel.add(btnUscita);
		
		_spostaArticoloPanel = new JPanel();
		dadPanel.add(_spostaArticoloPanel, "name_39079362177678");
		_spostaArticoloPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnSposta = new JButton("sposta");
		_spostaArticoloPanel.add(btnSposta);
		
		
		btnRegistraIngresso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistraIngresso.setBackground(Color.decode("#16A086"));
				btnRegistraUscita.setBackground(Color.decode("#474747"));
				btnSpostaArticolo.setBackground(Color.decode("#474747"));
				
				dadPanel.removeAll();
				dadPanel.add(_registraIngressoPanel);
				dadPanel.repaint();
				dadPanel.revalidate();
			}
		});
		
		btnRegistraUscita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistraIngresso.setBackground(Color.decode("#474747"));
				btnRegistraUscita.setBackground(Color.decode("#16A086"));
				btnSpostaArticolo.setBackground(Color.decode("#474747"));
				
				dadPanel.removeAll();
				dadPanel.add(_registraUscitaPanel);
				dadPanel.repaint();
				dadPanel.revalidate();
			}
		});
		
		btnSpostaArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRegistraIngresso.setBackground(Color.decode("#474747"));
				btnRegistraUscita.setBackground(Color.decode("#474747"));
				btnSpostaArticolo.setBackground(Color.decode("#16A086"));
				
				dadPanel.removeAll();
				dadPanel.add(_spostaArticoloPanel);
				dadPanel.repaint();
				dadPanel.revalidate();
				
			}
		});
	}
	
	public int getHour() {
		return (int) hour.getValue();
	}
	
	public int getMinute() {
		return (int) minute.getValue();
	}
	
	public void addConfermaOrarioListener(ActionListener listenForConfermaOrarioButton){
		btnConfermaOrario.addActionListener(listenForConfermaOrarioButton);
	}
	
	public void addCambiaOrarioListener(ActionListener listenForCambiaOrarioButton){
		btnCambiaOrario.addActionListener(listenForCambiaOrarioButton);
	}
	
	public void setOrario() {
		minute.setEnabled(false);
		hour.setEnabled(false);
		btnConfermaOrario.setEnabled(false);
		btnCambiaOrario.setEnabled(true);
		btnConfermaOrario.setBackground(Color.decode("#373737"));
		btnCambiaOrario.setBackground(Color.decode("#1BBC9B"));
	}
	
	public void unsetOrario() {
		minute.setEnabled(true);
		hour.setEnabled(true);
		btnConfermaOrario.setEnabled(true);
		btnCambiaOrario.setEnabled(false);
		btnConfermaOrario.setBackground(Color.decode("#1BBC9B"));
		btnCambiaOrario.setBackground(Color.decode("#373737"));
	}
	
	public void addTypeFieldListener(PopupMenuListener listenForTypeField){
		type_field.addPopupMenuListener(listenForTypeField);
	}
	
	public void setTypeField(List<String> ls) {
		type_field.setModel(new DefaultComboBoxModel(ls.toArray()));
	}
	
	
	
	
	public void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
