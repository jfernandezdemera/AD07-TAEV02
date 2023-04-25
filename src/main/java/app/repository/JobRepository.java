package app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.domain.Job;

public interface JobRepository extends MongoRepository<Job, String> {

	Job findByCodigo(String codigo);

	List<Job> findByMunicipio(String municipio);

	List<Job> findByProvincia(String provincia);

	List<Job> findByDisc(String discapacidad);
}
