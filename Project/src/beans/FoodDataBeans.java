package beans;

import java.io.Serializable;

public class FoodDataBeans implements Serializable {

	private int id;
	private String name;
	private String detail;
	private String fileName;
	private int foodId;
	private String itemName;
	private String foodName;
	private int price;
	private String itemFile;
	private String foodFile;
	private int itemId;
	private String itemDetail;

	public FoodDataBeans() {

	}

	public FoodDataBeans(int foodId, String itemName, String foodName, String detail2, int price, String itemFile,
			String foodFile, String itemDetail, int itemId) {

		this.foodId = foodId;
		this.itemName = itemName;
		this.price = price;
		this.foodName = foodName;
		this.detail = detail2;
		this.itemFile = itemFile;
		this.foodFile = foodFile;
		this.itemId = itemId;
		this.itemDetail = itemDetail;

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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getItemFile() {
		return itemFile;
	}

	public void setItemFile(String itemFile) {
		this.itemFile = itemFile;
	}

	public String getFoodFile() {
		return foodFile;
	}

	public void setFoodFile(String foodFile) {
		this.foodFile = foodFile;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
}
