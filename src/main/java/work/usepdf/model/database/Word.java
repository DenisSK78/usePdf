package work.usepdf.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "word")
public class Word implements Serializable {

    private static final long serialVersionUID = 7701214892707413276L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String wordEn;

    @NotNull
    private String wordRu;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Word() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWordEn() {
        return wordEn;
    }

    public void setWordEn(String wordEn) {
        this.wordEn = wordEn;
    }

    public String getWordRu() {
        return wordRu;
    }

    public void setWordRu(String wordRu) {
        this.wordRu = wordRu;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(id, word.id) &&
                Objects.equals(wordEn, word.wordEn) &&
                Objects.equals(wordRu, word.wordRu) &&
                Objects.equals(user, word.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wordEn, wordRu, user);
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", wordEn='" + wordEn + '\'' +
                ", wordRu='" + wordRu + '\'' +
                ", user=" + user.getId() +
                '}';
    }
}
