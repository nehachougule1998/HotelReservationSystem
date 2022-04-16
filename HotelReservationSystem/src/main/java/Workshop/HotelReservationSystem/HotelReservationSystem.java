package Workshop.HotelReservationSystem;

import java.util.HashMap;
import java.util.Map;

public class HotelReservationSystem {
    Map<String, Hotel> hotelReservation = new HashMap<>();

    public void addHotel() {
        Hotel obj1 = new Hotel("Lakewood", 3, 110, 90, 80, 80);
        Hotel obj2 = new Hotel("Bridgewood", 4, 150, 50, 110, 50);
        Hotel obj3 = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
        hotelReservation.put(obj1.getHotelName(), obj1);
        hotelReservation.put(obj2.getHotelName(), obj2);
        hotelReservation.put(obj3.getHotelName(), obj3);
    }
    public static void main(String[] args) {
    	System.out.println("Welcome to the Hotel Reservation System");
        HotelReservationSystem hotel = new HotelReservationSystem();
        hotel.addHotel();

    }

}
