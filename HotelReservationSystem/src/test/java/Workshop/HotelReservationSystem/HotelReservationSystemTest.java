package Workshop.HotelReservationSystem;

import org.junit.Assert;
import org.junit.Test;

public class HotelReservationSystemTest {

    @Test
    public void givenHotelNamesWhenAddedShouldReturnSize() {
        HotelReservationSystem obj = new HotelReservationSystem();
        obj.addHotel();
        Assert.assertEquals(3, obj.hotelReservation.size());
    }
}
 