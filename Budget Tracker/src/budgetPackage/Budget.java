package budgetPackage;

import java.util.ArrayList;

public class Budget {
	String customerName;
	ArrayList<BudgetItem> BudgetList;
	
	public Budget(String nameInput) {
		this.BudgetList = new ArrayList<BudgetItem>();
		this.customerName = nameInput;
	}

}
