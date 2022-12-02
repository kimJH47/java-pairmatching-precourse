package pairmatching.service;

import java.util.List;
import pairmatching.domain.crew.CrewRepository;
import pairmatching.dto.CrewSaveDto;

public class CrewService {
    //커맨드
    private final CrewRepository crewRepository;

    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    public void save(List<CrewSaveDto> crewSaveDtos) {
        crewSaveDtos.stream()
                .map(CrewSaveDto::toEntity)
                .forEach(crewRepository::save);
    }
}
