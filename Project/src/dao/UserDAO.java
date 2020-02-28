package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
			pStmt.setString(1, mailAddress);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			int loginId = rs.getInt("id");
			String loginMailAddress = rs.getString("mail_address");
			String loginName = rs.getString("name");

			return new UserDataBeans(loginId, loginMailAddress, loginName);

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

	public boolean idCheck(String mailAddress) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE mail_address = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mailAddress);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return false;
			}

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
	}

	public void userInsert(String mailAddress, String password, String name, String birthDate, String address) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();
			String sql = "insert into user" +
					"(name,mail_address,address,password,birth_date,create_date)" +
					"values(?,?,?,?,?,NOW())";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, mailAddress);
			pStmt.setString(3, address);
			pStmt.setString(4, password);
			pStmt.setString(5, birthDate);

			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public UserDataBeans masterKey(String mailAddress, String password) {

		Connection conn = null;

		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			// 確認済みのSQL
			String sql = "SELECT * FROM user WHERE mail_address = ? and password = ? and id = 1";
			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mailAddress);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			String masterKey = rs.getString("mail_address");
			String nameDate = rs.getString("name");
			return new UserDataBeans(masterKey, nameDate);

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

	public List<UserDataBeans> findAllUser() {
		Connection conn = null;
		List<UserDataBeans> userList = new ArrayList<UserDataBeans>();
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "select * from user WHERE NOT id = '1' ";

			//SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String password = rs.getString("password");
				Date birthDate = rs.getDate("birth_date");
				String createDate = rs.getString("create_date");
				String mailAddress = rs.getString("mail_address");
				UserDataBeans user = new UserDataBeans(id, name, address, password, birthDate, createDate, mailAddress);

				userList.add(user);

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
		return userList;
	}

	public UserDataBeans userDetail(String id) {

		Connection conn = null;

		try {
			//DBに接続
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}
			int id2 = rs.getInt("id");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String password = rs.getString("password");
			Date birthDate = rs.getDate("birth_date");
			String createDate = rs.getString("create_date");
			String mailAddress = rs.getString("mail_address");
			return new UserDataBeans(id2, name, address, password, birthDate, createDate, mailAddress);

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

	public void userDelete(String id) {

		Connection conn = null;
		try {
			//データベースに接続
			conn = DBManager.getConnection();
			//DELETE文を準備 password,name,birth_dateを更新
			String sql = "DELETE FROM user WHERE id = ?;";
			//DELETEを実行し、結果を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);

			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public int getUserId(String mailAddress, String password) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();

			st = con.prepareStatement("SELECT * FROM user WHERE mail_address = ?");
			st.setString(1, mailAddress);

			ResultSet rs = st.executeQuery();

			int userId = 0;

			userId = rs.getInt("id");

			return userId;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	public void userUpdate(String id, String mailAddress, String name, String address) {

		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE user SET mail_address = ?,name = ?,address = ? WHERE id = ?;";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mailAddress);
			pStmt.setString(2, name);
			pStmt.setString(3, address);
			pStmt.setString(4, id);

			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}
	}

	public boolean uptadeIdCheck(String mailAddress,String id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "SELECT * FROM user WHERE mail_address = ? AND NOT id = ?;";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mailAddress);
			pStmt.setString(2, id);

			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return false;
			}

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return true;
				}
			}
		}
	}
}

//	public boolean masterLogin(String mailAddress, String password) {
//		Connection conn = null;
//		try {
//			conn = DBManager.getConnection();
//
//			String sql = "SELECT * FROM user WHERE mail_address = ? AND WHERE password = ?";
//
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//			pStmt.setString(1, mailAddress);
//			pStmt.setString(2, password);
//			ResultSet rs = pStmt.executeQuery();
//
//			boolean id = rs.getString("id") != null;
//			//trueが成功、falseがエラー
//			if (id = "1" != null) {
//				return true;
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return false;
//		} finally {
//			// データベース切断
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//					return false;
//				}
//			}
//		}
//
//		return false;
//	}
//}
