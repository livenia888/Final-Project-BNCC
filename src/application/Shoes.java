package application;

public class Shoes {
	private String id;
	private String model;
	private String merk;
	private String warna;
	private int harga;

	public Shoes(String id, String model, String merk, String warna, int harga) {
		super();
		this.id = id;
		this.model = model;
		this.merk = merk;
		this.warna = warna;
		this.harga = harga;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMerk() {
		return merk;
	}

	public void setMerk(String merk) {
		this.merk = merk;
	}

	public String getWarna() {
		return warna;
	}

	public void setWarna(String warna) {
		this.warna = warna;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

}
