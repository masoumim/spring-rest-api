package myspringapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findByNameContaining(String categoryName);
}
