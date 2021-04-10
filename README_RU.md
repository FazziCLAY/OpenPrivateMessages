# OpenPrivateMessages
## Minecraft bukkit plugin.

### config.yml
```yaml
commands:
  - tell
  - msg
  - w

playerNotFound: # Когда получатель сообщения не онлайн.
  Pattern: "argument.entity.notfound.player"
  IsTranslatable: true # Использовать сообщение из data/lang/<язык_клиента>.json

timeFormat: "dd.MM.yyyy HH:mm:ss"
# Формат времени. Нужно для переменной $time

recipientMessage: # Сообщение со стороны получателя
  Pattern: "$sender_nickname -> $recipient_nickname: $message"
  Hover:
    Enable: true
    Text: "&9~~~~ PrivateMessage ~~~~\n&a$sender_nickname &7-> &a$recipient_nickname\n&d(Click to reply)\n\n&f$message"
  Click:
    Enable: true
    Text: "/$command $sender_nickname "

senderMessage: # Сообщение со стороны отправителя
  Pattern: "&2Message sent!"
  Hover:
    Enable: true
    Text: "&9~~~~ PrivateMessage ~~~~\n&a$sender_nickname &7-> &a$recipient_nickname\n&d(Click to send $recipient_nickname)\n\n&f$message"
  Click:
    Enable: true
    Text: "/$command $recipient_nickname "
```

### Доступные переменне в конфиге
**recipientMessagePattern** & **senderMessagePattern**:
- $recipient_nickname - Ник получателя
- $sender_nickname - Ник отправителя
- $message - Контент сообщения
- $time - Время при отправке

**recipientMessageClickText**:
- $command - Используемая команда
- $sender_nickname - Ник отправителя
- $time - Время при отправке

**senderMessageClickText**
- $command - Используемая команда
- $recipient_nickname - Ник получателя
- $time - Время при отправке

**recipientMessageHoverText** & **senderMessageHoverText**:
- $sender_nickname - Ник отправителя
- $recipient_nickname - Ник получателя
- $message - Контент сообщения
- $time - Время при отправке