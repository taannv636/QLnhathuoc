package form.thuoc;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import swing.panel.RoundPanel;
import swing.button.RoundButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import control.thuoc.quydoicontrol;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class quydoiform extends JPanel {
	public static  JTextField sl;
	public static JComboBox dv;
	public static  String lo;
	public static  String dvht;
	public static  String ma;
	public static  String hang;
	/**
	 * Create the panel.
	 */
	public quydoiform() {
		setLayout(new BorderLayout(0, 0));	
		setSize(1213,707);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		add(panel, BorderLayout.CENTER);
		
		RoundPanel roundPanel = new RoundPanel();
		roundPanel.setRoundTopRight(30);
		roundPanel.setRoundTopLeft(30);
		roundPanel.setRoundBottomRight(30);
		roundPanel.setRoundBottomLeft(30);
		roundPanel.setBackground(SystemColor.activeCaptionBorder);
		
		RoundButton rndbtnBack = new RoundButton();
		rndbtnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rndbtnBack.setText("Back");
		rndbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quydoicontrol.back();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1083, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(194)
					.addComponent(roundPanel, GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
					.addGap(194))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(152)
					.addComponent(roundPanel, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(202, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Quy đổi đơn vị");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		sl = new JTextField();
		sl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_ENTER)))
				{
					e.consume();
				}
			}
		});
		sl.setColumns(10);
		
		dv = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("Số lượng quy đổi");
		
		JLabel lblNewLabel_1_1 = new JLabel("Đơn vị được quy đổi");
		
		RoundButton rndbtnQuyi = new RoundButton();
		rndbtnQuyi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quydoicontrol.quydoi();
			}
		});
		rndbtnQuyi.setText("Quy đổi");
		rndbtnQuyi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(276)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addGap(276))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(352)
					.addComponent(rndbtnQuyi, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addGap(353))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(93)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(sl, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
					.addGap(103)
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(dv, 0, 160, Short.MAX_VALUE)
					.addGap(93))
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(sl, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(dv, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(75)
					.addComponent(rndbtnQuyi, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		roundPanel.setLayout(gl_roundPanel);
		panel.setLayout(gl_panel);
	}
}
