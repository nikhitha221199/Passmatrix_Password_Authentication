package User;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import Misc.CustButton;
import Misc.Hash;
import Welcome.WelcomePanel;

public class UserDel extends JPanel {

	String usrname;
	CustButton ok,cancel;
	Hash h=new Hash();
	int w;

	public UserDel(String usr) {
		usrname=usr;
		
		setOpaque(false);
		setLayout(null);
		
		ok = new CustButton("YES");
		ok.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				procOK();
			}
		});
		ok.setBounds(450, 300, 140, 40);
		add(ok);
		
		
		cancel = new CustButton("NO");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				procCancel();
			}
		});
		cancel.setBounds(650, 300, 140, 40);
		add(cancel);
	}
	
	
	public void paintComponent(Graphics g)
	{
		paintx(g);
		//paintChildren(g);
	}
	
	public void paint(Graphics g)
	{
		paintx(g);
		paintChildren(g);
	}
	
	public void paintx(Graphics g)
	{
		Graphics2D g2d=(Graphics2D)g;
		g2d.addRenderingHints( new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON ));
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Lucida Calligraphy", Font.ITALIC,30));
		w = g.getFontMetrics().stringWidth("Are you sure you want") / 2;
		g2d.drawString("Are you sure you want",getWidth()/2-w,100);
		w = g.getFontMetrics().stringWidth("delete this account ?") / 2;
		g2d.drawString("delete this account ?",getWidth()/2-w,150);
	}
	
	
	public void procCancel()
	{
		setVisible(false);
		UserPn.showHome();
	}
	
	public void procOK()
	{
		h.delUsr(usrname);
		setVisible(false);
		WelcomePanel.disableUsr();
	}
}
