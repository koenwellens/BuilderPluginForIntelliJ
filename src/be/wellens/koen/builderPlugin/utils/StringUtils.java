package be.wellens.koen.builderPlugin.utils;

public final class StringUtils {

    public static String upperCaseFirstLetter(String text) {
        StringParts stringParts = getPartsFrom(text);
        String upperCased = stringParts.firstLetter.toUpperCase();
        return createResultFrom(stringParts.replaceFirstLetter(upperCased));
    }

    public static String lowerCaseFirstLetter(String text) {
        StringParts stringParts = getPartsFrom(text);
        String upperCased = stringParts.firstLetter.toLowerCase();
        return createResultFrom(stringParts.replaceFirstLetter(upperCased));
    }

    private static StringParts getPartsFrom(String text) {
        StringParts result = new StringParts();
        result.rest = text.substring(1);
        result.firstLetter = String.valueOf(text.charAt(0));
        return result;
    }

    private static String createResultFrom(StringParts stringParts) {
        return stringParts.firstLetter + stringParts.rest;
    }

    private static class StringParts {
        private String firstLetter;
        private String rest;

        public StringParts replaceFirstLetter(String newFirstLetter) {
            StringParts newStringParts = new StringParts();
            newStringParts.firstLetter = newFirstLetter;
            newStringParts.rest = rest;

            return newStringParts;
        }
    }
}
