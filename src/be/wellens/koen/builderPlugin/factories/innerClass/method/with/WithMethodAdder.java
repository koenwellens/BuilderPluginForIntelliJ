package be.wellens.koen.builderPlugin.factories.innerClass.method.with;

import be.wellens.koen.builderPlugin.factories.innerClass.pojo.BuilderInformation;
import be.wellens.koen.builderPlugin.factories.innerClass.pojo.ContainingClassFieldInformation;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiMethod;

import static be.wellens.koen.builderPlugin.factories.innerClass.method.with.WithMethodStringCreator.createWithMethodFor;

public final class WithMethodAdder {

    public static void addWithMethodForContainingClassFieldToBuilder(BuilderInformation builderInformation, ContainingClassFieldInformation fieldInformation) {
        PsiClass builderClass = builderInformation.getBuilderClass();
        String withMethodAsString = createWithMethodFor(builderInformation.getContainingClassName(), fieldInformation);
        PsiMethod withMethod = builderInformation.getElementFactory().createMethodFromText(withMethodAsString, builderClass);
        builderClass.add(withMethod);
    }
}
