package com.lucasbsilva.clinagenda.controller;

import com.lucasbsilva.clinagenda.model.Status;
import com.lucasbsilva.clinagenda.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<Status> getAllStatus() {
        return statusService.getAllStatus();
    }

    @GetMapping("/{id}")
    public Status getStatusById(@PathVariable Integer id) { return statusService.getStatusById(id); }

    @PostMapping
    public Status createStatus(@RequestBody Status status){
        return statusService.saveStatus(status);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Integer id) {
        statusService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Integer id, @RequestBody Status status){
        Status updatedStatus = statusService.updateStatus(id, status);
        return ResponseEntity.ok(updatedStatus);
    }
}
