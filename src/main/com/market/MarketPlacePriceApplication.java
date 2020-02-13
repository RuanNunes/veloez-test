package com.market;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.market.contract.dto.CostumerDTO;
import com.market.contract.dto.ProductDTO;
import com.market.contract.dto.filters.CustomerFiltersDTO;
import com.market.contract.dto.filters.RuleMarketPlaceFiltersDTO;
import com.market.mapper.CostumerMapper;
import com.market.mapper.RuleMarketPlaceMapper;
import com.market.model.Customer;
import com.market.repository.CustomerRepository;
import com.market.repository.ProductRepository;
import com.market.service.CostumerService;
import com.market.service.ProductService;
import com.market.service.exception.DataIntegrityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.market.contract.dto.RuleMarketPlaceDTO;
import com.market.model.RuleMarketPlace;
import com.market.repository.RuleMarketPlaceRepository;
import com.market.service.RuleMarketPlaceService;

@SpringBootApplication
public class MarketPlacePriceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MarketPlacePriceApplication.class, args);
	}
	@Autowired
	private RuleMarketPlaceService rule;
	
	@Autowired
	private RuleMarketPlaceRepository ruleRepository;
	@Autowired
	private RuleMarketPlaceMapper ruleMarketPlaceMapper;

	@Autowired
	private CustomerRepository costumerRepository;

	@Autowired
	private CostumerService costumerService;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CostumerMapper costumerMapper;

	@Override
	public void run(String... args) throws Exception {

		saveCostumerInPacage(200, 2);
		saveRuleUmAUm(5);
		saveProducts(3);

//		saveRuleInPackage(20, 2);


	}

	private void saveProducts(int repeticoes) {
		System.out.println("Incluindo Products");
		Long mileInic = System.currentTimeMillis();

		for (int i = 0; i < repeticoes; i++) {
			String uid = UUID.randomUUID().toString();
			Random random = new Random();
			productService.save(ProductDTO.builder()
					.name("Product   " + uid)
					.description("Descrição do produto "+i)
					.costPrice(BigDecimal.valueOf(random.nextInt()))
					.costumerId(findCostumer("Costumer").getId())
					.build());
		}
		Long mileFin = System.currentTimeMillis();
		Long time = ((mileFin - mileInic)/1000)/60;
		System.out.println(time + " Minutos para inserir um a um......> Total Inclusos= "+ repeticoes);
	}

	private Set<Long> findRules(String name){
		Set<Long> list = rule.findPaginate(RuleMarketPlaceFiltersDTO
				.builder()
				.name(name)
				.build())
				.stream().map(RuleMarketPlaceDTO::getId).collect(Collectors.toSet());
		return list;
	}

	private Customer findCostumer(String name){
		return costumerMapper.toEntity(costumerService
				.findPaginate(CustomerFiltersDTO
						.builder()
						.name(name)
						.limit(Integer.valueOf(1))
						.build()).stream().findFirst().orElseThrow(() -> new DataIntegrityException("Não foi possivel encontrar um Costumer")));
	}

	private void saveCostumerInPacage(int pacote, int repeticoes){
		Long mileInic = System.currentTimeMillis();

		System.out.println("Incluindo Costumers "+pacote+ " a " + pacote);
		for (int i = 0; i < repeticoes; i++) {
			final List<Customer> costumers = new ArrayList<Customer>();
			for (int j = 0; j < pacote; j++) {

				String uid = UUID.randomUUID().toString();
				costumers.add(Customer.builder()
						.name("Customer  " + uid)
						.category("Premium")
						.email("teste."+uid+"@gmail.com")
						.level("Iniciante")
						.password(uid)
						.build());
			}
			costumerRepository.saveAll(costumers);
		}

		Long mileFin = System.currentTimeMillis();
		Long time = ((mileFin - mileInic)/1000)/60;
		System.out.println(time + " Minutos para inserir "+ pacote + " a "
				+ pacote+"......>Total Costumer Inclusos= "+ pacote*repeticoes);
	}

	private void saveRuleUmAUm(int repeticoes) {
		System.out.println("Incluindo um a um");
		Long mileInic = System.currentTimeMillis();

		for (int i = 0; i < repeticoes; i++) {
			String uid = UUID.randomUUID().toString();
			
			rule.save(RuleMarketPlaceDTO.builder()
					.name("Rule " + i + " " + uid)
					.description("Descrição da rule "+i)
					.discountPercentage(BigDecimal.valueOf(16))
					.customerId(findCostumer("Cu").getId())
					.build());
		}
		Long mileFin = System.currentTimeMillis();
		Long time = ((mileFin - mileInic)/1000)/60;
		System.out.println(time + " Minutos para inserir um a um......> Total Inclusos= "+ repeticoes);
	}
	
	private void saveRuleInPackage(int pacote, int repeticoes) {
		
		Long mileInic = System.currentTimeMillis();

		System.out.println("Incluindo Rules "+pacote+ " a " + pacote);
		for (int i = 0; i < repeticoes; i++) {
			final List<RuleMarketPlace> rules = new ArrayList<RuleMarketPlace>();
			for (int j = 0; j < pacote; j++) {
				
				String uid = UUID.randomUUID().toString();
				rules.add(ruleMarketPlaceMapper.toEntity(RuleMarketPlaceDTO.builder()
						.name("Rule " + i + " " + uid)
						.description("Descrição da rule "+i)
						.discountPercentage(BigDecimal.valueOf(16))
						.build()));
			}
			ruleRepository.saveAll(rules);
		}
		
		Long mileFin = System.currentTimeMillis();
		Long time = ((mileFin - mileInic)/1000)/60;
		System.out.println(time + " Minutos para inserir "+ pacote + " a " 
		+ pacote+"......>Total Rule Inclusos= "+ pacote*repeticoes);
	}
}
