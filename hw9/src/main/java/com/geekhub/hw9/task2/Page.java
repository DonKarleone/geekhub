package com.geekhub.hw9.task2;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that represents page that could be downloaded by specified URL.
 * Allows high-level access to page elements.
 */
public class Page {

    private Pattern imageLinkPattern = Pattern.compile("<img.*?src=\"(.*?)\".*?(/>|</img>)");

    private final URL url;
    private final String content;

    /**
     * Be careful, constructor downloads content, it could be slow.
     *
     * @param url
     * @throws IOException
     */
    public Page(URL url) throws IOException {
        this.url = url;
        this.content = new String(ConnectionUtils.getData(url));
    }

    /**
     * Extracts all links to images from the page like <img src={link}/>. Method does not cache content. Each time new list will be returned.
     *
     * @return list of URLs to images from that page.
     * @throws MalformedURLException
     */
    public Collection<URL> getImageLinks() throws MalformedURLException {
        Matcher matcher = imageLinkPattern.matcher(content);
        return extractMatches(matcher);
    }

    private Collection<URL> extractMatches(Matcher matcher) throws MalformedURLException {
        Set<URL> allMatches = new HashSet<>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        while (matcher.find()) {
            Matcher urlMatcher = pattern.matcher(matcher.group());
            while (urlMatcher.find()) {
                allMatches.add(new URL((matcher.group().substring(urlMatcher.start(0),
                        urlMatcher.end(0)))));
            }
        }
        return new ArrayList<>(allMatches);
    }
}
