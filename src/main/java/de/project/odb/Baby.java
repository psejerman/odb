package de.project.odb;

public class Baby extends Dataset{
    private String name;
    private int age;
    private boolean funny;

    public Baby() {

    }

    public Baby(String name, Integer age, boolean funny) {
        this.name = name;
        this.age = age;
        this.funny = funny;
    }

    @Override
    public String toString() {
        return "Baby{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", funny=" + funny +
                ", id=" + id +
                '}';
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

    public boolean isFunny() {
        return funny;
    }

    public void setFunny(boolean funny) {
        this.funny = funny;
    }
}
