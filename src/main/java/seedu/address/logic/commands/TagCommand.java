package seedu.address.logic.commands;

import seedu.address.model.tag.TagPredicate;

/**
 * Lists all persons with tag in the address book to the user.
 */

public class TagCommand extends Command {
    public static final String COMMAND_WORD = "tag";

    public static final String MESSAGE_SUCCESS = "Listed all tag persons";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all persons who has tag of "
            + "the specified keywords (case-sensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " friends family";

    private final TagPredicate predicate;

    public TagCommand(TagPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute() {
        model.updateFilteredPersonList(predicate);
        return new CommandResult(getMessageForPersonListShownSummary(model.getFilteredPersonList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TagCommand // instanceof handles nulls
                && this.predicate.equals(((TagCommand) other).predicate)); // state check
    }
}
