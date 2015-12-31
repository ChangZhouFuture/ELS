package presentation.reuse;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.util.concurrent.Executors;  
import java.util.concurrent.ScheduledExecutorService;  
import java.util.concurrent.TimeUnit;  
  
import javax.swing.JButton;  
import javax.swing.JDialog;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
public class EMSDialog {
	 private String message = null;  
	 private int secends = 0;  
	 private JLabel label = new JLabel();  
	 private JButton confirm,cancel;   
	 private JDialog dialog = null;  
	 int result = -5; 
	 Font font2=new Font("黑体",Font.PLAIN,15);
	 public int  showDialog(JFrame father, String message, int sec) {  
	     this.message = message;  
	     secends = sec;  
	     label.setText(message);  
	     label.setFont(font2);
	     label.setBounds(80,6,200,20);  
	     ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();  
	     confirm = new JButton("是");  
	     confirm.setFont(font2);
	     confirm.setBounds(100,40,60,20);  
	     confirm.setBackground(Color.WHITE);
	     confirm.addActionListener(new ActionListener() {              
	            @Override  
	         public void actionPerformed(ActionEvent e) {  
	             result = 1;  
	             EMSDialog.this.dialog.dispose();  
	         }  
	     });  
	     cancel = new JButton("否");
	     cancel.setFont(font2);
	     cancel.setBackground(Color.WHITE);
	     cancel.setBounds(190,40,60,20);  
	     cancel.addActionListener(new ActionListener() {  
	              
	            @Override  
	         public void actionPerformed(ActionEvent e) {  
	             result = 0;  
	             EMSDialog.this.dialog.dispose();  
	         }  
	     });  
	     dialog = new JDialog(father, true);  
	     dialog.setTitle("提示: 本窗口将在"+secends+"秒后自动关闭");  
	     dialog.setLayout(null);  
	     dialog.add(label);  
	     dialog.add(confirm);  
	     dialog.add(cancel);  
	     s.scheduleAtFixedRate(new Runnable() {  
	              
	            @Override  
	         public void run() {  
	            EMSDialog.this.secends--;  
	            if(EMSDialog.this.secends == 0) {  
	                EMSDialog.this.dialog.dispose();  
	            }else {  
	                dialog.setTitle("提示: 本窗口将在"+secends+"秒后自动关闭");  
	            }  
	        }  
	    }, 1, 1, TimeUnit.SECONDS);  
	    dialog.pack();  
	    dialog.setSize(new Dimension(350,140));  
	    dialog.setLocationRelativeTo(father);  
	    dialog.setVisible(true);  
	    return result;  
	}  
}
