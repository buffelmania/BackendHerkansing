package com.example.AutoGarage.controller;


import com.example.AutoGarage.entity.MechanicActions;
import com.example.AutoGarage.service.MechanicActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/monteurActies")
public class MechanicActionsController {

    private final MechanicActionsService mechanicActionsService;

    @Autowired
    public MechanicActionsController(MechanicActionsService mechanicActionsService){
        this.mechanicActionsService = mechanicActionsService;
    }

    @GetMapping("")
    public List<MechanicActions>getAllMechanicActions() {
        return mechanicActionsService.getAllMechanicActions();}

    @GetMapping("{mechanicActionsId}")
    public MechanicActions getMechanicAction(@PathVariable Long mechanicActionsId)throws EntityNotFoundException {
        return mechanicActionsService.getMechanicAction(mechanicActionsId);
    }

    @PostMapping(path = "")
    public ResponseEntity<?> createMechanicAction(@RequestBody MechanicActions mechanicActions) {
        mechanicActionsService.createMechanicAction(mechanicActions);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mechanicActions.getId())
                .toUri();
        return ResponseEntity.created(uri).body(uri);
    }
}
