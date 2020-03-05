package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemUpdate
 */
@WebServlet("/ItemUpdate")
@MultipartConfig(location = "/Users/Toshiki/Documents/Git/MyEC/Project/WebContent/assets/img", maxFileSize = 1048576)
public class ItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");
		// 確認用：idをコンソールに出力
		System.out.println(id);

		// idを引数にして、idに紐づくアイテム情報を出力する
		ItemDAO itemDao = new ItemDAO();
		ItemDataBeans item = itemDao.itemDetail(id);

		request.setAttribute("item", item);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemupdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの入力項目を取得
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		Part fileName = request.getPart("fileName");
		String detail = request.getParameter("detail");
		String id = request.getParameter("id");
		String categoryId = request.getParameter("categoryId");


		ItemDAO item = new ItemDAO();



		//値が間違ってる場合エラーメッセージをセットしてupdateページへフォワード
		if (name.equals("") || price.equals("") || fileName == null || detail.equals("")) {
			request.setAttribute("errMsg", "更新失敗　未入力の項目があります");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemupdate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		String fName = item.getFileName(fileName);
		fileName.write(fName);

		item.itemUpdate(name, price, fName, detail,categoryId, id);

		response.sendRedirect("Masterlist");

	}

}
