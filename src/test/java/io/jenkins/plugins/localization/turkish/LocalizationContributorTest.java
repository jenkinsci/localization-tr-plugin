package io.jenkins.plugins.localization.turkish;

import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import java.io.IOException;

import static org.junit.Assert.*;

public class LocalizationContributorTest {

    @Rule
    public JenkinsRule jenkins = new JenkinsRule();

    @Test
    public void testAcceptLanguageHeader() throws IOException {
        JenkinsRule.WebClient client = jenkins.createWebClient();
        WebRequest request = new WebRequest(jenkins.getURL());
        request.setAdditionalHeader("Accept-Language", "tr");
        HtmlPage page = client.getPage(request);
        assertEquals("Kontrol Merkezi [Jenkins]", page.getTitleText());
    }
}
