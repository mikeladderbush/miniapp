package com.ladderbush.miniapp;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MiniatureController {

	private final MiniatureRepository repository;

	MiniatureController(MiniatureRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/miniatures")
	List<Miniature> all() {
		return repository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/miniatures")
	Miniature newMiniature(@RequestBody Miniature newMiniature) {
		return repository.save(newMiniature);
	}

	@GetMapping("/miniatures/{id}")
	Optional<Miniature> one(@PathVariable Long id) {

		return repository.findById(id);
	}

	@PutMapping("/miniatures/{id}")
	Miniature replaceEmployee(@RequestBody Miniature newMiniature, @PathVariable Long id) {

		return repository.findById(id)
				.map(miniature -> {
					miniature.setName(newMiniature.getName());
					miniature.setScale(newMiniature.getScale());
					miniature.setProgress(newMiniature.getProgress());
					return repository.save(miniature);
				})
				.orElseGet(() -> {
					newMiniature.setId(id);
					return repository.save(newMiniature);
				});
	}

	@DeleteMapping("/miniatures/{id}")
	void deleteMiniature(@PathVariable Long id) {
		repository.deleteById(id);
	}
}