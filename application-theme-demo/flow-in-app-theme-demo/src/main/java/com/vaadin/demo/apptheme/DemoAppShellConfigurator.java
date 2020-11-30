package com.vaadin.demo.apptheme;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;

@PWA(
        name = "Vaadin Application-Theme Demo",
        shortName = "App-Theme Demo",
        offlineResources = {
                "./styles/offline.css",
                "./images/offline.png"
        }
)
@Theme("custom-theme")
public class DemoAppShellConfigurator implements AppShellConfigurator {
}
