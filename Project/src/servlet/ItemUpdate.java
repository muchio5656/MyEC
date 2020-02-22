package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemUpdate
 */
@WebServlet("/ItemUpdate")
public class ItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");
		// 確認用：idをコンソールに出力
		System.out.println(id);

		// idを引数にして、idに紐づくユーザ情報を出力する
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
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String fileName = request.getParameter("fileName");
		String detail = request.getParameter("detail");
		String itemCategoryId = request.getParameter("itemCategoryId");




		//値が間違ってる場合エラーメッセージをセットしてupdateページへフォワード
				if (name.equals("") || price.equals("") || fileName.equals("") || detail.equals("")) {
					request.setAttribute("errMsg", "更新失敗　未入力の項目があります");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemupdate.jsp");
					dispatcher.forward(request, response);
					return;
				}


		//コンストラクタに合わせて型の変換
		int id2 = Integer.parseInt(id);
		int price2 = Integer.parseInt(price);

		String dummy = "";

		ItemDataBeans Item = new ItemDataBeans(id2, name, price2, detail, fileName,itemCategoryId,dummy);

		request.setAttribute("item", Item);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemupdateconfirm.jsp");
		dispatcher.forward(request, response);


	}

}
