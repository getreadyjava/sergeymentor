# Сервис ведения списка сотрудников кластера
## Что позволяет сделать?
Позволяет выполнить операции:
- Получение списка с информацией о всех сотрудниках кластера
- Получение информации об одном сотруднике
- Удаление сотрудника из списка
- Обновление сведений о сотруднике

## Каким образом реализован сервис?
Сервис реализован в виде веб-сервиса предоставляющего API в форме RESTful API.

### API
| **#** | **Method** | **Endpoint**             | **Description**                           |
| :---: | :--------: | :----------------------- | :---------------------------------------- |
|   1   |   **GET**  | `/api/v1/employees`      | Retrieve a list of all employees.         |
|   2   |   **GET**  | `/api/v1/employees/{id}` | Retrieve a specific employee by their ID. |
|   3   |  **POST**  | `/api/v1/employees`      | Create a new employee record.             |
|   4   |   **PUT**  | `/api/v1/employees`      | Update an existing employee record.       |
|   5   | **DELETE** | `/api/v1/employees/{id}` | Delete an employee by their ID.           |

## Как запустить проект?
- В классе Main в IDE GigaIDE выбрать иконку старт
- Через maven ``` ./mvnw spring-boot:run ```

## Как протестировать запросы?
- Выбрать необходимый эндпоинт
- В терминале ввести запрос curl -X METHOD http://localhost:9091/api/v1/employees + [id]