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

    public int findCheapestHotelForWeekdayAndWeekend(String d1, String d2) {
        int weekEnds = 0;
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (weekEnds == 0) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
            return hotelObjList.get(0).getWeekdayRate() * 2;

        } else if (weekEnds == 2) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());

            System.out.println(" The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + hotelObjList.get(0).getWeekendRate() * 2);
            return hotelObjList.get(0).getWeekendRate() * 2;
        } else {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).collect(Collectors.toList());
            if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate()) {
                System.out.println("The cheapest hotels are " + hotelObjList.get(0).getHotelName() + " and " + hotelObjList.get(1).getHotelName() + ", Total Rates = $" + (hotelObjList.get(0).getAvgRate()));
                return hotelObjList.get(0).getAvgRate();
            } else {
                System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Total Rates = $" + (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
                return hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate();
            }
        }
    }
    public int findCheapestBestBestRatedHotel(String d1, String d2) {
        int weekEnds = 0;
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (weekEnds == 0) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekdayRate)).collect(Collectors.toList());
            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekdayRate() * 2);
            return hotelObjList.get(0).getWeekdayRate() * 2;
        }
        if (weekEnds == 2) {
            List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.weekendRate)).collect(Collectors.toList());

            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating : " + hotelObjList.get(0).getRating() + ", Total Rates = $" + hotelObjList.get(0).getWeekendRate() * 2);
            return hotelObjList.get(0).getWeekendRate() * 2;
        }
        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.avgRate)).collect(Collectors.toList());
        if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate() && hotelObjList.get(0).getRating() < hotelObjList.get(1).getRating()) {
            System.out.println("The cheapest hotel is " + hotelObjList.get(1).getHotelName() + ", Rating " + hotelObjList.get(1).getRating() + ", Total Rates = $" + (hotelObjList.get(1).getWeekdayRate() + hotelObjList.get(1).getWeekendRate()));
            return hotelObjList.get(1).getAvgRate();
        }
        if (hotelObjList.get(0).getAvgRate() == hotelObjList.get(1).getAvgRate() && hotelObjList.get(0).getRating() > hotelObjList.get(1).getRating()) {

            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
            return hotelObjList.get(0).getAvgRate();
        } else {
            System.out.println("The cheapest hotel is " + hotelObjList.get(0).getHotelName() + ", Rating " + hotelObjList.get(0).getRating() + ", Total Rates = $" + (hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate()));
            return hotelObjList.get(0).getWeekdayRate() + hotelObjList.get(0).getWeekendRate();
        }
    }

    public int findBestRatedHotel(String d1, String d2) {
        int weekEnds = 0;
        DayOfWeek day1 = LocalDate.parse(d1).getDayOfWeek();
        DayOfWeek day2 = LocalDate.parse(d2).getDayOfWeek();
        if (day1.equals(DayOfWeek.SUNDAY) || day1.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        if (day2.equals(DayOfWeek.SUNDAY) || day2.equals(DayOfWeek.SATURDAY)) {
            weekEnds++;
        }
        List<Hotel> hotelObjList = hotelReservation.values().stream().sorted(Comparator.comparing(Hotel -> Hotel.rating)).collect(Collectors.toList());
        if (weekEnds == 0) {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getWeekdayRate() * 2);
            return hotelObjList.get(2).getWeekdayRate() * 2;
        }
        if (weekEnds == 2) {

            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + hotelObjList.get(2).getWeekendRate() * 2);
            return hotelObjList.get(2).getWeekendRate() * 2;
        } else {
            System.out.println(" The Best Rated hotel is: " + hotelObjList.get(2).getHotelName() + ", Rating: " + hotelObjList.get(2).getRating() + ", Total Rates = $" + (hotelObjList.get(2).getWeekdayRate() + hotelObjList.get(2).getWeekendRate()));
            return (hotelObjList.get(2).getWeekdayRate() + hotelObjList.get(2).getWeekendRate());
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Hotel Reservation System");
        HotelReservationSystem hotel = new HotelReservationSystem();
        hotel.addHotel();
        hotel.enterDates();

        hotel.findCheapestHotelForWeekdayAndWeekend("2020-09-11", "2020-09-12");
        hotel.findCheapestBestBestRatedHotel("2020-09-11", "2020-09-12");
        hotel.findBestRatedHotel("2020-09-11", "2020-09-12");
    }

}
