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

/**
 * Servlet implementation class PlayServlet
 */
@WebServlet("/Planisp/PlayServlet")
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IChannelService service = new ChannelServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Channel channel =service.getChannel(id);
		List<ScheduleRecord> srs = service.getScheduleRecords(id);
		request.setAttribute("name",channel.getC_name());
		request.setAttribute("src",channel.getC_url());
		request.setAttribute("events",srs);
		request.getRequestDispatcher("/Planisp/viedo.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
