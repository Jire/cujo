package cujo;

public final class Data extends AbstractToken {

	private final Type type;
	private final Object value;

	public Data(Keyword keyword, Type type, Object value) {
		super(keyword);
		this.type = type;
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public Object getValue() {
		return type.convert(value);
	}

	@Override
	public String toString() {
		return String.format("[%s =: (%s, %s)]", getKeyword().toString(), type
				.name().toLowerCase(), value.toString());
	}

	public enum Type {

		TOGGLE(boolean.class), NUM(double.class), TEXT(String.class);

		private final Class<?> clazz;

		Type(Class<?> clazz) {
			this.clazz = clazz;
		}

		Class<?> getClazz() {
			return clazz;
		}

		Keyword keyword() {
			return Keyword.get(name().toLowerCase());
		}

		/**
		 * Converts an object value to the data type.
		 * 
		 * @param value
		 *            The object to cast.
		 * @return The object casted as the value.
		 */
		Object convert(Object value) {
			return clazz.cast(value);
		}

	}

}