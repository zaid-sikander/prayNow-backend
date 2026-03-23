package com.praynow.praynow.controller;

import com.praynow.praynow.model.Masjid;
import com.praynow.praynow.service.MasjidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/masjids")
public class MasjidController {
    private final MasjidService masjidService;

    public MasjidController(MasjidService masjidService) {
        this.masjidService = masjidService;
    }

    @PostMapping
    public ResponseEntity<Masjid> create(@RequestBody Masjid masjid) {
        return ResponseEntity.ok(masjidService.save(masjid));
    }

    @GetMapping
    public ResponseEntity<List<Masjid>> getAll() {
        return ResponseEntity.ok(masjidService.getAll());
    }

    @GetMapping("/{masjidId}")
    public ResponseEntity<List<Masjid>> getByMasjidId(@PathVariable String masjidId) {
        return ResponseEntity.ok(masjidService.getByMasjidId(masjidId));
    }

    @GetMapping("/{masjidId}/{year}/{month}")
    public ResponseEntity<Masjid> getSchedule(
            @PathVariable String masjidId,
            @PathVariable int year,
            @PathVariable int month) {
        return masjidService.getSchedule(masjidId, year, month)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
