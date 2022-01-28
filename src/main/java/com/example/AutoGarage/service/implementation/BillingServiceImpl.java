package com.example.AutoGarage.service.implementation;

import com.example.AutoGarage.dto.CustomerDto;
import com.example.AutoGarage.dto.PartOrderLineDto;
import com.example.AutoGarage.entity.Repair;
import com.example.AutoGarage.repository.BillingRepository;
import com.example.AutoGarage.repository.RepairRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class BillingServiceImpl {
    private final BillingRepository billingRepository;
    private final RepairRepository repairRepository;

    public BillingServiceImpl(BillingRepository billingRepository, RepairRepository repairRepository)  {
        this.billingRepository = billingRepository;
        this.repairRepository = repairRepository;
    }

    public void writeInvoice(Long repairId) throws IOException {

        //Deze zorgt voor het opmaken van de factuur. De factuur wordt in een .txt bestand uitgedraaid in intellij zelf.
        //In de buurt van het POM.xml bestand.
        List<PartOrderLineDto> partOrderLineDtoList = billingRepository.getPartOrderLines(repairId);
        Repair repair = repairRepository.getById(repairId);
        Long carId = repair.getCar().getId();
        CustomerDto customerDto = billingRepository.getCustomerData(carId);
        Integer totalPrice = 0;

        File file = new File("Factuur.txt");

        FileWriter fileWriter = new FileWriter(file);

        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.println("Factuur reparatie van klant");
        printWriter.println("---------------------------------------");
        printWriter.println(customerDto.getFirstName());
        printWriter.println(customerDto.getLastName());
        printWriter.println(customerDto.getPhoneNR());
        printWriter.println("---------------------------------------");
        printWriter.println("Auto");
        printWriter.println("---------------------------------------");
        printWriter.println(customerDto.getBrand());
        printWriter.println(customerDto.getModel());
        printWriter.println(customerDto.getRegistrationPlate());
        printWriter.println("---------------------------------------");
        printWriter.println("Onderdelen");
        printWriter.println("---------------------------------------");
        for(int i=0;i<partOrderLineDtoList.size();i++){
            printWriter.println("Omschrijving: " + partOrderLineDtoList.get(i).getPartName());
            printWriter.println("Prijs per stuk: " + partOrderLineDtoList.get(i).getPartPrice());
            printWriter.println("Aantal: " + partOrderLineDtoList.get(i).getQuantity());
            printWriter.println("Totaalprijs : " + partOrderLineDtoList.get(i).getTotalPrice());
            printWriter.println("\n");
            totalPrice += partOrderLineDtoList.get(i).getTotalPrice();
        }
        printWriter.println("---------------------------------------");
        printWriter.println("Totaal bedrag: ");
        printWriter.println(totalPrice);
        printWriter.println("---------------------------------------");
        printWriter.println("Totaalprijs met btw 21%: ");
        printWriter.println(totalPrice * 1.21);
        printWriter.println("---------------------------------------");
        printWriter.close();
    }
}
