package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.TriviaDataBeans;
import database.DBManager;

public class TriviaDAO {

	public TriviaDataBeans trivia(int i) {

		Connection conn = null;
		String s = String.valueOf(i);
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM trivia WHERE id = ?";

			//SELECTを実行し、idを元にアイテムデータ取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, s);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			int id = rs.getInt("id");
			String name = rs.getString("name");
			String detail = rs.getString("detail");
			int itemCategoryid = rs.getInt("item_category_id");
			return new TriviaDataBeans(id, name, detail, itemCategoryid);

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
	}

}
