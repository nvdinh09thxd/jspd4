package bean;

public class Hoa {
	int id;
	String tenHoa;
	int soLuong;
	float gia;

	public int getId() {
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

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		this.gia = gia;
	}

	public Hoa() {
		super();
	}

	public Hoa(int id, String tenHoa, int soLuong, float gia) {
		super();
		this.id = id;
		this.tenHoa = tenHoa;
		this.soLuong = soLuong;
		this.gia = gia;
	}

	public float tongTien() {
		return gia * soLuong;
	}

}
