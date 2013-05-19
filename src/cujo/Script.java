package cujo;

import java.io.File;

public final class Script {

	private final File file;

	private final KeywordRegistry keywordRegistry = new KeywordRegistry();
	private final DataRegistry dataRegistry = new DataRegistry();
	private final FunctionRegistry functionRegistry = new FunctionRegistry();

	private Script(File file) {
		this.file = file;
	}

	private Script(String file) {
		this(new File(file));
	}

	public File getFile() {
		return file;
	}

	public KeywordRegistry getKeywordRegistry() {
		return keywordRegistry;
	}

	public DataRegistry getDataRegistry() {
		return dataRegistry;
	}

	public FunctionRegistry getFunctionRegistry() {
		return functionRegistry;
	}

	public static Script getScript(File file) {
		return new Script(file);
	}

	public static Script getScript(String file) {
		return new Script(file);
	}

}