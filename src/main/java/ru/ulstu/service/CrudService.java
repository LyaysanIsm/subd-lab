package ru.ulstu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.ulstu.model.*;

import java.util.Date;
import java.util.List;
import java.util.PrimitiveIterator;

@Service
public class CrudService {
    private static final Logger log = LoggerFactory.getLogger(CrudService.class);
    private final static int PAGE_OF_RECORDS_SIZE = 10;

    private final CustomerService customerService;
    private final ProviderService providerService;
    private final RequestService requestService;
    private final SupplyService supplyService;
    private final TechniqueService techniqueService;

    public CrudService(CustomerService customerService,
                       ProviderService providerService,
                       RequestService requestService,
                       SupplyService supplyService,
                       TechniqueService techniqueService) {
        this.customerService = customerService;
        this.providerService = providerService;
        this.requestService = requestService;
        this.supplyService = supplyService;
        this.techniqueService = techniqueService;
    }

    public Customer createCustomer(String surname, String name, String patronymic, String telephone, String address){
        Customer customer = new Customer();
        customer.setAddress(address);
        customer.setName(name);
        customer.setPatronymic(patronymic);
        customer.setSurname(surname);
        customer.setTelephone(telephone);

        return customerService.create(customer);
    }

    public Customer updateCustomer(Customer customer){
        return customerService.update(customer);
    }

    public void deleteCustomer(Customer customer){
        customerService.delete(customer);
    }

    public void showAllCustomers(){
        log.info("All customers:\n");
        log.info(customerService.findAll().toString());
    }

    public Provider createProvider(String nameOrganization, String surname, String name, String patronymic, String telephone, String address){
        Provider provider = new Provider();
        provider.setNameOrganization(nameOrganization);
        provider.setSurname(surname);
        provider.setName(name);
        provider.setPatronymic(patronymic);
        provider.setTelephone(telephone);
        provider.setAddress(address);

        return providerService.create(provider);
    }

    public Provider updateProvider(Provider provider){
        return providerService.update(provider);
    }

    public void deleteProvider(Provider provider){
        providerService.delete(provider);
    }

    public void showAllProviders(){
        log.info("All providers:\n");
        log.info(providerService.findAll().toString());
    }

    public Request createRequest(Date date, int number){
        Request request = new Request();
        request.setDate(date);
        request.setNumber(number);

        return requestService.create(request);
    }

    public Request updateRequest(Request request){
        return requestService.update(request);
    }

    public void deleteRequest(Request request){
        requestService.delete(request);
    }

    public void showAllRequest(){
        log.info("All requests:\n");
        log.info(requestService.findAll().toString());
    }

    public Supply createSupply(Date date, int number){
        Supply supply = new Supply();
        supply.setDate(date);
        supply.setNumber(number);

        return supplyService.create(supply);
    }

    public Supply updateSupply(Supply supply){
        return supplyService.update(supply);
    }

    public void deleteSupply(Supply supply){
        supplyService.delete(supply);
    }

    public void showAllSupplies(){
        log.info("All supplies:\n");
        log.info(supplyService.findAll().toString());
    }

    public Technique createTechnique(String name, int number, byte availability){
        Technique technique = new Technique();
        technique.setName(name);
        technique.setNumber(number);
        technique.setAvailability(availability);

        return techniqueService.create(technique);
    }

    public Technique updateTechnique(Technique technique){
        return techniqueService.update(technique);
    }

    public void deleteTechnique(Technique technique){
        techniqueService.delete(technique);
    }

    public void showAllTechniques(){
        log.info("All Techniques:\n");
        log.info(techniqueService.findAll().toString());
    }

    public void showFirstPageOfRecords() {
        log.info("First page of records:\n");
        log.info(customerService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(providerService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(requestService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(supplyService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
        log.info(techniqueService.findAll(0, PAGE_OF_RECORDS_SIZE).getItems().toString());
    }

    public void showFilteredRecords() {
        log.info("Filtered records:\n");

        List<Customer> customers = customerService.findByAddress("Surova3");
        log.info(customers.toString());
        List<Provider> providers = providerService.findByNameOrganization("Avrora");
        log.info(providers.toString());
        List<Request> requests = requestService.findByNumber(8);
        log.info(requests.toString());
        List<Supply> supplies = supplyService.findByNumber(25);
        log.info(supplies.toString());
        List<Technique> techniques = techniqueService.findByAvailability((byte)1);
        log.info(techniques.toString());
    }

    public void showStatistic() {
        log.info("Technique statistic:\n");
        List<Technique> techniqueStatistics = techniqueService.getTechniqueStatisticByNumberMore(21);
        log.info(techniqueStatistics.toString());

        log.info("Customer statistic:\n");
        List<Customer> customerStatistics = customerService.getCustomerStatisticStartName("A");
        log.info(customerStatistics.toString());

        log.info("Technique order statistic:\n");
        List<Technique> techniqueOrder = techniqueService.getTechniqueOrder();
        log.info(techniqueOrder.toString());

        log.info("Report statistic:\n");
        List<Report> report = customerService.getReports();
        log.info(report.toString());
    }
}
