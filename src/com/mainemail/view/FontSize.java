package com.mainemail.view;

public enum FontSize {
    SMALL, MEDIUM, BIG;

    /**
     * connect the enum to the css file
     */
    public static String getCssPath(FontSize fontSize){
        return switch (fontSize){
            case SMALL -> "css/fontSmall.css";
            case MEDIUM -> "css/fontMedium.css";
            case BIG -> "css/fontBig.css";
        };
    }
}
