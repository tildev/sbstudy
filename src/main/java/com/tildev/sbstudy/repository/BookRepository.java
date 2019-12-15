/**
 * 
 */
package com.tildev.sbstudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tildev.sbstudy.dto.BookVO;

/**
 * @author tildev
 * @date   2019. 12. 15.
 */
public interface BookRepository extends JpaRepository<BookVO, Long>{
    List<BookVO> findByReader(String reader);
}
