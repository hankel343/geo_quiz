package com.example.geoquizbackend.Guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface GuestRepository {
    Guest findById(long id);

    @Transactional
    void deleteById(long id);
}
