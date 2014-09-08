package be.wellens.koen.builderPlugin.factories.innerClass.method.with;

import be.wellens.koen.builderPlugin.factories.innerClass.pojo.ContainingClassFieldInformation;
import be.wellens.koen.builderPlugin.utils.StringUtils;

public class WithMethodStringCreator {

    protected static final String START_METHOD_SIGNATURE = "public Builder with";
    protected static final String OPEN_BRACKET = "(";
    protected static final String WHITE_SPACE = " ";
    protected static final String END_METHOD_SIGNATURE = ") {\n";
    protected static final String DOT = ".";
    protected static final String EQUALS = " = ";
    protected static final String END_LINE = ";\n";
    protected static final String END_METHOD = "return this;\n}\n\n";

    public static String createWithMethodFor(String className, ContainingClassFieldInformation fieldInformation) {
        String fieldName = fieldInformation.getFieldName();
        return emptyString()
                .append(START_METHOD_SIGNATURE)
                .append(StringUtils.upperCaseFirstLetter(fieldName))
                .append(OPEN_BRACKET)
                .append(fieldInformation.getFieldType())
                .append(WHITE_SPACE)
                .append(fieldName)
                .append(END_METHOD_SIGNATURE)
                .append(StringUtils.lowerCaseFirstLetter(className))
                .append(DOT)
                .append(fieldName)
                .append(EQUALS)
                .append(fieldName)
                .append(END_LINE)
                .append(END_METHOD)
                .toString();
    }

    private static StringBuilder emptyString() {
        return new StringBuilder();
    }
}
