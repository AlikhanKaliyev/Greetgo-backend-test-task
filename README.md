# Проект gyzjutqwqvwlzxcbzcfr

## Оглавление

- [Настройки проекта](#настройки-проекта)
- [Контроллеры](#контроллеры)
  - [Контроллеры postgres](#контроллеры-postgres)
  - [Контроллеры mongo](#контроллеры-mongo)
- [Запуск проекта](#запуск-проекта)

## Настройки проекта

- Версия java - 17
- postges(версия 15.2, профиль - postgres, пароль - 12345678, порт - 5433) и mongodb(7.0.1, порт - 27018) у меня находятся в docker контейнерах.
- Версия gradle - 8.1.1

## Контроллеры

### Контроллеры postgres

HTTP GET для получения контакта по id или по номеру
```
http://localhost:8080/api/contacts/{idOrPhoneNumber}
```
Принимает переменную пути idOrPhoneNumber(номера начинаются с 8 или с +7) </br>
Пример ответа:
```
{
    "id": "83210715-30e8-46f5-a09f-9886ba986c84",
    "name": "София",
    "birth_year": 1998,
    "first_phone_number": "87755556666",
    "second_phone_number": "87777777777",
    "created_at": "2023-10-22T14:00:00"
}
```
HTTP GET для получения всех контактов
```
http://localhost:8080/api/contacts/
```
При запросе кидается такой json: </br>
```
{
    "offset": 0,
    "limit": 2
}
```
Такой ответ: </br>
```
[
    {
        "id": "91c93807-95dd-4a7a-89d6-d9aa931065da",
        "name": "Айжан",
        "birth_year": 1995,
        "first_phone_number": "87776669900",
        "second_phone_number": "87712233445",
        "created_at": "2023-10-22T12:00:00"
    },
    {
        "id": "702c5833-fc27-4650-98a3-7e4b10cfbf45",
        "name": "Аскар",
        "birth_year": 1980,
        "first_phone_number": "87771112233",
        "second_phone_number": "87779998877",
        "created_at": "2023-10-22T13:00:00"
    }
]
```
HTTP PUT для изменения контакта по id или номеру
```
http://localhost:8080/api/contacts/{idOrPhoneNumber}
```
Принимает переменную пути idOrPhoneNumber(номера начинаются с 8 или с +7). Так же принимает json с параметрами и новыми значениями(не обязательно передавать все параметры) </br>
Пример тела запроса:
```
{
    "name": "Alikhan",
    "first_phone_number": "+77772902908"
}
```
Ответ:
```
{
    "id": "91c93807-95dd-4a7a-89d6-d9aa931065da",
    "name": "Alikhan",
    "birth_year": 1995,
    "first_phone_number": "87772902908",
    "second_phone_number": "87712233445",
    "created_at": "2023-10-22T12:00:00"
}
```
HTTP DELETE удаление аккаунта по id или по номеру телефона:
```
http://localhost:8080/api/contacts/{idOrPhoneNumber}
```
Ответ:
```
{
    "message": "Deleted contact with id: 702c5833-fc27-4650-98a3-7e4b10cfbf45"
}
```

### Контроллеры mongo

HTTP GET для получения контакта по id или по номеру
```
http://localhost:8080/api/mongo-contacts/{idOrPhoneNumber}
```
Принимает переменную пути idOrPhoneNumber(номера начинаются с 8 или с +7) </br>
Пример ответа:
```
{
    "id": "6537b4fcfeedbb4a275485d4",
    "name": "София",
    "birth_year": 1998,
    "first_phone_number": "87755556666",
    "second_phone_number": "87777777777",
    "created_at": "2023-10-25T18:33:37.157"
}
```
HTTP GET для получения всех контактов
```
http://localhost:8080/api/mongo-contacts/
```
При запросе кидается такой json: </br>
```
{
    "offset": 1,
    "limit": 3
}
```
Такой ответ: </br>
```
[
    {
        "id": "6537b4fcfeedbb4a275485d4",
        "name": "София",
        "birth_year": 1998,
        "first_phone_number": "87755556666",
        "second_phone_number": "87777777777",
        "created_at": "2023-10-26T00:28:27.257"
    },
    {
        "id": "6537b4fcfeedbb4a275485d5",
        "name": "Арман",
        "birth_year": 1987,
        "first_phone_number": "87770001122",
        "second_phone_number": "87799998888",
        "created_at": "2023-10-26T00:28:27.257"
    }
]
```
HTTP PUT для изменения контакта по id или номеру
```
http://localhost:8080/api/mongo-contacts/{idOrPhoneNumber}
```
Принимает переменную пути idOrPhoneNumber(номера начинаются с 8 или с +7). Так же принимает json с параметрами и новыми значениями(не обязательно передавать все параметры) </br>
Пример тела запроса:
```
{
    "name": "Alikhan",
    "first_phone_number": "+77772902908"
}
```
Ответ:
```
{
    "id": "6537b4fcfeedbb4a275485d2",
    "name": "Alikhan",
    "birth_year": 1995,
    "first_phone_number": "87772902908",
    "second_phone_number": "87712233445",
    "created_at": "2023-10-26T00:28:27.257"
}
```
HTTP DELETE удаление аккаунта по id или по номеру телефона:
```
http://localhost:8080/api/mongo-contacts/{idOrPhoneNumber}
```
Ответ:
```
{
    "message": "Deleted contact with id: 6537b4fcfeedbb4a275485d3"
}
```

## Запуск проекта
1) Клоним репозиторий, команда ниже:
``` bash
git clone https://github.com/AlikhanKaliyev/gyzjutqwqvwlzxcbzcfr.git
```
2) Заходим в рут проекта:
``` bash
cd gyzjutqwqvwlzxcbzcfr
```
3) Создаем контейнеры для баз данных с помощью docker(должен быть скачан докер и запущен).
```
docker compose up -d
```
4) Для дальшей работы нужна джава версии 17 и gradle 8.1.1
- Cкачать java: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
- Скачать gradle: https://gradle.org/releases/
5) Запускаем проект с помощью команды ниже:
``` bash
gradle bootRun
``` 
или 
``` bash
./gradlew bootRun
```
6) При запуске происходят миграции в докер контейнеры-базы данных
7) Что бы запустить тест нужно прописать такие команду (тестирование делать после запуска миграций, тоесть сделать пункт 6 и остановить приложение и запускать тест):
``` bash
gradle test
``` 
или
``` bash
./gradlew test
```
8) Коллекция postman находится в руте проекта(название файла - gyzjutqwqvwlzxcbzcfr.postman_collection.json). Импортируете его и доступны все контроллеры с их эндпоинтамию. Лучше запускать запросы по порядку.

## Дополнительный пункт
- Для миграции данных в mongodb, я использовал библиотеку mongock. Миграции описаны в файле DatabaseChangeLog.java.
- Для запуска нужно сначала создать контейнеры в докере для баз данных(пункт 6 Запуска проекта), потом запускать проект и если нужно запустить тесты, то только после запуска проекта и его закрытия, т.к так проходят миграции.

