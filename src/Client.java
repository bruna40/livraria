import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Client {
    private UUID idClient= UUID.randomUUID();
    private String nameClient;
    private String emailClient;
    private LocalDate clientDateBirth;
    private List<Loan> loanHistory;

    Client(String nameClient, String emailClient, LocalDate clientDateBirth) {
        this.nameClient = nameClient;
        this.emailClient = emailClient;
        this.clientDateBirth = clientDateBirth;
    }

    public UUID getIdClient() {
        return idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public String getEmailClient() {
        return emailClient;
    }

    public LocalDate getClientDateBirth() {
        return clientDateBirth;
    }

    public void setClientDateBirth(LocalDate clientDateBirth) {
        this.clientDateBirth = clientDateBirth;
    }



    @Override
    public String toString() {
        return "Clients {"  +
                "id:" + idClient +
                ", name:'" + nameClient + '\'' +
                ", email:" + emailClient+
                ", Birth:" + clientDateBirth +
                '}';
    }
}
