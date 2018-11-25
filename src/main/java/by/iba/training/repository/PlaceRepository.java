package by.iba.training.repository;

import by.iba.training.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Integer> {
    Place findByPlaceNameEquals(String placeName);
}
