package com.group10.StudyGroupOrganizer.service;

import com.group10.StudyGroupOrganizer.model.SessionDetails;
import com.group10.StudyGroupOrganizer.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {
    public final SessionRepository sessionRepository;
    @Autowired
    public SessionService(SessionRepository sessionRepository){
       this.sessionRepository=sessionRepository;
    }
    public void saveSession(SessionDetails session){sessionRepository.save(session);}
    public List<SessionDetails> getAllSession(){ return sessionRepository.findAll();}
    public SessionDetails getSessionById(Long id){return sessionRepository.findById(id).orElse(null);}
    public void deleteSession(Long id){ sessionRepository.deleteById(id);}

}
