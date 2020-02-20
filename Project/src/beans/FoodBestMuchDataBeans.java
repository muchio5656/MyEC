package beans;

import java.io.Serializable;

public class FoodBestMuchDataBeans implements Serializable {

	private int id;
	private int food_id;
	private int item_id;

	public FoodBestMuchDataBeans() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
}
