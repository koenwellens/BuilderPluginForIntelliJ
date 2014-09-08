package be.wellens.koen.builderPlugin.factories.constructor;

import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiModifierList;

public final class PrivateConstructorCreator {

    public static PsiMethod createWith(PsiElementFactory elementFactory, String className) {
        PsiMethod constructor = elementFactory.createConstructor(className);
        makeConstructorPrivate(constructor);
        return constructor;
    }

    private static void makeConstructorPrivate(PsiMethod constructor) {
        PsiModifierList modifierList = constructor.getModifierList();
        modifierList.setModifierProperty("private", true);
    }
}
