package app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.domain.Job;
import app.repository.JobRepository;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

	@Autowired
	JobRepository jobRepository;

	@GetMapping({ "/", "" })
	public ResponseEntity<List<Job>> index() {
		List<Job> jobs = jobRepository.findAll();

		if (jobs.size() > 0) {
			return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/codigo={codigo}")
	@ResponseStatus(HttpStatus.OK)
	public Job byCodigo(@PathVariable("codigo") String codigo) {
		return jobRepository.findByCodigo(codigo);
	}

	@GetMapping("desc_empleo={descEmpleo}")
	public ResponseEntity<List<Job>> byDescripcion(@PathVariable("descEmpleo") String descEmpleo) {
		List<Job> jobs = jobRepository.findAll();
		List<Job> tempJobs = new ArrayList<Job>();

		if (jobs.size() > 0) {
			for (Job job : jobs) {
				if (job.getDesEmpleo().toUpperCase().contains(descEmpleo.toUpperCase())) {
					tempJobs.add(job);
				}
			}
			return new ResponseEntity<List<Job>>(tempJobs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/municipio={municipio}")
	public ResponseEntity<List<Job>> byPoblacion(@PathVariable("municipio") String municipio) {
		List<Job> jobs = jobRepository.findByMunicipio(municipio.toUpperCase());

		if (jobs.size() > 0) {
			return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/provincia={provincia}")
	public ResponseEntity<List<Job>> byProvincia(@PathVariable("provincia") String provincia) {
		List<Job> jobs = jobRepository.findByProvincia(provincia.toUpperCase());

		if (jobs.size() > 0) {
			return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("discapacidad={discapacidad}")
	public ResponseEntity<List<Job>> byDiscapacidad(@PathVariable("discapacidad") boolean discapacidad) {
		String sDiscapacidad = discapacidad ? "S" : "N";
		List<Job> jobs = jobRepository.findByDisc(sDiscapacidad);

		if (jobs.size() > 0) {
			return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Job>>(HttpStatus.NO_CONTENT);
		}
	}
}
