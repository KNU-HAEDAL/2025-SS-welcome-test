package java_test;

import java.util.*;

class Fan {
    private String model;
    private int price;

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class g1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Fan[] fans = new Fan[3];
        for (int i = 0; i < 3; i++) {
            fans[i] = new Fan();
            fans[i].setModel(sc.nextLine().trim());
            fans[i].setPrice(sc.nextInt());
            sc.nextLine();
        }

        Fan minFan = fans[0];
        for (int i = 1; i < 3; i++) {
            if (fans[i].getPrice() < minFan.getPrice())
                minFan = fans[i];
        }

        System.out.println(minFan.getModel());
        sc.close();
    }

}