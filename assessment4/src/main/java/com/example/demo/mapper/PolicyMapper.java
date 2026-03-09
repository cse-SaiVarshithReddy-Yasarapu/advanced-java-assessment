package com.example.demo.mapper;

import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.entity.Policy;

public class PolicyMapper {

    public static PolicyResponseDTO toDTO(Policy policy) {

        PolicyResponseDTO dto = new PolicyResponseDTO();

        dto.setId(policy.getId());
        dto.setPolicyNumber(policy.getPolicyNumber());
        dto.setPolicyType(policy.getPolicyType());
        dto.setPremiumAmount(policy.getPremiumAmount());
        dto.setCoverageAmount(policy.getCoverageAmount());
        dto.setStartDate(policy.getStartDate());
        dto.setEndDate(policy.getEndDate());
        dto.setStatus(policy.getStatus());

        return dto;
    }

}