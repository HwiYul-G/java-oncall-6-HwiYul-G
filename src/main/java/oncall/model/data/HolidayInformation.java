package oncall.model.data;

public enum HolidayInformation {
    NEW_YEAR("신정",1, 1),
    INDEPENDENCE_MOVEMENT_DAY("삼일절",3, 1),
    CHILDREN_DAY("어린이날",5, 5),
    MEMORIAL_DAY("현충일",6, 6),
    LIBERATION_DAY("광복절",8, 15),
    NATIONAL_FOUNDATION_DAY("개천절", 10, 3),
    HANGUL_DAY("한글날",10, 9),
    CHRISTMAS("성탄절",12, 25);


    private final String holidayName;
    private final int month;
    private final int date;

    HolidayInformation(String holidayName, int month, int date){
        this.holidayName = holidayName;
        this.month = month;
        this.date = date;
    }

    public String getHolidayName() {
        return holidayName;
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    // int와 date를 이용해서 해당 날짜가 공휴일인지 아닌지 체크하는 함수
    public static boolean isHoliday(int month, int date){
        for(HolidayInformation holidayInformation : HolidayInformation.values()){
            if(holidayInformation.getMonth() == month && holidayInformation.getDate() == date){
                return true;
            }
        }
        return false;
    }
}
