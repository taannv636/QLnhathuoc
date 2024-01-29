package form.ketoa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.ketoa.thongtintoacontrol;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import swing.button.RoundButton;
import swing.panel.RoundPanel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class thongtintoaform extends JPanel {
	public static JTextField ma;
	public static JTextField tong;
	public static JTextField nguoi;
	public static JTextField ngay;
	public static JTable table;

	/**
	 * Create the panel.
	 */
	public thongtintoaform() {
		setLayout(new BorderLayout(0, 0));
		setSize(1213,729);
		
		JPanel roundPanel = new JPanel();
		roundPanel.setBackground(SystemColor.activeCaption);
		add(roundPanel, BorderLayout.CENTER);
		
		RoundButton rndbtnBack = new RoundButton();
		rndbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongtintoacontrol.back();
			}
		});
		rndbtnBack.setText("Back");
		
		RoundPanel roundPanel_1 = new RoundPanel();
		roundPanel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Thông tin toa thuốc");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Mã toa");
		
		ma = new JTextField();
		ma.setEditable(false);
		ma.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Tổng tiền");
		
		tong = new JTextField();
		tong.setEditable(false);
		tong.setColumns(10);
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_2_1_2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tong, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
					.addGap(24))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(1087, Short.MAX_VALUE))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(225)
					.addComponent(roundPanel_1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(268, Short.MAX_VALUE))
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(22)
					.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(roundPanel_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 494, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tong, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_2_1_2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(27))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		nguoi = new JTextField();
		nguoi.setEditable(false);
		nguoi.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Người kê");
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Ngày kê");
		
		ngay = new JTextField();
		ngay.setEditable(false);
		ngay.setColumns(10);
		GroupLayout gl_roundPanel_1 = new GroupLayout(roundPanel_1);
		gl_roundPanel_1.setHorizontalGroup(
			gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addGap(52)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
					.addGap(53))
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(ma, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addGap(109)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nguoi, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(106, Short.MAX_VALUE))
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(ngay, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(474, Short.MAX_VALUE))
		);
		gl_roundPanel_1.setVerticalGroup(
			gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(ma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_1)
							.addComponent(nguoi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(7)
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1_2))
						.addComponent(ngay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		roundPanel_1.setLayout(gl_roundPanel_1);
		roundPanel.setLayout(gl_roundPanel);
	}
}

