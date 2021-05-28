public class Baby extends Dataset{
    private String name;
    private int age;

    public Baby(String name, int age) {
        super.setId();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Baby{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
