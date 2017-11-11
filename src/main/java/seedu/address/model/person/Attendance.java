package seedu.address.model.person;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.exceptions.PersonMaxAttendanceException;

//@@author pohjie
/**
 * Represents a Person's attendance in the address book.
 * Hardcoded now till further versions support actual implementation of attendance
 */
public class Attendance {

    public final int maxAttendance = 8;
    private int attended;
    private int missed;

    /**
     * Default constructor
     * All Person will get this default attendance in V1.4 and V1.5
     */
    public Attendance() {
        attended = 0;
        missed = 8;
    }

    /**
     * User can choose to set the number of attended sessions if it is not zero.
     * Only used for testing for V1.5
     * @param attended
     * must be within the range of 0 to 8 inclusive
     * @throws IllegalValueException
     */
    public Attendance(int attended) throws IllegalValueException {
        if (attended > -1 && attended < 9) {
            this.attended = attended;
            missed = maxAttendance - attended;
        } else {
            throw new IllegalValueException("attended not within 0 to 8 inclusive!");
        }
    }

    public int getAttended() {
        return attended;
    }

    public int getMissed() {
        return missed;
    }

    /**
     * Increments attended by one and decrements missed by one
     * to signify that a person has attended a session.
     * @throws PersonMaxAttendanceException
     */
    public void addAttendance() throws PersonMaxAttendanceException {
        if (attended < 8) {
            attended++;
            missed--;
        } else {
            throw new PersonMaxAttendanceException("Person already has maximum attendance!");
        }
    }

    @Override
    public String toString() {
        return "Attended is: " + attended + ", and missed is: " + missed;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Attendance
                && this.attended == (((Attendance) other).attended)
                && this.missed == (((Attendance) other).missed));

    }

}
