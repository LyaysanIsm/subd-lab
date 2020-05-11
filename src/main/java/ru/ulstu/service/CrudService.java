package ru.ulstu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.ulstu.model.*;

import java.util.List;

@Service
public class CrudService {
    private static final Logger log = LoggerFactory.getLogger(CrudService.class);
    private final static int PAGE_OF_RECORDS_SIZE = 10;
}
