package com.votacao.repository;

import com.votacao.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic,Long> {
    long countByCountYes(Long countYes);
    long countByCountNo(Long countNo);


}
