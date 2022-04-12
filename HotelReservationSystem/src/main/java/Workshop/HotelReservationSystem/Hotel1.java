package Workshop.HotelReservationSystem;

public class Hotel1 {
	String name;
    private Integer Rating;
    private Integer WeekDayRegularRate;
    private Integer WeekDayReward;
    private Integer WeekEndRegularRate;
    private Integer WeekEndReward;

    Hotel1(){
    	
    }

    public void Hotel() {
        this.name = name;
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRATING() {
        return Rating;
    }

    public void setRATING(Integer RATING) {
        this.Rating = RATING;
    }

    public Integer getWD_REGULAR() {
        return WeekDayRegularRate;
    }

    public void setWD_REGULAR(Integer WD_REGULAR) {
        this.WeekDayRegularRate = WD_REGULAR;
    }

    public Integer getWD_REWARD() {
        return WeekEndRegularRate;
    }

    public void setWD_REWARD(Integer WD_REWARD) {
        this.WeekEndRegularRate = WD_REWARD;
    }

    public Integer getWE_REGULAR() {
        return WeekEndRegularRate;
    }

    public void setWE_REGULAR(Integer WE_REGULAR) {
        this.WeekEndRegularRate = WE_REGULAR;
    }

    public Integer getWE_REWARD() {
        return WeekEndReward;
    }

    public void setWE_REWARD(Integer WE_REWARD) {
        this.WeekEndReward = WE_REWARD;
    }

}
