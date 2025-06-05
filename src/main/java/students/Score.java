package students;

import java.util.Objects;

public record Score(String name, String subject, int score) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Score) obj;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.subject, that.subject) &&
                this.score == that.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subject, score);
    }

    @Override
    public String toString() {
        return "Score[" +
                "name=" + name + ", " +
                "subject=" + subject + ", " +
                "score=" + score + ']';
    }

}
