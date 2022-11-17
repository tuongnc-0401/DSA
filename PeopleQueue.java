import java.util.Arrays;

public class PeopleQueue {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        People peopleD = new People("s1", 66);

        People peopleA = new People("s12", 20);
        People peopleB = new People("s13", 64);
        People peopleC = new People("s14", 65);

        queue.joinQueue(peopleD);
        queue.joinQueue(peopleA);
        queue.joinQueue(peopleB);
        queue.joinQueue(peopleC);


       // queue.display();
          queue.giveUp("s13");

        System.out.println("================");
        queue.display();

    }



}

class People {
    private String ID;
    private int age;

    public People(String ID, int age) {
        this.ID = ID;
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "ID='" + ID + '\'' +
                ", age=" + age +
                '}';
    }
}
 class ArrayQueue {
    private int size;
    private static int MAX_SIZE = 100;
    private People[] items;

    public ArrayQueue() {
        size = 0;
        items = new People[100];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void joinQueue(People person) {
        // make sure the queue still have empty slot
        if (size < MAX_SIZE) {
            items[size] = person;
            size++;

        }

    }

    public People getVaccine() {
        if (isEmpty()) {
            return null;
        }
        int flag = 0;
        for (int i= 0; i < size ; i++){
            if(items[i].getAge() >=65) {
                flag =i;
                break;
            }
        }
        People peopleGetVaccine = items[flag];
        for (int i = flag; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return peopleGetVaccine;
    }

    public void giveUp(String ID) {
        int flag = 0;
        for (int i= 0; i < size ; i++){
            if(items[i].getID().equals(ID)) {
                flag =i;
                break;
            }
        }
        for (int i = flag; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
    }

    public boolean deQueue() {
        // make sure the queue is not empty
        if (isEmpty()) {
            return false;
        }
        // shifting left
        for (int i = 0; i < size - 1; i++) {
            items[i] = items[i + 1];
        }
        size--;
        return true;
    }

    public People peekFront() {
        // make sure the queue is not empty
        if (isEmpty()) {
            return null;
        }
        return items[0];
    }


     public void display() {
         for (int i = 0; i < size; i++) {
             System.out.println(items[i].toString());
         }
     }
 }

