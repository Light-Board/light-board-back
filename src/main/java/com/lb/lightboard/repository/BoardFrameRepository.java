package com.lb.lightboard.repository;

import com.lb.lightboard.model.entity.BoardFrame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardFrameRepository extends JpaRepository<BoardFrame, Long> {

}
