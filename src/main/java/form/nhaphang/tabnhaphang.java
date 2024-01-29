package form.nhaphang;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class tabnhaphang extends JPanel {
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	public dsnhaphangform ds=new dsnhaphangform();
	public nhaphangform add=new nhaphangform();
	public thongtinphieuform tt=new thongtinphieuform();
	/**
	 * Create the panel.
	 */
	public tabnhaphang() {
		setSize(1213,707);
		setLayout(null);
		tabbedPane.setBounds(0, -35, 1213,742);
		add(tabbedPane);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				tabbedPane.setBounds(0,-35,getWidth(),tabbedPane.getHeight());
			}
		});
		tabbedPane.addTab(null, ds);
		tabbedPane.addTab(null, add);
		tabbedPane.addTab(null, tt);
	}

}
