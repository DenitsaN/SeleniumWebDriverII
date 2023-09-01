package pages.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardPage extends BaseTrelloPage {

    public BoardPage(WebDriver driver) {
        super(driver, "trello.boardPage");
    }

    public void addListToBoard() {
        String listName = getUIMappingByKey("trello.listName");

        actions.waitForElementClickable("trello.boardPage.listWrapper");
        actions.clickElement("trello.boardPage.listWrapper");

        actions.waitForElementClickable("trello.createList.titleInput");
        actions.typeValueInField(listName, "trello.createList.titleInput");

        actions.waitForElementClickable("trello.create.list.addButton");
        actions.clickElement("trello.create.list.addButton");
    }

    public void addSecondListToBoard() {
        String listName = getUIMappingByKey("trello.secondListName");

        actions.waitForElementClickable("trello.boardPage.listWrapper");
        actions.clickElement("trello.boardPage.listWrapper");

        actions.waitForElementClickable("trello.createList.titleInput");
        actions.typeValueInField(listName, "trello.createList.titleInput");

        actions.waitForElementClickable("trello.create.list.addButton");
        actions.clickElement("trello.create.list.addButton");
    }
    public void addCardToList() {
        String listName = getUIMappingByKey("trello.listName");

        actions.waitForElementClickable("trello.create.card.addButton", listName);
        actions.clickElement("trello.create.card.addButton", listName);

        String cardName = getUIMappingByKey("trello.cardName");
        actions.waitForElementClickable("trello.create.card.textarea");
        actions.typeValueInField(cardName, "trello.create.card.textarea");

        actions.waitForElementClickable("trello.create.card.createButton");
        actions.clickElement("trello.create.card.createButton");
    }

    public void moveCardToList(String cardName, String listName) {
        actions.waitForElementVisible("trello.cardName", cardName);
        actions.waitForElementClickable("trello.searchByCardName", cardName);
        actions.waitForElementVisible("trello.cardName", cardName);

        Actions action = new Actions(actions.getDriver());
    }

    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", listName);
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.listWrapper");
    }
}
