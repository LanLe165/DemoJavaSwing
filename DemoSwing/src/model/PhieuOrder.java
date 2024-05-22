package model;

public class PhieuOrder {
	public static final String TENKHACHHANG = " ";
	public static final String BAN = " ";
	public static final String SODIENTHOAI = " ";
	public static final String MONAN_DOUONG = " ";
	public static final int SOLUONG = 0;
	public static final double GIA = 0;
	public static final String NGAY = " ";
	
	private String tenKhachHang;
	private String ban;
	private String soDienThoai;
	private String monAn_DoUong;
	private int soLuong;
	private double gia;
	private String ngay;
	
	public PhieuOrder() {
		this.tenKhachHang = TENKHACHHANG;
		this.ban = BAN;
		this.soDienThoai = SODIENTHOAI;
		this.monAn_DoUong = MONAN_DOUONG;
		this.soLuong = SOLUONG;
		this.gia = GIA;
		this.ngay = NGAY;
	}

	public PhieuOrder(String tenKhachHang, String ban, String soDienThoai, String monAn_DoUong, int soLuong, double gia,
			String ngay) {
		this.tenKhachHang = tenKhachHang;
		this.ban = ban;
		this.soDienThoai = soDienThoai;
		this.monAn_DoUong = monAn_DoUong;
		this.soLuong = soLuong;
		this.gia = gia;
		this.ngay = ngay;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getMonAn_DoUong() {
		return monAn_DoUong;
	}

	public void setMonAn_DoUong(String monAn_DoUong) {
		this.monAn_DoUong = monAn_DoUong;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	@Override
	public String toString() {
		return "QuanLiOrder [tenKhachHang=" + tenKhachHang + ", ban=" + ban + ", soDienThoai=" + soDienThoai
				+ ", monAn_DoUong=" + monAn_DoUong + ", soLuong=" + soLuong + ", gia=" + gia + ", ngay=" + ngay + "]";
	}
	
	
	
}
