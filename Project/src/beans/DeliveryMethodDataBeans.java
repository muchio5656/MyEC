package beans;

import java.io.Serializable;

public class DeliveryMethodDataBeans implements Serializable {

	//プロパティの宣言
	private int id;
	private String name;
	private int price;

	// 引数なしコンストラクタの定義
	public DeliveryMethodDataBeans() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
