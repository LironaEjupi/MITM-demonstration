package projecti;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class frmPROJECTI extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaintextiA;
	private JTextField txtAlicesKey;
	private JTextField txtCiphertextiA;
	private JTextField txtChipertexti1;
	private JTextField txtAliceKeyM;
	private JTextField txtMansKey;
	private JTextField txtEnkriptoManA;
	private JTextField txtAliceKeyB;
	private JTextField txtBobsKey;
	private JTextField txtBobsKeyM;
	private JTextField txtMansKeyA;
	private JTextField txtEnkriptoMan1;
	private JTextField txtEnkriptoBob;
	private JTextField txtBobsMessageM;
	private JTextField txtEnkriptoManB;
	private JTextField txtBobsMessage;
	private JTextField txtDekriptoA;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmPROJECTI frame = new frmPROJECTI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public static String key() throws NoSuchAlgorithmException,
									  NoSuchPaddingException,
									  BadPaddingException,
									  IllegalBlockSizeException,
									  InvalidKeyException 
	{

		byte[] message = "Hello World".getBytes();

		KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		SecretKey desKey = keygenerator.generateKey();

		Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		desCipher.init(Cipher.ENCRYPT_MODE, desKey);
		byte[] encryptedMessage = desCipher.doFinal(message);
		return encryptedMessage.toString () ;
}
	public static String Encrypt(String strClearText,String strKey) throws Exception{
		String strData="";
		try {
			
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(strClearText.getBytes());
			strData=new String(encrypted);
			
			
		} catch (Exception e) {
			//e.printStackTrace();
			//throw new Exception(e);
			System.out.println("ENKRIPT KEYESOR");
			
		}
		return strData;
	}
	public static String decrypt(String strEncrypted,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
			Cipher cipher=Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
			strData=new String(decrypted);
		} catch (Exception e) {
			//e.printStackTrace();
			//throw new Exception(e);
			System.out.println("DEKRIPT KRYESOR");
		}
		return strData;
	}
	public frmPROJECTI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1145, 759);
		contentPane = new JPanel();
		setBackground(SystemColor.activeCaption);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		
		JLabel lblMitmAttack = new JLabel("MITM Attack");
		lblMitmAttack.setForeground(new Color(25, 25, 112));
		lblMitmAttack.setBounds(553, 28, 240, 36);
		lblMitmAttack.setBackground(UIManager.getColor("Button.light"));
		lblMitmAttack.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblMitmAttack.setAutoscrolls(true);
		lblMitmAttack.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblMitmAttack);
		
		JPanel panelAlice = new JPanel();
		panelAlice.setBorder(new TitledBorder(new LineBorder(new Color(25, 25, 112), 5, true), "ALICE", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(25, 25, 112)));
		panelAlice.setBounds(24, 137, 336, 334);
		contentPane.add(panelAlice);
		panelAlice.setLayout(null);
		
		JLabel lblPlaintexti = new JLabel("Plaintexti :");
		lblPlaintexti.setBounds(12, 105, 123, 20);
		panelAlice.add(lblPlaintexti);
		
		txtPlaintextiA = new JTextField();
		txtPlaintextiA.setBounds(12, 144, 137, 20);
		panelAlice.add(txtPlaintextiA);
		txtPlaintextiA.setBackground(Color.WHITE);
		txtPlaintextiA.setColumns(10);
		
		JLabel lblCelesi = new JLabel("Celesi :");
		lblCelesi.setBounds(12, 24, 123, 20);
		panelAlice.add(lblCelesi);
		
		txtAlicesKey = new JTextField();
		txtAlicesKey.setBounds(12, 43, 137, 20);
		panelAlice.add(txtAlicesKey);
		txtAlicesKey.setBackground(Color.WHITE);
		txtAlicesKey.setColumns(10);
		
		JButton btnEnkriptoA = new JButton("Enkripto");
		btnEnkriptoA.setBounds(150, 174, 89, 23);
		panelAlice.add(btnEnkriptoA);
		
		txtCiphertextiA = new JTextField();
		txtCiphertextiA.setBounds(12, 175, 137, 20);
		panelAlice.add(txtCiphertextiA);
		txtCiphertextiA.setColumns(10);
		JButton btnGjeneroAlice = new JButton("Generate");
		btnGjeneroAlice.setBounds(150, 42, 89, 23);
		panelAlice.add(btnGjeneroAlice);
		
		JButton btnSendCelesiA = new JButton("Send");
		btnSendCelesiA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtAliceKeyM.setText(txtAlicesKey.getText());
				txtAliceKeyB.setText(txtAlicesKey.getText());
				
			}
		});
		btnSendCelesiA.setBounds(242, 42, 84, 22);
		panelAlice.add(btnSendCelesiA);
		
		txtMansKeyA = new JTextField();
		txtMansKeyA.setColumns(10);
		txtMansKeyA.setBackground(Color.WHITE);
		txtMansKeyA.setBounds(108, 74, 137, 20);
		panelAlice.add(txtMansKeyA);
		
		JLabel lblBobsKeyAtA = new JLabel("Bob's Key :");
		lblBobsKeyAtA.setBounds(12, 74, 123, 20);
		panelAlice.add(lblBobsKeyAtA);
		
		JButton btnSendA = new JButton("Send");
		btnSendA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtChipertexti1.setText(txtCiphertextiA.getText());
			}
		});
		btnSendA.setBounds(242, 174, 84, 22);
		panelAlice.add(btnSendA);
		
		JLabel lblBobsMessage_2 = new JLabel("Bob's Message :");
		lblBobsMessage_2.setBounds(12, 223, 123, 20);
		panelAlice.add(lblBobsMessage_2);
		
		txtBobsMessage = new JTextField();
		txtBobsMessage.setColumns(10);
		txtBobsMessage.setBackground(Color.WHITE);
		txtBobsMessage.setBounds(108, 223, 137, 20);
		panelAlice.add(txtBobsMessage);
		
		txtDekriptoA = new JTextField();
		txtDekriptoA.setColumns(10);
		txtDekriptoA.setBounds(12, 254, 137, 20);
		panelAlice.add(txtDekriptoA);
		
		JButton btnDekriptoA = new JButton("Dekripto");
		btnDekriptoA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String currentKey = txtMansKeyA.getText();
					txtDekriptoA.setText(decrypt( txtBobsMessage.getText(), currentKey));
				} catch (Exception e1) {
					
					//e1.printStackTrace();
					System.out.println("Gabim ne dekriptim tek BOB");
				}
			}
		});
		btnDekriptoA.setBounds(156, 253, 89, 23);
		panelAlice.add(btnDekriptoA);
		btnGjeneroAlice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					txtAlicesKey.setText(key());
				} catch (Exception e1) {
				
					System.out.println("Gabim tek gjenerimi i celesit");
					//e1.printStackTrace();
				}
				
			}
		});
		
		btnEnkriptoA.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					try {
						String currentKey = txtAlicesKey.getText();
						txtCiphertextiA.setText(Encrypt( txtPlaintextiA.getText(), currentKey));
					} catch (Exception e1) {
						System.out.println("Gabim ne enkriptim tek ALice");
						//e1.printStackTrace();
					
					}	
			}});
		
		JLabel lblCiphertexti = new JLabel("Ciphertexti");
		lblCiphertexti.setBounds(26, 193, 123, 20);
		contentPane.add(lblCiphertexti);
		
		JPanel panelMITM = new JPanel();
		panelMITM.setLayout(null);
		panelMITM.setBorder(new TitledBorder(new LineBorder(new Color(25, 25, 112), 5, true), "MAN IN THE MIDDLE", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(25, 25, 112)));
		panelMITM.setBounds(401, 215, 353, 334);
		contentPane.add(panelMITM);
		
		JLabel lblAlicesKeyAtM = new JLabel("Alice's Key :");
		lblAlicesKeyAtM.setBounds(12, 24, 123, 20);
		panelMITM.add(lblAlicesKeyAtM);
		
		txtAliceKeyM = new JTextField();
		txtAliceKeyM.setColumns(10);
		txtAliceKeyM.setBackground(Color.WHITE);
		txtAliceKeyM.setBounds(108, 24, 137, 20);
		panelMITM.add(txtAliceKeyM);
		
		JLabel lblCelesi_1 = new JLabel("Celesi :");
		lblCelesi_1.setBounds(12, 86, 123, 20);
		panelMITM.add(lblCelesi_1);
		
		txtMansKey = new JTextField();
		txtMansKey.setColumns(10);
		txtMansKey.setBackground(Color.WHITE);
		txtMansKey.setBounds(12, 106, 137, 20);
		panelMITM.add(txtMansKey);
		
		JButton btnEnkriptoMITMA = new JButton("Enkripto");
		btnEnkriptoMITMA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String currentKey = txtAlicesKey.getText();
					txtEnkriptoManA.setText(Encrypt( txtChipertexti1.getText(), currentKey));
				} catch (Exception e1) {
					System.out.println("Gabim ne enkriptim tek MITM");
					//e1.printStackTrace();
				
				}	
			}
		});
		btnEnkriptoMITMA.setBounds(156, 194, 89, 23);
		panelMITM.add(btnEnkriptoMITMA);
		
		txtEnkriptoManA = new JTextField();
		txtEnkriptoManA.setColumns(10);
		txtEnkriptoManA.setBounds(12, 195, 137, 20);
		panelMITM.add(txtEnkriptoManA);
		
		JButton btnGenerateMITM = new JButton("Generate");
		btnGenerateMITM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					txtMansKey.setText(key());
				} catch (Exception e1) {
				
					System.out.println("Gabim tek gjenerimi i celesit");
					//e1.printStackTrace();
				}
			}
		});
		btnGenerateMITM.setBounds(156, 105, 89, 23);
		panelMITM.add(btnGenerateMITM);
		
		JLabel lblBobsKeyAtB = new JLabel("Bob's Key :");
		lblBobsKeyAtB.setBounds(12, 55, 123, 20);
		panelMITM.add(lblBobsKeyAtB);
		
		txtBobsKeyM = new JTextField();
		txtBobsKeyM.setColumns(10);
		txtBobsKeyM.setBackground(Color.WHITE);
		txtBobsKeyM.setBounds(108, 55, 137, 20);
		panelMITM.add(txtBobsKeyM);
		
		JButton btnSendMITM = new JButton("Send");
		btnSendMITM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtMansKeyA.setText(txtMansKey.getText());
				
			}
		});
		btnSendMITM.setBounds(255, 105, 84, 22);
		panelMITM.add(btnSendMITM);
		
		txtChipertexti1 = new JTextField();
		txtChipertexti1.setBounds(12, 164, 137, 20);
		panelMITM.add(txtChipertexti1);
		txtChipertexti1.setColumns(10);
		
		JButton btnDekriptoMITMA = new JButton("Dekripto");
		btnDekriptoMITMA.setBounds(156, 163, 89, 23);
		panelMITM.add(btnDekriptoMITMA);
		
		JLabel lblNewLabel = new JLabel("Alice's Message :");
		lblNewLabel.setBounds(12, 137, 105, 16);
		panelMITM.add(lblNewLabel);
		
		JButton btnSendMITMA = new JButton("Send");
		btnSendMITMA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEnkriptoMan1.setText(txtEnkriptoManA.getText());
			}
		});
		btnSendMITMA.setBounds(255, 193, 78, 25);
		panelMITM.add(btnSendMITMA);
		
		txtBobsMessageM = new JTextField();
		txtBobsMessageM.setColumns(10);
		txtBobsMessageM.setBounds(12, 253, 137, 20);
		panelMITM.add(txtBobsMessageM);
		
		txtEnkriptoManB = new JTextField();
		txtEnkriptoManB.setColumns(10);
		txtEnkriptoManB.setBounds(12, 284, 137, 20);
		panelMITM.add(txtEnkriptoManB);
		
		JButton btnDekriptoMITMB = new JButton("Dekripto");
		btnDekriptoMITMB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String currentKey = txtBobsKeyM.getText();
					txtBobsMessageM.setText(decrypt( txtBobsMessageM.getText(), currentKey));
				} catch (Exception e1) {
					
					//e1.printStackTrace();
					System.out.println("Gabim ne dekriptim tek MITM");
				}
			}
		});
		btnDekriptoMITMB.setBounds(156, 252, 89, 23);
		panelMITM.add(btnDekriptoMITMB);
		
		JButton btnEnkriptoMITMB = new JButton("Enkripto");
		btnEnkriptoMITMB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String currentKey = txtMansKey.getText();
					txtEnkriptoManB.setText(Encrypt( txtBobsMessageM.getText(), currentKey));
				} catch (Exception e1) {
					System.out.println("Gabim ne enkriptim Tek MITM");
					//e1.printStackTrace();
				
				}	
			}
		});
		btnEnkriptoMITMB.setBounds(156, 283, 89, 23);
		panelMITM.add(btnEnkriptoMITMB);
		
		JButton btnSendMITMB = new JButton("Send");
		btnSendMITMB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtBobsMessage.setText(txtEnkriptoManB.getText());
			}
		});
		btnSendMITMB.setBounds(255, 282, 78, 25);
		panelMITM.add(btnSendMITMB);
		
		JLabel lblBobsMessage_1 = new JLabel("Bob's Message :");
		lblBobsMessage_1.setBounds(12, 226, 105, 16);
		panelMITM.add(lblBobsMessage_1);
		btnDekriptoMITMA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String currentKey = txtAliceKeyM.getText();
					txtChipertexti1.setText(decrypt(txtCiphertextiA.getText(), currentKey));
				} catch (Exception e1) {
					
					//e1.printStackTrace();
					System.out.println("Gabim ne dekriptim MITM");
				}
			}
		});
		
		JPanel panelBOB = new JPanel();
		panelBOB.setLayout(null);
		panelBOB.setBorder(new TitledBorder(new LineBorder(new Color(25, 25, 112), 5, true), "BOB", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(25, 25, 112)));
		panelBOB.setBounds(783, 182, 336, 243);
		contentPane.add(panelBOB);
		
		JLabel lblAlicesKeyAtB = new JLabel("Alice's Key :");
		lblAlicesKeyAtB.setBounds(18, 24, 123, 20);
		panelBOB.add(lblAlicesKeyAtB);
		
		txtAliceKeyB = new JTextField();
		txtAliceKeyB.setColumns(10);
		txtAliceKeyB.setBackground(Color.WHITE);
		txtAliceKeyB.setBounds(114, 24, 137, 20);
		panelBOB.add(txtAliceKeyB);
		
		JLabel lblCelesi_2 = new JLabel("Celesi :");
		lblCelesi_2.setBounds(18, 55, 123, 20);
		panelBOB.add(lblCelesi_2);
		
		txtBobsKey = new JTextField();
		txtBobsKey.setColumns(10);
		txtBobsKey.setBackground(Color.WHITE);
		txtBobsKey.setBounds(15, 86, 137, 20);
		panelBOB.add(txtBobsKey);
		
		JButton btnGenerateBOB = new JButton("Generate");
		btnGenerateBOB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					txtBobsKey.setText(key());
				} catch (Exception e1) {
				
					System.out.println("Gabim tek gjenerimi i celesit");
					//e1.printStackTrace();
				}
			}
		});
		btnGenerateBOB.setBounds(155, 85, 89, 23);
		panelBOB.add(btnGenerateBOB);
		
		JButton button_6 = new JButton("Send");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				txtBobsKeyM.setText(txtBobsKey.getText());
				
			}
		});
		button_6.setBounds(244, 85, 84, 23);
		panelBOB.add(button_6);
		
		JLabel lblBobsMessage = new JLabel("Bob's Message :");
		lblBobsMessage.setBounds(18, 128, 105, 16);
		panelBOB.add(lblBobsMessage);
		
		txtEnkriptoMan1 = new JTextField();
		txtEnkriptoMan1.setColumns(10);
		txtEnkriptoMan1.setBounds(15, 155, 137, 20);
		panelBOB.add(txtEnkriptoMan1);
		
		JButton btnDekriptoBob = new JButton("Dekripto");
		btnDekriptoBob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String currentKey = txtAliceKeyB.getText();
					txtEnkriptoMan1.setText(decrypt( txtEnkriptoManA.getText(), currentKey));
				} catch (Exception e1) {
					
					//e1.printStackTrace();
					System.out.println("Gabim ne dekriptim");
				}
			}
		});
		btnDekriptoBob.setBounds(155, 154, 89, 23);
		panelBOB.add(btnDekriptoBob);
		
		txtEnkriptoBob = new JTextField();
		txtEnkriptoBob.setColumns(10);
		txtEnkriptoBob.setBounds(15, 186, 137, 20);
		panelBOB.add(txtEnkriptoBob);
		
		JButton btnEnkriptoBob = new JButton("Enkripto");
		btnEnkriptoBob.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String currentKey = txtBobsKey.getText();
					txtEnkriptoBob.setText(Encrypt( txtEnkriptoMan1.getText(), currentKey));
				} catch (Exception e1) {
					System.out.println("Gabim ne enkriptim");
					//e1.printStackTrace();
				
				}	
			}
		});
		btnEnkriptoBob.setBounds(155, 185, 89, 23);
		panelBOB.add(btnEnkriptoBob);
		
		JButton btnSend_BOB = new JButton("Send");
		btnSend_BOB.setBounds(244, 185, 84, 23);
		panelBOB.add(btnSend_BOB);
		btnSend_BOB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtBobsMessageM.setText(txtEnkriptoBob.getText());
			}
		});
		JLabel lblBackground = new JLabel("");
        lblBackground.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblBackground.setIcon(new ImageIcon(frmPROJECTI.class.getResource("/projecti/images/florina.jpg")));
		lblBackground.setBounds(0, 0, 1129, 720);
		contentPane.add(lblBackground);
		
	
		
	}
}

