package com.buschmais.gymmanagement.attendance;

import com.buschmais.gymmanagement.attendance.Attendance.AttendanceId;
import com.buschmais.gymmanagement.training.Training;
import com.buschmais.gymmanagement.user.User;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Identifier;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Getter
public class Attendance implements AggregateRoot<Attendance, AttendanceId> {

    private final AttendanceId id;
    private Association<User, User.UserId> attendingTrainee;
    private Association<Training, Training.TrainingId> attendedTraining;
    @Enumerated(EnumType.STRING)
    @Setter
    private RegistrationStatus registrationStatus;

    public Attendance(User attendingTrainee, Training attendedTraining) {
        this.id = AttendanceId.of(UUID.randomUUID().toString());
        this.attendingTrainee = Association.forAggregate(attendingTrainee);
        this.attendedTraining = Association.forAggregate(attendedTraining);
        this.registrationStatus = RegistrationStatus.CONFIRMED;
    }

    @Value(staticConstructor = "of")
    public static class AttendanceId implements Identifier {
        private final String id;
    }

    public enum RegistrationStatus {
        CONFIRMED,
        NOT_CONFIRMED
    }

}
