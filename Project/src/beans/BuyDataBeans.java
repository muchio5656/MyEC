package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyDataBeans implements Serializable {
	private int id;
	private int userId;
	private int totalPrice;
	private int deliveryMethodId;
	private String deliveryMethodName;
	private int deliveryMethodPrice;
	private Date createDate;
	private Date buyDate;
	private int price;
	private String name;

	public BuyDataBeans() {

	}

	public BuyDataBeans(int id2, int totalPrice2, String name2, int price2, Date createDate2) {

		this.id = id2;
		this.totalPrice = totalPrice2;
		this.name = name2;
		this.price = price2;
		this.createDate = createDate2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDeliveryMethodId() {
		return deliveryMethodId;
	}

	public void setDeliveryMethodId(int deliveryMethodId) {
		this.deliveryMethodId = deliveryMethodId;
	}

	public String getDeliveryMethodName() {
		return deliveryMethodName;
	}

	public void setDeliveryMethodName(String deliveryMethodName) {
		this.deliveryMethodName = deliveryMethodName;
	}

	public int getDeliveryMethodPrice() {
		return deliveryMethodPrice;
	}

	public void setDeliveryMethodPrice(int deliveryMethodPrice) {
		this.deliveryMethodPrice = deliveryMethodPrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getBuyData() {
		return buyDate;
	}

	public void setBuyData(Date buyData) {
		this.buyDate = buyData;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(buyDate);
	}

	public String getFormatCreateDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時mm分");
		return sdf.format(createDate);
	}

	public String getFormatTotalPrice() {
		return String.format("%,d", this.totalPrice);
	}

}
