package servlet;

import java.io.IOException;    
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Channel;
import model.ScheduleRecord;
import service.IChannelService;
import service.impl.ChannelServiceImpl;
import utils.SortUtil;

/**
 * PC视频播放页面
 */
@WebServlet("/pc_Live/PcPlayServlet")
public class PcPlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IChannelService service = new ChannelServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//通过id获取频道
		Channel channel =service.getChannel(id);
		//通过id查找到正在播出
		List<ScheduleRecord> srs = service.getScheduleRecords(id);
		request.setAttribute("name",channel.getC_name());
		request.setAttribute("src",channel.getC_url());
		request.setAttribute("events",srs);
		request.getRequestDispatcher("/pc_Live/live2.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
