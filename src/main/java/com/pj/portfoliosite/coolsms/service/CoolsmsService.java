package service;


import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CoolsmsService implements MessageService {

    @Value("${coolsms.api.key}")
    private String apiKey;
    @Value("${coolsms.api.secretkey}")
    private String apiSecret;

    private final DefaultMessageService messageService;

    public CoolsmsService() {
        this.messageService = NurigoApp.INSTANCE.initialize(
                apiKey,       // API Key
                apiSecret,    // API Secret
                "https://api.coolsms.co.kr" // API URL (기본값)
        );
    }
    // 단건 문자 전송
    @Override
    public void sendMessage(String message) {
        Message sendMessage = new Message();
        sendMessage.setFrom("01075077699"); // 발신번호
        sendMessage.setTo("01075077699"); // 수신번호
        sendMessage.setText(message);
        try {
            this.messageService.send(sendMessage);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
