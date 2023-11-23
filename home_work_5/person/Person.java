package home_work_5.person;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private String nick;
    private String password;
    private String name;

    public Person() {
    }

    public Person(String nick, String password, String name) {
        this.nick = nick;
        setPassword(password);
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() >= 5 && password.length() <= 10) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Длинна пароля должна быть от 5 до 10 символов");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int hashCode() {
        return Objects.hash(nick, password, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
