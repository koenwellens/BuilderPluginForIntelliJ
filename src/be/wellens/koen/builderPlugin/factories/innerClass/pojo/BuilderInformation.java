package be.wellens.koen.builderPlugin.factories.innerClass.pojo;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElementFactory;

public class BuilderInformation {

    private PsiElementFactory elementFactory;
    private String containingClassName;
    private PsiClass builderClass;

    private BuilderInformation() {
    }

    public PsiElementFactory getElementFactory() {
        return elementFactory;
    }

    public String getContainingClassName() {
        return containingClassName;
    }

    public PsiClass getBuilderClass() {
        return builderClass;
    }

    public static Builder newBuilderInformation() {
        return new Builder();
    }

    public static class Builder {

        private BuilderInformation builderInformation = new BuilderInformation();

        public BuilderInformation build() {
            return this.builderInformation;
        }

        public Builder withElementFactory(PsiElementFactory elementFactory) {
            builderInformation.elementFactory = elementFactory;
            return this;
        }

        public Builder withContainingClassName(String containingClassName) {
            builderInformation.containingClassName = containingClassName;
            return this;
        }

        public Builder withBuilderClass(PsiClass builderClass) {
            builderInformation.builderClass = builderClass;
            return this;
        }
    }
}
