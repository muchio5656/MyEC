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
 * Servlet implementation class ItemDelete
 */
@WebServlet("/ItemDelete")
public class ItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");
		// 確認用：idをコンソールに出力
		System.out.println(id);

		// idを引数にして、idに紐づくユーザ情報を出力する
		ItemDAO itemDao = new ItemDAO();
		ItemDataBeans item = itemDao.itemDetail(id);

		request.setAttribute("item", item);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemdelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// URLからGETパラメータとしてIDを受け取る
				String id = request.getParameter("id");
				// 確認用：idをコンソールに出力
				System.out.println(id);

				ItemDAO ItemDao = new ItemDAO();
				ItemDao.itemDelete(id);

				//ユーザ情報を削除しユーザ一覧へリダイレクト
				response.sendRedirect("ItemList");

	}

}
