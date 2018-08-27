package com.sys.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BinaryOperator;

public class AtomicReforenceTest {

	static class Book {
		private String name;
		private Integer price;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getPrice() {
			return price;
		}

		public void setPrice(Integer price) {
			this.price = price;
		}

		public Book() {
			super();
		}

		public Book(String name, Integer price) {
			super();
			this.name = name;
			this.price = price;
		}

		@Override
		public String toString() {
			return "Book [name=" + name + ", price=" + price + "]";
		}
	}

	public static void main(String[] args) {
		AtomicReference<Book> atomicBook = new AtomicReference<AtomicReforenceTest.Book>();
		Book b1 = new Book("java", 26);
		atomicBook.set(b1);
		Book b2 = new Book("java", 999);
		atomicBook.compareAndSet(b1, b2);
		System.out.println(atomicBook);
		atomicBook.getAndSet(b1);
		System.out.println(atomicBook);
		atomicBook.accumulateAndGet(new Book("C++", 65), new BinaryOperator<AtomicReforenceTest.Book>() {
			public Book apply(Book t, Book u) {
				t.name = u.getName();
				return t;
			}
		});
		System.out.println(atomicBook);
	}

}
