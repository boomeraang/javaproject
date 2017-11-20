package com.soorya.webscrapers;

import java.io.IOException;
import java.net.URL;

import org.jsoup.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;

public class XmlParse
{
    //gets URLs from the RSS link
    //these URLs get passed to another function to get content from the returned links
    public void getURLfromXML(URL url) throws SAXException, IOException, ParserConfigurationException
    {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(url.openStream());

        document.getDocumentElement().normalize();

        NodeList nodeList=document.getElementsByTagName("*");
        for (int i=0; i<nodeList.getLength(); i++)
        {
            Element element = (Element)nodeList.item(i);
            if(element.getTagName().equals("link"))
                System.out.println(element.getTextContent());
        }
    }
    public static void main(String args[]) throws IOException, ParserConfigurationException, SAXException
    {
        //URL url = new URL("");
        //new XmlParse().getURLfromXML(url);

        URL url = new URL("http://www.thehindubusinessline.com/info-tech/fintech-involves-anothers-money-it-has-to-be-secure-paypal-ceo/article9966742.ece?homepage=true");

        //returns the url in a string
        //System.out.println(url.toExternalForm());

        new SiteScraper().siteScrape(url);
        //org.jsoup.nodes.Document doc = Jsoup.connect("https://kotaku.com/star-wars-battlefront-ii-the-kotaku-review-1820477183").get();
        //String title = doc.title();
        //System.out.println(title);

        /*String author = doc.select(".meta__byline").first().text();
        String time = doc.select(".meta__time").first().text();
        String tags = doc.select(".post-tags-container").first().text();
        String content = doc.select(".post-content").first().text();

        System.out.println(author);
        System.out.println(time);
        System.out.println(tags);
        System.out.println(content);
        //System.out.println(doc.body().text());
        */
    }
}