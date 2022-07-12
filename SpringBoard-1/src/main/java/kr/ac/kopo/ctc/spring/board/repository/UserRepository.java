//package kr.ac.kopo.ctc.spring.board.repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<User,Long>{
//	Optional<User> findOneByName(String name);
//	
//	Page<User> findAllByType(String type, Pageable pageable);
//	
//	List<User> findAllByType(String type);
//
//}
