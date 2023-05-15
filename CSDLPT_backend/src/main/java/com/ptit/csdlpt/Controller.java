package com.ptit.csdlpt;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {
	@GetMapping("/dskh")
	public List<KhachHang> getAllKH() {
		DAO dao = new DAO();
		return dao.getAllKhachHang();
	}
	
	@GetMapping("/dsnv")
	public List<NhanVien> getAllNV() {
		DAO dao = new DAO();
		return dao.getAllNhanVien();
	}
	
	@PostMapping("/dsnv/new")
	public void addNV (@RequestBody NhanVien nhanVien) {
		DAO dao = new DAO();
		dao.addNV(nhanVien);
	}
	
	@PostMapping("/dscb/new")
	public void addNV (@RequestBody ChuyenBay chuyenBay) {
		DAO dao = new DAO();
		dao.addCB(chuyenBay);
	}
	
	@GetMapping("/dsmb")
	public List<MayBay> getAllMB() {
		DAO dao = new DAO();
		return dao.getAllMayBay();
	}
	
	@GetMapping("/dssb")
	public List<SanBay> getAllSB() {
		DAO dao = new DAO();
		return dao.getAllSanBay();
	}
	
	@GetMapping("/dscn")
	public List<ChiNhanh> getAllCN() {
		DAO dao = new DAO();
		return dao.getChiNhanh();
	}
	
	@GetMapping("/thongke")
	public List<ThongKe> thongke() {
		DAO dao = new DAO();
		return dao.thongKe();
	}
}
