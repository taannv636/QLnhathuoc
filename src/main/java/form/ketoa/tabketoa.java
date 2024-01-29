package form.ketoa;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class tabketoa extends JPanel {
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	public static dstoaform dstoa=new dstoaform();
	public static ketoaform ketoa=new ketoaform();
	public static thongtintoaform tttoa=new thongtintoaform();
	/**
	 * Create the panel.
	 */
	public tabketoa() {
		setSize(1213,707);
		setLayout(null);
		tabbedPane.setBounds(0, -25, 1213,742);
		add(tabbedPane);
		tabbedPane.addTab(null, dstoa);
		tabbedPane.addTab(null, ketoa);
		tabbedPane.addTab(null, tttoa);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				tabbedPane.setBounds(0,-35,getWidth(),tabbedPane.getHeight());
			}
		});
	}
}
