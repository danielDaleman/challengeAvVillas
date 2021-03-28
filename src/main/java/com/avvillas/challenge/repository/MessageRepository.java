package com.avvillas.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avvillas.challenge.entitys.Message;

public interface MessageRepository extends JpaRepository<Message, Long>{

}
