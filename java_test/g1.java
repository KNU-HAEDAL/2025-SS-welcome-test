package java_test;

import java.io.*;
import java.util.*;

public class g1 {

   static class Fan {
      private String model;
      private int price;

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

      public Fan() {
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      List<Fan> fanList = new ArrayList<>();
      for (int i = 0; i < 3; i++) {
         Fan fan = new Fan();
         fan.setModel(scanner.next());
         fan.setPrice(scanner.nextInt());
         fanList.add(fan);
      }

      Fan minPriceFan = fanList.get(0);
      for (Fan fan : fanList) {
         if (fan.getPrice() < minPriceFan.getPrice()) {
            minPriceFan = fan;
         }
      }
      System.out.println(minPriceFan.getModel());

      scanner.close();
   }
}