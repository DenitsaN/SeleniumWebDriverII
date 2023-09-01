package test.cases.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.trello.BoardPage;
import pages.trello.BoardsPage;
import org.junit.Ignore;
import org.junit.Test;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardTest extends BaseTest {

    private WebDriver driver;

    @Test
    public void createBoardWhenCreateBoardClicked() {
        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertAddListExists();
    }

    @Test
    public void createListWhenAddListClicked() {
        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.clickOnBoard("My First Board");

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.addListToBoard();

        String listName = getUIMappingByKey("trello.listName");
        boardPage.assertListExists(listName);
    }

    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {
        login();

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.clickOnBoard("My First Board");

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.addCardToList();
    }

    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
        login();

        String cardName = getUIMappingByKey("trello.cardName");
        String secondListName = getUIMappingByKey("trello.secondListName");
        String listName = getUIMappingByKey("trello.listName");

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.moveCardToList(cardName, secondListName);
    }

    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {
    }
}
