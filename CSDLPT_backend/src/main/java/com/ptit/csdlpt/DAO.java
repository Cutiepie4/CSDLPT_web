package com.ptit.csdlpt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DAO {
	private String url = "jdbc:sqlserver://DESKTOP-93VCUQT\\SQLSERVER;databaseName=CSDLPT;encrypt=true;trustServerCertificate=true";
	private String username = "sa";
	private String password = "123";

	private static final String SELECT_ALL_KH = "SELECT * FROM KhachHang";
	private static final String SELECT_ALL_NV = "SELECT * FROM NhanVien";
	private static final String SELECT_ALL_MB = "SELECT * FROM MayBay";
	private static final String SELECT_ALL_SB = "SELECT * FROM SanBay";
	private static final String SELECT_ALL_CN = "SELECT * FROM ChiNhanh";
	private static final String INSERT_NV = "INSERT INTO NhanVien(maNV, tenNV, maCN, ngaySinh, sdt, chucVu) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String INSERT_CB = "INSERT INTO ChuyenBay(maCB, maMB, sanBayXuatPhat, sanBayDich, thoiGianBatDau, thoiGianKetThuc, slChoNgoiConLai) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String THONGKE = "SELECT ChiNhanh.TenCN, COUNT(Ve.MaV) AS Tong_so_ve, SUM(Ve.GiaVe) AS Tong_tien_ve\r\n"
			+ "FROM ChiNhanh\r\n"
			+ "	INNER JOIN NhanVien\r\n"
			+ "		ON ChiNhanh.MaCN = NhanVien.MaCN\r\n"
			+ "	INNER JOIN Ve\r\n"
			+ "		ON Ve.MaNV = NhanVien.MaNV\r\n"
			+ "GROUP BY ChiNhanh.MaCN, ChiNhanh.TenCN\r\n"
			+ "ORDER BY Tong_tien_ve DESC";
//	private static final String SELECT_BY_ID = "SELECT * FROM book WHERE bookcode = ?";
//	private static final String INSERT = "INSERT INTO book VALUES(?, ?, ?, ?, ?)";
//	private static final String UPDATE = "UPDATE book SET title = ?, author = ?, category = ?, approved = ? WHERE bookcode = ?";
//	private static final String DELETE = "DELETE FROM book WHERE bookcode=?";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public List<KhachHang> getAllKhachHang() {
		List<KhachHang> listKH = new ArrayList<>();

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_KH);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listKH.add(new KhachHang(rs.getString("maKH"), rs.getString("tenKH"), rs.getString("diaChi"), rs.getString("sdt"), rs.getString("soHoChieu"), rs.getDate("ngaySinh")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listKH;
	}
	
	public List<ChiNhanh> getChiNhanh() {
		List<ChiNhanh> list = new ArrayList<>();

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CN);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new ChiNhanh(rs.getString(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<MayBay> getAllMayBay() {
		List<MayBay> listMB = new ArrayList<>();

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MB);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listMB.add(new MayBay(rs.getString("maMB"), rs.getString("tenMB"), rs.getInt("soGhe"), rs.getString("hang")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listMB;
	}
	
	public List<SanBay> getAllSanBay() {
		List<SanBay> listSB = new ArrayList<>();

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SB);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listSB.add(new SanBay(rs.getString("maSB"), rs.getString("tenSB"), rs.getString("diaChi")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listSB;
	}
	
	public List<NhanVien> getAllNhanVien() {
		List<NhanVien> listNV = new ArrayList<>();

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NV);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				listNV.add(new NhanVien(rs.getString("maNV"), rs.getString("tenNV"), rs.getString("maCN"), rs.getString("sdt"), rs.getString("chucVu"), rs.getDate("ngaySinh")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listNV;
	}
	
	public void addNV(NhanVien nhanVien) {
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NV);
			preparedStatement.setNString(1, nhanVien.getMaNV());
			preparedStatement.setNString(2, nhanVien.getTenNV());
			preparedStatement.setNString(3, nhanVien.getMaCN());
			preparedStatement.setDate(4, nhanVien.getNgaySinh());
			preparedStatement.setNString(5, nhanVien.getSdt());
			preparedStatement.setNString(6, nhanVien.getChucVu());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addCB(ChuyenBay chuyenBay) {
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CB);
			preparedStatement.setNString(1, chuyenBay.getMaCB());
			preparedStatement.setNString(2, chuyenBay.getMaMB());
			preparedStatement.setNString(3, chuyenBay.getSanBayXuatPhat());
			preparedStatement.setNString(4, chuyenBay.getSanBayDich());
			preparedStatement.setTimestamp(5, chuyenBay.getThoiGianBatDau());
			preparedStatement.setTimestamp(6, chuyenBay.getThoiGianKetThuc());
			preparedStatement.setInt(7, chuyenBay.getSlChoNgoiConLai());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<ThongKe> thongKe() {
		List<ThongKe> list = new ArrayList<>();

		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(THONGKE);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new ThongKe(rs.getString(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
