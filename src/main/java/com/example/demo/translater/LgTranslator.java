package com.example.demo.translater;

import com.example.demo.provider.SendRequest;
import org.springframework.format.Printer;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Locale;

public class LgTranslator implements Printer<String> {
    @Override
    public String print(String s, Locale locale) {
        try {
            String url = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20200423T181042Z.d9f537d0f165048a.3cef0d5e1fa0e9c06d0bada873b96ccc5726b0ed";
            url = url + "&text=" + URLEncoder.encode(s, "UTF-8") + "&lang=" + locale.getLanguage();
            String resp = SendRequest.send(url);
            int start = resp.indexOf("[");
            int end = resp.indexOf("]");
            return resp.substring(start + 2, end - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
