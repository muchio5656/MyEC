package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BuyDataDetailBeans;
import beans.ItemDataBeans;
import database.DBManager;

public class BuyDetailDAO {

	public static void insertBuyDetail(BuyDataDetailBeans bddb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO buy_detail(buy_id,item_id) VALUES(?,?)");
			st.setInt(1, bddb.getBuyId());
			st.setInt(2, bddb.getItemId());
			st.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public static ArrayList<ItemDataBeans> getItemDataBeansListByBuyId(int i)throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement(
					"SELECT item.id,"
					+ " item.name,"
					+ " item.price"
					+ " FROM buy_detail"
					+ " JOIN item"
					+ " ON buy_detail.item_id = item.id"
					+ " WHERE buy_detail.buy_id = ?");
			st.setInt(1, i);

			ResultSet rs = st.executeQuery();
			ArrayList<ItemDataBeans> buyDetailItemList = new ArrayList<ItemDataBeans>();

			while (rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setName(rs.getString("name"));
				idb.setPrice(rs.getInt("price"));


				buyDetailItemList.add(idb);
			}

			return buyDetailItemList;
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
