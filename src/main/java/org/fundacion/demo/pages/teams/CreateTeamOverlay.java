package org.fundacion.demo.pages.teams;

import org.fundacion.demo.pages.PageObject;
import org.fundacion.demo.pages.forms.FieldsEnum;
import org.fundacion.demo.pages.forms.FormPage;
import org.fundacion.demo.pages.forms.IFiller;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

import static org.fundacion.demo.pages.forms.FieldsEnum.DESCRIPTION;
import static org.fundacion.demo.pages.forms.FieldsEnum.NAME;
import static org.fundacion.demo.pages.forms.FieldsEnum.TYPE;

public final class CreateTeamOverlay extends PageObject {

    private static final String SKIP_MEMBERS_BUTTON = "a[data-test-id=show-later-button]";
    private static final String CONTINUE_BUTTON = "button[data-test-id=header-create-team-submit-button]";
    private static final String TEAM_NAME_INPUT = "input[data-test-id=header-create-team-name-input]";
    private static final String TEAM_TYPE_SELECT = "#teamTypeSelect";
    private static final String TEXTAREA_DESCRIPTION = "textarea[id*=create-team-org-description]";
    private final FormPage formPage;

    @FindBy(css = SKIP_MEMBERS_BUTTON)
    private WebElement skipMembersButton;

    @FindBy(css = CONTINUE_BUTTON)
    private WebElement continueCreation;

    @FindBy(css = TEAM_NAME_INPUT)
    private WebElement inputName;

    @FindBy(css = TEAM_TYPE_SELECT)
    private WebElement selectTeamType;

    @FindBy(css = TEXTAREA_DESCRIPTION)
    private WebElement description;

    public CreateTeamOverlay(final WebDriver driver) {
        super(driver);

        Map<FieldsEnum, IFiller> form = new HashMap<>();
        form.put(NAME, this::setName);
        form.put(TYPE, type -> setType(TeamTypesEnum.valueOf(type.toUpperCase())));
        form.put(DESCRIPTION, this::setDescription);

        this.formPage = new FormPage(form);
    }

    public CreateTeamOverlay setRequiredValues(final String name, final TeamTypesEnum type) {
        setName(name);
        setType(type);
        return this;
    }

    public CreateTeamOverlay setName(final String name) {
        inputName.sendKeys(name);
        return this;
    }

    public CreateTeamOverlay setType(final TeamTypesEnum type) {
        click(selectTeamType);
        String chosenType = "div[data-test-id=header-create-team-type-input-".concat(type.toString()).concat("]");
        WebElement createTeam = driver.findElement(By.cssSelector(chosenType));
        click(createTeam);
        return this;
    }

    public CreateTeamOverlay setDescription(final String description) {
        this.description.sendKeys(description);
        return this;
    }

    public CreateTeamOverlay nextSection() {
        click(continueCreation);
        return this;
    }

    public TeamPage skipAddMembers() {
        click(skipMembersButton);
        return new TeamPage(driver);
    }

    public void fillForm(final Map<String, String> data) {
        formPage.fillForm(data);
    }
}
