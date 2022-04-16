package Workshop.HotelReservationSystem;


public class HotelReservationSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");
        HotelSetup hotelSetup=new HotelSetup();
        hotelSetup.addHotel();
        hotelSetup.showHotelInfo();


        System.out.println(" ");
        System.out.println("*Cheapest Hotel Based on WeekdayRegularRate");
        hotelSetup.findCheapestHotelOne("01-Jan-2021","05-Jan-2021");
        System.out.println(" ");


    }
}
