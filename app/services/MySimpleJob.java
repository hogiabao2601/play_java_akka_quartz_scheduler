package services;

import akka.actor.UntypedActor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

import static utils.Contants.*;

/**
 * Created by wilson on 3/17/17.
 */

@Singleton
public class MySimpleJob extends UntypedActor {

    private static final Logger LOG = LoggerFactory.getLogger(MySimpleJob.class);

    public MySimpleJob(String message) {
        LOG.info("Initial MySimpleJob message ::: {}", message);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        LOG.info("Start simple job with message ::: {}", message);

        String strMessage = message.toString();
        if (JOB_01_MSG.equals(strMessage)) {
            LOG.info("Start job 01");
        } else if (JOB_02_MSG.equals(strMessage)) {
            LOG.info("Start job 02");
        } else {
            LOG.info("Can not understand the job");
        }
        LOG.info("Finish job");
    }
}


