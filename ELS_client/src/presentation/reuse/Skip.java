package presentation.reuse;

import javax.swing.JPanel;

public class Skip {
	public static void skip(JPanel mainPanel, JPanel childPanel) {
		mainPanel.removeAll();
		childPanel.setBounds(0, 0, mainPanel.getWidth(), mainPanel.getHeight());
		mainPanel.add(childPanel);
		mainPanel.revalidate();
		mainPanel.repaint();
	}
}
