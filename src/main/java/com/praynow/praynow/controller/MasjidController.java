package com.praynow.praynow.controller;

import com.praynow.praynow.model.Masjid;
import com.praynow.praynow.service.MasjidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/api/masjids")
public class MasjidController {
    private final MasjidService masjidService;

    public MasjidController(MasjidService masjidService) {
        this.masjidService = masjidService;
    }

    @Operation(summary = "Add a Masjid Schedule")
    @ApiResponse(responseCode = "200", description = "Schedule added success")
    @ApiResponse(responseCode = "403", description = "Missing or invalid JWT token")
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping
    public ResponseEntity<Masjid> create(@RequestBody Masjid masjid) {
        return ResponseEntity.ok(masjidService.save(masjid));
    }

    @Operation(summary = "Get all Masjid's schedules")
    @ApiResponse(responseCode =  "200", description = "Success")
    @GetMapping
    public ResponseEntity<List<Masjid>> getAll() {
        return ResponseEntity.ok(masjidService.getAll());
    }

    @Operation(summary = "Get all the schedules for a Masjid by Id")
    @ApiResponse(responseCode =  "200", description = "Success")
    @ApiResponse(responseCode =  "404", description = "Masjid not Found")
    @GetMapping("/{masjidId}")
    public ResponseEntity<List<Masjid>> getByMasjidId(@PathVariable String masjidId) {
        return ResponseEntity.ok(masjidService.getByMasjidId(masjidId));
    }

    @Operation(summary = "Get the schedule for a Masjid by Id, year, and month")
    @ApiResponse(responseCode =  "200", description = "Success")
    @ApiResponse(responseCode =  "404", description = "Masjid, Id, or year not Found")
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
