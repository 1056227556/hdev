package org.hgd.dev.action;

import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.ComponentPopupBuilder;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.ui.popup.ListPopup;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.file.PsiDirectoryImpl;
import com.intellij.ui.popup.ComponentPopupBuilderImpl;
import org.hgd.dev.components.SampleDialogWrapper;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.util.Objects;

/**
 * 创建hwin模块Action
 */
public class CreateModuleAction extends AnAction {


    @Override
    public void update(@NotNull AnActionEvent e) {
        // psi文件对象,选择文件夹时为null
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        // 选择的文件的psi元素对象,选择多个文件时为null
        PsiElement psiElement = e.getData(CommonDataKeys.PSI_ELEMENT);
        // 选择的文件,分文件和文件夹
        VirtualFile[] virtualFileArray = e.getData(CommonDataKeys.VIRTUAL_FILE_ARRAY);
        // 项目信息
        Project project = e.getData(CommonDataKeys.PROJECT);

        Object[] selectedItems = e.getData(PlatformDataKeys.SELECTED_ITEMS);


        Presentation presentation = e.getPresentation();
        if (Objects.nonNull(psiElement)&&psiElement instanceof PsiDirectory){
            PsiDirectory psiDirectory = (PsiDirectoryImpl) psiElement;
            VirtualFile virtualFile = psiDirectory.getVirtualFile().findChild("pom.xml");
            if (Objects.nonNull(virtualFile)){
                Path pomPath = virtualFile.toNioPath();
                presentation.setEnabled(true);
                presentation.setVisible(true);
                return;
            }
        }
        presentation.setEnabled(false);
        presentation.setVisible(false);
    }


    /**
     * 创建模块
     * @param e
     */
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // TODO: insert action logic here

    }
}


