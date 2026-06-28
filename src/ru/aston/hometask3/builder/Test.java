package ru.aston.hometask3.builder;

public class Test {
    public static void main(String[] args) {
        User user1 = User.builder()
                .firstName("Иван")
                .lastName("Иванов")
                .email("ivan@example.com")
                .age(21)
                .gender(User.Gender.Male)
                .active(false)
                .build();
        System.out.println("Test 1 completed successfully " + user1);

        User user2 = User.builder()
                .firstName("Татьяна")
                .lastName("Петрова")
                .email("tatyana@example.com")
                .age(20)
                .gender(User.Gender.Female)
                .active(true)
                .build();

        System.out.println("Test 2 completed successfully " + user2);
    }
}
