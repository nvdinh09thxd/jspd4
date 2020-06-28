package model.bean;

public class Hoa {
	int id;
	String tenHoa;
	int soLuong;
	int gia;

	public 	int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenHoa() {
		return tenHoa;
	}

	public void setTenHoa(String tenHoa) {
		this.tenHoa = tenHoa;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public Hoa() {
		super();
	}

	public Hoa(int id, String tenHoa, int soLuong, int gia) {
		super();
		this.id = id;
		this.tenHoa = tenHoa;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	public int tongTien() {
		return(gia*soLuong);
	}

}
