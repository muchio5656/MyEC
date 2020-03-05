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

import beans.ItemDataBeans;

/**
 * Servlet implementation class Car
 */
@WebServlet("/Car")
public class Car extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

		//カートがnullだった場合カートを作成する
		if (cart == null) {
			cart = new ArrayList<ItemDataBeans>();
			session.setAttribute("cart", cart);
		}
		if (cart.size() == 0) {
			String cartActionMessage = "※カートに商品がありません※";
			request.setAttribute("cartActionMessage", cartActionMessage);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/car.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//商品削除機能
		try {
			String[] deleteItemIdList = request.getParameterValues("delete_item_id_list");
			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
			if (deleteItemIdList != null) {
				for (String deleteItemId : deleteItemIdList) {
					for (ItemDataBeans cartInItem : cart) {
						if (cartInItem.getId() == Integer.parseInt(deleteItemId)) {
							cart.remove(cartInItem);
							break;
						}
					}
				}
			}
			if (cart.size() == 0) {
				String cartActionMessage = "※カートに商品がありません※";
				request.setAttribute("cartActionMessage", cartActionMessage);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/car.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}