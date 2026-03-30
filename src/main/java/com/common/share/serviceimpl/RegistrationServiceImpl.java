package com.common.share.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.share.dto.User;
import com.common.share.repository.RegistationRepository;
import com.common.share.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	RegistationRepository registationRepository;

	@Override
	public User saveUser(User user) {
		return registationRepository.save(user);

	}

	@Override
	public List<User> getAllStudents() {
		return registationRepository.findAll();
	}
	@Override
	public Optional<User> getStudentById(Long id) {
		return registationRepository.findById(id);
	}

	
}
