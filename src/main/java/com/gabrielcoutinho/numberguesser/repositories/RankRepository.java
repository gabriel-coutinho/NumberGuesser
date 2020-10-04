package com.gabrielcoutinho.numberguesser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielcoutinho.numberguesser.domain.Rank;

@Repository
public interface RankRepository extends JpaRepository<Rank, Integer>{
}