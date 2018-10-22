package com.thirdware.guptabookstore.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.thirdware.guptabookstore.dao.CartDao;
import com.thirdware.guptabookstore.getconnection.ConnectionProvider;
import com.thirdware.guptabookstore.models.Book;
import com.thirdware.guptabookstore.models.Cart;

public class CartDaoImpl implements CartDao {

	ConnectionProvider databaseConnection = new ConnectionProvider();
	Connection con = databaseConnection.CONN();

	@Override
	public int addCart(Cart cart) {

		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "insert into cart(bookid,bookname,customername,quantity,price) values(?,?,?,?,?)";
				PreparedStatement psmt = con.prepareStatement(query);
				cart = new Cart();
				psmt.setInt(1, cart.getBookId());
				psmt.setString(2, cart.getBookName());
				psmt.setString(3, cart.getCustomername());
				psmt.setInt(4, cart.getQuantity());
				psmt.setFloat(5, cart.getPrice());
				int i = psmt.executeUpdate();
				if (i > 0) {
					System.out.println("Inserted Successfully");

				}
				psmt.close();
				con.close();
				return 0;
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return 0;

	}

	@Override
	public List<Cart> getCart() {
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
			return null;
		} else {
			try {
				String query = "select * from cart";
				PreparedStatement psmt = con.prepareStatement(query);
				ResultSet result = psmt.executeQuery();
				List<Cart> ls = new ArrayList<>();
				while (result.next()) {
					Cart cart = new Cart();
					cart.setCartId(result.getInt(1));
					cart.setBookId(result.getInt(6));
					cart.setBookName(result.getString(2));
					cart.setCustomerId(result.getInt(5));
					cart.setQuantity(result.getInt(3));
					cart.setPrice(result.getFloat(4));
					ls.add(cart);
				}
				result.close();
				psmt.close();
				con.close();
				return ls;

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		return null;
	}

	@Override
	public int deleteCart(Book book) {
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "delete * from cart where bookid=?";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setInt(1, book.getBookid());
				int i = psmt.executeUpdate();
				if (i > 0) {

					System.out.println("Deleted Successfully");

				}
				psmt.close();
				con.close();

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return 0;
	}

	@Override
	public int deleteAll() {
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "delete from cart";
				PreparedStatement psmt = con.prepareStatement(query);
				int i = psmt.executeUpdate();
				if (i > 0) {
					System.out.println("Deleted Successfully");

				}
				psmt.close();
				con.close();

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return 0;
	}

	@Override
	public Book getBookDetails(Book book) {
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
			return null;
		} else {
			try {
				String query = "select * from book where bookid=?";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setInt(1, book.getBookid());
				ResultSet result = psmt.executeQuery();
				List<Book> ls = new ArrayList<>();
				while (result.next()) {
					book = new Book();
					book.setBookid(result.getInt(1));
					book.setBookname(result.getString(2));
					book.setQuantity(result.getInt(4));
					book.setPrice(result.getFloat(5));
					ls.add(book);
				}
				result.close();
				psmt.close();
				con.close();
				return book;
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		return null;
	}

	@Override
	public int updateBookQunatity(Book book) {
		if (con == null) {
			System.out.println("Not Connected, Please check the database details");
		} else {
			try {
				String query = "update book set quantity=? where bookid=?";
				PreparedStatement psmt = con.prepareStatement(query);
				psmt.setInt(1, book.getQuantity());
				psmt.setFloat(2, book.getBookid());
				int i = psmt.executeUpdate();
				if (i > 0) {
					System.out.println("Deleted Successfully");

				}
				psmt.close();
				con.close();

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return 0;

	}

}
