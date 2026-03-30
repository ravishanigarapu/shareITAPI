package com.common.share.service;

import java.util.List;
import java.util.Optional;

import com.common.share.dto.User;

public interface RegistrationService {

	User saveUser(User user);

	Optional<User> getStudentById(Long id);

	List<User> getAllStudents();

}
