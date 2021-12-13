package com.votacao.resource;

import com.votacao.dto.VoteCreateRequestDTO;
import com.votacao.dto.VoteDTO;
import com.votacao.entity.Vote;
import com.votacao.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;


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

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void delete(@Valid @RequestParam Long id){

        service.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public Vote findById(@Valid @RequestParam Long id){

        return service.findById(id);
    }

}
