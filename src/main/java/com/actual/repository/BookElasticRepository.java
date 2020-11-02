/*package com.actual.repository;

import com.actual.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookElasticRepository extends ElasticsearchRepository<Book, Long> {
	Optional<Book> findByTitleIgnoreCase(String title);

	//Page<Book> findByAuthorName(String author, Pageable pageable);

	//@Query("{\"bool\": {\"must\": [{\"match\": {\"books.author\": \"?0\"}}]}}")
	//Page<Book> findByAuthorNameUsingCustomQuery(String author, Pageable pageable);
}*/
