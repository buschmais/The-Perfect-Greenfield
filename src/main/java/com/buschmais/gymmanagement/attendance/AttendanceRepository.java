package com.buschmais.gymmanagement.attendance;

import com.buschmais.gymmanagement.training.Training;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Repository;
import org.jmolecules.spring.AssociationResolver;

import java.util.List;

public interface AttendanceRepository extends Repository<Attendance, Attendance.AttendanceId>, AssociationResolver<Attendance, Attendance.AttendanceId> {

    Attendance save(Attendance attendance);

    List<Attendance> findByAttendedTraining(Association<Training, Training.TrainingId> attendedTraining);

}
