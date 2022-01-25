package com.example.AutoGarage.service.implementation;



import com.example.AutoGarage.entity.MechanicActions;
import com.example.AutoGarage.repository.MechanicActionsRepository;
import com.example.AutoGarage.service.MechanicActionsService;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MechanicActionsServiceImpl implements MechanicActionsService {

    private MechanicActionsRepository mechanicActionsRepository;
    private RepairServiceImpl repairService;

    public MechanicActionsServiceImpl(MechanicActionsRepository mechanicActionsRepository, RepairServiceImpl repairService){
        this.mechanicActionsRepository = mechanicActionsRepository;
        this.repairService = repairService;
    }

    @Override
    public List<MechanicActions>getAllMechanicActions(){return mechanicActionsRepository.findAll();}

    @Override
    public MechanicActions getMechanicAction(Long mechanicActionsId){
        MechanicActions mechanicActions = mechanicActionsRepository.findById(mechanicActionsId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Handeling met id: %s niet gevonden",mechanicActionsId))
        );
                return mechanicActions;
    }

    @Override
    public MechanicActions createMechanicAction(MechanicActions mechanicActions) {
        Optional<MechanicActions> mechanicActionsOptional = mechanicActionsRepository.findById(mechanicActions.getId());
        if(mechanicActionsOptional.isPresent()){
            throw new IllegalStateException("Deze actie is al bekend");
        }
        mechanicActionsRepository.save(mechanicActions);
        return null;
    }


}
