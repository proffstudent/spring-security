package com.ogorodov.secure.service;

import com.ogorodov.repository.LevelRepository;
import com.ogorodov.entity.Level;
import com.ogorodov.entity.User;
import com.ogorodov.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelServiceImpl implements LevelService {

    private static Logger logger = Logger.getLogger(LevelServiceImpl.class);

    @Autowired
    LevelRepository levelRepository;
    @Autowired
    UserRepository userRepository;

    public String getUserAccessById(Integer id){
        logger.debug("getUserAccessById"+ ((Level)(userRepository.findById(id).getAccesslevel())).getAccess());
        return ((Level)(userRepository.findById(id).getAccesslevel())).getAccess();
    }
}
