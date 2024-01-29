package form.nhanvien;

import javax.swing.JPanel;
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
import javax.swing.JCheckBox;

import com.formdev.flatlaf.FlatLightLaf;
import com.toedter.calendar.JDateChooser;

import control.nhanvien.dsnhanviencontrol;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

public class dsnhanvienform extends JPanel {
	public static TableRowSorter sorter;
	public static JTextField ten;
	public static JTable table;
	public static DefaultTableModel model;
	public static JDateChooser ngay;
	public static JComboBox cv;
	/**
	 * Create the panel.
	 */
	public dsnhanvienform() {
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
				dsnhanviencontrol.add();
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
		
		JLabel lblNewLabel = new JLabel("Tên nhân viên");
		
		ten = new JTextField();
		ten.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		ten.setColumns(10);
		
		JLabel lblHotCht = new JLabel("chức vụ");
		
		RoundButton btnclear = new RoundButton();
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dsnhanviencontrol.clear();
			}
		});
		btnclear.setText("Làm mới");
		
		RoundButton btnfilter = new RoundButton();
		btnfilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dsnhanviencontrol.filter(ten.getText().trim(),cv.getSelectedItem().toString(),ngay.getDate());
			}
		});
		btnfilter.setText("Tìm kiếm");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(roundPanel_1, GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
					.addGap(20))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(100)
					.addComponent(roundPanel, GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
					.addGap(100))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(1051, Short.MAX_VALUE)
					.addComponent(btnpanel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(roundPanel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(roundPanel_1, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(btnpanel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		roundPanel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Ngày vào làm");
		
		ngay = new JDateChooser();
		ngay.setDateFormatString("yyyy-MM-dd");
		
		cv = new JComboBox();
		cv.setModel(new DefaultComboBoxModel(new String[] {"Tất cả","Nhân viên","Dược sĩ","Admin"}));
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(ten, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHotCht, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cv, 0, 165, Short.MAX_VALUE)
					.addGap(93)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(ngay, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
					.addGap(29)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnfilter, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
						.addComponent(btnclear, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
					.addGap(14))
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_roundPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHotCht, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(28)
							.addComponent(ngay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(11)
							.addComponent(btnfilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(btnclear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGap(27)
							.addComponent(ten, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		roundPanel.setLayout(gl_roundPanel);
		panel.setLayout(gl_panel);
		dsnhanviencontrol.newtable();
	}
}
