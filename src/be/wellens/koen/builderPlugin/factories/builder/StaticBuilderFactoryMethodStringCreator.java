package be.wellens.koen.builderPlugin.factories.builder;

public final class StaticBuilderFactoryMethodStringCreator {

    protected static final String START_OF_METHOD_SIGNATURE = "public static Builder new";
    protected static final String END_OF_METHOD_SIGNATURE = "() {\n";
    protected static final String METHOD_CONTENT = "return new Builder();\n";
    protected static final String END_OF_METHOD = "}\n\n";

    public static String createFor(String className) {
        return methodSignatureBuilder()
                .append(START_OF_METHOD_SIGNATURE)
                .append(className)
                .append(END_OF_METHOD_SIGNATURE)
                .append(METHOD_CONTENT)
                .append(END_OF_METHOD)
                .toString();
    }

    private static StringBuilder methodSignatureBuilder() {
        return new StringBuilder();
    }
}
