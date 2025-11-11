package Process;
import Database.Connect;
import java.sql.*;

public class LichSu {
    Connect cn = new Connect();

    public void ghiLichSu(String username, String role) throws SQLException {
        Connection conn = cn.connectSQL();
        PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO LichSuDangNhap (Username, Role, ThoiGian) VALUES (?, ?, NOW())");
        ps.setString(1, username);
        ps.setString(2, role);
        ps.executeUpdate();
        conn.close();
    }
}
