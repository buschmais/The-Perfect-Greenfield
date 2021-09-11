package com.buschmais.gymmanagement.training;

import com.buschmais.gymmanagement.training.Training.TrainingId;
import com.buschmais.gymmanagement.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Identifier;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
public class Training implements AggregateRoot<Training, TrainingId> {

    private final TrainingId id;
    @Setter
    private ZonedDateTime starttime;
    @Setter
    private ZonedDateTime endtime;
    private Association<User, User.UserId> providingTrainer;

    public Training(User providingTrainer, ZonedDateTime starttime, ZonedDateTime endtime) {
        this.id = TrainingId.of(UUID.randomUUID().toString());
        this.starttime = starttime;
        this.endtime = endtime;
        this.providingTrainer = Association.forAggregate(providingTrainer);
    }

    @Value(staticConstructor = "of")
    public static class TrainingId implements Identifier {
        private final String id;
    }
}
