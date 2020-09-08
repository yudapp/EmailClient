package com.mainemail.view;

public enum ColorTheme {
    LIGHT, DEFAULT, DARK;


    /**
     * In the viewFactory, in updateStyleSheet(), use scene.getStylesheets().add(getClass().getResource("").toExternalForm())
     * Below we link the enum to their style sheets and get the path
     * @param colorTheme
     * @return the css style sheet link
     */
    public static String getCssPath(ColorTheme colorTheme){
        return switch (colorTheme) {
            case LIGHT -> "css/themeLight.css";
            case DEFAULT -> "css/themeDefault.css";
            case DARK -> "css/themeDark.css";
        };
    }
}
