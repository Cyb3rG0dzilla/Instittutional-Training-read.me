package ip_finder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;

public class IP_Finder extends Frame implements ActionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField tf;
	JLabel l;
	JButton b;

	IP_Finder() {
		super("IP Finder Software");
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		l = new JLabel("Enter a URL:");
		l.setBounds(50, 100, 250, 20);
		tf = new JTextField();
		tf.setBounds(50, 50, 150, 20);
		tf.addKeyListener(this);
		b = new JButton("Find IP");
		b.setBounds(50, 150, 95, 30);
		b.addActionListener(this);
		add(b);
		add(tf);
		add(l);
		setSize(400, 400);
		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String url = tf.getText();
		try {
			InetAddress ia = InetAddress.getByName(url);
			String ip = ia.getHostAddress();
			l.setText("IP of " + url + " is: " + ip);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void main(String[] args) {
		new IP_Finder();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			String url = tf.getText();
			try {
				InetAddress ia = InetAddress.getByName(url);
				String ip = ia.getHostAddress();
				l.setText("IP of " + url + " is: " + ip);
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}