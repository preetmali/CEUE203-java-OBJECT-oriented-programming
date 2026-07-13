import java.util.Scanner;
enum coin
    {
       ONE,
       TWO,
       FIVE,
       TEN
    }
public class vending {
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
      
        int price=20;
        int total=0;
        while(total<price)
        {
         System.out.println("ENter the price : ");
        String input=sc.next().toUpperCase();
      coin day=coin.valueOf(input);      
      int  result =switch(day)
       {
         case ONE -> 1;
         case TWO -> 2;
         case FIVE -> 5;
         case TEN -> 10;
         default -> 0;
       };
       total=total+result;
        }
        
       System.out.println("Total price:"+total);
       int x=total-price;
       System.out.println("return rupee: "+x);
      sc.close();
    }
}
