package com.project.ace_tprevesion.Repository;

import com.project.ace_tprevesion.Entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone ,Long > , JpaSpecificationExecutor<Phone> {
    List<Phone> getPhoneByModel(String model);
    List<Phone> getPhoneByModelAndPrice(String model, Float price);

}
