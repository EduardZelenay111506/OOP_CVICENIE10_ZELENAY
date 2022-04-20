package sk.stuba.fei.uim.oop.oop_cvicenie10_zelenay;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class AhojService implements IGreetingsService{
    @Override
    public String createResponse(HelloRequestBody body){
        return "hello "+ body.getName();
    }
}
