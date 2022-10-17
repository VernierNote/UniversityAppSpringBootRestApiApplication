package com.java.springboot.task.service.impl;

import com.java.springboot.task.entity.Faculty;
import com.java.springboot.task.repository.FacultyRepository;
import com.java.springboot.task.service.FacultyService;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service("facultyService")
public class FacultyServiceImpl implements FacultyService {

	private final FacultyRepository facultyRepository;

	@Autowired
	public FacultyServiceImpl(FacultyRepository facultyRepository) {
		this.facultyRepository = facultyRepository;
	}

	@Override
	public Optional<Faculty> findById(Long id) {
		return facultyRepository.findById(id);
	}

	@Override
	public List<Faculty> list() {
		return IteratorUtils.toList( facultyRepository.findAll().iterator() );
	}

	@Override
	public Page<Faculty> list(Integer from, Integer pageSize, String sortBy, Sort.Direction ordering) {
		return facultyRepository.findAll(
				PageRequest.of(from, pageSize,ordering, sortBy)
		);
	}

	@Override
	public List<Faculty> findByName(String name) {
		return facultyRepository.findByName( name );
	}

	@Override
	@Transactional
	public Faculty create(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	@Transactional
	public Faculty update(Faculty faculty) {
		return facultyRepository.save(faculty);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		facultyRepository.deleteById(id);
	}
}
