package entities;

import java.util.Objects;

public class Vote {

    private String name;
    private Integer votes;

    public Vote(String name, Integer votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(name, vote.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
