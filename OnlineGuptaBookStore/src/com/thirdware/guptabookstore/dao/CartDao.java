package com.thirdware.guptabookstore.dao;

import java.util.List;

import com.thirdware.guptabookstore.models.Book;
import com.thirdware.guptabookstore.models.Cart;

public interface CartDao {
	public int addCart(Cart cart);

	public List<Cart> getCart();

	public int deleteCart(Book book);

	public int deleteAll();

	public Book getBookDetails(Book book);

	public int updateBookQunatity(Book book);

}
