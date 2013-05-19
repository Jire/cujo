package cujo;

public final class Loop {

	public enum Type implements Token {

		FOR, WHILE;

		private final Keyword keyword;

		Type() {
			this.keyword = new Keyword(name().toLowerCase());
		}

		@Override
		public Keyword getKeyword() {
			return keyword;
		}

	}

}