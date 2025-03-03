package java_test;
import java.util.Scanner;

// 이부분에 class 선언 해도 괜찮습니다

public class g1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fan[] fans = new Fan[3];
        Fan cheapest;
        
        for(int i = 0; i < 3; i++)
        {
            fans[i] = new Fan();
            fans[i].setModel(sc.next());
            fans[i].setPrice(sc.nextInt());
        }

        cheapest = Compare(fans[0], Compare(fans[1], fans[2]));

        System.out.printf("%s\n", cheapest.getModel());

        sc.close();
    }

    static Fan Compare(Fan A, Fan B)
    {
        if(A.getPrice() < B.getPrice())
            return A;
        else
            return B;
    }
}

class Fan
{
    private String model;
    private int price;

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public String getModel()
    {
        return this.model;
    }

    public int getPrice()
    {
        return this.price;
    }
}
