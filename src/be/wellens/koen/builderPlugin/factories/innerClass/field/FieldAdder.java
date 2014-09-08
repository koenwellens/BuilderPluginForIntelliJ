package be.wellens.koen.builderPlugin.factories.innerClass.field;

import be.wellens.koen.builderPlugin.factories.innerClass.pojo.BuilderInformation;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;

public class FieldAdder {

    public static void addContainingClassFieldToBuilder(BuilderInformation builderInformation) {
        PsiClass builderClass = builderInformation.getBuilderClass();
        String fieldAsString = FieldStringCreator.createField(builderInformation.getContainingClassName());
        PsiField builderField = builderInformation.getElementFactory().createFieldFromText(fieldAsString, builderClass);
        builderClass.add(builderField);
    }
}
