package listener;

import com.mysql.jdbc.Connection;
import dao.DbConnect;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DbConnectListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            Connection connection = DbConnect.connect();
            sce.getServletContext().setAttribute("connect", connection);
        
        } catch (Exception ex) {
            // code 500
            System.out.println("EX");
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
