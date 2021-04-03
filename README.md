# OpenPrivateMessages
## Minecraft bukkit plugin.

---
RUSSIAN README - [README_RU.md](./README_RU.md)

---

### config.yml
```yaml
commandUsing: "Use /$command <player> <message>"
# When a command is executed without a player argument or message

playerNotFound: "Player not found"
# When the recipient of the message is offline.

timeFormat: "dd.MM.yyyy HH:mm:ss"
# Time format. Required for the $time variable

recipientMessage: # Message from the recipient's side
  Pattern: "$sender_nickname -> $recipient_nickname: $message"
  Hover:
    Enable: true
    Text: "&9~~~~ PrivateMessage ~~~~\n&a$sender_nickname &7-> &a$recipient_nickname\n&d(Click to reply)\n\n&f$message"
  Click:
    Enable: true
    Text: "/$command $sender_nickname "

senderMessage: # Message from the sender's side
  Pattern: "&2Message sent!"
  Hover:
    Enable: true
    Text: "&9~~~~ PrivateMessage ~~~~\n&a$sender_nickname &7-> &a$recipient_nickname\n&d(Click to send $recipient_nickname)\n\n&f$message"
  Click:
    Enable: true
    Text: "/$command $sender_nickname "
```

### Available variables in config
**recipientMessagePattern** & **senderMessagePattern**:
- $recipient_nickname - The recipient's nickname
- $sender_nickname - Sender's nickname
- $message - Message content
- $time - Time when sending

**recipientMessageClickText**:
- $command - Command to use
- $sender_nickname - Sender's nickname
- $time - Time when sending

**senderMessageClickText**
- $command - Command to use
- $recipient_nickname - The recipient's nickname
- $time - Time when sending

**recipientMessageHoverText** & **senderMessageHoverText**:
- $sender_nickname - Sender's nickname
- $recipient_nickname - The recipient's nickname
- $message - Message content
- $time - Time when sending

**commandUsing**:
- $command - The command to use. If /tell <...> then tell; If /msg <...> then msg

(Translated from `Google Translate`)