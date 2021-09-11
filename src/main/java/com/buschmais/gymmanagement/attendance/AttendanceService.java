package com.buschmais.gymmanagement.attendance;

import com.buschmais.gymmanagement.training.Training;
import com.buschmais.gymmanagement.training.TrainingUpdatedEvent;
import com.buschmais.gymmanagement.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jmolecules.ddd.annotation.Service;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.event.annotation.DomainEventHandler;

@Service
@Slf4j
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public Attendance attend(User user, Training training) {
        Attendance attendance = new Attendance(user, training);
        return this.attendanceRepository.save(attendance);
    }

    @DomainEventHandler(namespace = "TrainingContext", name = "TrainingUpdate")
    public void on(TrainingUpdatedEvent trainingUpdatedEvent) {
        log.info("Received Event");
        this.attendanceRepository.findByAttendedTraining(Association.forId(trainingUpdatedEvent.getTraining())).forEach(a -> {
            a.setRegistrationStatus(Attendance.RegistrationStatus.NOT_CONFIRMED);
            this.attendanceRepository.save(a);
        });
    }
}
