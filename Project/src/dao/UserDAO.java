package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.UserDataBeans;
import database.DBManager;

public class UserDAO {

	public UserDataBeans findByLoginInfo(String mailAddress, String password) {
		Connection conn = null;

		try {
			//データベースへ接続
			conn = DBManager.getConnection();
			//SQL分を用意
			String sql = "SELECT * FROM user WHERE mail_address = ? and password = ?";
			//PreparedStatementをしようしSELECTを実行し
			//結果表を取得し　rs にセット
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,mailAddress);
			pStmt.setString(2,password);
			ResultSet rs = pStmt.executeQuery();

			if(!rs.next()) {
				return null;
			}

			String loginMailAddress = rs.getString("mail_address");
			String loginName = rs.getString("name");
			return new UserDataBeans(loginMailAddress,loginName);


		}catch (SQLException e) {
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
