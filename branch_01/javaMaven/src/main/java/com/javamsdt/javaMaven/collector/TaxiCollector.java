package com.javamsdt.javaMaven.collector;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class TaxiCollector implements Collector<TaxiTariff, Map<TaxiTariff, Double>, Map<TaxiTariff, Double>> {

	public static TaxiCollector taxiCollector() {

		return new TaxiCollector();
	}
	@Override
	public Supplier<Map<TaxiTariff, Double>> supplier() {
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<TaxiTariff, Double>, TaxiTariff> accumulator() {
		return (map, taxiTariff) -> map.merge(taxiTariff, getTariff(taxiTariff.getDestinationNumber(), taxiTariff
				.getTariffPerKillo()), (map0, map1) -> map0 + map1); 
	}

	@Override
	public BinaryOperator<Map<TaxiTariff, Double>> combiner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Function<Map<TaxiTariff, Double>, Map<TaxiTariff, Double>> finisher() {
		System.out.println("Inside finisher");
		return Function.identity();
	}

	@Override
	public Set<Characteristics> characteristics() {
		// TODO Auto-generated method stub
		return null;
	}

	private Double getTariff(final int destinace, final double tariff) {
		return destinace * tariff;
	}


}
