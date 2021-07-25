package com.lb.lightboard.repository;

import com.lb.lightboard.model.BoardFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardFrameRepository extends JpaRepository<BoardFrame, Long> {
	List<BoardFrame> findAll();
}
