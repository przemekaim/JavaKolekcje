package pl.java.kolekcje;

public class Anime implements Comparable<Anime> {
    @Override
    public int compareTo(Anime o) {
        return name.compareTo(o.name);
    }

    public enum Status {
        DROPPED,COMPLETED, WATCHING, PLAN
    }

    private String name;
    private int episodes;
    private Status status;

    public Anime(String name, int episodes, Status status) {
        this.name = name;
        this.episodes = episodes;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  name + " " + episodes + " " + status;
    }
}
