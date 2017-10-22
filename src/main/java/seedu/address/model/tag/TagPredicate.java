package seedu.address.model.tag;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import seedu.address.model.person.ReadOnlyPerson;

/**
 * Tests that a {@code ReadOnlyPerson}'s {@code tag} matches any of the keywords given.
 */

public class TagPredicate implements Predicate<ReadOnlyPerson> {

    private final List<String> keywords;

    public TagPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(ReadOnlyPerson person) {
        Set<Tag> tags = person.getTags();
        for (Tag s : tags) {
            for (String key : keywords) {
                if (key.equals(s.tagName)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TagPredicate // instanceof handles nulls
                && this.keywords.equals(((TagPredicate) other).keywords)); // state check
    }
}
