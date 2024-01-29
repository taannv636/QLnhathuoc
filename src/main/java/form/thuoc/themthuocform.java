package form.thuoc;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import swing.panel.RoundPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.formdev.flatlaf.FlatLightLaf;

import swing.button.RoundButton;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;
import java.awt.event.ActionEvent;
import control.thuoc.themthuoccontrol;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class themthuocform extends JPanel {
	public static JTextField masp;
	public static JTextField tensp;
	public static JTextField hamluong;
	public static JTextField hoatchat;
	public static DefaultComboBoxModel cbphanloai;
	public static DefaultComboBoxModel cbdonvi;
	public static DefaultComboBoxModel cbhang;
	public static JComboBox Donvi;
	public static JComboBox Phanloai;
	public static JComboBox Hang ;
	public static JTextField quydoi;
	public static JTextField gia;
	/**
	 * Create the panel.
	 */
	public themthuocform() {
		FlatLightLaf.setup();
		setLayout(new BorderLayout(0, 0));
		setSize(1213,707);
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setBackground(SystemColor.activeCaption);
		JLabel lblNewLabel = new JLabel("Sản phẩm mới");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		RoundPanel roundPanel = new RoundPanel();
		roundPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm");
		
		masp = new JTextField();
		masp.setColumns(10);
		
		tensp = new JTextField();
		tensp.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm");
		
		hamluong = new JTextField();
		hamluong.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Hàm lượng");
		
		JLabel lblNewLabel_2 = new JLabel("Hãng sản xuất");
		
		Hang = new JComboBox();
		
		JLabel lblNewLabel_2_1 = new JLabel("Phân loại");
		
		Phanloai = new JComboBox();
		
		JLabel lblNewLabel_2_2 = new JLabel("Đơn vị");
		
		Donvi = new JComboBox();
		
		hoatchat = new JTextField();
		hoatchat.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Hoạt chất");
		
		RoundButton rndbtnBack = new RoundButton();
		rndbtnBack.setFocusPainted(false);
		rndbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themthuoccontrol.back();
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
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(roundPanel, GroupLayout.PREFERRED_SIZE, 561, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		RoundButton rndbtnThm = new RoundButton();
		rndbtnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themthuoccontrol.add();
			}
		});
		rndbtnThm.setFocusPainted(false);
		rndbtnThm.setText("Thêm");
		rndbtnThm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		quydoi = new JTextField();
		quydoi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_ENTER)))
				{
					e.consume();
				}
			}
		});
		quydoi.setColumns(10);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Quy đổi");
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themthuoccontrol.thempl();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Thêm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themthuoccontrol.themdv();
			}
		});
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("(Nếu đây là đơn vị cơ bản hãy nhập số 1)");
		
		JLabel lbl = new JLabel("Giá");
		
		gia = new JTextField();
		gia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_ENTER)))
				{
					e.consume();
				}
			}
		});
		gia.setColumns(10);
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(masp, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(tensp, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(Hang, 0, 385, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Phanloai, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Donvi, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(hoatchat, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(hamluong, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(240)
					.addComponent(rndbtnThm, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
					.addGap(239))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(lbl, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(gia, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_2_2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(quydoi, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_2_2_1, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
					.addGap(60))
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(67)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(masp, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(tensp, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(Hang, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(Phanloai, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(Donvi, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_2_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(hoatchat, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(hamluong, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2_2_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(quydoi, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_2_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(gia, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(rndbtnThm, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
		);
		roundPanel.setLayout(gl_roundPanel);
		panel.setLayout(gl_panel);
		themthuoccontrol.newlist();
	}
}
