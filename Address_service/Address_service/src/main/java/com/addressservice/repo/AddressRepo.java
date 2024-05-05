package com.addressservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.addressservice.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address ,Integer> {
	
	@Query(nativeQuery=true, value="select ea.id,ea.line1,ea.line2,ea.state,ea.zip from address ea join  employee e on e.id=ea.employeeId where ea.employeeId=:employeeId")
	Address findAddressByEmployeeId(@Param("employeeId") int emploeeId);

}
