package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.DeliveryMethodDataBeans;
import database.DBManager;

public class DeliveryMethodDAO {

	//DBに登録されてる配送方法を取得
	public static ArrayList<DeliveryMethodDataBeans> getAllDeliveryMethodDataBeans() throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM delivery_method");

			ResultSet rs = st.executeQuery();

			ArrayList<DeliveryMethodDataBeans> deliveryMethodDataBeansList = new ArrayList<DeliveryMethodDataBeans>();
			while (rs.next()) {
				DeliveryMethodDataBeans dmdb = new DeliveryMethodDataBeans();
				dmdb.setId(rs.getInt("id"));
				dmdb.setName(rs.getString("name"));
				dmdb.setPrice(rs.getInt("price"));
				deliveryMethodDataBeansList.add(dmdb);
			}
			return deliveryMethodDataBeansList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public  DeliveryMethodDataBeans getDeliveryMethodDataBeansByID(int DeliveryMethodId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT * FROM delivery_method WHERE id = ?");
			st.setInt(1, DeliveryMethodId);

			ResultSet rs = st.executeQuery();
//   dmdbに配送方法をセット
			DeliveryMethodDataBeans dmdb = new DeliveryMethodDataBeans();
			if (rs.next()) {
				dmdb.setId(rs.getInt("id"));
				dmdb.setName(rs.getString("name"));
				dmdb.setPrice(rs.getInt("price"));
			}

//			System.out.println("searching DeliveryMethodDataBeans by DeliveryMethodID has been completed");

			return dmdb;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
