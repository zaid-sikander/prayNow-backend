package com.praynow.praynow.service;

import com.praynow.praynow.model.Masjid;
import com.praynow.praynow.repository.MasjidRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MasjidService {
    private final MasjidRepository masjidRepository;

    public MasjidService(MasjidRepository masjidRepository) {
        this.masjidRepository = masjidRepository;
    }

    public Masjid save(Masjid masjid) {
        return masjidRepository.save(masjid);
    }

    public List<Masjid> getAll() {
        return masjidRepository.findAll();
    }

    public List<Masjid> getByMasjidId(String masjidId) {
        return masjidRepository.findByMasjidId(masjidId);
    }

    public Optional<Masjid> getSchedule(String masjidId, int year, int month) {
        return masjidRepository.findByMasjidIdAndYearAndMonth(masjidId, year, month);
    }
}
