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

/**
 * Created by LENOVO on 2019-01-19.
 */
@WebServlet(name = "UpdateServlet",urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {
    MembersService membersService=new MembersServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String type=request.getParameter("type");
        if (type!=null && "sel".equals(type)){
         Integer id= Integer.valueOf(request.getParameter("id"));
         Members members=membersService.selectByid(id);
         request.getSession().setAttribute("info",members);
         response.sendRedirect("update.jsp");
        }else if (type!=null && "update".equals(type)){
            update(request,response);
        }
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Members members=new Members();
      members.setMid(Integer.valueOf(request.getParameter("bianhao")));
      members.setMname(request.getParameter("xingming"));
      members.setMgender(request.getParameter("xingbie"));
      members.setMemail(request.getParameter("youxiang"));
      members.setMage(Integer.valueOf(request.getParameter("nianling")));
      members.setMaddress(request.getParameter("dizhi"));
      int x=membersService.Update(members);
      if (x==1){
          response.setContentType("text/html;charset=UTF-8");
          request.getSession().setAttribute("m","更新成功");
          request.getRequestDispatcher("select?type=sel").forward(request,response);
      }else{
           response.sendRedirect("update.jsp");
      }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
