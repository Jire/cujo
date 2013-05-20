package cujo.tokenize;

import cujo.Data;
import cujo.Keyword;
import cujo.Script;

public final class DataAnalyzer extends AbstractTokenAnalyzer<Data> {

	public DataAnalyzer(Script script) {
		super(script);
	}

	@Override
	public Data tokenize(String line) {
		String[] pieces = line.split(" ");

		Data.Type type = Data.Type.valueOf(pieces[0].toUpperCase());

		if (type == null) {
			return null;
		}

		/*
		 * The data test passed: A matching defined type of data was found.
		 */

		return new Data(Keyword.get(pieces[1]), type, pieces[3]);
	}

}