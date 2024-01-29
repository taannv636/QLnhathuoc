package form.nhacungcap;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class tabnhacungcap extends JPanel {
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	public dsnhacungcapform ds=new dsnhacungcapform();
	public themnhacungcapform add=new themnhacungcapform();
	public thongtinnhacungcapform tt=new thongtinnhacungcapform();
	/**
	 * Create the panel.
	 */
	public tabnhacungcap() {
		setSize(1213,707);
		setLayout(null);
		tabbedPane.setBounds(0, -35, 1213,742);
		add(tabbedPane);
		tabbedPane.addTab(null, ds);
		tabbedPane.addTab(null, add);
		tabbedPane.addTab(null, tt);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				tabbedPane.setBounds(0,-35,getWidth(),tabbedPane.getHeight());
			}
		});
		
	}

}
