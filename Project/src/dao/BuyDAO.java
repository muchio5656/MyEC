package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.BuyDataBeans;
import beans.ItemDataBeans;
import database.DBManager;

public class BuyDAO {

	public static int getTotalItemPrice(ArrayList<ItemDataBeans> items) {
		int total = 0;
		for (ItemDataBeans item : items) {
			total += item.getPrice();
		}
		return total;
	}

	public int insertBuy(BuyDataBeans bdb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO buy(user_id,total_price,delivery_method_id,create_date) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, bdb.getId());
			st.setInt(2, bdb.getTotalPrice());
			st.setInt(3, bdb.getDeliveryMethodId());
			st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
			System.out.println("inserting buy-datas has been completed");

			return autoIncKey;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public List<BuyDataBeans> buyHistory(String id) {

		Connection conn = null;
		List<BuyDataBeans> userHistory = new ArrayList<BuyDataBeans>();
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "SELECT t.id,t.user_id,t.total_price,t.create_date," +
					"m.name,m.price FROM buy t INNER JOIN " +
					" delivery_method m ON t.delivery_method_id = m.id " +
					" WHERE user_id = ? ORDER BY t.create_date DESC";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id2 = rs.getInt("id");
				int totalPrice = rs.getInt("total_price");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				Date createDate = rs.getTimestamp("create_date");
				BuyDataBeans user = new BuyDataBeans(id2, totalPrice, name, price, createDate);
				userHistory.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userHistory;
	}

	public static BuyDataBeans getBuyDataBeansByBuyId(int i) throws SQLException {Connection con = null;
	PreparedStatement st = null;
	try {
		con = DBManager.getConnection();

		st = con.prepareStatement(
				"SELECT * FROM buy JOIN delivery_method " +
				"ON buy.delivery_method_id = delivery_method.id " +
				"WHERE buy.id = ?");
		st.setInt(1, i);

		ResultSet rs = st.executeQuery();

		BuyDataBeans bdb = new BuyDataBeans();
		if (rs.next()) {
			bdb.setId(rs.getInt("id"));
			bdb.setTotalPrice(rs.getInt("total_price"));
			bdb.setCreateDate(rs.getTimestamp("create_date"));
			bdb.setDeliveryMethodId(rs.getInt("delivery_method_id"));
			bdb.setUserId(rs.getInt("user_id"));
			bdb.setDeliveryMethodPrice(rs.getInt("price"));
			bdb.setDeliveryMethodName(rs.getString("name"));
		}
		return bdb;
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
