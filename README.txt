## 🧱 I. Cấu trúc thư mục
QLSinhVien11/
├── src/
│   ├── Database/
│   │   └── Connect.java
│   ├── Process/
│   │   ├── Sinhvien.java
│   │   ├── Lop.java
│   │   ├── Encrypt.java
│   │   ├── LichSu.java
│   └── Interface/
│       ├── frmLogin.java
│       ├── frmMain.java
│       ├── frmSinhvien.java
│       ├── frmBangDiem.java
│       ├── frmMonhoc.java
│       └── frmLop.java
│       └── Main.java
├── lib/
│   ├── mysql-connector-j-8.x.jar
│   └── jxl.jar
└── qlsinhvien11.sql
└── README.txt

## ⚙️ II. Cách chạy dự án

### 🔹 Bước 1: Cài đặt MySQL
- Cài MySQL Server  
- Mở MySQL Workbench 
- Tạo database:
  CREATE DATABASE QLSinhVien11;
- Import file qlsinhvien10.sql vào database này.

---

### 🔹 Bước 2: Cấu hình NetBeans
- Mở NetBeans IDE  
- File → Open Project → QLSinhVien11  
- Mở file Connect.java trong thư mục src/Database/  
- Kiểm tra:
  private final String url = "jdbc:mysql://localhost:3306/QLSinhVien11";
  private final String user = "root";
  private final String password = "WJ28@krhps";

# Nếu mật khẩu MySQL khác → sửa lại cho khớp.

---

### 🔹 Bước 3: Thêm thư viện
1. Chuột phải vào project → Properties  
2. Chọn Libraries → Add JAR/Folder  
3. Thêm:
   - lib/mysql-connector-j-8.x.jar
   - lib/jxl.jar  
4. Nhấn OK để lưu.

---

### 🔹 Bước 4: Chạy dự án
- Mở Main.java
- Nhấn Shift + F11 → Clean & Build Project  
- Nhấn F6 → Run Project  
- Giao diện đăng nhập sẽ hiển thị.

---

### 🔹 Bước 5: Đăng nhập
|  Username |  Password |        Role         |
|-----------|-----------|---------------------|
|   admin   |    123    |     Toàn quyền      |
|   gv01    |    123    | Giáo viên (chỉ xem) |

---

### 🔹 Bước 6: Sử dụng chương trình
- Admin: có thể thêm, sửa, xóa sinh viên hoặc lớp  
- Giáo viên: chỉ xem dữ liệu  
- Các chức năng khác:
  - Tìm kiếm sinh viên theo mọi cột  
  - Xuất danh sách ra Excel  
  - Ghi lịch sử đăng nhập tự động  

---

