import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void shouldDragAtoB() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //1 способ с использованием dragAndDropTo
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));

        $("#column-a").dragAndDropTo("#column-b");

        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));

        //2 способ с использованием moveToElement (не рабочий)
        actions().moveToElement($("#column-a")).clickAndHold().
                moveByOffset(200, 0).release().perform();

        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));

    }
}