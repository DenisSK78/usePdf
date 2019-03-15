package work.usepdf.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "log_update")
public class LogUpdate implements Serializable {

    private static final long serialVersionUID = 4168977867685936694L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date dateUpdate;

    @OneToOne(mappedBy = "logUpdate")
    private TextLogUpdate textLogUpdate;

    public LogUpdate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public TextLogUpdate getTextLogUpdate() {
        return textLogUpdate;
    }

    public void setTextLogUpdate(TextLogUpdate textLogUpdate) {
        this.textLogUpdate = textLogUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogUpdate logUpdate = (LogUpdate) o;
        return Objects.equals(id, logUpdate.id) &&
                Objects.equals(dateUpdate, logUpdate.dateUpdate) &&
                Objects.equals(textLogUpdate, logUpdate.textLogUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateUpdate, textLogUpdate);
    }

    @Override
    public String toString() {
        return "LogUpdate{" +
                "id=" + id +
                ", dateUpdate=" + dateUpdate +
                ", textLogUpdate=" + textLogUpdate +
                '}';
    }
}
