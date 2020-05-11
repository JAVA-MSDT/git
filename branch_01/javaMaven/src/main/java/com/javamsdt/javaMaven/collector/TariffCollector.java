package com.javamsdt.javaMaven.collector;

import java.util.Map;
import java.util.stream.Collector;

public class TariffCollector {

	public static <T> Collector<T, Map<TaxiTariff, Double>, Map<TaxiTariff, Double>> tariff(){
		return null;

	}


	private static Double getTariff(final int destinace, final double tariff) {
		return destinace * tariff;
	}
}
