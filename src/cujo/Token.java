package cujo;

public interface Token {

	Keyword getKeyword();

	enum Type {

		DATA(Data.class), PROCEDURE(FunctionRegistry.class), LOOP(Loop.class);

		private final Class<?> clazz;

		Type(Class<?> clazz) {
			this.clazz = clazz;
		}

		public ComponentBuilder createComponent(Class<?>... parameterTypes) {
			try {
				return new ComponentBuilder(
						clazz.getDeclaredConstructor(parameterTypes));
			} catch (Exception e) {
				return null;
			}
		}

		public static final class ComponentBuilder {

			private final java.lang.reflect.Constructor<?> constructor;

			private ComponentBuilder(
					java.lang.reflect.Constructor<?> constructor) {
				this.constructor = constructor;
			}

			public Token withParameters(Object... parameters) {
				try {
					return (Token) constructor.newInstance(parameters);
				} catch (Exception e) {
					return null;
				}
			}

		}

	}

}