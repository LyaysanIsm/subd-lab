package ru.ulstu.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.model.Provider;
import ru.ulstu.repository.ProviderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService implements Crud<Provider> {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Provider create(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    @Override
    public Provider get(Integer id) {
        return providerRepository.getOne(id);
    }

    @Override
    public Optional<Provider> find(Integer id) {
        return providerRepository.findById(id);
    }

    @Override
    public PageableItems<Provider> findAll(int offset, int count) {
        final Page<Provider> page = providerRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Provider update(Provider provider) {
        if (provider.getId() == null) {
            throw new RuntimeException("Provider id is null");
        }
        return providerRepository.save(provider);
    }

    @Override
    public void delete(Provider provider) {
        providerRepository.delete(provider);
    }
}
