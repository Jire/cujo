package cujo.tokenize;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import cujo.Data;
import cujo.Function;
import cujo.Script;

public final class Tokenizer {

	private final Script script;
	private final BufferedReader reader;

	private final TokenAnalyzer<Data> dataAnalyzer;
	private final TokenAnalyzer<Function> functionAnalyzer;

	public Tokenizer(Script script) throws FileNotFoundException {
		this.script = script;
		this.reader = new BufferedReader(new FileReader(script.getFile()));
		this.dataAnalyzer = new DataAnalyzer(script);
		this.functionAnalyzer = new FunctionAnalyzer(script);
	}

	public Script getScript() {
		return script;
	}

	public String readLine() throws IOException {
		return reader.readLine();
	}

	public void parseLine() throws IOException {
		String line;
		while ((line = readLine()) != null) {
			// Process data case
			Data data = dataAnalyzer.tokenize(line);
			if (data != null) {
				script.getDataRegistry().register(data.getKeyword().toString(),
						data);
				continue;
			}

			// Process function case
			Function function = functionAnalyzer.tokenize(line);
			if (function != null) {
				script.getFunctionRegistry().register(
						function.getKeyword().toString(), function);
				continue;
			}
		}
	}

}