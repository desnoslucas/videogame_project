package com.formation.app.demo.service;

import com.formation.app.demo.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsoleService {

    @Autowired
    private ConsoleRepository consoleRepository;

}
