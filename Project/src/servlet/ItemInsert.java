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

import dao.ItemDAO;

/**
 * Servlet implementation class ItemInsert
 */
@WebServlet("/ItemInsert")
@MultipartConfig(location = "/Users/Toshiki/Documents/Git/MyEC/Project/WebContent/assets/img", maxFileSize = 1048576)
public class ItemInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemInsert.jsp");
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
		String itemCategoryId = request.getParameter("itemCategoryId");

		ItemDAO item = new ItemDAO();

		String fName = item.getFileName(fileName);
		fileName.write(fName);

		//値が間違ってる場合エラーメッセージをセットしてinsertページへフォワード
		if (name.equals("") || price.equals("") || fileName.equals("") || detail.equals("")) {
			request.setAttribute("errMsg", "登録失敗　未入力の値があります");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemInsert.jsp");
			dispatcher.forward(request, response);
			return;
		}

		item.itemInsert(name, price, fName, detail, itemCategoryId);
		//
		//		ItemDataBeans Item = new ItemDataBeans(name, price2, fileName, detail,itemCategoryId2);
		//
		//		request.setAttribute("item", Item);

		response.sendRedirect("Masterlist");

	}

}
