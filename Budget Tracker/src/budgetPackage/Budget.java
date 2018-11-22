package budgetPackage;

import java.util.ArrayList;

public class Budget {
	String customerName;
	ArrayList<BudgetItem> BudgetList;
	BudgetFileInterface fInterface;
	Boolean fileExists;
	
	public Budget(String nameInput) {
		this.BudgetList = new ArrayList<BudgetItem>();
		this.customerName = nameInput;
		fileExists = fInterface.CheckFile(nameInput);
		if (fileExists = true) {
			//load the file
		}
		
	}
	
	public void finishingTouches() {
		//setDefaultCloseOperation(Budget.finishingTouches())
		//intended to save the current Budget after closing the window
		//todo
		cleanUp();
	}
	
	public void newItem(String setName, Double setValue, Boolean setPositive) {
		BudgetList.add(new BudgetItem(setName, setValue, setPositive));
	}
	
	public int getListSize() {
		return BudgetList.size();
	}
	
	public Double getValue(int id) {
		//gets the value of id
		id--;
		try {
			return BudgetList.get(id).getTrueValue();
		}
		catch (NullPointerException e) {
			System.out.println("Error: getValue nullPoint, id = " + id);
			return (double) -1;
		}
	}
	
	public void setValue(int id, double newValue) {
		//Sets the value of id to V
		id--;
		try {
			BudgetList.get(id).setItemValue(newValue);
			return;
		}
		catch (NullPointerException e) {
			System.out.println("Error: setValue nullPoint, id = " + id + ", value to set = " + newValue);
			return;
		}
		// toDo - add some update function when V = 0?
	}
	
	public void removeItem(int id) {
		//Removes id from the list
		id--;
		try {
			BudgetList.remove(id);
			return;
		}
		catch (NullPointerException e) {
			System.out.println("Error: removeItem nullpoint, id = " + id );
			return;
		}
	}
	
	public void rename(int id, String newName) {
		id--;
		try {
			BudgetList.get(id).setItemName(newName);
			return;
		}
		catch (NullPointerException e) {
			System.out.println("Error: rename nullPoint, id = " + id + ", newName to set = " + newName);
			return;
		}
	}
	
	public void cleanUp() {
		//Intended to prune away objects with no value
		for (int i = 0; i < BudgetList.size(); i++) {
			if (BudgetList.get(i).getItemValue() == 0){
				BudgetList.remove(i);
				i--;
			}
		}
	}
	
	public double totalValue() {
		double tally = 0;
		for (int i = 0; i < BudgetList.size(); i++) {
			tally += BudgetList.get(i).getTrueValue();
		}
		return tally;
	}
	
	public double totalAsset() {
		double tally = 0;
		for (int i = 0; i < BudgetList.size(); i++) {
			if (BudgetList.get(i).assetDebt() == true) {
				tally += BudgetList.get(i).getItemValue();
			}
		}
		return tally;
	}
	
	public double totalDebt() {
		double tally = 0;
		for (int i = 0; i < BudgetList.size(); i++) {
			if (BudgetList.get(i).assetDebt() == false) {
				tally += BudgetList.get(i).getItemValue();
			}
		}
		return tally;
	}
	
	
}
