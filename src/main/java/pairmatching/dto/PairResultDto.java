package pairmatching.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.pair.Pair;

public class PairResultDto {
    private final List<List<String>> pairedCrews;

    private PairResultDto(List<List<String>> pairedCrews) {
        this.pairedCrews = new ArrayList<>(pairedCrews);
    }

    public static PairResultDto create(List<Pair> pairs) {
        List<List<String>> pairedCrews = pairs.stream()
                .map(Pair::getPairCrewsName)
                .collect(Collectors.toList());
        return new PairResultDto(pairedCrews);
    }


    public List<List<String>> getPairedCrews() {
        return pairedCrews;
    }
}
