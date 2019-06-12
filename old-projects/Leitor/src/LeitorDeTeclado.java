//EX: KeyListener - ActionListener - JLabel - JButton - ImageIcon - JPanel
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;

public class LeitorDeTeclado extends JFrame {
	
	private JLabel lblCod,lblIconJava,lblTitleCod;
	private JButton btnSair;
	private ImageIcon IconJava;
	private JPanel pnCod,pnIconImg;
	
	public LeitorDeTeclado() {
		setLayout(null);
		
		//icon
		IconJava = new ImageIcon(getClass().getResource("icon.png"));
		
		//Label
		lblTitleCod = new JLabel("Cod:");
		lblTitleCod.setForeground(Color.blue);
		lblTitleCod.setBounds(75,80,100,30);
		add(lblTitleCod);	

		lblCod = new JLabel("00");
		lblCod.setBounds(80,100,100,30);
		add(lblCod);		
		
		lblIconJava = new JLabel(IconJava);
		lblIconJava.setBounds(70,45,35,35);
		add(lblIconJava);

		//Button	
		btnSair = new JButton("Fechar");
		btnSair.setBounds(45,170,90,30);
		add(btnSair);
		
		//JPanel
		pnIconImg = new JPanel();
		pnIconImg.setBorder(BorderFactory.createLoweredBevelBorder());
		pnIconImg.setSize(50,85);
		pnIconImg.setLocation(63,40);
		add(pnIconImg);		
		
		pnCod = new JPanel();
		pnCod.setBorder(BorderFactory.createTitledBorder("Codigo das Teclas:"));
		pnCod.setSize(170,150);
		pnCod.setLocation(10,10);
		add(pnCod);
		
		
		//ActionListener(JButton Close)
		buttonClose();
		
		//KeyListener
		addEscutaTeclado();

		
	}
	
	public void buttonClose() {
		btnSair.addActionListener (new ActionListener(){
			
			public void actionPerformed(ActionEvent e){
				
				System.exit(0);
				
			}
			
		}); 
		
		
	}

	public void addEscutaTeclado() {
		addKeyListener (new KeyListener() {
			
			//keyTyped <-- 'key' com 'k' minusculo.
			public void keyTyped(KeyEvent e) {
				
			}
			
			//keyPressed <-- 'key' com 'k' minusculo.
			public void keyPressed(KeyEvent e) {
				
				lblCod.setText(String.valueOf(e.getKeyCode()));

			}
			
			//keyReleased <-- 'key' com 'k' minusculo.
			public void keyReleased(KeyEvent e) {
				
				
			}

		});
		
		
	}

		public static void main(String[] args){
			LeitorDeTeclado Frame = new LeitorDeTeclado();
			
			Frame.setSize(200,250);
			Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			Frame.setFocusable(true); //deixa o frame em foco, deve ser colocado antes do 'setVisible(true)'.
			Frame.setResizable(false);
			Frame.setVisible(true);
			Frame.setLocationRelativeTo(null);
			
		
		}

}
