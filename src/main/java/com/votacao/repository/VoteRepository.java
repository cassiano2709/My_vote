package com.votacao.repository;

import com.votacao.entity.Topic;
import com.votacao.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

List<Vote> findAllByTopicId(Long id);

long countByTopicIdAndVoteTrue(Long id);
long countByTopicIdAndVoteFalse(Long id);


}