package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.entity.Policy;
import com.example.demo.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
        
        
        
    }

    @GetMapping
    public Page<Policy> getPoliciesWithPagination(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy,
            @RequestParam String direction) {

        return policyService.getPoliciesWithPagination(page, size, sortBy, direction);
    }
    @PostMapping
    public PolicyResponseDTO createPolicy(
            @Valid @RequestBody PolicyRequestDTO dto) {

        return policyService.createPolicy(dto);
    }

    
    @GetMapping("/{id}")
    public PolicyResponseDTO getPolicyById(
            @PathVariable Long id) {

        return policyService.getPolicyById(id);
    }
    @DeleteMapping("/{id}")
    public String cancelPolicy(@PathVariable Long id) {

        policyService.cancelPolicy(id);

        return "Policy cancelled successfully";
    }
    
    @GetMapping("/type/{type}")
    public List<PolicyResponseDTO> getPoliciesByType(
            @PathVariable String type) {

        return policyService.getPoliciesByType(type);
    }
    @PutMapping("/{id}")
    public PolicyResponseDTO updatePolicy(
            @PathVariable Long id,
            @RequestBody PolicyRequestDTO dto) {

        return policyService.updatePolicy(id, dto);
    }
    
    @GetMapping("/premium")
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(
            @RequestParam double min,
            @RequestParam double max) {

        return policyService.getPoliciesByPremiumRange(min, max);
    }
}