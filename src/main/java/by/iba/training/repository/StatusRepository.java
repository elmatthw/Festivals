package by.iba.training.repository;

import by.iba.training.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<UserStatus, Integer> {
}
