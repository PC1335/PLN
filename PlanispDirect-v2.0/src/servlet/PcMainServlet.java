package servlet;

import java.io.IOException;  
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * PC主页面Servlet
 */
@WebServlet("/pc_Live/PcMainServlet")
public class PcMainServlet extends HttpServlet {
	//Map<String, String> channelSrcs = new HashMap<String, String>();

	private static final long serialVersionUID = 1L;
	IChannelService cs = new ChannelServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<Channel> ysl = cs.getCCTV();
		List<Channel> gql = cs.getHD();
		List<Channel> wsl = cs.getTV();
		request.setAttribute("ys",SortUtil.sortList(ysl));
		request.setAttribute("ws",wsl);
//		request.setAttribute("ts",tsl);
		request.setAttribute("gq",gql);
		
		//channelSrcs.put("CCTV1","rtmp://play-test.galaxyclouds.cn/live/");
		//request.setAttribute("channelSrcs",channelSrcs); 
		
		//跳转到PC主页面
		request.getRequestDispatcher("/pc_Live/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
