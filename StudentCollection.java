public class StudentCollection {
    private int size;
    Student[] students;
    int MAX_SIZE = 100;

    public StudentCollection() {
        students = new Student[MAX_SIZE];
        size =0;
    }

    public static void main(String[] args) {

        StudentCollection classroom = new StudentCollection();
        Student s1 = new Student("s1","a",3.5);
        Student s2 = new Student("s2","a",3.4);
        Student s3 = new Student("s3","ABC DEF",3.4);
        Student s4 = new Student("s5","ABC DEF",3.3);

        classroom.addStudent(s1);
        classroom.addStudent(s2);
        classroom.addStudent(s3);
        classroom.addStudent(s4);

        System.out.println(classroom.rankStudent("s1"));

    }

    public void addStudent(Student std) {


        for (int i = 0; i <size ; i++) {
            if (students[i].getID().equals(std.getID())) {
                return;
            }
        }

        students[size] = std;
        size++;
    }

    public Student searchByName(String name){


        for (int i = 0; i < size; i++) {
            if (students[i].getName().contains(name)){
                return students[i];
            }
        }
        return null;
    }

    public int rankStudent(String sID) {
        double GPAofStudent = -1;
        double[] arrScore = new double[size];

        for (int i = 0; i < size; i++) {
            if (students[i].getID().equals(sID)){
                GPAofStudent =students[i].getGPA();
            }
            arrScore[i]= students[i].getGPA();
        }



        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size-1; j++) {
                if (arrScore[i]<arrScore[j]){
                    double tmp = arrScore[j];
                    arrScore[j] = arrScore[i];
                    arrScore[i]= tmp;
                }
            }
        }

        if (GPAofStudent != -1){
            for (int i = 0; i < size; i++) {
                if (arrScore[i] == GPAofStudent) {
                    return i+1;
                }
            }
        }
        return -1;
    }


    public void display(){
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
        System.out.println("size of students: "+ size);
    }

}

 class Student {
    private String ID;
    private String name;
    private double GPA;

    public Student(String ID, String name, double GPA) {
        this.ID = ID;
        this.name = name;
        this.GPA = GPA;
    }

     @Override
     public String toString() {
         return "Student{" +
                 "ID='" + ID + '\'' +
                 ", name='" + name + '\'' +
                 ", GPA=" + GPA +
                 '}';
     }

     public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
}



