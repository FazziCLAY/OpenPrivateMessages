# OpenPrivateMessages
## Minecraft bukkit plugin.

### config.yml
```yaml
commandUsing: "Use /$command <player> <message>"
# Когда команда выполняется без аргумента игрока или сообщения

playerNotFound: "Player not found"
# Когда получатель сообщения не онлайн.

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
    Text: "/$command $sender_nickname "
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

**commandUsing**:
- $command - Используемая команда. Если /tell <...> то tell; Если /msg <...> то msg