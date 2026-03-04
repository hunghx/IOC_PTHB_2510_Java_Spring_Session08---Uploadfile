package ra.hunghx.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ra.hunghx.entity.Candidate;

public interface ICandidateRepository extends JpaRepository<Candidate, Integer> {

}
