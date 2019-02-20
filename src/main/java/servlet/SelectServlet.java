package servlet;

import Service.Impl.MembersServiceImpl;
import Service.MembersService;
import entity.Members;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by LENOVO on 2019-01-19.
 */
@WebServlet(name = "SelectServlet",urlPatterns = "/select")
public class SelectServlet extends HttpServlet {
    MembersService membersService=new MembersServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        if (type==null){
            sel(request, response);
        }else {
            switch (type) {
                case "sel":
                    sel(request, response);
                    break;
            }
        }
    }
    protected void sel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Members> list=membersService.select();
        request.getSession().setAttribute("list",list);
        response.sendRedirect("sel.jsp");
        response.setContentType("text/html;charset=UTF-8");
//         PrintWriter o= response.getWriter();
//         String x= JSON.toJSONString(list);
//         o.print(x);
//         o.flush();
//         o.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
