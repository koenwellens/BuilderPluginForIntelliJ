package be.wellens.koen.builderPlugin.action;

import be.wellens.koen.builderPlugin.dialog.BuilderCreatorDialog;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.psi.PsiClass;

public final class BuilderCreatorAction extends AnAction {

    public void actionPerformed(AnActionEvent event) {
        PsiClass psiClass = PsiClassFromContextExtractor.createPsiClassFrom(event);

        BuilderCreatorDialog dlg = new BuilderCreatorDialog(psiClass);
        dlg.show();
        if (dlg.isOK()) {
            new BuilderWriteCommandAction(psiClass, dlg.getSelectedFields()).execute();
        }
    }

    @Override
    public void update(AnActionEvent event) {
        PsiClass psiClass = PsiClassFromContextExtractor.createPsiClassFrom(event);
        event.getPresentation().setEnabled(psiClass != null);
    }
}
