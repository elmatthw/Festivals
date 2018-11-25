package by.iba.training.repository;

import by.iba.training.entity.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Integer> {
    EventType findByType(String type);
}
