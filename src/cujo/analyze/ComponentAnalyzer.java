package cujo.analyze;

public interface ComponentAnalyzer<Type> {

	Type analyze(String line);

}