package co.grandcircus.jobpostingtracker;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // tells java api (thing that connects it to the db that this is a model)
public class JobPosting {

    @GeneratedValue(strategy = GenerationType.IDENTITY) // tells id to auto increment using identity
    @Id // vvv makes the primary key vvv 
    private Long id;
    private String title;
    private String company;
    private boolean applied;
    private LocalDate dateApplied;
    private String result;

    // overloaded constructor 
    public JobPosting() {
    }

    // constructors
    public JobPosting(Long id, String title, String company, boolean applied, LocalDate dateApplied, String result) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.applied = applied;
        this.dateApplied = dateApplied;
        this.result = result;
    }

    // getters + setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public boolean isApplied() {
        return applied;
    }
    public void setApplied(boolean applied) {
        this.applied = applied;
    }
    public LocalDate getDateApplied() {
        return dateApplied;
    }
    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    
}
