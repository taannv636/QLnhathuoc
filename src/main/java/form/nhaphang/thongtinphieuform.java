package form.nhaphang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import control.nhaphang.thongtinphieucontrol;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import swing.button.RoundButton;
import swing.panel.RoundPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class thongtinphieuform extends JPanel {
	public static JTextField ma;
	public static JTextField tongcong;
	public static JTextField ncc;
	public static JTextField ngaynhap;
	public static JTable table;
	public static JTextField nguoi;

	/**
	 * Create the panel.
	 */
	public thongtinphieuform() {
		setLayout(new BorderLayout(0, 0));
		setSize(1213,729);
		
		JPanel roundPanel = new JPanel();
		roundPanel.setBackground(SystemColor.activeCaption);
		add(roundPanel, BorderLayout.CENTER);
		
		RoundButton rndbtnBack = new RoundButton();
		rndbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongtinphieucontrol.back();
			}
		});
		rndbtnBack.setText("Back");
		
		RoundPanel roundPanel_1 = new RoundPanel();
		roundPanel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Thông tin phiếu nhập");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		
		JLabel lblNewLabel_1 = new JLabel("Mã phiếu");
		
		ma = new JTextField();
		ma.setEditable(false);
		ma.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Tổng cộng");
		
		tongcong = new JTextField();
		tongcong.setEditable(false);
		tongcong.setColumns(10);
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGap(121)
							.addComponent(roundPanel_1, GroupLayout.PREFERRED_SIZE, 691, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGroup(gl_roundPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
								.addGroup(gl_roundPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 881, Short.MAX_VALUE)
									.addComponent(lblNewLabel_1_2_1_2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tongcong, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))
							.addGap(24))))
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_roundPanel.createSequentialGroup()
							.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(123))
						.addGroup(Alignment.TRAILING, gl_roundPanel.createSequentialGroup()
							.addComponent(roundPanel_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addGap(11)))
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tongcong, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_2_1_2, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
					.addGap(27))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ncc = new JTextField();
		ncc.setEditable(false);
		ncc.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhà cung cấp");
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Ngày nhập");
		
		ngaynhap = new JTextField();
		ngaynhap.setEditable(false);
		ngaynhap.setColumns(10);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Người lập phiếu");
		
		nguoi = new JTextField();
		nguoi.setEditable(false);
		nguoi.setColumns(10);
		GroupLayout gl_roundPanel_1 = new GroupLayout(roundPanel_1);
		gl_roundPanel_1.setHorizontalGroup(
			gl_roundPanel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addGap(194)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
					.addGap(194))
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(ngaynhap, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(200)
							.addComponent(lblNewLabel_1_1_3, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(nguoi, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(ma, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addGap(168)
							.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
							.addGap(10)
							.addComponent(ncc, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
					.addGap(116))
		);
		gl_roundPanel_1.setVerticalGroup(
			gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(ma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1))
						.addComponent(ncc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_roundPanel_1.createSequentialGroup()
									.addGap(6)
									.addComponent(lblNewLabel_1_1_2))
								.addGroup(gl_roundPanel_1.createSequentialGroup()
									.addGap(3)
									.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1_1_3)
										.addComponent(nguoi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(ngaynhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		roundPanel_1.setLayout(gl_roundPanel_1);
		roundPanel.setLayout(gl_roundPanel);
	}
}
