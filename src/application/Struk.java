package application;

public class Struk {
	private String id;
	private String model;
	private String merk;
	private String color;
	private int price;
	private int qty;
	private int money;
	private int kembalian;

	public Struk(String id, String model, String merk, String color, int price, int qty, int money, int kembalian) {
		super();
		this.id = id;
		this.model = model;
		this.merk = merk;
		this.color = color;
		this.price = price;
		this.qty = qty;
		this.money = money;
		this.kembalian = kembalian;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getKembalian() {
		return kembalian;
	}

	public void setKembalian(int kembalian) {
		this.kembalian = kembalian;
	}

}
