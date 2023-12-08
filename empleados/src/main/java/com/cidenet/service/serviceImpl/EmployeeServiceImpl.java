package com.cidenet.service.serviceImpl;

import com.cidenet.dto.EmployeeDTO;
import com.cidenet.mapper.EmployeeMapper;
import com.cidenet.model.CountryEntity;
import com.cidenet.model.EmployeeEntity;
import com.cidenet.repository.CountryRepository;
import com.cidenet.repository.EmployeeRepository;
import com.cidenet.repository.GenericRepository;
import com.cidenet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmployeeServiceImpl extends CRUDimpl<EmployeeEntity, EmployeeDTO, Integer> implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private EmployeeMapper mapper;

    @Override
    protected GenericRepository<EmployeeEntity, Integer> getRepository() {
        return repository;
    }

    @Override
    public Page<EmployeeDTO> getAll(Pageable pageable) throws Exception {
        return mapper.getPageDtos(getRepository().findAll(pageable));
    }

    @Override
    @Transactional
    public EmployeeDTO register(EmployeeDTO employeeDTO) throws Exception {
        employeeDTO.setEmail(makeEmail(employeeDTO));
        employeeDTO.setCreationDate(LocalDateTime.now());
        return super.register(employeeDTO);
    }

    public String makeEmail(EmployeeDTO employeeDTO) {
        Optional<CountryEntity> country = countryRepository.findById(employeeDTO.getCountry().getId());

        String email = employeeDTO.getName().toLowerCase() + "." + employeeDTO.getSurname().toLowerCase();

        Integer numEmails = repository.countEmail(email);

        if (numEmails > 0) {
            email = email + "." + (numEmails + 1) + "@" + country.get().getDomain();
            return email;
        }
        email = email + "@" + country.get().getDomain();
        return email;
    }


}
