package com.geek.lambda;

public class ProductFitlerByRatings implements ProductFilter {
	public boolean test(Product p) {
		return p.getRatings()>=4;
	}
}
