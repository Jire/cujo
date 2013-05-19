package cujo.tokenize;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import cujo.Data;
import cujo.Script;
import cujo.analyze.ComponentAnalyzer;
import cujo.analyze.DataAnalyzer;

public final class Tokenizer {

	private final Script script;
	private final BufferedReader reader;

	private final ComponentAnalyzer<Data> dataAnalyzer = new DataAnalyzer();

	public Tokenizer(Script script) throws FileNotFoundException {
		this.script = script;
		this.reader = new BufferedReader(new FileReader(script.getFile()));
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
			Data data = dataAnalyzer.analyze(line);
			if (data != null) {
				script.getDataRegistry().register(data.getIdentifier(), data);
				System.out.println(data);
				continue;
			}
		}
	}

}