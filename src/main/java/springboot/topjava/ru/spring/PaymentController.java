package springboot.topjava.ru.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//обрабатывает запрос пользователя, создаёт соответствующую Модель и передаёт её для отображения в Вид
@RequestMapping("/payment")
//RequestMapping предназначена для того, чтобы задать методам вашего контроллера адреса, по которым они будут доступны на клиенте
//в данном случае для всего класса


public class PaymentController {

    @Autowired
    private UserService UserService;

    private final String sharedKey = "SHARED_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    //когда мы пытаемся получить данные с сервера (то есть просто вводим URL)
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, 2);
    }

    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest request) {

        final BaseResponse response;

        if (sharedKey.equalsIgnoreCase(key)) {
            int userId = request.getUserId();
            String itemId = request.getItemId();
            double discount = request.getDiscount();
            UserService.pay();
            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return response;
    }
}