package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BuyDataBeans;
import beans.ItemDataBeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * Servlet implementation class UserBuyHistoryData
 */
@WebServlet("/UserBuyHistoryData")
public class UserBuyHistoryData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// URLからGETパラメータとしてbuy_idを受け取る
		String id = request.getParameter("buy_id");
		int i = Integer.parseInt(id);

		BuyDataBeans use = null;
		try {
			use = BuyDAO.getBuyDataBeansByBuyId(i);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		//リクエストスコープに結果をセット
		request.setAttribute("use", use);
		ArrayList<ItemDataBeans> itemDetail = null;
		try {
			itemDetail = BuyDetailDAO.getItemDataBeansListByBuyId(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("itemDetail", itemDetail);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userbuyhistorydata.jsp");
		dispatcher.forward(request, response);
	}
}
