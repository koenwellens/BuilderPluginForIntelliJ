package be.wellens.koen.builderPlugin.action;

import be.wellens.koen.builderPlugin.factories.builder.StaticBuilderFactoryMethodCreator;
import be.wellens.koen.builderPlugin.factories.constructor.PrivateConstructorCreator;
import be.wellens.koen.builderPlugin.factories.innerClass.BuilderClassGenerator;
import com.google.common.collect.Iterables;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiField;

import java.util.Arrays;
import java.util.List;

public final class BuilderWriteCommandAction extends WriteCommandAction.Simple {

    private PsiClass psiClass;
    private List<PsiField> fields;

    public BuilderWriteCommandAction(PsiClass psiClass, List<PsiField> fields) {
        super(psiClass.getProject(), psiClass.getContainingFile());
        this.psiClass = psiClass;
        this.fields = fields;
    }

    @Override
    protected void run() throws Throwable {
        PsiElementFactory elementFactory = JavaPsiFacade.getElementFactory(getProject());

        psiClass.addAfter(
                PrivateConstructorCreator.createWith(elementFactory, psiClass.getName()),
                Iterables.getLast(Arrays.asList(psiClass.getAllFields())));

        psiClass.add(StaticBuilderFactoryMethodCreator.createWith(elementFactory, psiClass));

        psiClass.add(
                BuilderClassGenerator.newBuilderClassFor(elementFactory)
                        .withContainingClassName(psiClass.getName())
                        .withFields(fields)
                        .asPrivateClass()
                        .generate()
        );
    }
}
