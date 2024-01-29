package form.nhacungcap;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JDateChooser;

import control.nhacungcap.dsnhacungcapcontrol;
import control.nhaphang.dsnhaphangcontrol;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class dsnhacungcapform extends JPanel {
	public static  JTextField ma;
	public static JTable table;
	public static DefaultTableModel model;
	public static JTextField ten;
	public static TableRowSorter sorter;
	public static RoundButton rndbtnThm;
	/**
	 * Create the panel.
	 */
	public dsnhacungcapform() {
		setLayout(new BorderLayout(0, 0));
		setSize(1213,707);
		FlatLightLaf.setup();
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		add(panel, BorderLayout.CENTER);
		
		rndbtnThm = new RoundButton();
		rndbtnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dsnhacungcapcontrol.add();
			}
		});
		rndbtnThm.setText("Thêm");
		rndbtnThm.setFocusPainted(true);
		
		RoundPanel roundPanel_1 = new RoundPanel();
		roundPanel_1.setLayout(new BorderLayout(0, 0));
		
		RoundPanel roundPanel = new RoundPanel();
		roundPanel.setRoundTopRight(20);
		roundPanel.setRoundTopLeft(20);
		roundPanel.setRoundBottomRight(20);
		roundPanel.setRoundBottomLeft(20);
		
		JLabel lblNewLabel = new JLabel("Mã nhà cung cấp");
		
		ma = new JTextField();
		ma.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		ma.setColumns(10);
		
		RoundButton rndbtnLmMi = new RoundButton();
		rndbtnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dsnhacungcapcontrol.reset();
			}
		});
		rndbtnLmMi.setText("Làm mới");
		
		RoundButton btnfilter = new RoundButton();
		btnfilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dsnhacungcapcontrol.filter(ma.getText().trim(),ten.getText().trim());
			}
		});
		btnfilter.setText("Tìm kiếm");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(roundPanel_1, GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
					.addGap(20))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(183)
					.addComponent(roundPanel, GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
					.addGap(183))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(1039, Short.MAX_VALUE)
					.addComponent(rndbtnThm, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(roundPanel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(roundPanel_1, GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rndbtnThm, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		roundPanel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dsnhacungcapcontrol.load(table.getValueAt(table.getSelectedRow(),0).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhà cung cấp");
		
		ten = new JTextField();
		ten.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		ten.setColumns(10);
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(ma, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ten, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addGap(44)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnfilter, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
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
					.addComponent(ma, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(ten, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(btnfilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(rndbtnLmMi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		roundPanel.setLayout(gl_roundPanel);
		panel.setLayout(gl_panel);
		dsnhacungcapcontrol.newtable();
	}
}
