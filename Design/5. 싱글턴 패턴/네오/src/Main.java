import user.User;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        User[] users = {
                new User("김말랑"),
                new User("김사장"),
                new User("김과장"),
                new User("김부장"),
                new User("김대리")
        };

        Arrays.stream(users).parallel().forEach(User::run);
    }
}
