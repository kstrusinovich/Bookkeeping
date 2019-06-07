package by.bookkeeping.spring.model;

public class Family {

    private int id;
    private String fio;
    private String family_member;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFamily_member() {
        return family_member;
    }

    public void setFamily_member(String family_member) {
        this.family_member = family_member;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", family_member='" + family_member + '\'' +
                ", age=" + age +
                '}';
    }
}
