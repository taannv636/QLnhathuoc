package form.nhacungcap;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.formdev.flatlaf.FlatLightLaf;

import control.nhacungcap.themnhacungcapcontrol;
import control.thuoc.themthuoccontrol;
import swing.button.RoundButton;
import swing.panel.RoundPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class themnhacungcapform extends JPanel {
	public static JTextField ma;
	public static JTextField ten;
	public static JTextField email;
	public static DefaultComboBoxModel cbphanloai;
	public static DefaultComboBoxModel cbdonvi;
	public static DefaultComboBoxModel cbhang;
	public static JTextField dc;
	public static JTextField sdt;
	public static JTextField mdn;

	/**
	 * Create the panel.
	 */
	public themnhacungcapform() {
		FlatLightLaf.setup();
		setLayout(new BorderLayout(0, 0));
		setSize(1213,707);
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setBackground(SystemColor.activeCaption);
		JLabel lblNewLabel = new JLabel("Nhà cung cấp mới");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		RoundPanel roundPanel = new RoundPanel();
		roundPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhà cung cấp");
		
		ma = new JTextField();
		ma.setColumns(10);
		
		ten = new JTextField();
		ten.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên công ty");
		
		JLabel lblNewLabel_2 = new JLabel("Địa chỉ văn phòng");
		
		JLabel lblNewLabel_2_1 = new JLabel("Số điện thoại");
		
		JLabel lblNewLabel_2_2 = new JLabel("Mã doanh nghiệp");
		
		email = new JTextField();
		email.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Email");
		
		RoundButton rndbtnBack = new RoundButton();
		rndbtnBack.setFocusPainted(false);
		rndbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themnhacungcapcontrol.back();
			}
		});
		rndbtnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rndbtnBack.setText("Back");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(314)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
					.addGap(424))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(274)
					.addComponent(roundPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(275))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(42)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(roundPanel, GroupLayout.PREFERRED_SIZE, 467, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(129, Short.MAX_VALUE))
		);
		
		RoundButton rndbtnThm = new RoundButton();
		rndbtnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themnhacungcapcontrol.add();
			}
		});
		rndbtnThm.setFocusPainted(false);
		rndbtnThm.setText("Thêm");
		rndbtnThm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		dc = new JTextField();
		dc.setColumns(10);
		
		sdt = new JTextField();
		sdt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_ENTER)))
				{
					e.consume();
				}
			}
		});
		sdt.setColumns(10);
		
		mdn = new JTextField();
		mdn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_ENTER)))
				{
					e.consume();
				}
			}
		});
		mdn.setColumns(10);
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(ma, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(ten, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_1_2_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(email, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(239)
					.addComponent(rndbtnThm, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
					.addGap(240))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(dc, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
						.addComponent(sdt, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
						.addComponent(mdn, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
					.addGap(60))
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(ma, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(ten, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(dc, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(sdt, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(mdn, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(email, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
					.addGap(28)
					.addComponent(rndbtnThm, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
					.addGap(60))
		);
		roundPanel.setLayout(gl_roundPanel);
		panel.setLayout(gl_panel);
	}

}
