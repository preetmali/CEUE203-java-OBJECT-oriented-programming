
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {
    @Column(name = "Student_ID")
    int id;

    @Column(name = "Student_Name")
    String name;

    @Column(name = "Student_Age")
    int age;

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class ColumnMappingDemo {

    public static void main(String[] args) throws Exception {

        String[] headers = {
                "Student_ID", "Student_Name"
        };

        String[] data = {
                "101", "Rahul"
        };

        Student s = new Student();

        for (Field field : Student.class.getDeclaredFields()) {

            Column column = field.getAnnotation(Column.class);

            if (column != null) {

                int index = -1;

                for (int i = 0; i < headers.length; i++) {
                    if (headers[i].equals(column.name())) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println(
                            "Missing column: " + column.name());
                    continue;
                }

                field.setAccessible(true);

                if (field.getType() == int.class) {
                    field.setInt(s, Integer.parseInt(data[index]));
                } else if (field.getType() == String.class) {
                    field.set(s, data[index]);
                }
            }
        }

        System.out.println("\nStudent Details:");
        s.display();
        System.out.println("25CE057");
    }
}
