package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class ItemDataBeans implements Serializable {

	private int id;
	private String name;
	private String detail;
	private int price;
	private String fileName;
	private int itemCategoryId;
	private String createDate;
	private int itemSales;
	private String itemCategoryName;

	public ItemDataBeans() {

	}

	//Itemの全データを取得するコンストラクタ
	public ItemDataBeans(int id2, String name2, int price2, String detail2,String fileName2, String createDate2, String itemCategoryName2) {
		this.id=id2;
		this.name=name2;
		this.price=price2;
		this.detail=detail2;
		this.fileName= fileName2;
		this.createDate= createDate2;
		this.itemCategoryName=itemCategoryName2;
	}

	public ItemDataBeans(int id2,String name2, int price2, String fileName2, String detail2) {
		this.id=id2;
		this.name=name2;
		this.price=price2;
		this.detail=detail2;
		this.fileName= fileName2;
	}

	public ItemDataBeans(String name2, int price2, String fileName2, String detail2, int itemCategoryId2) {

		this.name=name2;
		this.price=price2;
		this.detail=detail2;
		this.fileName= fileName2;
		this.itemCategoryId=itemCategoryId2;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getItemCategoryId() {
		return itemCategoryId;
	}

	public void setItemCategoryId(int itemCategoryId) {
		this.itemCategoryId = itemCategoryId;
	}


	public String getFormatCreateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(createDate);
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getItemSales() {
		return itemSales;
	}

	public void setItemSales(int itemSales) {
		this.itemSales = itemSales;
	}

	public String getCreateDate() {
		return createDate;
	}

	public String getItemCategoryName() {
		return itemCategoryName;
	}

	public void setItemCategoryName(String itemCategoryName) {
		this.itemCategoryName = itemCategoryName;
	}

	public String getFormatTotalPrice() {

		return String.format("%,d", this.price);
	}

	public String getFormatPrice() {
		return String.format("%,d", this.price);
	}

}
