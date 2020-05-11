package ru.ulstu.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.model.Request;
import ru.ulstu.repository.RequestRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService implements Crud<Request> {

    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public Request create(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public Request get(Integer id) {
        return requestRepository.getOne(id);
    }

    @Override
    public Optional<Request> find(Integer id) {
        return requestRepository.findById(id);
    }

    @Override
    public PageableItems<Request> findAll(int offset, int count) {
        final Page<Request> page = requestRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Request update(Request request) {
        if (request.getId() == null) {
            throw new RuntimeException("Request id is null");
        }
        return requestRepository.save(request);
    }

    @Override
    public void delete(Request request) {
        requestRepository.delete(request);
    }

    public List<Request> findByDateBetween(Date dateFrom, Date dateTo){
        return requestRepository.findByDateBetween(dateFrom, dateTo);
    }
}
