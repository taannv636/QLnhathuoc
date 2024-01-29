package form;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import swing.button.RoundButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import swing.panel.RoundPanel;
import java.awt.Color;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JDateChooser;

import control.thongtincanhancontrol;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class thongtincanhanform extends JPanel {
	public static JTextField ten;
	public static JTextField email;
	public static JTextField sh;
	public static JTextField cv;
	public static JTextField gt;
	public static JTextField date;
	public static JPasswordField comfirm;
	public static JPasswordField password;
	public static JLabel lblsohieu;

	/**
	 * Create the panel.
	 */
	public thongtincanhanform() {
		FlatLightLaf.setup();
		setLayout(new BorderLayout(0, 0));
		setSize(1213,707);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Thông tin nhân viên");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		RoundPanel roundPanel = new RoundPanel();
		roundPanel.setRoundTopRight(30);
		roundPanel.setRoundTopLeft(30);
		roundPanel.setRoundBottomRight(30);
		roundPanel.setRoundBottomLeft(30);
		roundPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên");
		
		ten = new JTextField();
		ten.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		
		email = new JTextField();
		email.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày vào");
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Chức vụ");
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Giới tính");
		
		lblsohieu = new JLabel("Số hiệu bằng dược sĩ");
		
		sh = new JTextField();
		sh.setEnabled(false);
		sh.setColumns(10);
		
		RoundButton rndbtnThm = new RoundButton();
		rndbtnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongtincanhancontrol.suatt();
			}
		});
		rndbtnThm.setText("Sửa");
		rndbtnThm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rndbtnThm.setFocusPainted(false);
		
		RoundPanel roundPanel_1 = new RoundPanel();
		roundPanel_1.setRoundTopRight(30);
		roundPanel_1.setRoundTopLeft(30);
		roundPanel_1.setRoundBottomRight(30);
		roundPanel_1.setRoundBottomLeft(30);
		roundPanel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lbliMtKhu = new JLabel("Đổi mật khẩu");
		lbliMtKhu.setHorizontalAlignment(SwingConstants.CENTER);
		lbliMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(424)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
					.addGap(424))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(274)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(roundPanel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(roundPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(275))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(424)
					.addComponent(lbliMtKhu, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
					.addGap(424))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(roundPanel, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lbliMtKhu, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(roundPanel_1, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		comfirm = new JPasswordField();
		
		JLabel lblMtKhuMi = new JLabel("Xác nhận");
		
		JLabel lblMtKhuMi_1 = new JLabel("Mật khẩu mới");
		
		password = new JPasswordField();
		
		RoundButton rndbtnThm_1 = new RoundButton();
		rndbtnThm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongtincanhancontrol.doimk();
			}
		});
		rndbtnThm_1.setText("Đổi");
		rndbtnThm_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rndbtnThm_1.setFocusPainted(false);
		GroupLayout gl_roundPanel_1 = new GroupLayout(roundPanel_1);
		gl_roundPanel_1.setHorizontalGroup(
			gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(43)
							.addComponent(lblMtKhuMi_1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(password, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(43)
							.addComponent(lblMtKhuMi, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(comfirm, GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(240)
							.addComponent(rndbtnThm_1, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addGap(154)))
					.addGap(85))
		);
		gl_roundPanel_1.setVerticalGroup(
			gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMtKhuMi_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(password, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMtKhuMi, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(comfirm, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addComponent(rndbtnThm_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		roundPanel_1.setLayout(gl_roundPanel_1);
		
		cv = new JTextField();
		cv.setEnabled(false);
		cv.setColumns(10);
		
		gt = new JTextField();
		gt.setEnabled(false);
		gt.setColumns(10);
		
		date = new JTextField();
		date.setEnabled(false);
		date.setColumns(10);
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(53)
							.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_roundPanel.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(ten, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(gl_roundPanel.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(email, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(gl_roundPanel.createSequentialGroup()
									.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(date, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
									.addGap(6))
								.addGroup(gl_roundPanel.createSequentialGroup()
									.addComponent(lblNewLabel_1_2_1_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
									.addGap(14)
									.addComponent(cv, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
									.addGap(6)
									.addComponent(lblNewLabel_1_2_1_1_1, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
									.addGap(10)
									.addComponent(gt, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))
								.addGroup(gl_roundPanel.createSequentialGroup()
									.addComponent(lblsohieu, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
									.addGap(6)
									.addComponent(sh, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(240)
							.addComponent(rndbtnThm, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
							.addGap(186)))
					.addGap(53))
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_roundPanel.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
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
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_2_1_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(cv, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(gt, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblsohieu, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(sh, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(rndbtnThm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		roundPanel.setLayout(gl_roundPanel);
		panel.setLayout(gl_panel);
		
	}
}
