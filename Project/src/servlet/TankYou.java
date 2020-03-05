package servlet;

import java.io.IOException;
import java.util.ArrayList;

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
			session.removeAttribute("cart");
			request.getRequestDispatcher("/WEB-INF/jsp/thankyou.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
