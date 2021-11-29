package com.votacao.repository;

import com.votacao.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository  extends JpaRepository<Topic,Long> {

}
