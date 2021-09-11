package com.buschmais.gymmanagement.training;

import com.buschmais.gymmanagement.user.User;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Service;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.event.annotation.DomainEventPublisher;
import org.springframework.context.ApplicationEventPublisher;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainingService {

    private final ApplicationEventPublisher eventPublisher;
    private final TrainingRepository trainingRepository;

    public List<Training> findTraining(User providingTrainer) {
        return this.trainingRepository.findByProvidingTrainer(Association.forAggregate(providingTrainer));
    }

    public Training provideTraining(User providingTrainer, ZonedDateTime start, ZonedDateTime end) {
        Training training = new Training(providingTrainer, start, end);
        return this.trainingRepository.save(training);
    }

    @DomainEventPublisher(publishes = "TrainingContext.TrainingUpdate", type = DomainEventPublisher.PublisherType.INTERNAL)
    public void updateTraining(Training training, ZonedDateTime start, ZonedDateTime end) {
        training.setStarttime(start);
        training.setEndtime(end);
        eventPublisher.publishEvent(new TrainingUpdatedEvent(this.trainingRepository.save(training).getId(), TrainingUpdatedEvent.EventType.UPDATED));
    }

}
