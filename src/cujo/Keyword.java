package cujo;

public final class Keyword {

	private final String identifier;

	private Keyword(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public String toString() {
		return identifier;
	}

	public static Keyword get(String identifier) {
		return new Keyword(identifier);
	}

}