package co.grandcircus.jobpostingtracker;
import org.springframework.data.jpa.repository.JpaRepository;

// < model, datatype>
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

}
