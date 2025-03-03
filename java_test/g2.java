package java_test;

import java.util.Scanner;

class Book{
    public String title;
    public int price;
    public double rating;


    @Override
    public String toString() {
        return "Highest rated book information:\n" + "Title: " + title + "\n" + "Price: " + price + "\n" + "Rating: " + rating + "\n";
    }
}

class EBook extends Book{
    public int fileSize;

    @Override
    public String toString() {
        
        return super.toString() + "File Size: " + fileSize;
    }
}

class PrintedBook extends Book{
    public int pageCount;

    @Override
    public String toString() {
        
        return super.toString() + "Page Count: " + pageCount;
    }
}

public class g2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String bookType;
        Book[] books = new Book[3];
        double highestRating = -999;
        Book highestBook = null;

        for(int i=0; i<3; i++){
            while (true) {
                bookType = input.next();
                if(!bookType.equals("EBook") && !bookType.equals("PrintedBook")){
                    System.out.println("Invalid book type. Please enter 'EBook' or 'PrintedBook'.");
                    continue;
                }

                Book selectedBook = null;
                if(bookType.equals("EBook")){
                    selectedBook = new EBook();
                }else{
                    selectedBook = new PrintedBook();
                }
                input.nextLine();

                selectedBook.title = input.nextLine();

                try {
                    selectedBook.price = Integer.parseInt(input.next());
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
                    // input.nextLine();
                    continue;
                }

                try {
                    selectedBook.rating = Double.parseDouble(input.next());
                } catch (NumberFormatException e) {
                    System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
                    // input.nextLine();
                    continue;
                }

                try{
                    if(selectedBook instanceof EBook){
                        ((EBook)selectedBook).fileSize = Integer.parseInt(input.next());
                    
                    }else {
                        ((PrintedBook)selectedBook).pageCount = Integer.parseInt(input.next());
                    }
                }catch(NumberFormatException e){
                    System.out.println("잘못된 입력입니다. 처음부터 다시 입력하세요.");
                    // input.nextLine();
                    continue;
                }

                books[i] = selectedBook;

                if(selectedBook.rating > highestRating){
                    highestRating = selectedBook.rating;
                    highestBook = selectedBook;
                }
                
                
                break;

            }
            


            
            
        }
        
        System.out.println(highestBook);
        input.close();
    }

}