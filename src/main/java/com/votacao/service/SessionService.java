package com.votacao.service;

import com.sun.xml.bind.marshaller.Messages;
import com.votacao.dto.SessionCreateRequestDTO;
import com.votacao.dto.SessionDTO;
import com.votacao.dto.SessionUpdateRequestDTO;
import com.votacao.entity.Session;
import com.votacao.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessionService {

    private SessionRepository sessionRepository;




    public SessionDTO create(SessionCreateRequestDTO session) {





        return null;
    }

    public SessionDTO findDTOById(Long id){

        return null;
    }

    public Boolean SessionOpen(Long sessionId) {
       Optional<Session> openSession = sessionRepository.findById(sessionId);
        if (openSession.isPresent()) {
            return LocalDateTime.now().isBefore(openSession.get().getStartingVoting());
        }
        throw new IllegalArgumentException(Messages.UNSUPPORTED_RESULT);
    }



    public SessionDTO updateSession(SessionUpdateRequestDTO request){

        return null;
    }

}
