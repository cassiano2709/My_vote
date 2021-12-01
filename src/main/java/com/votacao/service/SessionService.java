package com.votacao.service;

import com.sun.xml.bind.marshaller.Messages;
import com.votacao.dto.SessionCreateRequestDTO;
import com.votacao.dto.SessionDTO;
import com.votacao.entity.Session;
import com.votacao.entity.Topic;
import com.votacao.repository.SessionRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SessionService {

    private SessionRepository repository;
    private TopicService topicService;

    public SessionDTO create(SessionCreateRequestDTO session) {

        var openSession = repository.save(Session.builder()
                .topicId(session.getTopicId())
                .startDateTime(session.getStartDateTime())
                .finishDateTime(session.getFinishDateTime()).build());

        return SessionDTO.builder()
                .id(openSession.getId())
                .topicDTO(topicService.findDTOById(openSession.getTopicId()))
                .startDateTime(openSession.getStartDateTime())
                .finishDateTime(openSession.getFinishDateTime())
                .build();
    }

    public SessionDTO findDTOById(Long id){

        return null;
    }

    public Boolean sessionOpen(Long sessionId, Topic topic) {
       Optional<Session> openSession = repository.findById(sessionId);
        if (openSession.isPresent()) {
            return LocalDate.now().isBefore(openSession.get().getFinishDateTime());
        }
        throw new IllegalArgumentException(Messages.UNSUPPORTED_RESULT);
    }

    public Session findById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não rolou"));
    }



//    public SessionDTO updateSession(SessionUpdateRequestDTO request){
//
//        return null;
//    }

}
