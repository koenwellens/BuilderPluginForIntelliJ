package be.wellens.koen.builderPlugin.factories.innerClass.pojo;

public class ContainingClassFieldInformation {

    private String fieldName;
    private String fieldType;

    private ContainingClassFieldInformation() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public static Builder newContainingClassFieldInformation() {
        return new Builder();
    }

    public static class Builder {

        private ContainingClassFieldInformation containingClassFieldInformation = new ContainingClassFieldInformation();

        private Builder() {
        }

        public ContainingClassFieldInformation build() {
            return this.containingClassFieldInformation;
        }

        public Builder withFieldName(String fieldName) {
            containingClassFieldInformation.fieldName = fieldName;
            return this;
        }

        public Builder withFieldType(String fieldType) {
            containingClassFieldInformation.fieldType = fieldType;
            return this;
        }
    }
}
