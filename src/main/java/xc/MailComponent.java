package xc;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by changhai on 15/9/21.
 */
@Service
public class MailComponent {
    @PostConstruct
    public void init() {
        System.out.println("connect to openfire");
    }
}
