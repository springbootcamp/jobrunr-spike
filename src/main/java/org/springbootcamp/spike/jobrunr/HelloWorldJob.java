package org.springbootcamp.spike.jobrunr;

import org.jobrunr.jobs.lambdas.JobLambda;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldJob implements JobLambda {

  private final Logger logger = LoggerFactory.getLogger(HelloWorldJob.class);


  @Override
  public void run() {
    logger.info("" +
      "\n" +
      "\n" +
      "\n" +
      "\n" +
      "HELLO WORLD" +
      "\n" +
      "\n" +
      "\n" +
      "\n" +
      "");
  }
}
