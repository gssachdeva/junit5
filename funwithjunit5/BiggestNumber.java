package funwithjunit5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

public class BiggestNumber {

	public long findBiggestNumber(long [] numbers) {

		List<Long> listOfNumbers = Arrays
				.stream(numbers)
				.boxed()
				.collect(Collectors.toList());
                
		Long max = listOfNumbers
				.stream()
				.mapToLong(num -> num)
				.max().orElseThrow(NoSuchElementException::new);
		
		return Long.valueOf(max);
	}
}
