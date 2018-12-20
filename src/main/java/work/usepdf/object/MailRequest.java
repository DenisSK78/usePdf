package work.usepdf.object;

import java.util.Objects;

public class MailRequest {
    private String name;
    private String to;
    private String from;
    private String subject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailRequest that = (MailRequest) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(to, that.to) &&
                Objects.equals(from, that.from) &&
                Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, to, from, subject);
    }

    public MailRequest(String name, String to, String from, String subject) {
        this.name = name;
        this.to = to;
        this.from = from;
        this.subject = subject;
    }

    public MailRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "MailRequest{" +
                "name='" + name + '\'' +
                ", to='" + to + '\'' +
                ", from='" + from + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
