package com.buschmais.gymmanagement.user;

import org.jmolecules.ddd.types.Repository;
import org.jmolecules.spring.AssociationResolver;

public interface UserRepository extends Repository<User, User.UserId>, AssociationResolver<User, User.UserId> {
    User save(User user);
}
