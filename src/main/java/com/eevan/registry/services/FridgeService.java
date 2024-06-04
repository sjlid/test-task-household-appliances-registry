package com.eevan.registry.services;

import com.eevan.registry.entities.Cleaner;
import com.eevan.registry.entities.Fridge;
import com.eevan.registry.repos.FridgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FridgeService {
    private final FridgeRepository fridgeRepository;

    @Transactional
    public void save(Fridge fridge) {
        fridgeRepository.save(fridge);
    }

    @Transactional(readOnly = true)
    public List<Fridge> getAllFridges() {
        return fridgeRepository.findAll();
    }
}
