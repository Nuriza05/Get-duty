import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PersonServiceImpl implements PersonService{
    List<Student> students = new LinkedList<>();


    @Override
    public String createPeople(List<Student> students) {
        this.students.addAll(students);
        return "Students are successfully created!";
    }

    @Override
    public List<Student> getAllPeople() {
        return students;
    }

    @Override
    public Map<Integer,Student> getAge() {
        Map<Integer, Student> studentMap = new HashMap<>();
        for (Student student : this.students) {
            int years = Period.between(student.getDateOfBirth(), LocalDate.now()).getYears();
            studentMap.put(years, student);
        }
        return studentMap;
    }

    @Override
    public String getDuty(String name, String takeName, BigDecimal money) {
        for (Student student : this.students) {
            if(student.getName().equals(name)){
                for (Student student1 : this.students) {
                    if(student1.getName().equals(takeName)) {
                        int v =student1.getMoney().subtract(money).intValue();
                        if(v>=0){
                            student1.setMoney(student1.getMoney().subtract(money));
                            student.setMoney(student.getMoney().add(money));
                        }
                        else{
                            return "Don't have enough money!";
                        }
                    }
                }
            }
        }
        return "Sozsuz ertten beresin!";
    }

    @Override
    public List<Student> findByName(String name) {
        List<Student>students1 = new LinkedList<>();
        for (Student student : this.students) {
            if(student.getName().equals(name)){
                students1.add(student);
            }
        }return students1;
    }

    @Override
    public String removeById(int id) {
        for (Student student : this.students) {
            if(student.getId()==id) {
         this.students.remove(student);
            }
        }
        return "Student is successfully removed!";
    }

    @Override
    public List<Student> findById(int id) {
        List<Student>students1=new LinkedList<>();
        for (Student student : this.students) {
            if(student.getId()==id){
                students1.add(student);
            }
            else {
                System.out.println("No such person!");
            }
        } return students1;
    }
}
