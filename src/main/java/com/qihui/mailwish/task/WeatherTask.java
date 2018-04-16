package com.qihui.mailwish.task;

import com.qihui.mailwish.model.UserDO;
import com.qihui.mailwish.model.WetherRO;
import com.qihui.mailwish.service.GetWeatherService;
import com.qihui.mailwish.service.MorningSentenceService;
import com.qihui.mailwish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * create by chenqihui on 2018/4/5
 */
@RestController
public class WeatherTask {
    private static final String SEND_MESSAGE = "%s \n" +
            " %s，早上好，今天气温%s-%s度，天气%s, 祝您每天都有好心情";
    @Resource
    GetWeatherService getWeatherService;
    @Resource
    MorningSentenceService morningSentenceService;

    @Autowired
    private JavaMailSender mailSender;

    private String mail = "example@gmail.com";
    private String person = "person";

    @Resource
    UserService userService;
    @GetMapping("/weather")
    @Scheduled(cron = "0 0 8 * * ? ")
    public void getWeather() {
        List<UserDO> users = userService.getUsers();
        WetherRO  weather = getWeatherService.getWether();
        String morningSentence = morningSentenceService.getMorningSentence();
        users.forEach(item -> {
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = null;
            try {
                helper = new MimeMessageHelper(mimeMessage, true);
                helper.setFrom(mail, person);
                helper.setTo(item.getMail());
                helper.setSubject("Good Morning");
                String message = String.format(SEND_MESSAGE, morningSentence, item.getUserName(), weather.getTemplow(),
                        weather.getTemphigh(), weather.getWeather());
                helper.setText(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            mailSender.send(mimeMessage);
        });

    }

}
