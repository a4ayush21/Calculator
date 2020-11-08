package Calculator;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JTextField;

public class Calculator extends Frame implements ActionListener {
	Button b[] = new Button[20];
	String s[] = { "B", "C", "1/x", "sqrt", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", ".", "0", "=",
			"+" };
	JTextField tf=new JTextField(20);
	String ss=new String();
	Calculator() {

		setVisible(true);
		setSize(400, 600);
		setLocation(200, 100);
		setBackground(Color.GRAY);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setLayout(null);
		int k = 0, x = 0, y = 100, w = 100, h = 100;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				b[k] = new Button(s[k]);
				b[k].setLocation(x, y);
				b[k].setSize(w, h);
				b[k].setFont(new Font("Times New Roman", Font.BOLD, 20));
				add(b[k]);
				b[k].addActionListener(this);
				k++;
				x = x + 100;
			}
			x = 0;
			y = y + 100;
		}
		tf.setLocation(0,0);
		tf.setSize(395,100);
		tf.setBackground(Color.white);
		tf.setForeground(Color.black);
		add(tf);
	}

	public static void main(String args[]) {
		Calculator cl = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b[4] || e.getSource() == b[5] || e.getSource() == b[6] || e.getSource() == b[7]
				|| e.getSource() == b[8] || e.getSource() == b[9] || e.getSource() == b[10] || e.getSource() == b[11]
				|| e.getSource() == b[12] || e.getSource() == b[13] || e.getSource() == b[14] || e.getSource() == b[15]
				|| e.getSource() == b[16] || e.getSource() == b[17] || e.getSource() == b[19]) {
			tf.setFont(new Font("Times New Roman",Font.BOLD,20));
			ss=ss+((Button) e.getSource()).getLabel();
			tf.setHorizontalAlignment(JTextField.RIGHT);
			tf.setText(ss);
		}
		else if(e.getSource()==b[0]) {
			tf.setText(ss.substring(0, ss.length()-1));
		}
		else if(e.getSource()==b[1]) {
			ss="";
			tf.setText(ss);
		}
		else {
			String s1=tf.getText();
			ScriptEngineManager em =new  ScriptEngineManager();
			ScriptEngine se=em.getEngineByName("js");
			String a="";
			try {
			 a=""+se.eval(s1);
			}catch(Exception f){}
			
			if(e.getSource()==b[2]) {
				double b=Double.parseDouble(a);
				b=1/b;
				tf.setText(""+b);
			}
			else if(e.getSource()==b[3]) {
				Double b=Double.parseDouble(a);
				b=Math.sqrt(b);
				tf.setText(""+b);
			}
			else if(e.getSource()==b[18]) {
				tf.setText(""+a);
			}
		}

	}

}

