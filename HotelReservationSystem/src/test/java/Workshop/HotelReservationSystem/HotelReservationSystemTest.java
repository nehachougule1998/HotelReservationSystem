package Workshop.HotelReservationSystem;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationSystemTest {

    //uc1
    @Test
    public void givenHotelNamesWhenAddedShouldReturnSize() {
        HotelReservationSystem obj = new HotelReservationSystem();
        obj.addHotel();
        Assert.assertEquals(3, obj.hotelReservation.size());
    }
    //uc2
    @Test
    public void givenDateRangeShouldReturnTheCheapestHotelRate() {
        HotelReservationSystem  obj = new HotelReservationSystem();
        obj.addHotel();
        Assert.assertEquals(220, obj.findCheapestHotel("2020-09-10", "2020-09-11"));
    }
    //UC3
    @Test
    public void givenWeekDayWeekEndRatesShouldReturnThoseRates() {
        HotelReservationSystem obj = new HotelReservationSystem();
        obj.addHotel();
        Assert.assertEquals(90, obj.hotelReservation.get("Lakewood").getWeekendRate());
        Assert.assertEquals(50, obj.hotelReservation.get("Bridgewood").getWeekendRate());
        Assert.assertEquals(150, obj.hotelReservation.get("Ridgewood").getWeekendRate());
    }

    //UC4
    @Test
    public void givenDateRangeShouldReturnTheCheapestHotelRateForWeekdayAndWeekend() {
        HotelReservationSystem obj = new HotelReservationSystem();
        obj.addHotel();
        Assert.assertEquals(200, obj.findCheapestHotelForWeekdayAndWeekend("2020-09-11", "2020-09-12"));
    }


	//UC5
	@Test
	public void givenRatingShouldReturnsThoseRatings() {
		HotelReservationSystem obj = new  HotelReservationSystem();
		obj.addHotel();
		Assert.assertEquals(5, obj.hotelReservation.get("Ridgewood").getRating());
		Assert.assertEquals(4, obj.hotelReservation.get("Bridgewood").getRating());
		Assert.assertEquals(3, obj.hotelReservation.get("Lakewood").getRating());
	}
}