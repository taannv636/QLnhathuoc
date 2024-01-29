package form.nhaphang;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import swing.panel.RoundPanel;
import java.awt.GridLayout;
import swing.button.RoundButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DebugGraphics;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JDateChooser;

import control.nhaphang.dsnhaphangcontrol;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dsnhaphangform extends JPanel {
	public static TableRowSorter sorter;
	public static JTextField maphieu;
	public static JComboBox Hang ;
	public static JDateChooser ngaynhap;
	public static JTable table;
	public static DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public dsnhaphangform() {
		setLayout(new BorderLayout(0, 0));
		setSize(1213,707);
		FlatLightLaf.setup();
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		add(panel, BorderLayout.CENTER);
		
		RoundPanel btnpanel = new RoundPanel();
		btnpanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		RoundButton rndbtnThm = new RoundButton();
		rndbtnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dsnhaphangcontrol.add();
			}
		});
		rndbtnThm.setText("Thêm");
		rndbtnThm.setFocusPainted(false);
		btnpanel.add(rndbtnThm);
		
		RoundPanel roundPanel_1 = new RoundPanel();
		roundPanel_1.setLayout(new BorderLayout(0, 0));
		
		RoundPanel roundPanel = new RoundPanel();
		roundPanel.setRoundTopRight(20);
		roundPanel.setRoundTopLeft(20);
		roundPanel.setRoundBottomRight(20);
		roundPanel.setRoundBottomLeft(20);
		
		JLabel lblNewLabel = new JLabel("Mã phiếu");
		
		maphieu = new JTextField();
		maphieu.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		maphieu.setColumns(10);
		
		JLabel lblHng = new JLabel("Nhà cung cấp");
		
		Hang = new JComboBox();
		
		RoundButton rndbtnLmMi = new RoundButton();
		rndbtnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dsnhaphangcontrol.clear();
			}
		});
		rndbtnLmMi.setText("Làm mới");
		RoundButton rndbtnLmMi_1 = new RoundButton();
		rndbtnLmMi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dsnhaphangcontrol.filter(maphieu.getText().trim(),Hang.getSelectedItem().toString(),ngaynhap.getDate());
			}
		});
		rndbtnLmMi_1.setText("Tìm kiếm");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(157)
					.addComponent(roundPanel, GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
					.addGap(157))
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnpanel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addComponent(roundPanel_1, GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)))
					.addGap(20))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(roundPanel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(roundPanel_1, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnpanel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		roundPanel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dsnhaphangcontrol.load(table.getValueAt(table.getSelectedRow(),0).toString().trim());
			}
		});
		scrollPane.setViewportView(table);
		
		ngaynhap = new JDateChooser();
		ngaynhap.setDateFormatString("dd/M/yyyy");
		
		JLabel lblNewLabel_1 = new JLabel("Ngày nhập");
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(maphieu, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addGap(14)
					.addComponent(lblHng, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(Hang, 0, 136, Short.MAX_VALUE)
					.addGap(25)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(ngaynhap, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(rndbtnLmMi_1, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(rndbtnLmMi, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(28)
					.addComponent(maphieu, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblHng, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(Hang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel_1))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(27)
					.addComponent(ngaynhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(rndbtnLmMi_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(rndbtnLmMi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		roundPanel.setLayout(gl_roundPanel);
		panel.setLayout(gl_panel);
		dsnhaphangcontrol.newtable();
		dsnhaphangcontrol.newcombo();
	}
}
