package form.nhanvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

import com.formdev.flatlaf.FlatLightLaf;

import control.nhanvien.themnhanviencontrol;
import control.thuoc.themthuoccontrol;
import swing.button.RoundButton;
import swing.panel.RoundPanel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class themnhanvienform extends JPanel {
	public static JTextField ten;
	public static JTextField email;
	public static final ButtonGroup chucvu = new ButtonGroup();
	public static final ButtonGroup gioi = new ButtonGroup();
	public static JTextField sohieu;
	public static JPasswordField pass;
	public static JDateChooser date ;
	public static JRadioButton rdbtnDuocsi = new JRadioButton("Dược sĩ");
	public static JRadioButton rdbtnKimKho = new JRadioButton("Kiểm kho");
	public static JRadioButton rdbtnNam = new JRadioButton("Nam");
	public static JRadioButton rdbtnNu = new JRadioButton("Nữ");
	/**
	 * Create the panel.
	 */
	public themnhanvienform() {
		FlatLightLaf.setup();
		setLayout(new BorderLayout(0, 0));
		setSize(1213,707);
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setBackground(SystemColor.activeCaption);
		JLabel lblNewLabel = new JLabel("Nhân viên mới");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		RoundPanel roundPanel = new RoundPanel();
		roundPanel.setRoundTopRight(30);
		roundPanel.setRoundTopLeft(30);
		roundPanel.setRoundBottomRight(30);
		roundPanel.setRoundBottomLeft(30);
		roundPanel.setBackground(Color.LIGHT_GRAY);
		
		ten = new JTextField();
		ten.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên");
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày vào");
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Password");
		
		RoundButton rndbtnBack = new RoundButton();
		rndbtnBack.setFocusPainted(false);
		rndbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themnhanviencontrol.back();
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
					.addComponent(roundPanel, GroupLayout.PREFERRED_SIZE, 451, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(145, Short.MAX_VALUE))
		);
		
		RoundButton rndbtnThm = new RoundButton();
		rndbtnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themnhanviencontrol.add();
			}
		});
		rndbtnThm.setFocusPainted(false);
		rndbtnThm.setText("Thêm");
		rndbtnThm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		final JLabel lblsohieu = new JLabel("Số hiệu bằng dược sĩ");
		email = new JTextField();
		email.setColumns(10);
		
		date = new JDateChooser();
		

		rdbtnDuocsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sohieu.setVisible(true);
				lblsohieu.setVisible(true);
			}
		});
		chucvu.add(rdbtnDuocsi);
		rdbtnDuocsi.setSelected(true);

		rdbtnKimKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sohieu.setVisible(false);
				sohieu.setText("");
				lblsohieu.setVisible(false);
			}
		});
		chucvu.add(rdbtnKimKho);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Chức vụ");
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Giới tính");
		
		
		gioi.add(rdbtnNam);
		rdbtnNam.setSelected(true);
		
		
		gioi.add(rdbtnNu);
		
		sohieu = new JTextField();
		sohieu.setColumns(10);
		
		pass = new JPasswordField();
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(ten, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addGap(62))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(email, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addGap(62))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(date, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
					.addGap(62))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_1_2_1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(4)
					.addComponent(pass, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
					.addGap(62))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(lblNewLabel_1_2_1_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnDuocsi, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
						.addComponent(rdbtnKimKho, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(78)
					.addComponent(lblNewLabel_1_2_1_1_1, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNam, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
						.addComponent(rdbtnNu, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
					.addGap(124))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(50)
					.addComponent(lblsohieu, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(sohieu, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
					.addGap(62))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(240)
					.addComponent(rndbtnThm, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
					.addGap(239))
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(ten, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(email, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(date, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addComponent(pass, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_1_2_1_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(rdbtnDuocsi)
							.addGap(3)
							.addComponent(rdbtnKimKho))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(rdbtnNam)
							.addGap(3)
							.addComponent(rdbtnNu)))
					.addGap(6)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblsohieu, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(sohieu, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(47)
					.addComponent(rndbtnThm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		roundPanel.setLayout(gl_roundPanel);
		panel.setLayout(gl_panel);
	}
}
