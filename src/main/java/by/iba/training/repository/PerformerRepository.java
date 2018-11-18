package by.iba.training.repository;

import by.iba.training.entity.Event;
import by.iba.training.entity.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformerRepository extends JpaRepository<Performer, Integer> {
    //List<Performer> findAllByListOfEvents()
}
