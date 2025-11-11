package Process;

import Database.Connect;
import java.sql.*;
import java.util.*;

public class Sinhvien {

    Connect cn = new Connect();

    public List<String[]> getAll() throws SQLException {
        List<String[]> list = new ArrayList<>();
        Connection conn = cn.connectSQL();
        ResultSet rs = conn.prepareStatement("SELECT * FROM SinhVien").executeQuery();
        while (rs.next()) {
            list.add(new String[]{
                rs.getString("MaSV"),
                rs.getString("HoTen"),
                rs.getString("GioiTinh"),
                rs.getString("NgaySinh"),
                rs.getString("MaLop"),
                rs.getString("DiemTB")
            });
        }
        conn.close();
        return list;
    }

    public void insert(String ma, String ten, String gt, String ns, String ml, float dtb) throws SQLException {
        Connection conn = cn.connectSQL();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO SinhVien VALUES(?,?,?,?,?,?)");
        ps.setString(1, ma);
        ps.setString(2, ten);
        ps.setString(3, gt);
        ps.setString(4, ns);
        ps.setString(5, ml);
        ps.setFloat(6, dtb);
        ps.executeUpdate();
        conn.close();
    }

    public void update(String ma, String ten, String gt, String ns, String ml, float dtb) throws SQLException {
        Connection conn = cn.connectSQL();
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE SinhVien SET HoTen=?, GioiTinh=?, NgaySinh=?, MaLop=?, DiemTB=? WHERE MaSV=?");
        ps.setString(1, ten);
        ps.setString(2, gt);
        ps.setString(3, ns);
        ps.setString(4, ml);
        ps.setFloat(5, dtb);
        ps.setString(6, ma);
        ps.executeUpdate();
        conn.close();
    }

    public void delete(String ma) throws SQLException {
        Connection conn = cn.connectSQL();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM SinhVien WHERE MaSV=?");
        ps.setString(1, ma);
        ps.executeUpdate();
        conn.close();
    }

    public List<String[]> search(String key) throws SQLException {
        List<String[]> list = new ArrayList<>();
        Connection conn = cn.connectSQL();

        String sql = """
        SELECT * FROM SinhVien 
        WHERE MaSV LIKE ? 
           OR HoTen LIKE ? 
           OR GioiTinh LIKE ?
           OR NgaySinh LIKE ?
           OR MaLop LIKE ?
           OR DiemTB LIKE ?
    """;

        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 1; i <= 6; i++) {
            ps.setString(i, "%" + key + "%");
        }

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new String[]{
                rs.getString("MaSV"),
                rs.getString("HoTen"),
                rs.getString("GioiTinh"),
                rs.getString("NgaySinh"),
                rs.getString("MaLop"),
                rs.getString("DiemTB")
            });
        }
        conn.close();
        return list;
    }
}
