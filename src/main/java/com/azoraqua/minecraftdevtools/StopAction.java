package com.azoraqua.minecraftdevtools;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

public final class StopAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        ServerManager.getInstance().destroyServer();
    }
}
