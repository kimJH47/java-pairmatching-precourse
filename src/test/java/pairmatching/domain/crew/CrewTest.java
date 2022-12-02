package pairmatching.domain.crew;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CrewTest {


    @Test
    @DisplayName("크루의 과정과 이름이 같을시 중복으로 판단한다.")
    public void 중복테스트(){
        //given
        Crew crew1 = Crew.create(Course.BACK_AND, "김재현");
        Crew crew2 = Crew.create(Course.BACK_AND, "김재현");
        Crew crew3 = Crew.create(Course.FRONT_AND, "김재민");
        Crew crew4 = Crew.create(Course.BACK_AND, "김재민");
        //when
        //then
        Assertions.assertThat(crew1).isEqualTo(crew2);
        Assertions.assertThat(crew3).isNotEqualTo(crew4);
    }

}