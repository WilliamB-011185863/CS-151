package mvc;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MVCTester extends JPanel
					{
	private static final long serialVersionUID = 109893666086085583L;
	protected JTextField textField;
    protected JTextArea textArea;
    private final static String newline = "\n";
	 
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                CreateAndShowGUI();
            }
        });
	}

	private static void CreateAndShowGUI() { //view
        JFrame frame = new JFrame("Input Text and Press Add");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MVCTester());
        frame.pack();
        frame.setVisible(true);
    }
	 
    public MVCTester() { //model
        super(new GridBagLayout());
        textField = new JTextField(20);
        textArea = new JTextArea(25, 50);
        textArea.setEditable(false);
        JButton adderbutton = new JButton("Add");
        adderbutton.setBounds(10, 80, 80, 25);
        JScrollPane scrollPane = new JScrollPane(textArea);
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(textField, c);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        add(scrollPane, c);
        adderbutton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) { //controll, anonymous class
        		String text = textField.getText();
                textArea.append(text + newline);
                textField.selectAll();
                textArea.setCaretPosition(textArea.getDocument().getLength());
        	}
        });
        add(adderbutton, c);
    }


}
