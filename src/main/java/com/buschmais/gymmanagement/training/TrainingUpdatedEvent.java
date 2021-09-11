package com.buschmais.gymmanagement.training;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jmolecules.event.annotation.DomainEvent;

@DomainEvent(namespace = "TrainingContext", name = "TrainingUpdate")
@Getter
@RequiredArgsConstructor
public class TrainingUpdatedEvent {

    private final Training.TrainingId training;
    private final EventType eventType;

    public enum EventType {
        CREATED,
        UPDATED,
        DELETED
    }

}
