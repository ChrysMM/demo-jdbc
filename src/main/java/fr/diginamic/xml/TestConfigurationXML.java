package fr.diginamic.xml;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;


public class TestConfigurationXML {
    public static void main(String[] args) {
        Configurations confs = new Configurations();
        try {
            XMLConfiguration conf = confs.xml("configurations.xml");
            String nomBase = conf.getString("database[@nom]");
            System.out.println(nomBase);
            String host = conf.getString("database.host");

        } catch (ConfigurationException e) {
            System.err.println("fichier introuvable");

        }
    }
}

