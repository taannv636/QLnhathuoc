package form.home;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.formdev.flatlaf.FlatLightLaf;

public class homeform extends JPanel {

	/**
	 * Create the panel.
	 */
	public homeform() {
		setLayout(new BorderLayout(0, 0));
		setSize(1213,707);
		FlatLightLaf.setup();
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Quản lý nhà thuốc");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 70));
		
		JLabel lblNhm = new JLabel("Nhóm 9");
		lblNhm.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhm.setFont(new Font("Arial", Font.PLAIN, 45));
		
		JLabel lblNewLabel_1 = new JLabel("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNhm, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
							.addGap(395))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGap(225))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(227)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNhm, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(141)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(166, Short.MAX_VALUE))
		);
		lblNewLabel_1.setIcon(getImage("/form/home/pharma.png", 400, 400));
		panel.setLayout(gl_panel);
	}
	public ImageIcon getImage(String source,int width,int height) {
		ImageIcon a=new ImageIcon(getClass().getResource(source));
		Image newicon;
		Image icon=a.getImage();
		icon=a.getImage();
		newicon=icon.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		a=new ImageIcon(newicon);
		return a;
	}
}
