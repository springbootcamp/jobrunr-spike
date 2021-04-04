package org.springbootcamp.spike.jobrunr;

import org.jobrunr.scheduling.BackgroundJob;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JobrunrSpikeApplicationTests {

  private final Logger logger = LoggerFactory.getLogger(JobrunrSpikeApplicationTests.class);

	@Test
	void contextLoads() {
	}

  @Test
  void name() {
    BackgroundJob.enqueue(() -> { logger.info("hello world"); });
  }
}
