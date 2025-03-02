package java_test;

import java.util.*;

class Fan {
    private String model; int price;

    // getter
    public String getModel(){
        return model;
    }

    public int getPrice(){
        return price;
    }

    // setter
    public void setPrice(int price){
        this.price = price;
    }

    public void setModel(String model){
        this.model = model;
    }
}

// 이부분에 class 선언 해도 괜찮습니다

public class g1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Fan> fans = new ArrayList<Fan>();

        Fan f1 = new Fan();
        Fan f2 = new Fan();
        Fan f3 = new Fan();

        f1.setModel(sc.nextLine());
        f1.setPrice(Integer.parseInt(sc.nextLine()));
        f2.setModel(sc.nextLine());
        f2.setPrice(Integer.parseInt(sc.nextLine()));
        f3.setModel(sc.nextLine());
        f3.setPrice(Integer.parseInt(sc.nextLine()));

        fans.add(f1); fans.add(f2); fans.add(f3);

        Fan minPrice = Collections.min(fans, Comparator.comparingInt(Fan::getPrice));
        System.out.println(minPrice.getModel());
        
        sc.close();
    }
}
