package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

	private int bookNo; // primary key
	private String title;
	private String author;
	private int accessAge; // access_age

	public Book(String title, String author, int accessAge) {
		this.title = title;
		this.author = author;
		this.accessAge = accessAge;
	}
}
