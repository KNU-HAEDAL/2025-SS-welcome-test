package java_test;
import java.util.*;

abstract class Book implements Comparable<Book> {
	String title;
	int price;
	double rating;
	
	@Override
	public int compareTo(Book o) {
		if(this.rating>o.rating) {
			return -1;
		}else if(this.rating<o.rating) {
			return 1;
		}else {
			return 0;
		}
	}
	
	abstract int getExtra();
}

class EBook extends Book {
	int fileSize;
	
	EBook(String title, int price, double rating, int fileSize) {
		this.title=title;
		this.price=price;
		this.rating=rating;
		this.fileSize=fileSize;
	}
	
	int getExtra() { return fileSize; }
}

class PrintedBook extends Book {
	int pageCount;
	
	PrintedBook(String title, int price, double rating, int pageCount) {
		this.title=title;
		this.price=price;
		this.rating=rating;
		this.pageCount=pageCount;
	}
	
	int getExtra() { return pageCount; }
}

public class g2 {
    public static void main(String[] args) {
    	ArrayList<Book> arr=new ArrayList<>();
    	Scanner sc=new Scanner(System.in);
    	boolean isFirst=true;
    	for(int i=0; i<3 ;i++) {
    		if(!isFirst) sc.nextLine();
    		String genre=sc.nextLine();
    		if(!genre.equals("EBook") && !genre.equals("PrintedBook")) {
    			System.out.println("Invalid book type. Please enter 'EBook' or 'PrintedBook'.");
    			isFirst=true;
    			i--;
    			continue;
    		}
    		String title=sc.nextLine();
    		try {
    			int price=sc.nextInt();
    			double rating=sc.nextDouble();
    			int extra=sc.nextInt();
    			
    			if(genre.equals("EBook")) {
    				arr.add(new EBook(title, price, rating, extra));
    			}else {
    				arr.add(new PrintedBook(title, price, rating, extra));
    			}
    		}catch(Exception e) {
    			System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
    			i--;
    		}
    		isFirst=false;
    	}
    	
    	Collections.sort(arr);
    	Book book=arr.get(0);
    	System.out.println("Highest rated book information:");
    	System.out.println("Title: "+book.title);
    	System.out.println("Price: "+book.price);
    	System.out.println("Rating: "+book.rating);
    	if(book.getClass().getName().contains("Printed")) {
    		System.out.println("Page Count: "+book.getExtra());
    	}else {
    		System.out.println("File Size: "+book.getExtra());
    	}
    }
}

