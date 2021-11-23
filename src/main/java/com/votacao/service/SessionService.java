package com.votacao.service;

import com.sun.xml.bind.marshaller.Messages;
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
    private ParticipantService participantService;



    public SessionDTO create(SessionDTO sessionDto) {

        return sessionDto;
    }

    public SessionDTO findDTOById(Long id){

        return null;
    }

    public Boolean SessionOpen(Long sessionId) {
       Optional<Session> optionalSession = sessionRepository.findById(sessionId);
        if (optionalSession.isPresent()) {
            return LocalDateTime.now().isBefore(optionalSession.get().getStartingVoting());
        }
        throw new IllegalArgumentException(Messages.UNSUPPORTED_RESULT);
    }



    public SessionDTO updateSession(SessionUpdateRequestDTO request){

        return null;
    }

}
