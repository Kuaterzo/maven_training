package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SampleTest {

    private final Sample sample = new Sample();

    @Test
    void TestFactNegativeNumber(){


        //int result = sample.fact(-1);
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sample.fact(-1))
            .withMessage("N should be positive");
    }

    @Test
    void TestFactPossitifNumber(){

        int result = sample.fact(3);
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void Addition(){

        int result = sample.op(Sample.Operation.ADD,8,3);
        Assertions.assertThat(result).isEqualTo(11);
    }

    @ParameterizedTest
    @CsvSource({
        "0, 9, 0",
        "2, 8, 16"
    })
    void Multiplication(int a, int b, int ExpResult){

        int result = sample.op(Sample.Operation.MULT, a, b);
        Assertions.assertThat(result).isEqualTo(ExpResult);
    }
}
