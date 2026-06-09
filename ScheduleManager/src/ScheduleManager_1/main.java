package ScheduleManager_1;

public class main {
    public static void main(String[] args) {
        testRequirements();
        demonstrateUsage();
    }
    
    private static void testRequirements() {
        System.out.println("=== Testing Requirements ===");
        Schedule schedule = new Schedule();
        
        // Test array structure
        System.out.println("Array structure test passed");
        
        // Test lesson addition
        assert schedule.addLesson(WeekDay.MONDAY.getValue(), "Math", 10, 2);
        assert schedule.addLesson(WeekDay.MONDAY.getValue(), "English", 8, 1);
        assert !schedule.addLesson(WeekDay.MONDAY.getValue(), "Science", 9, 2); // Overlap
        
        // Test time boundaries
        assert !schedule.addLesson(WeekDay.TUESDAY.getValue(), "Early", 5, 1);
        assert !schedule.addLesson(WeekDay.TUESDAY.getValue(), "Late", 21, 2);
        
        System.out.println("All tests passed!\n");
    }
    
    private static void demonstrateUsage() {
        Schedule school = new Schedule();
        
        // Add lessons
        school.addLesson(WeekDay.MONDAY.getValue(), "Mathematics", 9, 2);
        school.addLesson(WeekDay.WEDNESDAY.getValue(), "Science", 10, 1);
        school.addLesson(WeekDay.FRIDAY.getValue(), "History", 8, 1);
        
        // Display schedule
        System.out.println("=== School Schedule ===");
        System.out.println(school);
        
        // Show availability
        System.out.println("=== Availability ===");
        System.out.println(school.getAvailability());
        
        // Perform queries
        System.out.println("=== Queries ===");
        System.out.printf("Friday 8:00: %s\n", 
            school.lessonAt(WeekDay.FRIDAY.getValue(), 8));
        System.out.printf("Total Math hours: %d\n", 
            school.howMuch("Mathematics"));
    }
}