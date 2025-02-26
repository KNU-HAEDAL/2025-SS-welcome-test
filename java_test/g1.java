package java_test;

import java.util.Scanner;

// 이부분에 class 선언 해도 괜찮습니다

class Fan {
    private char model;
    private int price;

    public void setModel(char model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public char getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public Fan compare(Fan fan) {
        return this.getPrice() < fan.getPrice() ? this : fan;
    }
}

public class g1 {
    public static void main(String[] args) {

        // 이 부분에 code를 작성해주세요!
        var sc = new Scanner(System.in);
        Fan cheapest = new Fan();
        cheapest.setPrice(1001);
        for (int i = 0; i < 3; ++i) {
            char model = sc.next().charAt(0);
            int price = sc.nextInt();
            Fan fan = new Fan();
            fan.setModel(model);
            fan.setPrice(price);
            cheapest = cheapest.compare(fan);
        }
        sc.close();
        System.out.println(cheapest.getModel());
    }

}