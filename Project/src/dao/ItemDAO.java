package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import beans.ItemDataBeans;
import database.DBManager;

public class ItemDAO {

	public List<ItemDataBeans> findAllItem() {
		Connection conn = null;
		List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "SELECT i.id,i.name,i.detail,i.price,i.file_name," +
					"i.item_category_id,i.create_date,c.category " +
					"FROM item i INNER JOIN item_category c " +
					"ON i.item_category_id = c.id";

			//SELECTを実行し、アイテム全データ取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				int price = rs.getInt("price");
				String fileName = rs.getString("file_name");
				String createDate = rs.getString("create_date");
				//				int itemSales = rs.getInt("");
				String itemCategoryName = rs.getString("category");
				ItemDataBeans item = new ItemDataBeans(id, name, price, detail, fileName, createDate, itemCategoryName);

				itemList.add(item);

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
		return itemList;
	}

	public ItemDataBeans itemDetail(String id2) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "SELECT i.id,i.name,i.detail,i.price,i.file_name," +
					"i.item_category_id,i.create_date,c.category " +
					"FROM item i INNER JOIN item_category c " +
					"ON i.item_category_id = c.id WHERE i.id = ?";

			//SELECTを実行し、idを元にアイテムデータ取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id2);
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}


			int id = rs.getInt("id");
			String name = rs.getString("name");
			String detail = rs.getString("detail");
			int price = rs.getInt("price");
			String fileName = rs.getString("file_name");
			String createDate = rs.getString("create_date");
			String itemCategoryName = rs.getString("category");
			return new ItemDataBeans(id, name, price, detail, fileName, createDate, itemCategoryName);

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

	public void itemDelete(String id) {

		Connection conn = null;
		try {
			//データベースに接続
			conn = DBManager.getConnection();
			//DELETE文を準備 password,name,birth_dateを更新
			String sql = "DELETE FROM item WHERE id = ?;";
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

	public void itemUpdate(String name, String price, String fileName, String detail, String categoryId, String id) {

		Connection conn = null;
		try {
			//データベースに接続
			conn = DBManager.getConnection();
			//UPDATE文を準備 password,name,birth_dateを更新
			String sql = "UPDATE item SET name = ?,price = ? ,file_name = ? ,detail = ? ,item_category_id = ? WHERE id = ?;";

			//UPDATEを実行し、結果を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, price);
			pStmt.setString(3, fileName);
			pStmt.setString(4, detail);
			pStmt.setString(5, categoryId);
			pStmt.setString(6, id);

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

	public void itemInsert(String name, String price, String fileName, String detail, String itemCategoryId) {
		Connection conn = null;

		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO item (name,detail,price,file_name," +
					"item_category_id,create_date)" +
					"VALUE(?,?,?,?,?,NOW())";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, detail);
			pStmt.setString(3, price);
			pStmt.setString(4, fileName);
			pStmt.setString(5, itemCategoryId);

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

	{

	}

	public List<ItemDataBeans> findCategory(String id2) {
		Connection conn = null;
		List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "SELECT i.id,i.name,i.detail,i.price,i.file_name," +
					"i.item_category_id,i.create_date,c.category " +
					"FROM item i INNER JOIN item_category c " +
					"ON i.item_category_id = c.id WHERE c.id = ?";

			//SELECTを実行し、アイテム全データ取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id2);
			ResultSet rs = pStmt.executeQuery();

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				int price = rs.getInt("price");
				String fileName = rs.getString("file_name");
				String createDate = rs.getString("create_date");
				//				int itemSales = rs.getInt("");
				String itemCategoryName = rs.getString("category");
				ItemDataBeans item = new ItemDataBeans(id, name, price, detail, fileName, createDate, itemCategoryName);

				itemList.add(item);

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
		return itemList;
	}

	public ItemDataBeans intoCar(String id) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	public static List<ItemDataBeans> wordSearch(String searchWord) {
		// キーワード検索
		Connection conn = null;
		List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql = "SELECT i.id,i.name,i.detail,i.price,i.file_name," +
					"i.item_category_id,i.create_date,c.category " +
					"FROM item i INNER JOIN item_category c " +
					"ON i.item_category_id = c.id WHERE i.name LIKE ? ORDER BY id ASC";

			//SELECTを実行し、アイテム全データ取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, "%" + searchWord + "%");
			ResultSet rs = pStmt.executeQuery();

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				int price = rs.getInt("price");
				String fileName = rs.getString("file_name");
				String createDate = rs.getString("create_date");
				//				int itemSales = rs.getInt("");
				String itemCategoryName = rs.getString("category");
				ItemDataBeans item = new ItemDataBeans(id, name, price, detail, fileName, createDate, itemCategoryName);

				itemList.add(item);

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
		return itemList;
	}

	public String getFileName(Part part) {
		String name = null;
		for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
				break;
			}
		}
		return name;
	}

	public List<ItemDataBeans> ranking() {
		Connection conn = null;
		List<ItemDataBeans> itemRanking = new ArrayList<ItemDataBeans>();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT b.item_id,count(b.item_id) as count," +
					"i.name,i.detail,i.price,i.file_name FROM buy_detail as b " +
					"INNER JOIN item as i ON i.id = b.item_id " +
					"GROUP BY b.item_id ORDER BY count DESC LIMIT 3";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// Userインスタンスに設定し、ArrayListインスタンスに追加

			while (rs.next()) {
				int itemId = rs.getInt("item_id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String detail = rs.getString("detail");
				String fileName = rs.getString("file_name");

				ItemDataBeans item = new ItemDataBeans(itemId, name, price, fileName, detail);

				itemRanking.add(item);
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
		return itemRanking;
	}

	public List<ItemDataBeans> syuki() {
		Connection conn = null;
		List<ItemDataBeans> itemRanking = new ArrayList<ItemDataBeans>();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM item WHERE item_category_id = 6 " +
					"ORDER BY RAND() LIMIT 3";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String detail = rs.getString("detail");
				String fileName = rs.getString("file_name");

				ItemDataBeans item = new ItemDataBeans(id, name, price, fileName, detail);

				itemRanking.add(item);
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
		return itemRanking;
	}

}
