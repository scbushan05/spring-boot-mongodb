package in.bushansirgur.restapi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import in.bushansirgur.restapi.model.EmployeeModel;

@Repository
public interface EmployeeDAO extends MongoRepository<EmployeeModel, Long> {

}
