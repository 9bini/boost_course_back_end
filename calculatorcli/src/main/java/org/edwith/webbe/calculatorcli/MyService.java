package org.edwith.webbe.calculatorcli;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	private final CalService calService;

	public MyService(CalService calService) {
		this.calService = calService;
	}

	public int execute(int value1, int value2) {
		return calService.plus(value1, value2) * 2;
	}

}
