package cujo.analyze;

import cujo.Data;

public final class DataAnalyzer implements ComponentAnalyzer<Data> {

	@Override
	public Data analyze(String line) {
		String[] pieces = line.split(" ");

		Data.Type type = Data.Type.valueOf(pieces[0].toUpperCase());

		if (type == null) {
			return null;
		}

		/*
		 * The data test passed: A matching defined type of data was found.
		 */

		return new Data(pieces[1], type, pieces[3]);
	}

}