package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class TranscriptServiceImpl implements TranscriptService {

    private final TranscriptRepository transcriptRepository;


    @Override
    public Transcript saveTranscript(Transcript transcript) {
        return transcriptRepository.save(transcript);
    }
}
