package budgetPackage;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BudgetPanel extends JPanel{

	protected JTextField inputField; //This field is where commands are entered
    protected JTextArea commandArea; //This area is where commands are copied, and instructions are shown
    protected JTextArea budgetArea; //This area is where the budget is displayed
    private final static String newline = "\n"; //used for button, to add new line after addition
    //should Budget be a property of the UI? to be decided
	
    
	public BudgetPanel() {
		super(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		inputField = new JTextField(20);
        commandArea = new JTextArea(25, 20); 
        commandArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(commandArea);
        budgetArea = new JTextArea(25, 20); 
        budgetArea.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(budgetArea);
        JButton inputButton = new JButton("Add");
        inputButton.setBounds(10, 80, 80, 25);
        inputButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) { 
        		String text = inputField.getText();
                commandArea.append(text + newline);
                inputField.selectAll();
                commandArea.setCaretPosition(commandArea.getDocument().getLength());
        	}
        });
        
        
		
		
	}
	
	
	
	
}
