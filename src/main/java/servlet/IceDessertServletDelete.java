package servlet;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ice.IceOrder;  //老師建的包 不要抓錯了

//冰品店
@WebServlet("/iceD")
public class IceDessertServletDelete extends HttpServlet{
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        // 取得要刪除的 ID（來自 form 的 hidden input）
        String idToDelete = req.getParameter("odid");
        System.out.println("收到刪除請求，ID：" + idToDelete);

        // 從前一個 Servlet 的 static 方法取得 List
        List<IceOrder> iceOrders = IceDessertServlet.getIceOrders();
        //System.out.println("檢查陣列" + iceOrders);
        if (iceOrders != null && idToDelete != null && !idToDelete.isEmpty()) {
            int beforeSize = iceOrders.size();

            // 執行刪除
            iceOrders.removeIf(e -> e.getId() == Integer.parseInt(idToDelete));

            int afterSize = iceOrders.size();

            System.out.println("刪除前數量：" + beforeSize + "，刪除後數量：" + afterSize);
        } else {
            System.out.println("iceOrders 為 null 或 idToDelete 無效");
        }

        // 設定回 request，準備轉發 JSP 顯示
        req.setAttribute("iceOrders", iceOrders);

        // forward 回結果頁
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/ice_dessert_result.jsp");
        rd.forward(req, resp);
    }
	

}
