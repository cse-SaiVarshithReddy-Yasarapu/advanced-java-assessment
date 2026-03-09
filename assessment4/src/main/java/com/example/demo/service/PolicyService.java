package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.entity.Customer;
import com.example.demo.entity.Policy;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.PolicyMapper;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PolicyRepository;


import org.springframework.data.domain.*;
@Service
public class PolicyService {

    private final PolicyRepository policyRepository;
    private final CustomerRepository customerRepository;
    public void cancelPolicy(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        policy.setStatus("CANCELLED");

        policyRepository.save(policy);
    }
    

    public Page<Policy> getPoliciesWithPagination(int page, int size,
                                                  String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return policyRepository.findAll(pageable);
    }

    public PolicyService(PolicyRepository policyRepository,
                         CustomerRepository customerRepository) {
        this.policyRepository = policyRepository;
        this.customerRepository = customerRepository;
    }

    // Create Policy
    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Policy policy = new Policy();

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setStatus("ACTIVE");
        policy.setCustomer(customer);

        policy = policyRepository.save(policy);

        PolicyResponseDTO response = PolicyMapper.toDTO(policy);
        response.setCustomer(CustomerMapper.toDTO(customer));

        return response;
    }

    // Get Policy by ID
    public PolicyResponseDTO getPolicyById(Long id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        PolicyResponseDTO response = PolicyMapper.toDTO(policy);
        response.setCustomer(CustomerMapper.toDTO(policy.getCustomer()));

        return response;
    }

    // Get policies by type
    public List<PolicyResponseDTO> getPoliciesByType(String type) {

        return policyRepository.findByPolicyType(type)
                .stream()
                .map(policy -> {
                    PolicyResponseDTO dto = PolicyMapper.toDTO(policy);
                    dto.setCustomer(CustomerMapper.toDTO(policy.getCustomer()));
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // Get policies by premium range
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(double min, double max) {

        return policyRepository.findByPremiumAmountBetween(min, max)
                .stream()
                .map(policy -> {
                    PolicyResponseDTO dto = PolicyMapper.toDTO(policy);
                    dto.setCustomer(CustomerMapper.toDTO(policy.getCustomer()));
                    return dto;
                })
                .collect(Collectors.toList());
    }
    public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Policy not found"));

        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        policyRepository.save(policy);

        return PolicyMapper.toDTO(policy);
    }

}