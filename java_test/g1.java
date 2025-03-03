package java_test;

import java.util.Scanner;

class Fan {
    private String model;
    private int price;

    Fan(){}

    public String getModel(){

        return this.model;

    }
    public int getPrice(){

        return this.price;
        
    }
    public void setPrice(int price){

        this.price = price;
        
    }
    public void setModel(String model){

        this.model = model;
        
    }
    
    
}

public class g1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Fan [] fans = new Fan[3];
        String model = "";
        int price, minPrice = 9999999;

        for(int i=0; i<fans.length;i++){
            fans[i] = new Fan();

            model = input.next();
            fans[i].setModel(model);

            price = input.nextInt();
            fans[i].setPrice(price);

        }
        
    
        for(int i=0;i<fans.length;i++){
            price = fans[i].getPrice();

            if(price < minPrice){
                minPrice = price;
                model = fans[i].getModel();
            }

        }

        System.out.println(model);
        input.close();

    }

}