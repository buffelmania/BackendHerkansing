package com.example.AutoGarage;

import com.example.AutoGarage.dto.PartOrderLineDto;
import com.example.AutoGarage.entity.*;
import com.example.AutoGarage.repository.*;
import com.example.AutoGarage.service.RepairPartLineService;
import com.example.AutoGarage.service.RepairService;
import com.example.AutoGarage.service.implementation.BillingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
public class AutoGarageApplication implements CommandLineRunner {

	@Autowired
	private final CustomerRepository customerRepository;
	private final CarRepository carrepository;
	private final PartRepository partRepository;
	private final RepairService repairService;
	private final BillingRepository billingRepository;
	private final BillingServiceImpl billingService;
	private final RepairPartLineService repairPartLineService;

	public AutoGarageApplication(CustomerRepository customerRepository,
                                 CarRepository carrepository, PartRepository partRepository, RepairService repairService, BillingRepository billingRepository, BillingServiceImpl billingService, RepairPartLineService repairPartLineService) {
		this.customerRepository = customerRepository;
		this.carrepository = carrepository;
		this.partRepository = partRepository;
		this.repairService = repairService;
		this.billingRepository = billingRepository;
		this.billingService = billingService;
		this.repairPartLineService = repairPartLineService;
	}

	public static void main(String[] args) {
		SpringApplication.run(AutoGarageApplication.class, args);
	}



	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Part uitlaat = new Part("Uitlaat",100);
		Part remschijf = new Part("Remschijf",50);
		Part oliefilter = new Part("Oliefilter",20);

		partRepository.saveAll(List.of(uitlaat,remschijf,oliefilter));

		Customer customer = new Customer("Willem","van der Bijl","w.vanderBijl@belastingparadijd.nl","06-23424224");
		customerRepository.save(customer);

		Car car = new Car("Audi", "A3","GHJ-21-J");
		car.setCustomer(customer);
		car = carrepository.save(car);

		repairService.saveRepair(car.getId());

		repairPartLineService.saveRepairPartLine(1L,1L);
		repairPartLineService.saveRepairPartLine(1L,2L);
		repairPartLineService.saveRepairPartLine(1L,3L);


//		CustomerDto dto = billingRepository.getCustomerData(1L);
//		billingService.writeInvoice(1L);

		List<PartOrderLineDto> lines = billingRepository.getPartOrderLines(1L);


	}
}

