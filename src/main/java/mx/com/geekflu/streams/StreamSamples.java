package mx.com.geekflu.streams;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamSamples {
	
	public static void main(String[] args) {
		int[] nums = {1,34,65,-23,-2,45,98,1};
		double[] fnums = {23.34f, -124.324f, 565.2343f, 3244.5699f, 898987.34f,23.456f, -2342,223f};
		IntSummaryStatistics summary = IntStream.of(nums).summaryStatistics();
		DoubleSummaryStatistics dSummsry = DoubleStream.of(fnums).summaryStatistics();
		
		System.out.println("************ INT Summary");
		System.out.println("Avg: " + summary.getAverage());
		System.out.println("Min: " + summary.getMin());
		System.out.println("Max: " + summary.getMax());
		System.out.println("Count: " + summary.getCount());
		System.out.println("Sum: " + summary.getSum());

		System.out.println("************ Double Summary");
		System.out.println("Avg: " + dSummsry.getAverage());
		System.out.println("Min: " + dSummsry.getMin());
		System.out.println("Max: " + dSummsry.getMax());
		System.out.println("Count: " + dSummsry.getCount());
		System.out.println("Sum: " + dSummsry.getSum());
		
		int[] arrNum = {23,-345,2,2,46,-123,78978,2332};
		
		IntStream.of(arrNum).distinct().sorted().limit(3).forEach(num -> System.out.println(num));
		
		System.out.println("\n\n\t");
		List<Employee> employees = List.of(new Employee("Luis", 23456, true), 
				new Employee("Arreola", 23456,false), 
				new Employee("Beto", 45456, true), 
				new Employee("Pedorro", 56, false), 
				new Employee("Vergudo", 2345634,false),
				new Employee("Zetozoso", 298765,false));
		
		employees.stream()
				 .sorted(Comparator.comparingInt(Employee::getSalary))
				 .limit(3)
				 .map(Employee::getName)
				 .forEach(name -> System.out.println("Sorted by salary: " + name));
		
		employees.stream()
				 .sorted(Comparator.comparingInt(Employee::getSalary))
				 .filter(emp -> emp.isActive())
				 .limit(3)
				 .map(Employee::getName)
				 .forEach(name -> System.out.println("Filtering is active: " + name));
		
	}
	
}
