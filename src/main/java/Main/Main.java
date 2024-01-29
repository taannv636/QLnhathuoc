package Main;

import java.awt.EventQueue;

import com.formdev.flatlaf.FlatLightLaf;

import form.login.login;

public class Main {

	public static void main(String[] args) {
		FlatLightLaf.setup();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	}


