package co.grandcircus.jobpostingtracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController // assigns class as controller 
public class JobPostingController {

    @Autowired // dependecy injection
    private JobPostingRepository jobRepo; // gives access to everything 
}
