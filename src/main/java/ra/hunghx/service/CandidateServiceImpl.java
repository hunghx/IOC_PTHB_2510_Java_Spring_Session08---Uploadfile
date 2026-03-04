package ra.hunghx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.hunghx.dto.request.CandidateCreateDTO;
import ra.hunghx.entity.Candidate;
import ra.hunghx.exception.ResourceNotFoundException;
import ra.hunghx.repository.ICandidateRepository;

@Service
public class CandidateServiceImpl {
    @Autowired
    private ICandidateRepository candidateRepository;
    public Candidate create(CandidateCreateDTO request){
        Candidate entity = Candidate.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .age(request.getAge())
                .yearsOfExperience(request.getYearsOfExperience())
                .build();
        return candidateRepository.save(entity);
    }
    public Candidate findById(int id) throws ResourceNotFoundException{
        return candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate not found with id = "+id));
    }
}
