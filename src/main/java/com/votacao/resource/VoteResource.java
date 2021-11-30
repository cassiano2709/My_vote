package com.votacao.resource;

import com.votacao.dto.VoteCreateRequestDTO;
import com.votacao.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("/vote")
@RequiredArgsConstructor
public class VoteResource {

    private final VoteService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public void openVote(@Valid @RequestBody VoteCreateRequestDTO vote) {
        service.openVote(vote);
    }
//
//    @GetMapping("/{id}")
//    @ResponseStatus(OK)
//    public SessionDTO findById(@PathVariable Long id) {
//        return service.findDTOById(id);
//    }
//
//    @GetMapping("/{sessionId}")
//    @ResponseStatus(OK)
//    public Boolean openSession(@PathVariable Long sessionId, Topic topic) {
//        return service.SessionOpen(sessionId, topic);
//    }

//    @PutMapping
//    public SessionDTO update(@Valid @RequestBody SessionUpdateRequestDTO request) {
//        return service.updateSession(request);
//    }

}
