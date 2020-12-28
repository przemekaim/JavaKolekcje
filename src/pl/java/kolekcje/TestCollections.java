package pl.java.kolekcje;

import java.util.Comparator;
import java.util.Objects;

public class TestCollections implements Comparable<TestCollections>{
    private String name;
    private int number;

    public TestCollections() {
    }

    public TestCollections(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return name + " " +
                number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCollections that = (TestCollections) o;
        return number == that.number && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public int compareTo(TestCollections o) {
        // return name.compareTo(o.name);
        return Integer.compare(this.number, o.number);
    }
}
