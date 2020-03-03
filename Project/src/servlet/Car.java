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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session =request.getSession();

			ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>)session.getAttribute("cart");

			if(cart == null) {
				cart = new ArrayList<ItemDataBeans>();
				session.setAttribute("cart", cart);

			}

			if(cart.size() == 0) {
				String cartActionMessage = "※カートに商品がありません※";
				request.setAttribute("cartActionMessage", cartActionMessage);
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/car.jsp");
			dispatcher.forward(request, response);


		}





	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

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

			if(cart.size() == 0) {
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
