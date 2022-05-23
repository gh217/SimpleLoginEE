package dao;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.LoginModel;

public class LoginDao {


    /*
        0 username error
        1 ok
        2 username ok passeord error
    */
    public static int valid(LoginModel dao, Connection connection) throws SQLException {
        PreparedStatement state;
        ResultSet result;

        String query = "select * from login where username=?";
        state = connection.prepareStatement(query);
        state.setString(1, dao.getName());

        result = state.executeQuery();

        return !result.next()?0:dao.getPassword().equals(result.getString("password"))?1:2;
        
    }
}
