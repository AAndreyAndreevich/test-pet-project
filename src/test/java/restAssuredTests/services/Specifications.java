package restAssuredTests.services;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    /**
     * Устанавливает спецификацию
     * @param request параметры запроса
     * @param response параметры ожидаемых результатов
     */
    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }

    /**
     * Создает параметры запроса
     * @param uri принимает ссылку нужного сайта
     * @return возвращает параметры запроса
     */
    public static RequestSpecification requestSpecification(String uri) {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .build();
    }

    /**
     * Создает ожидаемый результат
     * @param status принимает ожидаемый статус
     * @return возвращает ожидаемый статус
     */
    public static ResponseSpecification responseSpecification(int status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
    }

}