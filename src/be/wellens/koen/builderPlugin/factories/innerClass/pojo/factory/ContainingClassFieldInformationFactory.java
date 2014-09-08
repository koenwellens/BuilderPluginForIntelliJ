package be.wellens.koen.builderPlugin.factories.innerClass.pojo.factory;

import be.wellens.koen.builderPlugin.factories.innerClass.pojo.ContainingClassFieldInformation;
import com.intellij.psi.PsiField;

import static be.wellens.koen.builderPlugin.factories.innerClass.pojo.ContainingClassFieldInformation.newContainingClassFieldInformation;

public class ContainingClassFieldInformationFactory {

    public static ContainingClassFieldInformation createFor(PsiField field) {
        return newContainingClassFieldInformation()
                .withFieldName(field.getName())
                .withFieldType(field.getType().getPresentableText())
                .build();
    }
}
