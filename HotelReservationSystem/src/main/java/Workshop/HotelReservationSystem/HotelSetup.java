package Workshop.HotelReservationSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class HotelSetup {
	  ArrayList<Hotel1> hotelList = new ArrayList<>();
	
	void addHotel(){
        Scanner scan = new Scanner(System.in);
        Hotel1 newHotel = new Hotel1();
        System.out.println("Enter Name of the hotel: ");
        String name = scan.next();
        newHotel.setName(name);
        System.out.println("Enter rates for regular customer on Weekdays: ");
        Integer wdRegular = scan.nextInt();
        newHotel.setWD_REGULAR(wdRegular);
        System.out.println("Enter rates for regular customer on Weekends: ");
        Integer weRegular = scan.nextInt();
        newHotel.setWE_REGULAR(weRegular);
        hotelList.add(newHotel);
        
        }
}


