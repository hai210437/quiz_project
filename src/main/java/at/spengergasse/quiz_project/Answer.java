package at.spengergasse.quiz_project;

import jakarta.persistence.*;

@Entity
@Table(name = "a_answers", schema = "quiz", catalog = "")
public class Answer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "a_id")
    private int id;
    @Basic
    @Column(name = "a_correct")
    private Boolean correct;
    @Basic
    @Column(name = "a_text")
    private String aText;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    public String getaText() {
        return aText;
    }

    public void setaText(String aText) {
        this.aText = aText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (id != answer.id) return false;
        if (correct != null ? !correct.equals(answer.correct) : answer.correct != null) return false;
        if (aText != null ? !aText.equals(answer.aText) : answer.aText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (correct != null ? correct.hashCode() : 0);
        result = 31 * result + (aText != null ? aText.hashCode() : 0);
        return result;
    }
}
