package work.usepdf.model;

import java.util.Objects;

public class MailResponse {
    private String massage;
    private boolean status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailResponse that = (MailResponse) o;
        return status == that.status &&
                Objects.equals(massage, that.massage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(massage, status);
    }

    @Override
    public String toString() {
        return "MailResponse{" +
                "massage='" + massage + '\'' +
                ", status=" + status +
                '}';
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public MailResponse(String massage, boolean status) {
        this.massage = massage;
        this.status = status;
    }

    public MailResponse() {
    }
}
