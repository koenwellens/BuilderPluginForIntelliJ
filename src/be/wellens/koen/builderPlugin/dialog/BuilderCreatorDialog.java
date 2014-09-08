package be.wellens.koen.builderPlugin.dialog;

import com.intellij.ide.util.DefaultPsiElementCellRenderer;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.ui.CollectionListModel;
import com.intellij.ui.ToolbarDecorator;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BuilderCreatorDialog extends DialogWrapper {

    private CollectionListModel<PsiField> classFields;
    private final JList fieldList;
    private final LabeledComponent<JPanel> myComponent;

    public BuilderCreatorDialog(PsiClass psiClass) {
        super(psiClass.getProject());

        setTitle("Select fields for Builder generation");
        classFields = new CollectionListModel<PsiField>(psiClass.getAllFields());
        fieldList = initFieldList();
        myComponent = LabeledComponent.create(createPanel(), "Fields to include as Builder with-methods");

        init();
    }

    private JList initFieldList() {
        JList fieldList = new JList(classFields);
        fieldList.setCellRenderer(new DefaultPsiElementCellRenderer());
        fieldList.setSelectionInterval(0, classFields.getSize() - 1);

        return fieldList;
    }

    private JPanel createPanel() {
        ToolbarDecorator decorator = ToolbarDecorator.createDecorator(fieldList);
        decorator.disableAddAction();

        return decorator.createPanel();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return myComponent;
    }

    public List<PsiField> getSelectedFields() {
        List<PsiField> psiFields = new ArrayList<PsiField>();
        for (Object selectedValue : fieldList.getSelectedValues()) {
            psiFields.add((PsiField) selectedValue);
        }

        return psiFields;
    }
}
