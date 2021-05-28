package de.project.odb;

public class Baby extends Dataset{
    private String name;
    private int age;

    public Baby() {

    }

    public Baby(String name, int age) {
        super.setId();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        System.out.println("Baby:");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("id:" + super.getId());
        System.out.println("Vorname:" + this.name);
        System.out.println("Alter:" + age);
        return "string";
    }
    public void printData() {
        System.out.println("Baby:");
        System.out.println("--------------------------------:");
        System.out.println("id:" + super.getId());
        System.out.println("Vorname:" + this.name);
        System.out.println("Alter:" + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
