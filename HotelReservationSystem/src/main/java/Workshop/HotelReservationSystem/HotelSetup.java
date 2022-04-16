package Workshop.HotelReservationSystem;


import java.util.ArrayList;

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
}