# Vaadin Custom-Theme Demo 

This repository contains the source code of four separate projects:
* flow-in-app-theme-demo: demonstrate wide range of the custom-theme features.
* reusable-theme: a project just to demonstrate how to place assets and resources for creating a reusable-theme as jar.
* reusing-theme-jar-demo: demonstrate how to use a reusable theme that packaged as jar.
* extend-existing-app-theme-demo: demonstrate how to inherit style from a parent theme and apply extra tweaks based on that.

The source code for those three projects which their names are ending with `-demo`, is the same source code of `vaadin-crm` demo. 
Only the custom-theming is applied to these projects to show how this new theming can be applied easily to any existing or new vaadin project. 

### flow-in-app-theme-demo

This project is about demonstrating how to apply theming to a vaadin application. 
As mentioned above, the source code is from `vaadin-crm` which contains basic spring security and two views other than the login page.

To understand the applied theme, take a quick look at `./frontend/themes/custom-theme` first. 
The `custom-theme` folder's name acts as theme's name by convention. 
So the theme is activated by that name using `@Theme("custom-theme")` in `DemoAppShellConfigurator.java`.

So, as the documentation of application theme describes, there are several theming features we can apply easily:
* having global styles, background-images, fonts, etc.: see `styles.css`, and note that it can contain @Import rule naturally.
* importing css from npm packages: see `theme.json` for `importCss` and note `@NpmPackage` and using css classes in `LoginView.java`. 
* using assets and resources from npm packages: see `theme.json` for `assets` note `@NpmPackage` and using svg images in `LoginView.java`.
* having component-specific styles auto-applied by matching the css file's name with the component's HTML tag name. 
See `/components` folder to examples of applied component-specific styles.
* No need to change view-specific styles of existing vaadin applications, just @Import them from `styles.css`.

NOTE: Some changes also applied for ignoring the theme resources in Spring Security configurations. See `SecurityConfiguration`.

By running the application, you can see the applied theme.
The Applied theme has bold colors, borders, backgrounds, etc. on purpose, just to show the applied changes and tweaks on top of the base Lumo theme.


##### - How to Run:

This project is a vaadin application based on SpringBoot and it is not dependent on other projects in this repository. 
So you can run it to see the output:
* using `mvn spring-boot:run`, or 
* simply by running the main method of `Application.java`

### reusable-theme

This project is about demonstrating how assets and resources should be organized for creating a reusable theme packaged as jar.
See the dependencies needed for this in `pom.xml`.

The theme resources in this project are the exact same resources and assets of `flow-in-app-theme-demo`. 
This way, it can be easily verified that the exact same look and feel of `flow-in-app-theme-demo` can be achieved by reusable themes packaged as jar.

##### - How to Build:

This is a maven project, so nothing magical needed, just use `mvn clean install` and `reusable-theme-1.0-SNAPSHOT.jar` would be created. 
 

### reusing-theme-jar-demo

NOTE: This demo project is simply using the output of the `reusable-theme` project as dependency, to show that the exact same look and feel as in `flow-in-app-theme-demo` can be achieved by using that `custom-theme` packaged as jar.

So it is dependent on the build output of `reusable-theme`.
Please make sure `reusable-theme` project has already been installed before running this project.

##### - How to Run:

This project is a vaadin application based on SpringBoot, and it is not dependent on other projects in this repository. 
So you can run it to see the output:
* using `mvn spring-boot:run`, or 
* simply by running the main method of `Application.java`

### extend-existing-app-theme-demo

This demo project is demonstrating that extending (inheriting) from an existing theme is also possible. 
Imagine you have as set of projects related to each other, and they have to share some styles. 
So basically, the common parts can be packaged as a parent theme and be reused and inherited by the projects, that might have their own specific theming, too.

* So the first thing happened is that there is a `specific-theme` theme folder. 
* Next, there is a `theme.json` in this `specific-theme` folder containing:
```
{
    "parent": "custom-theme"
}
```
* An `@Theme("specific-theme")` is applied to `DemoAppShellConfigurator.java`.
* Other specific overrides on fonts, background-colors, components, etc. applied in this `specific-theme`.

By running the project, it can be verified that some styles are being applied from the parent theme, and some other styles are coming directly from `specific-theme` inside this project.

NOTE: This demo project is simply using the output of the `reusable-theme` project as dependency.

So it is dependent on the build output of `reusable-theme`.
Please make sure `reusable-theme` project has already been installed before running this project.

##### - How to Run:

This project is a vaadin application based on SpringBoot, and it is not dependent on other projects in this repository. 
So you can run it to see the output:
* using `mvn spring-boot:run`, or 
* simply by running the main method of `Application.java`
