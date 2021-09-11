package com.buschmais.gymmanagement;

import com.buschmais.gymmanagement.attendance.Attendance;
import com.buschmais.gymmanagement.attendance.AttendanceRepository;
import com.buschmais.gymmanagement.attendance.AttendanceService;
import com.buschmais.gymmanagement.training.Training;
import com.buschmais.gymmanagement.training.TrainingService;
import com.buschmais.gymmanagement.user.User;
import com.buschmais.gymmanagement.user.UserService;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.jmolecules.ddd.types.Association;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.time.ZonedDateTime;

@SpringBootTest
@RequiredArgsConstructor
public class UpdateTrainingTest {

    @SpyBean
    private AttendanceService attendanceService;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private TrainingService trainingService;
    @Autowired
    private UserService userService;

    @Test
    public void testUpdateTraining() {
        User trainer = this.userService.createUser("Stephan", "Trainer", User.UserRole.TRAINER);
        User trainee = this.userService.createUser("Stephan", "Trainee", User.UserRole.TRAINEE);
        Training training = this.trainingService.provideTraining(trainer, ZonedDateTime.now().plusHours(2), ZonedDateTime.now().plusHours(4));
        this.attendanceService.attend(trainee, training);
        attendanceRepository.findByAttendedTraining(Association.forAggregate(training))
                .forEach(a -> Assertions.assertThat(a.getRegistrationStatus()).isEqualTo(Attendance.RegistrationStatus.CONFIRMED));

        this.trainingService.findTraining(trainer).forEach(t -> this.trainingService.updateTraining(t, t.getStarttime().plusHours(1), t.getEndtime().plusHours(1)));

        Mockito.verify(attendanceService, Mockito.times(1)).on(Mockito.any());
        attendanceRepository.findByAttendedTraining(Association.forAggregate(training))
                .forEach(a -> Assertions.assertThat(a.getRegistrationStatus()).isEqualTo(Attendance.RegistrationStatus.NOT_CONFIRMED));

    }
}
