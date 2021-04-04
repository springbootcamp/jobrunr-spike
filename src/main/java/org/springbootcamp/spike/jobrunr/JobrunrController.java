package org.springbootcamp.spike.jobrunr;

import org.jobrunr.jobs.JobId;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;

@RestController
@RequestMapping("/job")
public class JobrunrController {

  private final JobScheduler jobScheduler;
  private final SampleJobService sampleJobService;

  public JobrunrController(JobScheduler jobScheduler, SampleJobService sampleJobService) {
    this.jobScheduler = jobScheduler;
    this.sampleJobService = sampleJobService;
  }

  @GetMapping("/run-job")
  public ResponseEntity<JobId> runJob(
    @RequestParam(value = "name", defaultValue = "Hello World") String name) {

    return ResponseEntity.ok(jobScheduler.enqueue(() -> sampleJobService.execute(name)));
  }

  @GetMapping("/schedule-job")
  public ResponseEntity<JobId> scheduleJob(
    @RequestParam(value = "name", defaultValue = "Hello World") String name,
    @RequestParam(value = "when", defaultValue = "PT3H") String when) {

    return ResponseEntity.ok(jobScheduler.schedule(() ->
        sampleJobService.execute(name),
      Instant.now().plus(Duration.parse(when))
    ));
  }

}
