package Database;
import java.sql.*;

public class Connect {
    private final String url = "jdbc:mysql://localhost:3306/QLSinhVien11";
    private final String user = "root";
    private final String password = "WJ28@krhps"; // thay bằng mật khẩu MySQL của bạn

    public Connection connectSQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Lỗi kết nối: " + e.getMessage());
            return null;
        }
    }
}
