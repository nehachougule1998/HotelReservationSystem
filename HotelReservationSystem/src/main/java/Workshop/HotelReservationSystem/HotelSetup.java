package Workshop.HotelReservationSystem;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class HotelSetup {
    ArrayList<Hotel> myHotelList = new ArrayList();                                                //Array

    public void addHotel() {                                                                          //Add Method

        Hotel LakeWood = new Hotel("LakeWood", 110, 80, 90, 80, 3);          //Adding Hotels Using Constructor in ArrayList
        Hotel BridgeWood = new Hotel("BridgeWood", 150, 110, 50, 50, 4);     //HotelName - WeekDayRegularRate - WeekDayRewardRate - WeekendRegularRate - WeekendRewardRate - Rating
        Hotel RidgeWood = new Hotel("RidgeWood", 220, 100, 150, 40, 5);

        myHotelList.add(LakeWood);
        myHotelList.add(BridgeWood);
        myHotelList.add(RidgeWood);
    }
    public void showHotelInfo() {                                                //Show Method

        for (int i = 0; i < myHotelList.size(); i++) {
            System.out.println(myHotelList.get(i));
        }
    }


    public void findCheapestHotelOne(String startDateRange, String endDateRange) {                                                      //Find CheapestHotel based on weekdayRegularRate

        LocalDate startDate = LocalDate.parse(startDateRange, DateTimeFormatter.ofPattern("d-MMM-yyyy"));        //LocalDate class is used to parse the start and end date ranges with DateTimeFormater class to pass date format
        LocalDate endDate = LocalDate.parse(endDateRange, DateTimeFormatter.ofPattern("d-MMM-yyyy"));

        int numberOfDays = endDate.getDayOfMonth() - startDate.getDayOfMonth() + 1;                                 //To calculate Number of days stayed + the weekdayRegularRate for eg-(5*110)

        Optional<Hotel> cheapestHotel = this.myHotelList.stream().sorted(Comparator.comparing(Hotel::getWeekdayRegularRate)).findFirst();  //Stream function on arrlits ie-myHotelList and storing in cheapestHotel

        Hotel hotel = new Hotel();                                                                                  //Hotel Object
        hotel.setHotelName(cheapestHotel.get().getHotelName());
        hotel.setTotal(cheapestHotel.get().getWeekdayRegularRate() * numberOfDays);                            //numberOfDays = for eg-(5*110)

        System.out.println("-HotelName :" + hotel.getHotelName());                                        //Printing Hotel name and total Hotel rate for the date range
        System.out.println("-NumberOfDaysStayed * WeekdayRegularRate :" + hotel.getTotal() + "$");

    }


}
