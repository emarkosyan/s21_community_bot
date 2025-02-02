package ru.klodmit.s21_community_bot;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.klodmit.s21_community_bot.bot.BotMain;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackages = "ru.klodmit.s21_community_bot.services")
public class S21CommunityBotApplication {
    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication.run(S21CommunityBotApplication.class, args);
        TelegramBotsApi botsApi;
        botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new BotMain());
    }

}

