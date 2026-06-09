package ScheduleManager_1;

public class Lesson {
    private String name;
    private int startTime;
    private int duration;
    private Lesson next;
    
    public Lesson(String name, int startTime, int duration) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Lesson name must be non-empty");
        }
        if (startTime < 6 || startTime > 21) {
            throw new IllegalArgumentException("Start time must be between 6 and 21");
        }
        if (duration <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        if (startTime + duration > 22) {
            throw new IllegalArgumentException("Lesson must end by 22:00");
        }
        
        this.name = name;
        this.startTime = startTime;
        this.duration = duration;
    }
    
    // Getters and other methods
    public String getName() { return name; }
    public int getStartTime() { return startTime; }
    public int getDuration() { return duration; }
    public Lesson getNext() { return next; }
    public void setNext(Lesson next) { this.next = next; }
    
    public int getEndTime() {
        return startTime + duration;
    }
    
    public boolean coversHour(int hour) {
        return hour >= 6 && hour < 22 && hour >= startTime && hour < getEndTime();
    }
    
    public boolean overlapsWith(Lesson other) {
        return !(getEndTime() <= other.getStartTime() || other.getEndTime() <= startTime);
    }
    
    @Override
    public String toString() {
        return String.format("%s (%02d:00-%02d:00)", name, startTime, getEndTime());
    }
}