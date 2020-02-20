package beans;

import java.io.Serializable;

public class TriviaDataBeans implements Serializable {

	private int id;
	private String name;
	private String detail;
	private int itemCategoryid;

	public TriviaDataBeans() {

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

	public int getItemCategoryid() {
		return itemCategoryid;
	}

	public void setItemCategoryid(int itemCategoryid) {
		this.itemCategoryid = itemCategoryid;
	}

}
