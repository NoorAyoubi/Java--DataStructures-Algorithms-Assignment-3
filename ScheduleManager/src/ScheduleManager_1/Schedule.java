package ScheduleManager_1;

public class Schedule {
    private final Lesson[] week;
    
    public Schedule() {
        week = new Lesson[7]; // 0=Sunday to 6=Saturday
    }
    
    public boolean addLesson(int day, String name, int startTime, int duration) {
        if (day < 0 || day > 6) return false;
        
        try {
            Lesson newLesson = new Lesson(name, startTime, duration);
            Lesson current = week[day];
            Lesson prev = null;
            
            while (current != null) {
                if (newLesson.overlapsWith(current)) {
                    return false;
                }
                if (newLesson.getStartTime() < current.getStartTime()) {
                    break;
                }
                prev = current;
                current = current.getNext();
            }
            
            if (prev == null) {
                newLesson.setNext(week[day]);
                week[day] = newLesson;
            } else {
                newLesson.setNext(current);
                prev.setNext(newLesson);
            }
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
    public String lessonAt(int day, int hour) {
        if (day < 0 || day > 6 || hour < 6 || hour >= 22) {
            return "";
        }
        
        Lesson current = week[day];
        while (current != null) {
            if (current.coversHour(hour)) {
                return current.getName();
            }
            current = current.getNext();
        }
        return "";
    }
    
    public String getAvailability() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s | Sun | Mon | Tue | Wed | Thu | Fri | Sat\n", "Hour"));
        sb.append("-----------------------------------------\n");
        
        for (int hour = 6; hour < 22; hour++) {
            sb.append(String.format("%02d:00 | ", hour));
            for (int day = 0; day < 7; day++) {
                boolean booked = false;
                Lesson current = week[day];
                while (current != null) {
                    if (current.coversHour(hour)) {
                        booked = true;
                        break;
                    }
                    current = current.getNext();
                }
                sb.append(booked ? "  X  | " : "FREE | ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public int howMuch(String lessonName) {
        int total = 0;
        for (int day = 0; day < 7; day++) {
            Lesson current = week[day];
            while (current != null) {
                if (current.getName().equals(lessonName)) {
                    total += current.getDuration();
                }
                current = current.getNext();
            }
        }
        return total;
    }
    
    public boolean equals(Schedule other) {
        if (other == null) return false;
        
        for (int day = 0; day < 7; day++) {
            Lesson current1 = week[day];
            Lesson current2 = other.week[day];
            
            while (current1 != null && current2 != null) {
                if (!current1.getName().equals(current2.getName()) ||
                    current1.getStartTime() != current2.getStartTime() ||
                    current1.getDuration() != current2.getDuration()) {
                    return false;
                }
                current1 = current1.getNext();
                current2 = current2.getNext();
            }
            
            if (current1 != null || current2 != null) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Weekly School Schedule\n");
        sb.append("======================\n\n");
        
        for (int day = 0; day < 7; day++) {
            sb.append(WeekDay.values()[day].getDisplayName()).append(":\n");
            Lesson current = week[day];
            if (current == null) {
                sb.append("  No lessons scheduled\n");
            } else {
                while (current != null) {
                    sb.append("  • ").append(current).append("\n");
                    current = current.getNext();
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
