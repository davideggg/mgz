package view;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

public class AccediView extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPassword;
	private JLabel lblAccedi;
	JButton btnAccedi;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccediView frame = new AccediView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public AccediView(){
		
		setTitle("Autenticazione");
		setResizable(false);
		setBackground(Color.decode("#F4F4F4"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 426);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#F4F4F4"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblAccedi = new JLabel("Login");
		lblAccedi.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblAccedi.setForeground(Color.decode("#F4F4F4"));
		lblAccedi.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccedi.setBounds(113, 26, 366, 69);
		contentPane.add(lblAccedi);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 599, 118);
		panel.setBackground(Color.decode("#1ABC9C"));
		contentPane.add(panel);
		
		
		txtId = new JTextField();
		txtId.setFont(new Font("Leelawadee UI", Font.PLAIN, 16));
		TextPrompt id_prompt = new TextPrompt("id", txtId);
		id_prompt.setFont(new Font("SansSerif", Font.PLAIN, 16));
		ImageIcon id_img = new ImageIcon(getClass().getResource("/imports/id.png"));
		CompoundBorder id_border = new CompoundBorder(
			    BorderFactory.createMatteBorder(0, 34, 0, 0, id_img),
			    BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#373737"))
		);
		txtId.setBorder(id_border);
		txtId.setBackground(Color.decode("#F4F4F4"));
		txtId.setBounds(113, 161, 366, 33);
		
		contentPane.add(txtId);
		
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Leelawadee UI", Font.PLAIN, 16));
		TextPrompt psw_prompt = new TextPrompt("password", txtPassword);
		psw_prompt.setFont(new Font("SansSerif", Font.PLAIN, 16));
		ImageIcon pwd_img = new ImageIcon(getClass().getResource("/imports/lock.png"));
		CompoundBorder pwd_border = new CompoundBorder(
			    BorderFactory.createMatteBorder(0, 34, 0, 0, pwd_img),
			    BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#373737"))
		);
		txtPassword.setBorder(pwd_border);
		txtPassword.setBackground(Color.decode("#F4F4F4"));
		txtPassword.setColumns(10);
		txtPassword.setBounds(113, 206, 366, 33);
		contentPane.add(txtPassword);
		
		btnAccedi = new MyGUI.MyButton("Accedi");
		btnAccedi.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnAccedi.setBackground(Color.decode("#1BBC9B"));
		btnAccedi.setForeground(Color.decode("#F4F4F4"));
		btnAccedi.setBounds(113, 283, 366, 44);
		btnAccedi.setBorder(null);
		contentPane.add(btnAccedi);
	}
	
	public String getId() {
		return txtId.getText();
	}
	
	public String getPassword() {
		return txtPassword.getText();
	}
	
	public void addAccediListener(ActionListener listenForAccediButton){
		btnAccedi.addActionListener(listenForAccediButton);
	}
	
	public void displayErrorMessage(String errorMessage){
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
