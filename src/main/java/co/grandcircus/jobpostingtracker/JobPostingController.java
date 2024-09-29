package co.grandcircus.jobpostingtracker;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController // assigns class as controller 
public class JobPostingController {

    @Autowired // dependecy injection
    private JobPostingRepository jobRepo; // gives access to everything 

   @GetMapping("/") // base endpoint
   public String TestingTesting() {
       return "HelloHiHey! :-)";
   }

   @GetMapping("/Jobs") // returns all job postings
   public List<JobPosting> GetAllJobPostings() {
       return jobRepo.findAll();

       // should initally return an empty [] because there is currently no data
   }

   @PostMapping("/Jobs")  
   // @RequestBody takes in datatype JobPosting from body 
   public JobPosting AddJobPostings(@RequestBody JobPosting newPosting) {
       newPosting.setId(null); // no incoming entity has an id  
       jobRepo.save(newPosting);
       return newPosting;
   }

   @GetMapping("/Jobs/{id}")
   // @PathVariable signals a path param 
   public JobPosting GetByJobPostingId(@PathVariable("id") Long id) {
       return jobRepo.findById(id).orElse(null);
   }
}
