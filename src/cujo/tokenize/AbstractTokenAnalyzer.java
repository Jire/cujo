package cujo.tokenize;

import cujo.Script;

public abstract class AbstractTokenAnalyzer<T> implements TokenAnalyzer<T> {

	private final Script script;

	protected AbstractTokenAnalyzer(Script script) {
		this.script = script;
	}

	protected final Script getScript() {
		return script;
	}

}