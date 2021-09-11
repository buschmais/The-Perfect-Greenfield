package com.buschmais.gymmanagement.training;

import com.buschmais.gymmanagement.user.User;
import org.jmolecules.ddd.types.Association;
import org.jmolecules.ddd.types.Repository;
import org.jmolecules.spring.AssociationResolver;

import java.util.List;

public interface TrainingRepository extends Repository<Training, Training.TrainingId>, AssociationResolver<Training, Training.TrainingId> {

    List<Training> findByProvidingTrainer(Association<User, User.UserId> providingTrainer);

    Training save(Training training);
}
