package pl.java.kolekcje;

public class RandomStrings implements Comparable<RandomStrings> {
    private String randomName;

    public RandomStrings(String randomName) {
        this.randomName = randomName;
    }

    public String getRandomName() {
        return randomName;
    }

    public void setRandomName(String randomName) {
        this.randomName = randomName;
    }

    @Override
    public String toString() {
        return randomName;
    }

    @Override
    public int compareTo(RandomStrings o) {
        return this.randomName.compareTo(o.randomName);
    }
}
