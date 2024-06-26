package com.eevan.registry.services;

import com.eevan.registry.dtos.SmartphoneDto;
import com.eevan.registry.entities.Fridge;
import com.eevan.registry.entities.ProductFamily;
import com.eevan.registry.entities.Smartphone;
import com.eevan.registry.entities.Tv;
import com.eevan.registry.repos.ProductFamilyRepository;
import com.eevan.registry.repos.SmartphoneRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmartphoneService {
    private final SmartphoneRepository smartphoneRepository;
    private final ProductFamilyRepository productFamilyRepository;

    @Transactional
    public void save(SmartphoneDto smartphoneDto) {
        ProductFamily productFamily = productFamilyRepository.getFamilyById(smartphoneDto.getProductFamilyId());
        Smartphone smartphone = convertToSmartphone(smartphoneDto);
        smartphone.setProductFamily(productFamily);
        if (smartphone.getModelAvailability()) {
            int totalModels = productFamily.getAvailableProducts() + 1;
            productFamily.setAvailableProducts(totalModels);
            productFamilyRepository.save(productFamily);
        }
        smartphoneRepository.save(smartphone);
    }

    @Transactional(readOnly = true)
    public List<Smartphone> getAllSmartphones() {
        return smartphoneRepository.findAll();
    }

    private Smartphone convertToSmartphone(SmartphoneDto smartphoneDto) {
        Smartphone smartphone = new Smartphone();
        smartphone.setModelName(smartphoneDto.getModelName());
        smartphone.setModelSerialNumber(smartphoneDto.getModelSerialNumber());
        smartphone.setProductType(smartphoneDto.getProductType().toString());
        smartphone.setModelSize(smartphoneDto.getModelSize());
        smartphone.setModelColor(smartphoneDto.getModelColor());
        smartphone.setModelPrice(smartphoneDto.getModelPrice());
        smartphone.setModelAvailability(smartphoneDto.getModelAvailability());
        smartphone.setModelCamera(smartphoneDto.getModelCamera());
        smartphone.setModelMemory(smartphoneDto.getModelMemory());
        return smartphone;
    }
}
