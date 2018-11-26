package by.iba.training.repository;

import by.iba.training.entity.User;
import by.iba.training.entity.UserOnEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserOnEventRepository extends JpaRepository<UserOnEvent, Integer> {
    List<UserOnEvent> findUserOnEventsByUser(User user);
}
