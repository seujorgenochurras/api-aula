package com.apiaula.tutorial.apiaula.domain.Repository;

import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRespository extends JpaRepository<Delivery, Long> {

}
