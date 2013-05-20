package cujo.tokenize;

public interface TokenAnalyzer<Type> {

	Type tokenize(String line);

}