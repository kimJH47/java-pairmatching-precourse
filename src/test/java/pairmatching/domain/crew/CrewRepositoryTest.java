package pairmatching.domain.crew;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrewRepositoryTest {

    CrewRepository crewRepository = new CrewRepository();
    @Test
    @DisplayName("같은 과정의 크루가 전체조회 되어야한다.")
    public void 조회테스트_1(){

        crewRepository.save(Crew.create(Course.BACK_AND, "김재현"));
        crewRepository.save(Crew.create(Course.BACK_AND, "김재민"));
        crewRepository.save(Crew.create(Course.FRONT_AND, "정필규"));
        crewRepository.save(Crew.create(Course.FRONT_AND, "김동주"));
        //when
        List<Crew> expected = crewRepository.findByCourse(Course.BACK_AND);
        //then
        assertThat(expected.size()).isEqualTo(2);
        assertThat(expected.get(0).isSameCourse(Course.BACK_AND)).isTrue();

    }
}