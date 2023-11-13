package springboottelegrambot.storage.entity;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.util.List;


public class StihiyaShopSlash extends TelegramLongPollingBot {

    private final static String massage = "Hey my dear, this is first msg ever";
    private final static Long vicRumId = 530618365L;
    private final static Long dimonId = 425925545L;
    private final static String massage1 = "Еще раз напишешь пизды получишь";

    private InlineKeyboardMarkup keyboardM1;
    private InlineKeyboardMarkup keyboardM2;

    // TELEGRAM METHODS
    @Override
    public String getBotUsername() {
        return "slash_shop_bot";
    }

    @Override
    public String getBotToken() {
        return "6984652084:AAGjfSTm7Q2wFn5-XCVKvM4Dg_vYFmNWDrQ";
    }


    @Override
    public void onUpdateReceived(Update update) {
//        var msg = update.getMessage();
//        var user = msg.getFrom();
//        var id = update.getUpdateId();
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();

        var next = InlineKeyboardButton.builder()
                .text("Next").callbackData("next")
                .build();

        var back = InlineKeyboardButton.builder()
                .text("Back").callbackData("back")
                .build();

        var url = InlineKeyboardButton.builder()
                .text("Tutorial")
                .url("https://core.telegram.org/bots/api")
                .build();


        keyboardM1 = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(next)).build();

//Buttons are wrapped in lists since each keyboard is a set of button rows
        keyboardM2 = InlineKeyboardMarkup.builder()
                .keyboardRow(List.of(back))
                .keyboardRow(List.of(url))
                .build();


        sendMenu(id, "Menu", keyboardM2);
        System.out.println(user.getFirstName() + " wrote " + msg.getText());
        System.out.println(update);


    }

    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

    public void sendMenu(Long who, String txt, InlineKeyboardMarkup kb) {
        SendMessage sm = SendMessage.builder().chatId(who.toString())
                .parseMode("HTML").text(txt)
                .replyMarkup(kb).build();

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void buttonTap(Long id, String queryId, String data, int msgId) throws TelegramApiException {

        EditMessageText newTxt = EditMessageText.builder()
                .chatId(id.toString())
                .messageId(msgId).text("").build();

        EditMessageReplyMarkup newKb = EditMessageReplyMarkup.builder()
                .chatId(id.toString()).messageId(msgId).build();

        if (data.equals("next")) {
            newTxt.setText("MENU 2");
            newKb.setReplyMarkup(keyboardM2);
        } else if (data.equals("back")) {
            newTxt.setText("MENU 1");
            newKb.setReplyMarkup(keyboardM1);
        }

        AnswerCallbackQuery close = AnswerCallbackQuery.builder()
                .callbackQueryId(queryId).build();

        execute(close);
        execute(newTxt);
        execute(newKb);
    }
}
