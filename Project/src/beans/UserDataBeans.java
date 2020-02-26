package beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDataBeans implements Serializable {

	private String name;
	private String address;
	private Date birthDate;
	private String createDate;
	private String password;
	private int id;
	private String mailAddress;

	public UserDataBeans() {

	}

	public UserDataBeans(String loginData, String nameData) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.mailAddress = loginData;
		this.name = nameData;
	}

	public UserDataBeans(String mailAddress2, String name2, String address2, Date birthDate2, String password2) {
		this.mailAddress = mailAddress2;
		this.name = name2;
		this.address = address2;
		this.birthDate = birthDate2;
		this.password = password2;
	}

	public UserDataBeans(String mailAddress2, String name2, String address2, String birthDate2, String password2) {
		this.mailAddress = mailAddress2;
		this.name = name2;
		this.address = address2;
		setBirthDate(birthDate2);
		this.password = password2;
	}

	public UserDataBeans(int id2, String name2, String address2, String password2, java.sql.Date birthDate2,
			String createDate2, String mailAddress2) {
		this.id = id2;
		this.name = name2;
		this.address = address2;
		this.password = password2;
		this.birthDate = birthDate2;
		this.createDate = createDate2;
		this.mailAddress = mailAddress2;
	}

	public UserDataBeans(int loginId, String loginMailAddress, String loginName) {

		this.id = loginId;
		this.mailAddress = loginMailAddress;
		this.name = loginName;

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

	public void setBirthDate(String birthDate) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.birthDate = sdFormat.parse(birthDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getBirthDate(String birthDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(birthDate);

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

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}
