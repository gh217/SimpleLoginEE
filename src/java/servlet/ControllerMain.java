package servlet;

import com.mysql.jdbc.Connection;
import dao.LoginDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoginModel;

public class ControllerMain extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // db connect
        ServletContext ser = request.getServletContext();//connect  connect
        Connection connection = (Connection) ser.getAttribute("connect");

        String name =request.getParameter("username");
        String Password=request.getParameter("password");
        
        
        LoginModel loginModel=new LoginModel();
        loginModel.setName(name);
        loginModel.setPassword(Password);
        
        
        
        try {
            /*
                0 username error
                1 ok
                2 username ok passeord error
            */
            int check=LoginDao.valid(loginModel, connection);
            
            if(check==1){
                response.sendRedirect("loginOk.html");
            }else if(check==2){
                response.sendRedirect("passwordError.html");
            }else{
                 response.sendRedirect("userNameNotFound.html");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControllerMain.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("EX");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
