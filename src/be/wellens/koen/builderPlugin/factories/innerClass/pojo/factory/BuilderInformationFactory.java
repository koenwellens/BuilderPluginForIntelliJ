package be.wellens.koen.builderPlugin.factories.innerClass.pojo.factory;

import be.wellens.koen.builderPlugin.factories.innerClass.BuilderClassGenerator;
import be.wellens.koen.builderPlugin.factories.innerClass.pojo.BuilderInformation;
import com.intellij.psi.PsiElementFactory;

import static be.wellens.koen.builderPlugin.factories.innerClass.pojo.BuilderInformation.newBuilderInformation;

public class BuilderInformationFactory {

    public static BuilderInformation createFor(BuilderClassGenerator builderClassGenerator) {
        PsiElementFactory elementFactory = builderClassGenerator.getElementFactory();
        
        return newBuilderInformation()
                .withContainingClassName(builderClassGenerator.getContainingClassName())
                .withElementFactory(elementFactory)
                .withBuilderClass(elementFactory.createClass("Builder"))
                .build();
    }
}
