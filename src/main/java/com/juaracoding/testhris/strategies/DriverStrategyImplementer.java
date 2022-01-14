package com.juaracoding.testhris.strategies;

import com.juaracoding.testhris.utils.Constants;

public class DriverStrategyImplementer {

	public static DriverStrategy chooseStrategy(String strategy) {
		if (strategy.equalsIgnoreCase(Constants.CHROME)) {
			return new Chrome();
		}else if(strategy.equalsIgnoreCase(Constants.FIREFOX)) {
			return new Firefox();
		}else {
			return null;
		}
	}
}
