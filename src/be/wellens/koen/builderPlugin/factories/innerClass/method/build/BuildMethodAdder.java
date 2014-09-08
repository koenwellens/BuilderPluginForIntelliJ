package be.wellens.koen.builderPlugin.factories.innerClass.method.build;

import be.wellens.koen.builderPlugin.factories.innerClass.pojo.BuilderInformation;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiMethod;

public class BuildMethodAdder {

    public static void addBuildMethodForContainingClassToBuilder(BuilderInformation builderInformation) {
        PsiClass builderClass = builderInformation.getBuilderClass();
        String buildMethodAsString = BuildMethodStringCreator.createBuildMethodFor(builderInformation.getContainingClassName());
        PsiMethod buildMethod = builderInformation.getElementFactory().createMethodFromText(buildMethodAsString, builderClass);
        builderClass.add(buildMethod);
    }
}
