package com.praynow.praynow.repository;

import com.praynow.praynow.model.Masjid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MasjidRepository extends MongoRepository<Masjid, String> {
    List<Masjid> findByMasjidId(String masjidId);
    List<Masjid> findByCity(String city);
    Optional<Masjid> findByMasjidIdAndYearAndMonth(String masjidId, int year, int month);
}
