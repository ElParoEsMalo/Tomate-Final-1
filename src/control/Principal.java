package control;

import java.awt.EventQueue;

import vistaVentana.UIGazpacho;

public class Principal {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIGazpacho frame = new UIGazpacho();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
