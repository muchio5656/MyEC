package beans;

import java.io.Serializable;
import java.util.Date;

public class UserDataBeans implements Serializable{

	private String name;
	private String address;
	private Date birthDate;
	private Date createDate;
	private String password;
	private int id;
	private String mailAddress;

	public UserDataBeans() {

	}

	public UserDataBeans(String loginData, String nameData) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.mailAddress=loginData;
		this.name = nameData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMailAddres() {
		return mailAddress;
	}

	public void setMailAddres(String mailAddress) {
		this.mailAddress = mailAddress;
	}



}
