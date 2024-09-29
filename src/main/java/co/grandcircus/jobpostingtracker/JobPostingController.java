package co.grandcircus.jobpostingtracker;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    // @RequestParam(required = false) makes optional query params
    // Optional<datatype> allows whatever datatype to return null
   public List<JobPosting> GetAllJobPostings(
        @RequestParam(required = false) Optional<String> title, 
        @RequestParam(required = false) Optional<Boolean> applied,
        @RequestParam(required = false) Optional<LocalDate> appliedSince
        ) {
            if (title != null) { return jobRepo.findByTitle(title); }
            if (applied.isPresent()) { return jobRepo.findByApplied(applied); }   
            
            // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            // Date date1 = simpleDateFormat.parse("2022-12-06");
            // Date date2 = simpleDateFormat.parse("2022-12-06");
            // System.out.println(date2.compareTo(date1));

            // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
            // Date 

            // if (appliedSince.)
    return jobRepo.findAll();
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
