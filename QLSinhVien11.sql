CREATE DATABASE QLSinhVien11 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE QLSinhVien11;

-- =========================
-- BẢNG LỚP
-- =========================
CREATE TABLE Lop (
    MaLop VARCHAR(10) PRIMARY KEY,
    TenLop VARCHAR(100),
    Khoa VARCHAR(100)
);

-- =========================
-- BẢNG SINH VIÊN
-- =========================
CREATE TABLE SinhVien (
    MaSV VARCHAR(10) PRIMARY KEY,
    HoTen VARCHAR(100),
    GioiTinh VARCHAR(10),
    NgaySinh DATE,
    MaLop VARCHAR(10),
    DiemTB FLOAT,
    FOREIGN KEY (MaLop) REFERENCES Lop(MaLop)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- =========================
-- BẢNG MÔN HỌC
-- =========================
CREATE TABLE MonHoc (
    MaMon VARCHAR(10) PRIMARY KEY,
    TenMon VARCHAR(100),
    SoTinChi INT
);

-- =========================
-- BẢNG BẢNG ĐIỂM
-- =========================
CREATE TABLE BangDiem (
    MaSV VARCHAR(10),
    MaMon VARCHAR(10),
    Diem FLOAT,
    PRIMARY KEY (MaSV, MaMon),
    FOREIGN KEY (MaSV) REFERENCES SinhVien(MaSV)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (MaMon) REFERENCES MonHoc(MaMon)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- =========================
-- BẢNG LỚP - MÔN HỌC (NHIỀU - NHIỀU)
-- =========================
CREATE TABLE Lop_MonHoc (
    MaLop VARCHAR(10),
    MaMon VARCHAR(10),
    NamHoc VARCHAR(20),
    PRIMARY KEY (MaLop, MaMon),
    FOREIGN KEY (MaLop) REFERENCES Lop(MaLop)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY (MaMon) REFERENCES MonHoc(MaMon)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- =========================
-- BẢNG NGƯỜI DÙNG
-- =========================
CREATE TABLE NguoiDung (
    Username VARCHAR(50) PRIMARY KEY,
    Password VARCHAR(255),
    Role VARCHAR(20)
);

-- =========================
-- BẢNG LỊCH SỬ ĐĂNG NHẬP
-- =========================
CREATE TABLE LichSuDangNhap (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Username VARCHAR(50),
    Role VARCHAR(20),
    ThoiGian DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (Username) REFERENCES NguoiDung(Username)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- =========================
-- DỮ LIỆU MẪU
-- =========================
INSERT INTO Lop VALUES 
('D15CNTT1','Công nghệ thông tin 1','CNTT'),
('D15CNTT2','Công nghệ thông tin 2','CNTT'),
('D15QTKD1','Quản trị kinh doanh 1','Kinh tế');

INSERT INTO SinhVien VALUES
('SV001','Nguyễn Văn A','Nam','2003-01-15','D15CNTT1',8.2),
('SV002','Trần Thị B','Nữ','2003-04-12','D15CNTT1',7.6),
('SV003','Phạm Văn C','Nam','2003-02-20','D15CNTT2',5.8),
('SV004','Lê Thị D','Nữ','2003-07-25','D15CNTT2',6.4),
('SV005','Hoàng Văn E','Nam','2003-11-11','D15QTKD1',9.0);

INSERT INTO MonHoc VALUES
('MH01','Cơ sở dữ liệu',3),
('MH02','Lập trình Java',4),
('MH03','Kinh tế học',2);

INSERT INTO Lop_MonHoc VALUES
('D15CNTT1','MH01','2023-2024'),
('D15CNTT1','MH02','2023-2024'),
('D15QTKD1','MH03','2023-2024');

INSERT INTO BangDiem VALUES
('SV001','MH01',8.5),
('SV001','MH02',9.0),
('SV002','MH01',7.0),
('SV002','MH02',7.5),
('SV005','MH03',9.3);

-- Mật khẩu = "123" (SHA-256)
INSERT INTO NguoiDung VALUES
('admin','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','admin'),
('gv01','a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3','giaovien');

-- ==========================================================
-- 🔥 TRIGGER TỰ ĐỘNG CẬP NHẬT ĐIỂM TRUNG BÌNH SINH VIÊN
-- ==========================================================

DELIMITER //

-- Khi thêm điểm mới
CREATE TRIGGER trg_bangdiem_insert
AFTER INSERT ON BangDiem
FOR EACH ROW
BEGIN
    UPDATE SinhVien
    SET DiemTB = (
        SELECT ROUND(AVG(Diem), 2)
        FROM BangDiem
        WHERE MaSV = NEW.MaSV
    )
    WHERE MaSV = NEW.MaSV;
END;
//

-- Khi sửa điểm
CREATE TRIGGER trg_bangdiem_update
AFTER UPDATE ON BangDiem
FOR EACH ROW
BEGIN
    UPDATE SinhVien
    SET DiemTB = (
        SELECT ROUND(AVG(Diem), 2)
        FROM BangDiem
        WHERE MaSV = NEW.MaSV
    )
    WHERE MaSV = NEW.MaSV;
END;
//

-- Khi xóa điểm
CREATE TRIGGER trg_bangdiem_delete
AFTER DELETE ON BangDiem
FOR EACH ROW
BEGIN
    UPDATE SinhVien
    SET DiemTB = (
        SELECT ROUND(AVG(Diem), 2)
        FROM BangDiem
        WHERE MaSV = OLD.MaSV
    )
    WHERE MaSV = OLD.MaSV;
END;
//

DELIMITER ;
