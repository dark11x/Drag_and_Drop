import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void shouldDragAtoB() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));

//       $("column-a").dragAndDropTo($("#column-b"));

        sleep(2000);

        actions().moveToElement($("#column-a")).clickAndHold().
                moveByOffset(200,0).release().perform();

        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }
}
