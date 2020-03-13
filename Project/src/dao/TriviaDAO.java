package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.TriviaDataBeans;
import database.DBManager;

public class TriviaDAO {

	public TriviaDataBeans trivia() {

		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM trivia ORDER BY RAND() LIMIT 1";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

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
