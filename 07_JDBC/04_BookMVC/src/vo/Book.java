package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

	public Book(String title, String author, int accessAge) {
	}
	private int bookNO; // primary key
	private String title;
	private String author;
	private int accessAge; // access_age
}
