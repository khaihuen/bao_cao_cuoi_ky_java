package Process;

import Database.Connect;
import java.sql.*;
import java.util.*;

public class Lop {

    Connect cn = new Connect();

    // Lấy toàn bộ danh sách lớp
    public List<String[]> getAll() throws SQLException {
        List<String[]> list = new ArrayList<>();
        Connection conn = cn.connectSQL();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Lop");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new String[]{
                rs.getString("MaLop"),
                rs.getString("TenLop"),
                rs.getString("Khoa")
            });
        }
        conn.close();
        return list;
    }

    // Tìm kiếm lớp theo từ khóa (cho tất cả cột)
    public List<String[]> search(String key) throws SQLException {
        List<String[]> list = new ArrayList<>();
        Connection conn = cn.connectSQL();
        String sql = "SELECT * FROM Lop WHERE MaLop LIKE ? OR TenLop LIKE ? OR Khoa LIKE ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 1; i <= 3; i++) {
            ps.setString(i, "%" + key + "%");
        }
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new String[]{
                rs.getString("MaLop"),
                rs.getString("TenLop"),
                rs.getString("Khoa")
            });
        }
        conn.close();
        return list;
    }

    // Thêm lớp mới
    public void insert(String ma, String ten, String khoa) throws SQLException {
        Connection conn = cn.connectSQL();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO Lop VALUES(?, ?, ?)");
        ps.setString(1, ma);
        ps.setString(2, ten);
        ps.setString(3, khoa);
        ps.executeUpdate();
        conn.close();
    }

    // Sửa thông tin lớp
    public void update(String ma, String ten, String khoa) throws SQLException {
        Connection conn = cn.connectSQL();
        PreparedStatement ps = conn.prepareStatement("UPDATE Lop SET TenLop=?, Khoa=? WHERE MaLop=?");
        ps.setString(1, ten);
        ps.setString(2, khoa);
        ps.setString(3, ma);
        ps.executeUpdate();
        conn.close();
    }

    // Xóa lớp
    public void delete(String ma) throws SQLException {
        Connection conn = cn.connectSQL();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM Lop WHERE MaLop=?");
        ps.setString(1, ma);
        ps.executeUpdate();
        conn.close();
    }
}
