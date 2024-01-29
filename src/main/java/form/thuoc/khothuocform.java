package form.thuoc;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import swing.panel.RoundPanel;
import swing.button.RoundButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DebugGraphics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.formdev.flatlaf.FlatLightLaf;
import control.thuoc.khothuoccontrol;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class khothuocform extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static TableRowSorter sorter;
	public static JTextField mathuoc=new JTextField();
	public static JTextField tenthuoc=new JTextField();
	public static JTextField hoatchat=new JTextField();
	public static JTextField hamluong=new JTextField();
	public static JTable table = new JTable();
	public static DefaultTableModel model=new DefaultTableModel();
	public static JPanel panel=new JPanel();
	public static DefaultComboBoxModel cbphanloai=new DefaultComboBoxModel();
	public static DefaultComboBoxModel cbdonvi=new DefaultComboBoxModel();
	public static DefaultComboBoxModel cbhang;
	public static JComboBox Donvi=new JComboBox();
	public static JComboBox Phanloai=new JComboBox();
	public static JComboBox Hang =new JComboBox();
	public static RoundButton rndbtnThm ;

	/**
	 * Create the panel.
	 */
	public khothuocform() {
		FlatLightLaf.setup();
		setSize(1213,707);
		setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		
		
		rndbtnThm = new RoundButton();
		rndbtnThm.setFocusPainted(false);
		rndbtnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khothuoccontrol.addpanel();;
			}
		});
		rndbtnThm.setText("Thêm");
		
		RoundPanel roundPanel_1 = new RoundPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				khothuoccontrol.info();
			}
		});
		scrollPane.setViewportView(table);
		
		RoundPanel roundPanel = new RoundPanel();
		roundPanel.setRoundTopRight(20);
		roundPanel.setRoundTopLeft(20);
		roundPanel.setRoundBottomRight(20);
		roundPanel.setRoundBottomLeft(20);
		
		JLabel lblNewLabel = new JLabel("Mã thuốc");
		
		JLabel lblTnThuc = new JLabel("Tên thuốc");
		
		mathuoc = new JTextField();
		mathuoc.setDebugGraphicsOptions(DebugGraphics.NONE_OPTION);
		mathuoc.setColumns(10);
		
		tenthuoc = new JTextField();
		tenthuoc.setColumns(10);
		
		JLabel lblHng = new JLabel("Hãng");
		
		Hang = new JComboBox();
		
		Phanloai = new JComboBox();
		
		JLabel lblHng_1 = new JLabel("Phân loại");
		
		JLabel lblnV = new JLabel("Đơn vị");
		
		Donvi = new JComboBox();
		
		JLabel lblHotCht = new JLabel("Hoạt chất");
		
		hoatchat = new JTextField();
		hoatchat.setColumns(10);
		
		RoundButton rndbtnLmMi = new RoundButton();
		rndbtnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khothuoccontrol.reset();
			}
		});
		rndbtnLmMi.setText("Làm mới");
		
		RoundButton rndbtnLmMi_1 = new RoundButton();
		rndbtnLmMi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khothuoccontrol.filter(mathuoc.getText().trim(),tenthuoc.getText().trim(),Hang.getSelectedItem().toString(),Phanloai.getSelectedItem().toString(),Donvi.getSelectedItem().toString(),hoatchat.getText().trim());
			}
		});
		rndbtnLmMi_1.setText("Tìm kiếm");
		GroupLayout gl_roundPanel = new GroupLayout(roundPanel);
		gl_roundPanel.setHorizontalGroup(
			gl_roundPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
						.addComponent(lblTnThuc, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
					.addGap(10)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(mathuoc, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
						.addComponent(tenthuoc, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addGap(14)
					.addComponent(lblHng, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
					.addGap(8)
					.addComponent(Hang, 0, 136, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblHng_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
						.addComponent(lblnV, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(Phanloai, 0, 212, Short.MAX_VALUE)
						.addComponent(Donvi, 0, 212, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHotCht, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(hoatchat, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
					.addGap(38)
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(rndbtnLmMi, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
						.addComponent(rndbtnLmMi_1, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
					.addGap(46))
		);
		gl_roundPanel.setVerticalGroup(
			gl_roundPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_roundPanel.createSequentialGroup()
					.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_roundPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(rndbtnLmMi_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(rndbtnLmMi, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_roundPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_roundPanel.createSequentialGroup()
								.addGap(12)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
								.addComponent(lblTnThuc, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_roundPanel.createSequentialGroup()
								.addGap(13)
								.addComponent(mathuoc, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(9)
								.addComponent(tenthuoc, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, Short.MAX_VALUE))
							.addGroup(gl_roundPanel.createSequentialGroup()
								.addGap(12)
								.addGroup(gl_roundPanel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_roundPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblHng_1, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
										.addComponent(Phanloai, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblHng, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_roundPanel.createSequentialGroup()
										.addGap(1)
										.addComponent(Hang, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE)))
								.addGap(8)
								.addGroup(gl_roundPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblnV, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addComponent(Donvi, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_roundPanel.createSequentialGroup()
								.addGap(12)
								.addGroup(gl_roundPanel.createParallelGroup(Alignment.BASELINE, false)
									.addComponent(lblHotCht, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
									.addComponent(hoatchat, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))))
					.addGap(10))
		);
		roundPanel.setLayout(gl_roundPanel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(rndbtnThm, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(roundPanel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
								.addComponent(roundPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE))))
					.addGap(20))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(roundPanel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(roundPanel_1, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(rndbtnThm, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		roundPanel_1.setLayout(new BorderLayout(0, 0));
		roundPanel_1.add(scrollPane);
		panel.setLayout(gl_panel);
		add(panel);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				panel.setSize(getSize());
			}
		});
	khothuoccontrol.newlist();
	khothuoccontrol.newtable();
	}
}
