package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemList
 */
@WebServlet("/ItemList")
public class ItemList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//アイテム一覧を取得
		ItemDAO itemDao = new ItemDAO();
		List<ItemDataBeans> itemData = itemDao.findAllItem();

		// リクエストスコープにユーザ一覧情報をセット
		request.setAttribute("itemData", itemData);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemlist.jsp");
		dispatcher.forward(request, response);
	}

}
