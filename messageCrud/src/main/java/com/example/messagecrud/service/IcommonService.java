package com.example.messagecrud.service;

import com.example.messagecrud.model.User;

public interface IcommonService {
    User validateUser(String username,String password);
    User checkUser(String username);

}
