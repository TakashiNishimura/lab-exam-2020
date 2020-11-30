package csv;

import java.util.Comparator;

public class Main {
  public static void main(String[] args) {
    var users = new UserCsvReader().readUserCsv("users.csv");
    // TODO Q2.1
    users.stream()
        .filter(user -> user.getCode().contains("m"))
        .peek(user -> user.setName(user.getName().toLowerCase()))
        .sorted(Comparator.comparing(User::getName))
        .forEach(user -> System.out.println(user.getName() + ", " + user.getCode() + ", " + user.getGrade()));
  }
}
