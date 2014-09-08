package be.wellens.koen.builderPlugin.factories.innerClass.field;

import be.wellens.koen.builderPlugin.utils.StringUtils;

public final class FieldStringCreator {

    protected final static String PRIVATE = "private";
    protected final static String WHITE_SPACE = " ";
    protected final static String ASSIGN_NEW = " = new ";
    protected final static String BRACKETS_AND_END = "();\n\n";

    public static String createField(String className) {
        return new StringBuilder()
                .append(PRIVATE)
                .append(WHITE_SPACE)
                .append(className)
                .append(WHITE_SPACE)
                .append(StringUtils.lowerCaseFirstLetter(className))
                .append(ASSIGN_NEW)
                .append(className)
                .append(BRACKETS_AND_END)
                .toString();
    }
}
