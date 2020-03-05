package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemDAO;

/**
 * Servlet implementation class ItemInsertConfirm
 */
@WebServlet("/ItemInsertConfirm")
public class ItemInsertConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//文字化け防止処理
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータの入力項目を取得
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String fileName = request.getParameter("fileName");
		String detail = request.getParameter("detail");
		String itemCategoryId = request.getParameter("itemCategoryId");

		ItemDAO item = new ItemDAO();

		item.itemInsert(name, price, fileName, detail,itemCategoryId);

		response.sendRedirect("Masterlist");
	}

}
