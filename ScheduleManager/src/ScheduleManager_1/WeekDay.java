package ScheduleManager_1;

public enum WeekDay {
    SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), 
    THURSDAY(4), FRIDAY(5), SATURDAY(6);
    
    private final int value;
    
    WeekDay(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public String getDisplayName() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}