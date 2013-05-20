package cujo;

public abstract class AbstractToken implements Token {

	private final Keyword keyword;

	protected AbstractToken(Keyword keyword) {
		this.keyword = keyword;
	}

	@Override
	public final Keyword getKeyword() {
		return keyword;
	}

}