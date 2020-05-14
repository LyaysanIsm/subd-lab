package ru.ulstu.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.model.Report;
import ru.ulstu.model.Technique;
import ru.ulstu.repository.TechniqueRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TechniqueService implements Crud<Technique> {

    private final TechniqueRepository techniqueRepository;

    public TechniqueService(TechniqueRepository techniqueRepository) {
        this.techniqueRepository = techniqueRepository;
    }

    @Override
    public Technique create(Technique technique) {
        return techniqueRepository.save(technique);
    }

    @Override
    public List<Technique> findAll() {
        return techniqueRepository.findAll();
    }

    @Override
    public Technique get(Integer id) {
        return techniqueRepository.getOne(id);
    }

    @Override
    public Optional<Technique> find(Integer id) {
        return techniqueRepository.findById(id);
    }

    @Override
    public PageableItems<Technique> findAll(int offset, int count) {
        final Page<Technique> page = techniqueRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Technique update(Technique technique) {
        if (technique.getId() == null) {
            throw new RuntimeException("Request id is null");
        }
        return techniqueRepository.save(technique);
    }

    @Override
    public void delete(Technique technique) {
        techniqueRepository.delete(technique);
    }

    public List<Technique> findByAvailability(byte availability){
        return techniqueRepository.findByAvailability(availability);
    }

   public List<Technique> getTechniqueStatisticByNumberMore(int number){
        return techniqueRepository.getTechniqueStatisticByNumberMore(number);
    }
   public List<Technique> getTechniqueOrder(){
       return techniqueRepository.getTechniqueOrder();
    }
}
