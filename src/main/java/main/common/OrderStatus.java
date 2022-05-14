package main.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {
    BACKLOG("В ожидании"),
    DECLINE("Отказан"),
    ACCEPT("Принят"),
    IN_PROGRESS("В работе"),
    FITTING_WAIT("Ожидается примерка"),
    READY("Ждет клиента"),
    DONE("Сделан");

    private final String name;

}
