import java.util.*;
public class BevShopDriverApp {

	public static void main(String[] args) {
		
		BevShop shop = new BevShop();
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		
		System.out.println("The current order in process can have at most 3 alcoholic beverages.");
		System.out.println("The minimum age to order alcohol drink is 21");
		
		do
		{
			System.out.println("Start please a new order: ");
			if(shop.totalNumOfMonthlyOrders() > 0)
			{
				System.out.println("Your Total Order for now is "+ shop.totalMonthlySale());
			}
			else
			{
				System.out.println("Your Total Order for now is 0.0");
			}
			
			
			System.out.print("Would you please enter your name ");
			name = sc.nextLine();
			System.out.print("Would you please enter your age ");
			age = sc.nextInt();
			sc.nextLine();
			
	        shop.startNewOrder(9, Day.FRIDAY, name, age);;

			
			// Alcohol order
			if(shop.isValidAge(shop.getCurrentOrder().getCustomer().getAge()))
			{
				System.out.println("Your age is above 20 and you are eligible to order alcohol");
				System.out.println("Would you please add an alcohol drink");
				int count = 0;
				while(shop.isEligibleForMore())
				{
					shop.processAlcoholOrder("Drink #"+(count+1), Size.MEDIUM);
					count++;
					
					System.out.println("Total price on the order is "+ 
					shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo())	);
				}
				
	            System.out.println("You have reached the maximum alcohol drinks for this order.");				
			}
			
			// Non-alcoholic order
			else
			{
				System.out.println("Your Age is not appropriate for alcohol drink!");
				System.out.println("Would you please add a COFFEE to your order");
				shop.processCoffeeOrder("Coffee", Size.MEDIUM, true, true);
				System.out.println("Total price on the order is "+ 
						shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo())	);
				
				System.out.println("Would you please add a SMOOTHIE to your order");
				shop.processSmoothieOrder("Smoothie", Size.MEDIUM, 2, true);
				
				System.out.println("Total price on the order is "+ 
						shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo())	);
				
				System.out.println("Would you please add another SMOOTHIE to your order");
				shop.processSmoothieOrder("Smoothie #2", Size.MEDIUM, 6, true);
				System.out.println("Too many fruits in the smoothie");
				
				System.out.println("Total price on the order is "+ 
						shop.totalOrderPrice(shop.getCurrentOrder().getOrderNo())	);

				
				
			}
			
		}while(shop.totalNumOfMonthlyOrders() < 2); // two orders
		
		
		System.out.println(shop.toString());
		
		
		



		



	}

}
