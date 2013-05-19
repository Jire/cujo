package cujo;

import java.io.FileNotFoundException;
import java.io.IOException;

import cujo.tokenize.Tokenizer;

public final class Cujo {

	public static void execute(Script script) throws FileNotFoundException,
			IOException {
		Tokenizer parser = new Tokenizer(script);
		parser.parseLine();
	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException {
		execute(Script.getScript(args[0]));
	}

}