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
@Table(name = "phrase")
public class Phrase implements Serializable {

    private static final long serialVersionUID = -266536345579335854L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String textEn;

    @NotNull
    private String textRu;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Phrase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextEn() {
        return textEn;
    }

    public void setTextEn(String textEn) {
        this.textEn = textEn;
    }

    public String getTextRu() {
        return textRu;
    }

    public void setTextRu(String textRu) {
        this.textRu = textRu;
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
        Phrase phrase = (Phrase) o;
        return Objects.equals(id, phrase.id) &&
                Objects.equals(textEn, phrase.textEn) &&
                Objects.equals(textRu, phrase.textRu) &&
                Objects.equals(user, phrase.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, textEn, textRu, user);
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "id=" + id +
                ", textEn='" + textEn + '\'' +
                ", textRu='" + textRu + '\'' +
                ", user=" + user.getId() +
                '}';
    }
}
