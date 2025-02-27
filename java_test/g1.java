package java_test;
import java.util.*;

class Fan implements Comparable<Fan> {
	private String model;
	private int price;
	
	Fan(String model, int price) {
		this.model=model;
		this.price=price;
	}
	
	String getModel() { return model; }
	int getPrice() { return price; }
	
	@Override
	public int compareTo(Fan o) {
		if(this.price>o.price) {
			return 1;
		}else if(this.price<o.price) {
			return -1;
		}else {
			return 0;
		}
	}
}

public class g1 {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	ArrayList<Fan> fan=new ArrayList<>();
    	
    	for(int i=0; i<3 ;i++) {
    		if(i!=0) sc.nextLine();
    		String model=sc.nextLine();
    		int price=sc.nextInt();
    		fan.add(new Fan(model, price));
    	}
    	
    	Collections.sort(fan);
    	System.out.println(fan.get(0).getModel());
    	
    }
}

