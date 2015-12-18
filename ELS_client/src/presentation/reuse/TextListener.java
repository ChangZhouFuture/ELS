package presentation.reuse;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TextListener implements DocumentListener{
	private JTextField jTextField;
	
	public TextListener(JTextField jTextField) {
		this.jTextField = jTextField;
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		String text = jTextField.getText();
		
		char c = text.charAt(text.length()-1);
		if ((c < '0' || c > '9') && c != '.') {
			System.out.println("wrong");
			return;
		}
		
		try {
			double weight = Double.parseDouble(jTextField.getText());
		} catch (Exception e2) {
			System.out.println("«Î÷ÿ–¬ ‰»Î");
		}
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		
	}

}
