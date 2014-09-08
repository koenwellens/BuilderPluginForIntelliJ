package be.wellens.koen.builderPlugin.factories.builder;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiMethod;

public final class StaticBuilderFactoryMethodCreator {

    // TODO test
    public static PsiMethod createWith(PsiElementFactory elementFactory, PsiClass psiClass) {
        String methodAsString = StaticBuilderFactoryMethodStringCreator.createFor(psiClass.getName());
        return elementFactory.createMethodFromText(methodAsString, psiClass);
    }
}
