package com.sist.web.dao;

import com.sist.web.entity.BoardEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

  @Query(value = "SELECT * FROM board ORDER BY no DESC "
      + "LIMIT :start,10", nativeQuery = true)
  public List<BoardEntity> boardListData(@Param("start") int start);

  // @Query => 입력되는 데이터가 있는 경우 => @Param
  // @Param 두개이상 => Integer
  public BoardEntity findByNo(int no);

}