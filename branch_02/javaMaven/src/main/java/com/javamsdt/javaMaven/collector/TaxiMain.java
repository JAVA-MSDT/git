package com.javamsdt.javaMaven.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.IntStream;

public class TaxiMain {

	public static void main(String[] args) {

		final Set<Integer> result = IntStream.of(1, 2, 3, 4, 3, 4, 5).boxed().collect(unique());

		System.out.println(result);
		
		List<Double> priDoubles = tariffs().stream().collect(getPrice());
		
		System.out.println(priDoubles);
		
		Map<TaxiTariff, Double> priceMap = tariffs().stream().collect(mapCollector());
		
		priceMap.forEach((k, v) -> System.out.println(k + " : " + v));

	}

	static List<TaxiTariff> tariffs() {
		return Arrays.asList(new TaxiTariff(50, 1.5, "Allan"), new TaxiTariff(30, 2.5, "Jhon"),
				new TaxiTariff(40, 0.75, "Adam"), new TaxiTariff(25, 1.15, "Islam"), new TaxiTariff(60, 1.55, "Sergey"),
				new TaxiTariff(15, 2.0, "Alaa"), new TaxiTariff(20, 1.75, "Essam"), new TaxiTariff(70, 2.25, "Ahmed"));
	}

	static <T> Collector<T, Set<T>, Set<T>> unique() {
		return Collector.of(() -> new HashSet<T>(), (result, item) -> result.add(item), (result1, result2) -> {
			result1.addAll(result2);
			return result1;
		}, Function.identity(), Characteristics.IDENTITY_FINISH);
	}

	static <T> Collector<TaxiTariff, ArrayList<Double>, ArrayList<Double>> getPrice() {
		return Collector.of(() -> new ArrayList<Double>(), (priceList, taxiTariff) -> priceList
				.add(((TaxiTariff) taxiTariff).getDestinationNumber() * ((TaxiTariff) taxiTariff).getTariffPerKillo()),
				(result1, result2) -> {
					result1.addAll(result2);
					return result1;
				}, Function.identity(), Characteristics.IDENTITY_FINISH);
	}

	static <T> Collector<TaxiTariff, ?, Map<TaxiTariff, Double>> mapCollector(){
		return Collector.of(() -> new HashMap<TaxiTariff, Double>(), 
				(map, taxiTariff) -> map.put(taxiTariff, ((TaxiTariff) taxiTariff).getDestinationNumber() * ((TaxiTariff) taxiTariff).getTariffPerKillo()),
				(map1, map2) -> {
					map1.putAll(map2);
					return map1;
				},
				Function.identity(), 
				Characteristics.IDENTITY_FINISH);
	}
	static Double getTariff(int destinace, double tariff) {
		return destinace * tariff;
	}

}
