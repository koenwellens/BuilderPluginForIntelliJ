package be.wellens.koen.builderPlugin.factories.innerClass.method.build;

import be.wellens.koen.builderPlugin.utils.StringUtils;

public final class BuildMethodStringCreator {

    protected final static String PUBLIC = "public ";
    protected final static String METHOD_NAME = " build() {\n";
    protected final static String METHOD_CONTENT = "return this.";
    protected final static String METHOD_END = ";\n}\n\n";

    public static String createBuildMethodFor(String className) {
        return emptyString()
                .append(PUBLIC)
                .append(className)
                .append(METHOD_NAME)
                .append(METHOD_CONTENT)
                .append(StringUtils.lowerCaseFirstLetter(className))
                .append(METHOD_END)
                .toString();
    }

    private static StringBuilder emptyString() {
        return new StringBuilder();
    }
}
