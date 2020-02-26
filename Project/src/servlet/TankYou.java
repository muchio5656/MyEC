package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyDataBeans;
import beans.BuyDataDetailBeans;
import beans.ItemDataBeans;
import dao.BuyDAO;
import dao.BuyDetailDAO;

/**
 * Servlet implementation class TankYou
 */
@WebServlet("/ThankYou")
public class TankYou extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	// TODO Auto-generated constructor stub

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/thankyou.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		BuyDAO buyDao = new BuyDAO();

		try {
			//セッションからカート情報を取得
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

			BuyDataBeans bdb = (BuyDataBeans) session.getAttribute("bdb");

			//購入情報登録

			int buyId = buyDao.insertBuy(bdb);

			// 購入詳細情報を購入情報IDに紐づけして登録
			for (ItemDataBeans cartInItem : cart) {
				BuyDataDetailBeans bddb = new BuyDataDetailBeans();
				bddb.setBuyId(buyId);
				bddb.setItemId(cartInItem.getId());
				BuyDetailDAO.insertBuyDetail(bddb);

			}
			//						/* ====購入完了ページ表示用==== */
			//						BuyDataBeans resultBDB = BuyDAO.getBuyDataBeansByBuyId(buyId);
			//						request.setAttribute("resultBDB", resultBDB);
			//
			//						// 購入アイテム情報
			//						ArrayList<ItemDataBeans> buyIDBList = BuyDetailDAO.getItemDataBeansListByBuyId(buyId);
			//						request.setAttribute("buyIDBList", buyIDBList);
			//
			//
			// 購入完了ページ
			request.getRequestDispatcher("/WEB-INF/jsp/thankyou.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}

	}

}
