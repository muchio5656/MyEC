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
import dao.ItemDAO;

/**
 * Servlet implementation class ItemAdd
 */
@WebServlet("/ItemAdd")
public class ItemAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");
		// 確認用：idをコンソールに出力
		System.out.println(id);

		//idの商品の情報を取得
		ItemDAO itemDao = new ItemDAO();
		ItemDataBeans item = itemDao.itemDetail(id);
		//追加した商品を表示するためリクエストパラメーターにセット
		request.setAttribute("item", item);

		//カートを取得
		ArrayList<ItemDataBeans> cart = (ArrayList<ItemDataBeans>) session.getAttribute("cart");

		//セッションにカートがない場合カートを作成
		if (cart == null) {
			cart = new ArrayList<ItemDataBeans>();
		}

		//カートに商品を追加。
		cart.add(item);

		//カート情報更新
		session.setAttribute("cart", cart);
		//		request.setAttribute("cartActionMessage", "商品を追加しました");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/car.jsp");
		dispatcher.forward(request, response);

	}

}
