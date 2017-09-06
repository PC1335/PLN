package servlet;

import java.io.IOException;  
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Channel;
import service.IChannelService;
import service.impl.ChannelServiceImpl;
import utils.SortUtil;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Planisp/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IChannelService cs = new ChannelServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//三行编码
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Channel> ysl = cs.getCCTV();
		List<Channel> gql = cs.getHD();
		List<Channel> wsl = cs.getTV();
		//传输
		request.setAttribute("ys",SortUtil.sortList(ysl));
		request.setAttribute("ws",wsl);
//		request.setAttribute("ts",tsl);
		request.setAttribute("gq",gql);
		//服务器跳转
		request.getRequestDispatcher("/Planisp/demand.jsp").forward(request, response);
		//基本的reques服务器跳转传值
//		String s1 = request.getHeader("user-agent");
//		if(s1.contains("Android")||s1.contains("iPhone")) {
//			request.getRequestDispatcher("/Planisp/demand.jsp").forward(request, response);
//		} else if(s1.contains("Windows")) {
//			//跳转到PC主页面
//			request.getRequestDispatcher("/pc_Live/index.jsp").forward(request, response);
//		} 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
