package co.grandcircus.jobpostingtracker;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// < model, datatype>
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    // create a new method signatures
    List<JobPosting> findByTitle(Optional<String> title);
    List<JobPosting> findByApplied(Optional<Boolean> applied);
    List<JobPosting> findByDateApplied(Optional<LocalDate> appliedSince);
}
