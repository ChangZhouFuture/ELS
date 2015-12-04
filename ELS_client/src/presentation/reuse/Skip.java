package presentation.reuse;

import javax.swing.JPanel;

public class Skip {
	public static JPanel skip(JPanel mainPanel, JPanel childPanel) {
		mainPanel.removeAll();
		mainPanel.add(childPanel);
		mainPanel.revalidate();
		mainPanel.repaint();
		return mainPanel;
	}
}
