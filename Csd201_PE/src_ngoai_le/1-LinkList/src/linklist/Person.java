package linklist;


public class Person {

    String name;
    int age;

    Person() {
    }
    
    Person(String xName, int xAge) {
        name = xName;
        age = xAge;
    }
    
    @Override
    public String toString() {
        return ("(" + name + ", " + age + ") ");
    }
}
