package com.common.share.service;

import com.common.share.dto.User;

public interface LoginService {

	User login(String userName, String password);

}
