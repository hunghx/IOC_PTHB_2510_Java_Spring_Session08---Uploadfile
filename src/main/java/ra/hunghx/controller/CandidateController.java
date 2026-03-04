package ra.hunghx.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ra.hunghx.dto.request.CandidateCreateDTO;
import ra.hunghx.dto.response.ErrorResponseDto;
import ra.hunghx.entity.Candidate;
import ra.hunghx.exception.ResourceNotFoundException;
import ra.hunghx.service.CandidateServiceImpl;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateServiceImpl candidateService;
    @PostMapping
    public ResponseEntity<?> createCandidate(@Valid @RequestBody CandidateCreateDTO request){
        return ResponseEntity.ok().body(candidateService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> findById(@PathVariable int id) throws ResourceNotFoundException {
        return new ResponseEntity<>( candidateService.findById(id), HttpStatus.OK);
    }
}
