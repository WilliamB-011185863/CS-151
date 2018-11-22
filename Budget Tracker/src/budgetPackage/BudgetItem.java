package budgetPackage;

public class BudgetItem {
	String itemName; //Name of a object in budget
	Double value; //Value of an object in budget
	Boolean plusMinus; //If object is revenue or expense
	
	public BudgetItem(String setName, Double setValue, Boolean setPositive) {
		this.itemName = setName;
		this.value = setValue;
		this.plusMinus = setPositive;
	}
	public void setItemName(String setName) {
		this.itemName = setName;
	}
	public void setItemValue(Double setValue) {
		if (setValue < 0) {
			this.value = Math.abs(setValue);
			this.plusMinus = false;
		}
		else {
			this.value = setValue;
			this.plusMinus = true;
		}
	}
	public String getItemName() {
		return this.itemName;
	}
	public Double getItemValue() {
		return this.value;
	}
	public Double getTrueValue() {
		if (this.plusMinus = true) {
			return this.value;
		}
		else {
			return (-this.value);
		}
	}
	
	public Boolean assetDebt() {
		return this.plusMinus;
	}
	
	
	

	
}
