package work.usepdf.model.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "text_log_update")
public class TextLogUpdate implements Serializable {

    private static final long serialVersionUID = 9121487741718028394L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String textLog;

    @OneToOne
    @JoinColumn(name = "log_update_id")
    private LogUpdate logUpdate;

    public TextLogUpdate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextLog() {
        return textLog;
    }

    public void setTextLog(String textLog) {
        this.textLog = textLog;
    }

    public LogUpdate getLogUpdate() {
        return logUpdate;
    }

    public void setLogUpdate(LogUpdate logUpdate) {
        this.logUpdate = logUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextLogUpdate that = (TextLogUpdate) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(textLog, that.textLog) &&
                Objects.equals(logUpdate, that.logUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, textLog, logUpdate);
    }

    @Override
    public String toString() {
        return "TextLogUpdate{" +
                "id=" + id +
                ", textLog='" + textLog + '\'' +
                ", logUpdate=" + logUpdate +
                '}';
    }
}
