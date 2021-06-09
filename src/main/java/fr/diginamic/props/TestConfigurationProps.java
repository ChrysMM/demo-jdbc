package fr.diginamic.props;

import java.util.ResourceBundle;

public class TestConfigurationProps {
    public static void main(String[] args) {
        ResourceBundle conf = ResourceBundle.getBundle("conf");
        String nomAdmin = conf.getString("nom");
        System.out.println(nomAdmin);
    }
}
