import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface PersonService {
     String  createPeople(List<Student>students);
     List<Student> getAllPeople();
     Map<Integer,Student> getAge();
     String  getDuty(String name, String takeName, BigDecimal money);
     List<Student> findByName(String name);
     String  removeById(int id);
     List<Student> findById(int id);
}
