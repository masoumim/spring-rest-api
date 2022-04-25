package myspringapi;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByCategoryId(Long id);

	@Transactional
	void deleteByCategoryId(long id);
}
