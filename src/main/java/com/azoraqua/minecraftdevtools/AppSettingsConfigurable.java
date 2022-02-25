package com.azoraqua.minecraftdevtools;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.util.NlsContexts.ConfigurableName;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public final class AppSettingsConfigurable implements Configurable {
    private AppSettingComponent settingComponent;

    @Override
    public @ConfigurableName String getDisplayName() {
        return "Minecraft Development Tools";
    }

    @Override
    public @Nullable JComponent getPreferredFocusedComponent() {
        return null;
    }

    @Override
    public @Nullable JComponent createComponent() {
        settingComponent = new AppSettingComponent();

        return settingComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        MinecraftVersion version = settingComponent.getVersionSelector().getItem();
        MinecraftVersion storedVersion = AppSettingsState.getInstance().version;

        return version != storedVersion;
    }

    @Override
    public void apply() {
        AppSettingsState.getInstance().version = settingComponent.getVersionSelector().getItem();
    }

    @Override
    public void reset() {
        settingComponent.getVersionSelector().setItem(AppSettingsState.getInstance().version);
    }

    @Override
    public void disposeUIResources() {
        settingComponent = null;
    }
}
