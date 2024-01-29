package form.nhaphang;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import swing.panel.RoundPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import swing.button.RoundButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;

import control.nhaphang.nhaphangcontrol;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class nhaphangform extends JPanel {
	public static JTextField maphieu;
	public static JTextField nhacungcap;
	public static JTextField mathuoc;
	public static JTable table;
	public static JTextField hang;
	public static JTextField dongia;
	public static JTextField tongtien;
	public static JComboBox dv;
	public static JSpinner sl;
	public static JDateChooser date;

	/**
	 * Create the panel.
	 */
	public nhaphangform() {
		setLayout(new BorderLayout(0, 0));
		setSize(1213,707);
		RoundPanel roundPanel = new RoundPanel();
		add(roundPanel, BorderLayout.CENTER);
		
		RoundButton rndbtnBack = new RoundButton();
		rndbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaphangcontrol.back();
			}
		});
		rndbtnBack.setText("Back");
		
		RoundPanel roundPanel_1 = new RoundPanel();
		roundPanel_1.setBackground(Color.LIGHT_GRAY);
		
		RoundPanel roundPanel_1_1 = new RoundPanel();
		roundPanel_1_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Đơn vị");
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã thuốc");
		
		mathuoc = new JTextField();
		mathuoc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nhaphangcontrol.checkdv();
			}
		});
		mathuoc.setColumns(10);
		
		JLabel lblThmThngTin = new JLabel("Thêm thông tin phiếu");
		lblThmThngTin.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmThngTin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		dv = new JComboBox();		
		sl = new JSpinner();
		sl.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		
		JScrollPane scrollPane = new JScrollPane();
		
		RoundButton rndbtnNhp = new RoundButton();
		rndbtnNhp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaphangcontrol.nhap();
			}
		});
		rndbtnNhp.setText("Nhập");
		
		tongtien = new JTextField();
		tongtien.setText("150000");
		tongtien.setEnabled(false);
		tongtien.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Tổng tiền ");
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(lblNewLabel_1_2_1_1_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tongtien, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rndbtnNhp, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(roundPanel_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(roundPanel_1, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1_2_1_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_roundPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(rndbtnNhp, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
									.addComponent(tongtien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addComponent(rndbtnBack, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(roundPanel_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(roundPanel_1_1, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Sl");
		
		date = new JDateChooser();
		date.setDateFormatString("dd/MM/yyyy");
		JLabel lblNewLabel_3 = new JLabel("Ngày hết hạn");
		
		RoundButton rndbtnThm = new RoundButton();
		rndbtnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaphangcontrol.them();
			}
		});
		rndbtnThm.setText("Thêm");
		
		RoundButton rndbtnXa = new RoundButton();
		rndbtnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhaphangcontrol.xoa();
			}
		});
		rndbtnXa.setText("Xóa");
		
		hang = new JTextField();
		hang.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nhaphangcontrol.checkdv();
			}
		});
		hang.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Mã hãng thuốc");
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Đơn giá");
		
		dongia = new JTextField();
		dongia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_ENTER)))
				{
					e.consume();
				}
			}
		});
		dongia.setColumns(10);
		GroupLayout gl_roundPanel_1_1 = new GroupLayout(roundPanel_1_1);
		gl_roundPanel_1_1.setHorizontalGroup(
			gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel_1_1.createSequentialGroup()
					.addGroup(gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(mathuoc, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
							.addGap(59))
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel_1_2_1, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(hang, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
							.addGap(59))
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_2, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
							.addGap(4)
							.addComponent(dv, 0, 189, Short.MAX_VALUE)
							.addGap(59))
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(sl, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
							.addGap(162))
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(date, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
							.addGap(59))
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel_1_2_1_1, GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
							.addGap(4)
							.addComponent(dongia, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
							.addGap(59))
						.addGroup(Alignment.TRAILING, gl_roundPanel_1_1.createSequentialGroup()
							.addGap(217)
							.addComponent(rndbtnXa, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(rndbtnThm, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(80)
							.addComponent(lblThmThngTin, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
							.addGap(69)))
					.addGap(10))
		);
		gl_roundPanel_1_1.setVerticalGroup(
			gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblThmThngTin, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_2))
						.addComponent(mathuoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_2_1))
						.addComponent(hang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_roundPanel_1_1.createSequentialGroup()
									.addGap(3)
									.addComponent(lblNewLabel_1_1_1_1))
								.addComponent(lblNewLabel_1_1_2)))
						.addComponent(dv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_2))
						.addComponent(sl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(2)
							.addComponent(lblNewLabel_3))
						.addComponent(date, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel_1_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_2_1_1))
						.addComponent(dongia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_roundPanel_1_1.createParallelGroup(Alignment.LEADING)
						.addComponent(rndbtnXa, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(rndbtnThm, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
		);
		roundPanel_1_1.setLayout(gl_roundPanel_1_1);
		
		JLabel lblNewLabel = new JLabel("Thông tin phiếu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		maphieu = new JTextField();
		maphieu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phiếu");
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã nhà cung cấp");
		
		nhacungcap = new JTextField();
		nhacungcap.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		GroupLayout gl_roundPanel_1 = new GroupLayout(roundPanel_1);
		gl_roundPanel_1.setHorizontalGroup(
			gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addGap(60)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
					.addGap(60))
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
							.addGap(193))
						.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_roundPanel_1.createSequentialGroup()
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(nhacungcap, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_roundPanel_1.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(maphieu, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)))))
		);
		gl_roundPanel_1.setVerticalGroup(
			gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(maphieu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_roundPanel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(nhacungcap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_roundPanel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1)))
					.addGap(9)
					.addComponent(lblNewLabel_1_1_1)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		roundPanel_1.setLayout(gl_roundPanel_1);
		roundPanel.setLayout(gl_roundPanel);
		nhaphangcontrol.newtable();
		nhaphangcontrol.checkdv();
	}
}
