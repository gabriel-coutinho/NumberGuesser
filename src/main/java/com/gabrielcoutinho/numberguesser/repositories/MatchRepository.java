package com.gabrielcoutinho.numberguesser.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gabrielcoutinho.numberguesser.domain.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer>{
	@Query("SELECT obj FROM Match obj WHERE obj.player LIKE %:player%")
	List<Match> getPlayer(@Param("player") String player);
	
	@Query("SELECT obj FROM Match obj WHERE obj.id IN :idsRank")
	Page<Match> getRank(@Param("idsRank") List<Integer> idsRank, Pageable pageRequest);

	@Query("SELECT obj FROM Match obj WHERE obj.player LIKE %:player%")
	Page<Match> getMatchsByName(@Param("player") String player, Pageable page);

	@Query("SELECT obj FROM Match obj WHERE obj.player LIKE %:player% ORDER BY obj.attemptsNum DESC, obj.timeSecs DESC")
	List<Match> getBestMatchs(@Param("player") String player);
}