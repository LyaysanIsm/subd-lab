package ru.ulstu.service;

import org.springframework.data.domain.Page;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.model.Supply;
import ru.ulstu.repository.SupplyRepository;

import java.util.List;
import java.util.Optional;

public class SupplyService implements Crud<Supply> {

    private final SupplyRepository supplyRepository;

    public SupplyService(SupplyRepository supplyRepository) {
        this.supplyRepository = supplyRepository;
    }

    @Override
    public Supply create(Supply supply) {
        return supplyRepository.save(supply);
    }

    @Override
    public List<Supply> findAll() {
        return supplyRepository.findAll();
    }

    @Override
    public Supply get(Integer id) {
        return supplyRepository.getOne(id);
    }

    @Override
    public Optional<Supply> find(Integer id) {
        return supplyRepository.findById(id);
    }

    @Override
    public PageableItems<Supply> findAll(int offset, int count) {
        final Page<Supply> page = supplyRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Supply update(Supply supply) {
        if (supply.getId() == null) {
            throw new RuntimeException("Request id is null");
        }
        return supplyRepository.save(supply);
    }

    @Override
    public void delete(Supply supply) {
        supplyRepository.delete(supply);
    }
}
