import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

public class BevShopTestStudent {

	@Test
	public void testSortOrders() {
		
        BevShop shop = new BevShop();

        shop.startNewOrder(12, Day.TUESDAY, "Ben", 30);  
        shop.startNewOrder(10, Day.MONDAY, "Benny", 25); 
        shop.startNewOrder(14, Day.WEDNESDAY, "Benjamin", 22); 
        
        
        int[] array = new int[shop.totalNumOfMonthlyOrders()];
                
        int totalOrders = shop.totalNumOfMonthlyOrders();
        for (int i = 0; i < totalOrders; i++) {
        	int orderNo = shop.getOrderAtIndex(i).getOrderNo();
        	array[i] = orderNo;
        }
        
       Arrays.sort(array);
        
               
        
       shop.sortOrders();
        
        int[] sortedArray = new int[shop.totalNumOfMonthlyOrders()];
        for (int i = 0; i < totalOrders; i++) {
        	int orderNo = shop.getOrderAtIndex(i).getOrderNo();
        	sortedArray[i] = orderNo;
        }
        
        
		assertEquals(Arrays.toString(array), Arrays.toString(sortedArray));
	}

}
