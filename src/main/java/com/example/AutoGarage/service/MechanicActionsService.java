package com.example.AutoGarage.service;


import com.example.AutoGarage.entity.MechanicActions;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MechanicActionsService {

    List<MechanicActions>getAllMechanicActions();
    MechanicActions getMechanicAction(Long mechanicActionsId);
    MechanicActions createMechanicAction(MechanicActions mechanicActions);


}
