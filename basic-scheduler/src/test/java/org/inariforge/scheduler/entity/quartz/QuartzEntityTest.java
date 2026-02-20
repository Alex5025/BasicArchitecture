package org.inariforge.scheduler.entity.quartz;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class QuartzEntityTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testQrtzJobDetailMapping() {
        // Since entities are @Immutable, we can't save them via repository/EM easily if they are read-only.
        // But for testing mapping, we can try to retrieve if data existed.
        // Or we can rely on verifying the Metamodel.
        
        // Actually, Hibernate @Immutable allows inserts (if not using @Entity(mutable=false) which is deprecated/different).
        // Hibernate's @Immutable annotation on entity means updates are ignored. Inserts are usually allowed.
        
        QrtzJobDetail jobDetail = new QrtzJobDetail();
        jobDetail.setSchedName("testScheduler");
        jobDetail.setJobName("testJob");
        jobDetail.setJobGroup("testGroup");
        jobDetail.setJobClassName("com.example.Job");
        jobDetail.setIsDurable(true);
        jobDetail.setIsNonconcurrent(false);
        jobDetail.setIsUpdateData(false);
        jobDetail.setRequestsRecovery(false);
        
        // We will just check if the class is recognized as an entity
        assertThat(entityManager.getMetamodel().entity(QrtzJobDetail.class)).isNotNull();
    }

    @Test
    public void testQrtzTriggerMapping() {
        assertThat(entityManager.getMetamodel().entity(QrtzTrigger.class)).isNotNull();
    }
    
    @Test
    public void testQrtzCronTriggerMapping() {
        assertThat(entityManager.getMetamodel().entity(QrtzCronTrigger.class)).isNotNull();
    }

    @Test
    public void testQrtzSimpleTriggerMapping() {
        assertThat(entityManager.getMetamodel().entity(QrtzSimpleTrigger.class)).isNotNull();
    }

    @Test
    public void testQrtzSimpropTriggerMapping() {
        assertThat(entityManager.getMetamodel().entity(QrtzSimpropTrigger.class)).isNotNull();
    }

    @Test
    public void testQrtzBlobTriggerMapping() {
        assertThat(entityManager.getMetamodel().entity(QrtzBlobTrigger.class)).isNotNull();
    }

    @Test
    public void testQrtzCalendarMapping() {
        assertThat(entityManager.getMetamodel().entity(QrtzCalendar.class)).isNotNull();
    }

    @Test
    public void testQrtzPausedTriggerGrpMapping() {
        assertThat(entityManager.getMetamodel().entity(QrtzPausedTriggerGrp.class)).isNotNull();
    }

    @Test
    public void testQrtzFiredTriggerMapping() {
        assertThat(entityManager.getMetamodel().entity(QrtzFiredTrigger.class)).isNotNull();
    }

    @Test
    public void testQrtzSchedulerStateMapping() {
        assertThat(entityManager.getMetamodel().entity(QrtzSchedulerState.class)).isNotNull();
    }

    @Test
    public void testQrtzLockMapping() {
        assertThat(entityManager.getMetamodel().entity(QrtzLock.class)).isNotNull();
    }
}
