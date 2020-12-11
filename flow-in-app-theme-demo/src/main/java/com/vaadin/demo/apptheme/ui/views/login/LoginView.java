package com.vaadin.demo.apptheme.ui.views.login;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")
@PageTitle("Login | Vaadin CRM")
@NpmPackage(value = "@fortawesome/fontawesome-free", version = "5.15.1")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    LoginForm login = new LoginForm();

    public LoginView() {
        addClassName("login-view");
        setSizeFull();

        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);

        login.setAction("login");

        Image crmImage = new Image(
                "fontawesome/svgs/brands/vaadin.svg",
                "Vaadin CRM");
        crmImage.getStyle().set("margin-top", "5px");
        crmImage.setWidth(35, Unit.PIXELS);
        crmImage.setHeight(35, Unit.PIXELS);

        Html vaadinFontImage = new Html("<i class=\"fab fa-vaadin\"></i>");

        HorizontalLayout titleLayout = new HorizontalLayout(crmImage,
                new H1("Vaadin CRM"),
                vaadinFontImage);
        titleLayout.setAlignItems(Alignment.BASELINE);

        add(titleLayout,
            login
        );
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
        .getQueryParameters()
        .getParameters()
        .containsKey("error")) {
            login.setError(true);
        }
    }
}
