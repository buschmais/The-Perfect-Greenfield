package com.buschmais.gymmanagement.user;

import com.buschmais.gymmanagement.user.User.UserId;
import lombok.Getter;
import lombok.Value;
import org.jmolecules.ddd.types.AggregateRoot;
import org.jmolecules.ddd.types.Identifier;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Getter
public class User implements AggregateRoot<User, UserId> {

    private final UserId id;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String firstname, String lastname, UserRole role) {
        this.id = UserId.of(UUID.randomUUID().toString());
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    @Value(staticConstructor = "of")
    public static class UserId implements Identifier {
        private final String id;
    }

    public enum UserRole {
        TRAINEE,
        TRAINER,
        MANAGER
    }
}
