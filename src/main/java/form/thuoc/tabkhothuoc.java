package form.thuoc;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class tabkhothuoc extends JPanel {
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	static khothuocform kho=new khothuocform();
	static themthuocform them=new themthuocform();
	static thongtinform info=new thongtinform();
	static quydoiform qd=new quydoiform();
	/**
	 * Create the panel.
	 */
	public tabkhothuoc() {
		setSize(1213,707);
		setLayout(null);
		tabbedPane.setBounds(0, -35, 1213,742);
		add(tabbedPane);
		tabbedPane.addTab(null, kho);
		tabbedPane.addTab(null, them);
		tabbedPane.addTab(null, info);
		tabbedPane.addTab(null, qd);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				tabbedPane.setBounds(0,-35,getWidth(),tabbedPane.getHeight());
			}
		});
	}
}
