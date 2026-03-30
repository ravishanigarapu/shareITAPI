package com.common.share.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.share.dto.User;
import com.common.share.repository.RegistationRepository;
import com.common.share.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	RegistationRepository registationRepository;

	@Override
	public User login(String userName, String password) {

		User student = registationRepository.findByUserName(userName)
				.orElseThrow(() -> new RuntimeException("Invalid username or password"));

		if (!student.getPassword().equals(password)) {
			throw new RuntimeException("Invalid username or password");
		}

		return student;
	}


}
