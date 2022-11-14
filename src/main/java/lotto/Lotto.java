package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        // 6개가 아닌 경우 Exception
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        //중복 숫자가 있는 경우 Exception
        Set<Integer> numSet = new HashSet<>(numbers);
        if(numSet.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
        //1~45이외에 숫자가 있는 경우 Exception
        for(int num : numbers){
            if(num<1 && num>45)
                throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
