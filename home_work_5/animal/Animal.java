package home_work_5.animal;

import java.util.Objects;

public class Animal implements Comparable<Animal>{
    private int age;
    private String nick;

    public Animal(){}
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 15){
            this.age = age;
        }else {
            throw new IllegalArgumentException("Возраст должен быть от 1 до 15");
        }
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Animal(int age, String nick) {
        setAge(age);
        this.nick = nick;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, nick);
    }
    @Override
    public String toString(){
        return "Animal{" +
                "age='" + age + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }

    @Override
    public int compareTo(Animal o) {
        return this.nick.compareTo(o.nick);
    }
}
