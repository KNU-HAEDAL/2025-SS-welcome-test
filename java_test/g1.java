package java_test;

import java.util.Scanner;

class Fan {
    private String model;
    private int price;

    public Fan(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
public class g1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fan[] fans = new Fan[3];

        for(int i=0;i<3;i++){
            String model = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine();
            fans[i] = new Fan(model,price);
        }
        int minPriceIndex = 0;
        for(int i = 1; i < fans.length; i++) {
            if(fans[i].getPrice() < fans[minPriceIndex].getPrice()) {
                minPriceIndex = i;
            }
        }

        System.out.println(fans[minPriceIndex].getModel());
        
        sc.close();
    }

}