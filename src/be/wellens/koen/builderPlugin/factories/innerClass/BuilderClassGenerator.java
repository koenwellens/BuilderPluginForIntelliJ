package be.wellens.koen.builderPlugin.factories.innerClass;

import be.wellens.koen.builderPlugin.factories.innerClass.pojo.BuilderInformation;
import be.wellens.koen.builderPlugin.factories.innerClass.pojo.factory.BuilderInformationFactory;
import be.wellens.koen.builderPlugin.factories.innerClass.pojo.factory.ContainingClassFieldInformationFactory;
import com.intellij.psi.*;

import java.util.List;

import static be.wellens.koen.builderPlugin.factories.innerClass.field.FieldAdder.addContainingClassFieldToBuilder;
import static be.wellens.koen.builderPlugin.factories.innerClass.method.build.BuildMethodAdder.addBuildMethodForContainingClassToBuilder;
import static be.wellens.koen.builderPlugin.factories.innerClass.method.with.WithMethodAdder.addWithMethodForContainingClassFieldToBuilder;

public class BuilderClassGenerator {

    private String containingClassName;
    private PsiElementFactory elementFactory;
    private boolean isStatic = false;
    private List<PsiField> fields;

    private BuilderClassGenerator() {
    }

    public String getContainingClassName() {
        return containingClassName;
    }

    public PsiElementFactory getElementFactory() {
        return elementFactory;
    }

    public static BuilderClassGenerator newBuilderClassFor(PsiElementFactory elementFactory) {
        BuilderClassGenerator builderClassGenerator = new BuilderClassGenerator();
        builderClassGenerator.elementFactory = elementFactory;
        return builderClassGenerator;
    }

    public PsiClass generate() {
        BuilderInformation builderInformation = BuilderInformationFactory.createFor(this);

        addContainingClassFieldToBuilder(builderInformation);
        addBuildMethodForContainingClassToBuilder(builderInformation);

        for (PsiField field : fields) {
            addWithMethodForContainingClassFieldToBuilder(builderInformation, ContainingClassFieldInformationFactory.createFor(field));
        }

        makeBuilderClassStatic(builderInformation);

        return builderInformation.getBuilderClass();
    }

    private void makeBuilderClassStatic(BuilderInformation builderInformation) {
        PsiModifierList modifierList = builderInformation.getBuilderClass().getModifierList();
        modifierList.setModifierProperty(PsiModifier.STATIC, this.isStatic);
    }

    public BuilderClassGenerator withContainingClassName(String containingClassName) {
        this.containingClassName = containingClassName;
        return this;
    }

    public BuilderClassGenerator withFields(List<PsiField> fields) {
        this.fields = fields;
        return this;
    }

    public BuilderClassGenerator asPrivateClass() {
        this.isStatic = true;
        return this;
    }
}
