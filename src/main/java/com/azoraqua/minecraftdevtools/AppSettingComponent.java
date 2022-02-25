package com.azoraqua.minecraftdevtools;

import com.intellij.openapi.application.Application;
import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.util.ui.FormBuilder;
import org.jdesktop.swingx.JXButton;
import org.jdesktop.swingx.JXRadioGroup;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public final class AppSettingComponent {

    private final JPanel panel;
    private final ComboBox<MinecraftVersion> versionSelector;

    public AppSettingComponent() {
        versionSelector = new ComboBox<>(MinecraftVersion.values());

        panel = FormBuilder.createFormBuilder()
                .addLabeledComponent("Minecraft version", versionSelector)
                .getPanel();
    }

    public JPanel getPanel() {
        return panel;
    }

    public ComboBox<MinecraftVersion> getVersionSelector() {
        return versionSelector;
    }
}
