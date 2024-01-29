package form.nhanvien;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class tabnhanvien extends JPanel {
	public static JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	public dsnhanvienform ds=new dsnhanvienform();
	public themnhanvienform add=new themnhanvienform();
	/**
	 * Create the panel.
	 */
	public tabnhanvien() {
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
	}
}
