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
import beans.DeliveryMethodDataBeans;
import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.BuyDAO;
import dao.DeliveryMethodDAO;

/**
 * Servlet implementation class BuyConfirm
 */
@WebServlet("/BuyConfirm")
public class BuyConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		DeliveryMethodDAO DMD = new DeliveryMethodDAO();

		try {
			//選択された配送方法IDを取得
			int inputDeliveryMethodId = Integer.parseInt(request.getParameter("delivery_method_id"));
			//選択されたIDをもとに配送方法Beansを取得
			DeliveryMethodDataBeans userSelectDMB = DMD.getDeliveryMethodDataBeansByID(inputDeliveryMethodId);
			//買い物かご
			ArrayList<ItemDataBeans> cartIDBList = (ArrayList<ItemDataBeans>) session.getAttribute("cart");
			//合計金額
			int totalPrice = BuyDAO.getTotalItemPrice(cartIDBList);

			// 配送料金計算を合計金額に追加
			totalPrice += userSelectDMB.getPrice();

			UserDataBeans ub = (UserDataBeans) session.getAttribute("userInfo");

			BuyDataBeans bdb = new BuyDataBeans();
			bdb.setId(ub.getId());
			bdb.setTotalPrice(totalPrice);
			bdb.setDeliveryMethodId(userSelectDMB.getId());

			// bdbインスタンスにDMNameとDMPriceをセット
			//  のちにjspでの表示に使用する
			bdb.setDeliveryMethodName(userSelectDMB.getName());
			bdb.setDeliveryMethodPrice(userSelectDMB.getPrice());

			//購入確定で利用
			session.setAttribute("bdb", bdb);
			request.getRequestDispatcher("/WEB-INF/jsp/buyconfirm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
		}

	}

}
