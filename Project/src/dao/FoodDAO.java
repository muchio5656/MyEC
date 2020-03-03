package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.FoodDataBeans;
import database.DBManager;

public class FoodDAO {

	public List<FoodDataBeans> bestMuch(int foodNum) {
		Connection conn = null;
		String s = String.valueOf(foodNum);
		List<FoodDataBeans> FBM = new ArrayList<FoodDataBeans>();
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM food_best_much f JOIN" +
					" item i ON f.item_id = i.id JOIN" +
					" food f2 ON f.food_id = f2.id WHERE f2.id = ?";

			//SELECTを実行し、idを元にアイテムデータ取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, s);
			ResultSet rs = pStmt.executeQuery();


			while (rs.next()) {
				int foodId = rs.getInt("food_id");
				String itemName = rs.getString("i.name");
				String foodName = rs.getString("f2.name");
				String detail = rs.getString("f2.detail");
				int price = rs.getInt("price");
				String itemFile = rs.getString("i.file_name");
				String foodFile = rs.getString("f2.file_name");
				String itemDetail = rs.getString("i.detail");
				int itemId = rs.getInt("i.id");
				FoodDataBeans FBMD = new FoodDataBeans(foodId, itemName, foodName, detail, price, itemFile,
						foodFile,itemDetail,itemId);

				FBM.add(FBMD);
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
		return FBM;

	}
}
