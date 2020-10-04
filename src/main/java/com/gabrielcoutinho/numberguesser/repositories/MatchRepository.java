package com.gabrielcoutinho.numberguesser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielcoutinho.numberguesser.domain.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>{

}