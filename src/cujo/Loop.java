package cujo;

public final class Loop extends AbstractToken {

	public Loop(Keyword keyword) {
		super(keyword);
	}

	public enum Type implements Token {

		FOR, WHILE;

		private final Keyword keyword;

		Type() {
			this.keyword = Keyword.get(name().toLowerCase());
		}

		@Override
		public Keyword getKeyword() {
			return keyword;
		}

	}

}