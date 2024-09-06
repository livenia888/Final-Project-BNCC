package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	Connection con;
	Statement s;
	PreparedStatement ps;
	ResultSet rs;

	public Database() {
		connect();
	}

	public void connect() {
		try {// try catch supaya program ga stop di tengah
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "jdbc:mysql://localhost:3306/bncc";
		String username = "root";
		String pass = "";
		try {
			con = DriverManager.getConnection(url, username, pass);
			s = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insert(Struk struk) {
		try {
			ps = con.prepareStatement(
					"insert into struk (ID, Model, Merk, Color, Price, Quantity, Money, Kembalian) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, struk.getId());
			ps.setString(2, struk.getModel());
			ps.setString(3, struk.getMerk());
			ps.setString(4, struk.getColor());
			ps.setInt(5, struk.getPrice());
			ps.setInt(6, struk.getQty());
			ps.setInt(7, struk.getMoney());
			ps.setInt(8, struk.getKembalian());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertShoes(Shoes shoes) {
		try {
			ps = con.prepareStatement("insert into struk (ID, Model, Merk, Color, Price) values (?,?,?,?,?)");
			ps.setString(1, shoes.getId());
			ps.setString(2, shoes.getModel());
			ps.setString(3, shoes.getMerk());
			ps.setString(4, shoes.getWarna());
			ps.setInt(5, shoes.getHarga());
			ps.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Struk struk) {
		try {
			ps = con.prepareStatement("update struk set Quantity= ?, Money=?");
			ps.setInt(1, struk.getQty());
			ps.setInt(2, struk.getMoney());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Struk struk) {
		try {
			ps = con.prepareStatement("delete from struk where ID= ?");
			ps.setString(1, struk.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet select() {
		try {
			rs = s.executeQuery("select * from struk"); // langsung tulis & jalanin query, simpan ke result set
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
