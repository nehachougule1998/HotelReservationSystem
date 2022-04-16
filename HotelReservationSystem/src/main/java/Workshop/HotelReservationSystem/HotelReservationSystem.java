package Workshop.HotelReservationSystem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

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
    public void enterDates() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2 dates in yyyymmdd format: ");
        String date1 = sc.nextLine();
        String date2 = sc.nextLine();
        findCheapestHotel(date1, date2);
    }
    public int findCheapestHotel(String d1, String d2) {
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();

        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
        System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
        return (hotelObjList.get(0).getWeekdayRate() * 2);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Reservation System");
        HotelReservationSystem hotel = new HotelReservationSystem();
        hotel.addHotel();
        hotel.enterDates();
    }

}
