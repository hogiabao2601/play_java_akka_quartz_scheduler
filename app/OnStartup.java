import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.ExtendedActorSystem;
import akka.actor.Props;
import com.typesafe.akka.extension.quartz.QuartzSchedulerExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.MySimpleJob;

import javax.inject.Inject;

import static utils.Contants.JOB_01_MSG;
import static utils.Contants.JOB_02_MSG;

/**
 * Created by wilson on 3/17/17.
 */
public class OnStartup {
    private static final Logger LOG = LoggerFactory.getLogger(OnStartup.class);
    private final ActorSystem system = ActorSystem.create("system_onStartup");
    private static final String SIMPLE_JOB_CONFIG = "SimpleJob";
    private static final String JOB_01_CONFIG = "Job01";
    private static final String JOB_02_CONFIG = "Job02";

    /**
     * job starter on application startup
     */
    @Inject
    public OnStartup() {
        LOG.info("start :: OnStartup()");
        ActorRef mySimpleJob = system.actorOf(Props.create(MySimpleJob.class, "MySimpleJob"));

        QuartzSchedulerExtension scheduler = new QuartzSchedulerExtension((ExtendedActorSystem) system);

        scheduler.schedule(new StringBuilder()
                .append(SIMPLE_JOB_CONFIG)
                .append("-")
                .append(JOB_01_CONFIG).toString(), mySimpleJob, JOB_01_MSG);

        scheduler.schedule(new StringBuilder()
                .append(SIMPLE_JOB_CONFIG)
                .append("-")
                .append(JOB_02_CONFIG).toString(), mySimpleJob, JOB_02_MSG);


        LOG.info("end :: OnStartup()");
    }
}
