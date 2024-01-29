package form.thuoc;

import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;

import control.thuoc.quydoicontrol;
import control.thuoc.themthuoccontrol;
import control.thuoc.thongtincontrol;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import swing.panel.RoundPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import swing.button.RoundButton;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class thongtinform extends JPanel {
	public static JTextField ma;
	public static JTextField ten;
	public static JTextField hc;
	public static JTextField hl;
	public static JTable table;
	public static JTextField hang;
	public static JTextField dv;
	public static JTextField qd;
	public static JComboBox Phanloai;
	public static JTextField gia;
	public static RoundButton rndbtnLu;
	/**
	 * Create the panel.
	 */
	public thongtinform() {
		setLayout(new BorderLayout(0, 0));
		
		setSize(1213,707);
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setBackground(SystemColor.activeCaption);
		RoundPanel roundPanel = new RoundPanel();
		roundPanel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblma = new JLabel("Mã sản phẩm");
		
		ma = new JTextField();
		ma.setEditable(false);
		ma.setColumns(10);
		
		JLabel lblten = new JLabel("Tên sản phẩm");
		
		ten = new JTextField();
		ten.setColumns(10);
		
		JLabel lblhoatchat = new JLabel("Hoạt chất");
		
		hc = new JTextField();
		hc.setColumns(10);
		
		JLabel lblhamluong = new JLabel("Hàm lượng");
		
		hl = new JTextField();
		hl.setColumns(10);
		
		JLabel lblhang = new JLabel("Hãng sản xuất");
		
		JLabel lblpl = new JLabel("Phân loại");
		
		JLabel lbldv = new JLabel("Đơn vị");
		
		Phanloai = new JComboBox();
		
		JLabel lblNewLabel = new JLabel("Thông tin thuốc");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		hang = new JTextField();
		hang.setEditable(false);
		hang.setColumns(10);
		
		dv = new JTextField();
		dv.setEditable(false);
		dv.setColumns(10);
		
		JLabel lblquydoi = new JLabel("Quy đổi");
		
		qd = new JTextField();
		qd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_ENTER)))
				{
					e.consume();
				}
			}
		});
		qd.setColumns(10);
		
		JLabel lblquydoi_1 = new JLabel("Giá");
		
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
		
		rndbtnLu = new RoundButton();
		rndbtnLu.setText("Lưu");
		rndbtnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongtincontrol.update();
			}
		});
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblten, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(ten, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addComponent(lblhoatchat, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(hc, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblhang, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblpl, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbldv, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(Phanloai, 0, 342, Short.MAX_VALUE)
						.addComponent(hang, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
						.addComponent(dv, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(lblma, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(ma, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)))
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(lblquydoi_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(gia, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(lblquydoi, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(qd, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(lblhamluong, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(hl, GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)))
					.addGap(60))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addContainerGap(464, Short.MAX_VALUE)
					.addComponent(rndbtnLu, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(36)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblma, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(ma, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblten, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(ten, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblhang, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(hang, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblpl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(Phanloai, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbldv, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(dv, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblhoatchat, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(hc, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblhamluong, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(hl, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblquydoi, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(qd, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblquydoi_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(gia, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(138)
					.addComponent(rndbtnLu, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(700))
		);
		roundPanel.setLayout(gl_roundPanel);
		
		RoundButton rndbtnBack = new RoundButton();
		rndbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongtincontrol.back();
			}
		});
		rndbtnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rndbtnBack.setText("Back");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(roundPanel, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
						.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
						.addComponent(roundPanel, GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				quydoicontrol.load(ma.getText().trim(),hang.getText().trim(),dv.getText().trim(),table.getValueAt(table.getSelectedRow(),0).toString().trim());
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin số lượng trong kho");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3, BorderLayout.NORTH);
		panel.setLayout(gl_panel);
		FlatLightLaf.setup();
	}
}
