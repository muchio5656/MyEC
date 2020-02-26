package beans;

import java.io.Serializable;

public class TriviaDataBeans implements Serializable {

	private int id;
	private String name;
	private String detail;
	private int itemCategoryid;

	public TriviaDataBeans() {

	}

	public TriviaDataBeans(int id2, String name2, String detail2, int itemCategoryid2) {

		this.id=id2;
		this.name=name2;
		this.detail=detail2;
		this.itemCategoryid=itemCategoryid2;
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
