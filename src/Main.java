import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Nuriza", LocalDate.of(2005, 2, 5), Gender.FEMALE, BigDecimal.valueOf(10000), 1);
        Student s2 = new Student("Adil", LocalDate.of(2004, 2, 17), Gender.MALE, BigDecimal.valueOf(15000), 2);
        Student s3 = new Student("Eliza", LocalDate.of(2002, 5, 22), Gender.FEMALE, BigDecimal.valueOf(20000), 3);
        Student s4 = new Student("Nursultan", LocalDate.of(2000, 8, 20), Gender.MALE, BigDecimal.valueOf(2000), 4);

        List<Student> students = new LinkedList<>(Arrays.asList(s1, s2, s3, s4));

        PersonServiceImpl person = new PersonServiceImpl();
        while (true) {
            System.out.println("""
                    1. Create people!
                    2. Get all people!
                    3. Get age!
                    4. Get duty!
                    5. Find by name!
                    6. Remove by ID!
                    7. Find by id!
                    """);
            int number = new Scanner(System.in).nextInt();
            if (number == 1) {
                System.out.println(person.createPeople(students));
            } else if (number == 2) {
                System.out.println(person.getAllPeople());
            } else if (number == 3) {
                System.out.println(person.getAge());
            } else if (number == 4) {
                System.out.print("Kim karyz alat atyn jaz: ");
                String n = new Scanner(System.in).next();
                System.out.print("Kaisyl adamdan alat: ");
                String v = new Scanner(System.in).next();
                System.out.print("Kanca som alat: ");
                BigDecimal bigDecimal = BigDecimal.valueOf(new Scanner(System.in).nextInt());
                System.out.println(person.getDuty(n, v, bigDecimal));
            } else if (number == 5) {
                System.out.print("Write the name: ");
                String name = new Scanner(System.in).next();
                System.out.println(person.findByName(name));
            } else if (number == 6) {
                System.out.print("Write the id: ");
                int id = new Scanner(System.in).nextInt();
                System.out.println(person.removeById(id));
            } else if (number == 7) {
                System.out.print("Write the id: ");
                int id1 = new Scanner(System.in).nextInt();
                System.out.println(person.findById(id1));
            } else {
                System.out.println("Myndai san jok!");
            }
        }
    }
}